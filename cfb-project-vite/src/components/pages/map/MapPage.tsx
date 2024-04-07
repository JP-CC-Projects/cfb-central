// MapPage.tsx 
import MapComponent from "./MapComponent";
import { useParams } from "react-router-dom";

const MapPage = () => {
    const { teamId } = useParams<{ teamId?: string }>();
    // Default to 0 (or another appropriate default value) if teamId is undefined
    const parsedTeamId = teamId ? parseInt(teamId, 10) : 0;

    return (
            <div>
                <MapComponent teamId={parsedTeamId} teamSeason={2023} />
            </div>
    );
};

export default MapPage;
