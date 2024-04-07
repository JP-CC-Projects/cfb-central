// src/components/common/header/Header.tsx
import { useSelector } from 'react-redux';
import { Link, useLocation, useParams } from 'react-router-dom';
import { RootState, useAppDispatch } from '../../../redux/store';
import { useEffect, useState } from 'react';
import { contrastUtils } from '../../../utils/isContrastReadable';
import { fetchTeamDetails } from '../../../redux/actions/teamActions';

const Header = () => {
  const isAuthenticated = useSelector((state: RootState) => state.auth.isAuthenticated);
  const teamDetails = useSelector((state: RootState) => state.team.teamDetails);
  const { teamId: teamIdStr } = useParams<{ teamId?: string }>();
  const teamId = teamIdStr ? parseInt(teamIdStr, 10) : null;
  const location = useLocation();
  const [bgColor, setBgColor] = useState('');
  const dispatch = useAppDispatch();
  
  useEffect(() => {
    if (teamId && !isNaN(teamId)) {
      dispatch(fetchTeamDetails(teamId));
    }
  }, [dispatch, teamId]);

  if (!teamId || isNaN(teamId)) {
    return (
      <p>Invalid Team ID</p>
    );
  }




  useEffect(() => {
    if (location.pathname.startsWith('/')) {
      let newBgColor = '';
      if (teamDetails?.color) {
        const isReadable = contrastUtils.isContrastReadable(teamDetails.color, '#FFFFFF');
        if (isReadable) {
          newBgColor = teamDetails.color;
        } else if (teamDetails.altColor) {
          const isAltReadable = contrastUtils.isContrastReadable(teamDetails.altColor, '#FFFFFF');
          if (isAltReadable) {
            newBgColor = teamDetails.altColor;
          }
        }
      }
      setBgColor(newBgColor);
    } else {
      setBgColor('#1F2937'); // Default color if no colors are readable
    }
  }, [location, teamDetails]);

  return (
    // <nav style={{ backgroundColor: bgColor }} className="text-white p-4 relative">

    <nav style={{ backgroundColor: bgColor, position: 'fixed', top: 0, width: '100%', height: 80, zIndex: 2000 /* AppBar z-index */ }} className="text-white p-4 relative">

      <div className="flex justify-between items-center">
        <div>
        </div>

        {/* Center Content - Team Logo */}
        {teamDetails && teamDetails.logos && teamDetails.logos.length > 0 && (
          <div className="logo-container">
            <img src={teamDetails.logos[0]} alt="Team Logo" />
          </div>
        )}

        {/* Right Side Content - Navigation Links */}
        <div className="hidden md:flex">
          <Link to="/" className="mr-4">Home</Link>
          {isAuthenticated ? (
            <>
              <Link to="/profile" className="mr-4">Profile</Link>
              <Link to="/logout" className="mr-4">Logout</Link>
            </>
          ) : (
            <>
              <Link to="/login" className="mr-4">Login</Link>
              <Link to="/register">Register</Link>
            </>
          )}
        </div>

        {/* Placeholder for balancing layout */}
        <div className="text-lg font-bold opacity-0 md:hidden"></div>
      </div>
    </nav>
  );
};

export default Header;
