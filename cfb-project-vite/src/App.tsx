// src/App.tsx
import { Provider } from 'react-redux';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import store from './redux/store';
import TeamPage from './components/pages/team/TeamPage';
import HomePage from './components/pages/home/HomePage';
import SchedulePage from './components/pages/schedule/SchedulePage';
import MapPage from './components/pages/map/MapPage';
import LoginPage from './components/pages/auth/LoginPage';
import Logout from './components/pages/auth/Logout';
import AdminDashboard from './components/pages/admin/AdminDashboard';
import { useDispatch } from 'react-redux';
import { useEffect } from 'react';
import setupAxiosInterceptor from './utils/setupAxiosInterceptor';
import ProfilePage from './components/pages/user/ProfilePage';
import RegisterPage from './components/pages/auth/RegisterPage';

const App: React.FC = () => {
  const dispatch = useDispatch();
  useEffect(() => {
    setupAxiosInterceptor();
    const accessToken = localStorage.getItem('accessToken');
    if (accessToken) {
      dispatch({ type: 'LOGIN_SUCCESS', payload: accessToken });
    }
  }, [dispatch]);

  return (
    <Provider store={store}>
      <Router>
        <div className="App">
          <header className="App-header">
          </header>
          <Routes>
            <Route path="/" element={<HomePage />} /> {/* HomePage component */}
            <Route path="/:teamId/team" element={<TeamPage />} /> {/* TeamPage component for individual team */}
            <Route path="/schedule" element={<SchedulePage />} /> {/* SchedulePage component */}
            <Route path="/:teamId/map" element={<MapPage />} />
            <Route path="/login" element={<LoginPage />} />
            <Route path="/register" element={<RegisterPage />} />
            <Route path="/admin" element={<AdminDashboard />} />
            <Route path="/profile" element={<ProfilePage />} />
            <Route path="/logout" element={<Logout />} />
          </Routes>
        </div>
      </Router>
    </Provider>
  );
}

export default App;
