// MapPage.tsx 
import MapComponent from "./MapComponent";
import { useParams } from "react-router-dom";

const MapPage = () => {
    const { teamId } = useParams<{ teamId?: string }>();
    // Default to 0 (or another appropriate default value) if teamId is undefined
    const parsedTeamId = teamId ? parseInt(teamId, 10) : 0;
    // Date-related Constants
    const currentDate = new Date();
    const currentMonth = currentDate.getMonth();
    const currentYear = currentDate.getFullYear();
    // Will list 2023 Season Stats until August:
    const teamSeason = currentMonth < 8 ? currentYear - 1 : currentYear;
    return (
        <div>
            <MapComponent teamId={parsedTeamId} teamSeason={teamSeason} />
        </div>
    );
};

export default MapPage;
