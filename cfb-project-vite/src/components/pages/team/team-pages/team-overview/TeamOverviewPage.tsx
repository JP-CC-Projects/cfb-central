//TeamOverviewPage.tsx
import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { AppDispatch, RootState } from '../../../../../redux/store';
import { fetchTeamDetails } from '../../../../../redux/actions/teamActions';
import { useParams } from 'react-router-dom';
import TileComponent from './tiles/TileComponent';


const TeamOverviewPage: React.FC = () => {
    const { teamId: teamIdStr } = useParams<{ teamId?: string }>();
    const teamId = teamIdStr ? parseInt(teamIdStr, 10) : null;
    const dispatch = useDispatch<AppDispatch>();
    const teamDetails = useSelector((state: RootState) => state.team.teamDetails);

    useEffect(() => {
        if (teamId && !isNaN(teamId)) {
          dispatch(fetchTeamDetails(teamId));
        }
      }, [dispatch, teamId]);
    
      if (!teamId || isNaN(teamId)) {
        return (
          <p>Invalid Team ID</p>
        );
      }
    return (
        <div className="w-full">
            <TileComponent teamId={teamId} teamDetails={teamDetails} />
        </div>
    );
};
export default TeamOverviewPage;
