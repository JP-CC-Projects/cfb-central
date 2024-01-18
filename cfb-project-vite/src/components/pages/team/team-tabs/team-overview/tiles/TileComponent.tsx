import { useState } from 'react';
import './TileComponent.css'; // Import the CSS file
import { TeamDetails } from '../../../../../../types/teamTypes';
import TeamRecordTileBack from './tile-team-record/TeamRecordTileBack';
import SchoolTileFront from './tile-school/SchoolTileFront';
import SchoolTileBack from './tile-school/SchoolTileBack';
import StadiumTileFront from './tile-stadium/StadiumTileFront'
import StadiumTileBack from './tile-stadium/StadiumTileBack';
import TeamRecordTileFront from './tile-team-record/TeamRecordTileFront';
interface TeamDetailsProps {
    teamId: number;
    teamDetails: TeamDetails;
}
const TileComponent: React.FC<TeamDetailsProps> = ({ teamId, teamDetails }) => {
    if (teamDetails) {
        console.log(`teamDetails received for teamId ${teamId}`);
    }
    const [flippedStates, setFlippedStates] = useState(Array(6).fill(false));
    const handleFlip = (index: number) => {
        const newFlippedStates = [...flippedStates];
        newFlippedStates[index] = !newFlippedStates[index];
        setFlippedStates(newFlippedStates);
    };

    const renderFrontContent = (index: number) => {
        // Custom content for the front of each tile
        switch (index) {
            case 0: return <TeamRecordTileFront teamId={teamId} teamSeason={2023}/>;
            case 1: return <SchoolTileFront/>;
            case 2: return <StadiumTileFront/>;
            case 3: return ;
            case 4: return ;
            case 5: return ;
            case 6: return ;
        }
    };

    const renderBackContent = (index: number) => {
        // Custom content for the back of each tile
        switch (index) {
            case 0: return <div><TeamRecordTileBack teamId={teamId} teamSeason={2023} /></div>;
            case 1: return <SchoolTileBack/>;
            case 2: return <StadiumTileBack/>;
            case 3: return ;
            case 4: return ;
            case 5: return ;
            case 6: return ;
        }
    };
    

    return (
        
        <div className="tile-container">
            {flippedStates.map((isFlipped, index) => (
                <div 
                    key={index} 
                    className={`tile ${isFlipped ? 'flipped' : ''}`} 
                    onClick={() => handleFlip(index)}
                >
                    <div className="tile-front">
                        {renderFrontContent(index)}
                    </div>
                    <div className="tile-back">
                        {renderBackContent(index)}
                    </div>
                </div>
            ))}
        </div>
    );
};

export default TileComponent;
