//TeamRosterTab.tsx
import { Player } from '../../../../types/teamTypes';
import { useEffect } from 'react';
import type { ThunkDispatch } from 'redux-thunk';
import type { UnknownAction } from 'redux';
import { useDispatch, useSelector } from 'react-redux';
import { fetchTeamRoster } from '../../../../redux/actions/teamActions';
import { RootState } from '../../../../redux/store';
import SortableSegmentedTable from './SortableSegmentedTable';
import { ColumnDef } from '@tanstack/react-table';



interface TeamRosterProps {
    teamId: number;
    teamSeason: number;
}


const TeamRosterTab: React.FC<TeamRosterProps> = ({ teamId, teamSeason }) => {
    const dispatch = useDispatch<ThunkDispatch<{}, {}, UnknownAction>>();
    const players = useSelector((state: RootState) => state.team.teamRoster); // Adjust this path to your Redux state structure

    useEffect(() => {
        const cacheKey = `teamRoster-${teamId}-${teamSeason}`;
        const cachedRoster = localStorage.getItem(cacheKey);

        if (cachedRoster) {
            const parsedRoster = JSON.parse(cachedRoster);
            // Optional: Check if the cached data matches the current teamId and teamSeason
            if (parsedRoster.teamId === teamId && parsedRoster.teamSeason === teamSeason) {
                dispatch({ type: 'FETCH_TEAM_ROSTER_SUCCESS', payload: parsedRoster });
            } else {
                // Cached data is stale or for a different team, fetch new data
                dispatch(fetchTeamRoster(teamId, teamSeason));
            }
        } else if (teamId && !isNaN(teamId) && teamSeason) {
            dispatch(fetchTeamRoster(teamId, teamSeason));
        }
    }, [dispatch, teamId, teamSeason]);

    useEffect(() => {
        const cacheKey = `teamRoster-${teamId}-${teamSeason}`;
        if (players.length > 0) {
            localStorage.setItem(cacheKey, JSON.stringify(players));
        }
    }, [players]); // Runs only if players data changes



    const preprocessData = (players: Player[]): Player[] => {
        return players.map(player => {
            let teamSegment = 'Special Teams'; // Default segment

            if (['OL', 'QB', 'WR', 'TE', 'RB', 'HB', 'FB', 'C', 'OG', 'OT', 'R'].includes(player.position)) {
                teamSegment = 'Offense';
            } else if (['S', 'DE', 'DB', 'LB', 'RB', 'DL', 'DT', 'LB', 'MLB', 'OLB', 'DB', 'CB'].includes(player.position)) {
                teamSegment = 'Defense';
            }

            return { ...player, teamSegment };
        });
    };

    const processedPlayers = preprocessData(players);
    const offensePlayers = processedPlayers.filter(player => player.teamSegment === 'Offense');
    const defensePlayers = processedPlayers.filter(player => player.teamSegment === 'Defense');
    const specialTeamsPlayers = processedPlayers.filter(player => player.teamSegment === 'Special Teams');


    // Define columns for your sortable and grouped table
    const columns: ColumnDef<Player>[] = [
        { accessorKey: 'jersey', header: '#' },
        { accessorKey: 'firstName', header: 'First Name' },
        { accessorKey: 'lastName', header: 'Last Name' },
        { accessorKey: 'position', header: 'Pos.' },
        { accessorKey: 'height', header: 'Height', cell: info => `${Math.floor(info.getValue() / 12)}ft ${info.getValue() % 12}in` },
        { accessorKey: 'weight', header: 'Weight', cell: info => `${info.getValue()} lbs` },
        { accessorKey: 'year', header: 'Year' },
        { accessorKey: 'homeCity', header: 'Home City' },
        { accessorKey: 'homeState', header: 'Home State' }
    ];


    return (

        <div>
            <div className="text-2xl md:text-3xl lg:text-3xl font-bold text-center">Offense</div>
            <div>
                <SortableSegmentedTable data={offensePlayers} columns={columns} />
            </div>
            <div>
                <div className="text-2xl md:text-3xl lg:text-3xl font-bold text-center">Defense</div>
                <SortableSegmentedTable data={defensePlayers} columns={columns} />
            </div>
            <div>
                <div className="text-2xl md:text-3xl lg:text-3xl font-bold text-center">Special Teams</div>
                <SortableSegmentedTable data={specialTeamsPlayers} columns={columns} />
            </div>
        </div>

    );
};

export default TeamRosterTab;