import React from 'react';
import { useSelector } from 'react-redux';
import { RootState } from '../../../../redux/store';
import MyLoading from '../../../common/MyLoading';
import { TeamRecord, RecordDetail } from '../../../../types/teamTypes';

interface TeamRecordComponentProps {
    teamId: number;
    teamSeason: number;
}

interface TeamState {
    teamRecord: TeamRecord | null; 
    isFetchingTeamRecord: boolean;
}

const TeamRecordTileBack: React.FC<TeamRecordComponentProps> = () => {
    // const dispatch = useAppDispatch();
    const { teamRecord, isFetchingTeamRecord } = useSelector((state: RootState) => state.team) as TeamState;
    const formatRecord = (record: RecordDetail) => {
        return `${record.wins ?? 0}-${record.losses ?? 0}-${record.ties ?? 0}`;
    };

    return (
        <div>
            {isFetchingTeamRecord ? (
                <MyLoading message="Loading record component..." />
            ) : teamRecord ? (
                <table>
                    <tbody>
                        <tr>
                            <td>Overall:  </td>
                            <td>{formatRecord(teamRecord.total)}</td>
                        </tr>
                        <tr>
                            <td>Conference:  </td>
                            <td>{formatRecord(teamRecord.conferenceGames)}</td>
                        </tr>
                        <tr>
                            <td>Home Games:  </td>
                            <td>{formatRecord(teamRecord.homeGames)}</td>
                        </tr>
                        <tr>
                            <td>Road Games:  </td>
                            <td>{formatRecord(teamRecord.awayGames)}</td>
                        </tr>
                    </tbody>
                </table>
            ) : (
                <p>No record found.</p>
            )}
        </div>
    );
};
export default TeamRecordTileBack;
