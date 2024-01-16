import { useSelector } from 'react-redux';
import { RootState } from '../../../../redux/store';

const StadiumTileFront = () => {
    const teamDetails = useSelector((state: RootState) => state.team.teamDetails);

    return (
        teamDetails &&
<div
    style={{
        backgroundImage: `url(${teamDetails.location.venue_image_url})`,
        width: '100%', 
        height: '100%',
        backgroundSize: 'cover', 
        backgroundPosition: 'center',
        backgroundRepeat: 'no-repeat', 
        borderRadius: '10px' 
    }}>
</div>
    );
};

export default StadiumTileFront;
