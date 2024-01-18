import React, { useEffect } from 'react';
import { useSelector } from 'react-redux';
import { fetchTeamRecord } from '../../../../../../../redux/actions/teamActions';
import { RootState, useAppDispatch } from '../../../../../../../redux/store';
import MyLoading from '../../../../../../common/MyLoading';
import { TeamRecord, RecordDetail } from '../../../../../../../types/teamTypes';

interface TeamRecordComponentProps {
    teamId: number;
    teamSeason: number;
}

interface TeamState {
    teamRecord: TeamRecord | null;
    isFetchingTeamRecord: boolean;
}

const TeamRecordTileFront: React.FC<TeamRecordComponentProps> = ({ teamId, teamSeason }) => {
    const dispatch = useAppDispatch();
    const { teamRecord, isFetchingTeamRecord } = useSelector((state: RootState) => state.team) as TeamState;

    useEffect(() => {
        dispatch(fetchTeamRecord(teamId, teamSeason));
    }, [dispatch, teamId, teamSeason]);

    const formatRecord = (record: RecordDetail) => {
        return `${record.wins ?? 0}-${record.losses ?? 0}-${record.ties ?? 0}`;
    };

    return (
        <div>
            {isFetchingTeamRecord ? (
                <MyLoading message="Team Record is Loading..." />
            ) : teamRecord ? (
                <div style={{
                    fontSize: '2.5rem', // Typical font size for h1
                    fontWeight: 'bold', // h1 is usually bold
                }}>
                    <h1>{formatRecord(teamRecord.total)}</h1>
                </div>

            ) : (
                <p>No record found.</p>
            )}
        </div>
    );
};
export default TeamRecordTileFront;
