//TeamTimeOverviewTab.tsx
import { TeamDetails } from '../../../../../types/teamTypes';
import TileComponent from './tiles/TileComponent';

interface TeamDetailsProps {
    teamId: number;
    teamDetails: TeamDetails;
}

const TeamOverviewTab: React.FC<TeamDetailsProps> = ({ teamId, teamDetails }) => {


    return (
        <div className="w-full">
            <TileComponent teamId={teamId} teamDetails={teamDetails} />
        </div>
    );
};
export default TeamOverviewTab;
