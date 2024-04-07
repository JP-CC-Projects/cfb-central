import { useSelector } from 'react-redux';
import { RootState } from '../../../../../../../redux/store'; // Adjust the import path as needed

const SchoolTileBack = () => {
    const teamDetails = useSelector((state: RootState) => state.team.teamDetails);

    return (
        teamDetails && (
            <div className="flex items-center space-x-4">
                {teamDetails.logos && teamDetails.logos.length > 0 && (
                    <img src={teamDetails.logos[0]} alt={`${teamDetails.school} logo`} className="h-20 w-20" />
                )}
                <div>
                    <h1 className="text-2xl font-bold">{teamDetails.school}</h1>
                    <h2 className="text-xl">{teamDetails.mascot}</h2>
                    <p className="text-sm">{teamDetails.abbreviation}</p>
                </div>
            </div>
        )
    );
};

export default SchoolTileBack;
