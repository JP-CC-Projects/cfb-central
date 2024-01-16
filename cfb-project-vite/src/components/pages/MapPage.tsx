// MapPage.tsx 
import MapComponent from "../features/map/MapComponent";
import { useParams } from "react-router-dom";
import MainLayout from "../layout/MainLayout";

const MapPage = () => {
    const { teamId } = useParams<{ teamId?: string }>();
    // Default to 0 (or another appropriate default value) if teamId is undefined
    const parsedTeamId = teamId ? parseInt(teamId, 10) : 0;

    return (
        <MainLayout>
            <div>
                <MapComponent teamId={parsedTeamId} teamSeason={2023} />
            </div>
        </MainLayout>
    );
};

export default MapPage;
