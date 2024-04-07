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
import ProfilePage from './components/pages/user/ProfilePage';
import RegisterPage from './components/pages/auth/RegisterPage';
import MainLayout from './components/layout/MainLayout';
import AppInitializer from './AppInitializer';
import TeamRosterPage from './components/pages/team/team-pages/team-page-roster/TeamRosterPage';
import ChartComponent from './components/pages/team/team-pages/team-page-chart/ChartComponent';
import TeamTimelinePage from './components/pages/team/team-pages/team-page-timeline/TeamTimeLinePage';

const App: React.FC = () => {

  return (
    <Provider store={store}>
      <Router>
        <AppInitializer>
          <div className="App">
            <header className="App-header">
            </header>
            <Routes>
              <Route path="/" element={<HomePage />} />
              <Route path="/:teamId/" element={<MainLayout />}>
                <Route path="team" element={<TeamPage />} />
                <Route path="timeline" element={<TeamTimelinePage />} />
                <Route path="roster" element={<TeamRosterPage />} />
                <Route path="chart" element={<ChartComponent />} />
                <Route path="map" element={<MapPage />} />
              </Route>
              <Route path="/login" element={<LoginPage />} />
              <Route path="/register" element={<RegisterPage />} />
              <Route path="/admin" element={<AdminDashboard />} />
              <Route path="/schedule" element={<SchedulePage />} /> {/* SchedulePage component */}
              <Route path="/profile" element={<ProfilePage />} />
              <Route path="/logout" element={<Logout />} />
            </Routes>
          </div>
        </AppInitializer>
      </Router>
    </Provider>
  );
}

export default App;
