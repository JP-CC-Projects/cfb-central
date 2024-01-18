import TeamSearchAutocomplete from '../../common/TeamSearchAutocomplete';
import mainLogo from '../../../assets/mainlogo.png';
const HomePage = () => {
  return (
    <div className="bg-black flex flex-col h-screen">
      {/* Pseudo-element to push content up */}
      <div className="h-1/6"></div>

      {/* Main content */}
      <div className="flex-1 flex justify-center items-center">
        <div className="text-center">
          <div className="flex flex-col justify-center items-center">
            <img src={mainLogo} alt="Main Logo" className="w-2/3 lg:w-1/3 mb-5" />
            <div className="w-full lg:w-80">
              <TeamSearchAutocomplete />
            </div>
          </div>
        </div>
      </div>

      {/* Prevent content stretch to the bottom */}
      <div className="flex-1"></div>
    </div>
  );
};

export default HomePage;


