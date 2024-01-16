import { useSelector } from 'react-redux';
import { RootState } from '../../../../redux/store';

const SchoolTileFront = () => {
    const teamDetails = useSelector((state: RootState) => state.team.teamDetails);

    return (
        teamDetails && <img src={teamDetails.logos[0]} alt={`${teamDetails.school} logo`} className="h-40 w-40" />
    );
};

export default SchoolTileFront;
