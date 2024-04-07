
import ClippedDrawer from '../common/nav/ClippedDrawer';
import { Outlet } from 'react-router-dom';


  const MainLayout = () => {
  return (
    <div>
      <ClippedDrawer>
        <Outlet /> {/* This will render the child route component */}
      </ClippedDrawer>
    </div>
  );
};
export default MainLayout;
