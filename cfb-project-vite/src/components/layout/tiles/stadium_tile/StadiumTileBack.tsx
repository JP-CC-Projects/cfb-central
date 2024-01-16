import { useSelector } from 'react-redux';
import { RootState } from '../../../../redux/store';

const StadiumTileBack = () => {
    const teamDetails = useSelector((state: RootState) => state.team.teamDetails);

    return (teamDetails &&
        <div>
        <p>Name: {teamDetails.location.name}</p>
        <p>Location: {teamDetails.location.city}, {teamDetails.location.state}</p>
        <p>Capacity: {teamDetails.location.capacity}</p>
        <p>Constructed in: {teamDetails.location.year_constructed}</p>
        <p>Field: {teamDetails.location.grass ? "Real grass" : "Fake grass"} </p>
    </div>
    );
};

export default StadiumTileBack;
