import TeamSearchAutocomplete from '../../common/TeamSearchAutocomplete';
import mainLogo from '../../../assets/mainlogo2.png';
import backgroundVideo from '../../../assets/bgvid.mp4';


const HomePage = () => {
  return (
    <div className="bg-black flex flex-col h-screen">

      <video autoPlay loop muted playsInline className="absolute w-full h-full object-cover">
        <source src={backgroundVideo} type="video/mp4" />
        Your browser does not support the video tag.
      </video>

      {/* Dark Overlay */}
      <div className="absolute w-full h-full bg-black opacity-70"></div>
      <div className="m-auto z-10 text-center">
        {/* Main content */}
        <div className="flex justify-center items-center">
          <div>
            <div className="flex flex-col justify-center items-center opacity-60">
            <img src={mainLogo} alt="Main Logo" className="w-full lg:w-full mb-5" />
              <div className="w-full lg:w-80">
                <TeamSearchAutocomplete />
              </div>
            </div>
          </div>
        </div>

        {/* Prevent content stretch to the bottom */}
        <div className="flex-1"></div>
      </div>
    </div>
  );
};

export default HomePage;


