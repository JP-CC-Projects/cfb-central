// src/App.tsx
import { Provider } from 'react-redux';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import store from './redux/store';
import TeamPage from './components/pages/team/TeamPage'; 
import HomePage from './components/pages/home/HomePage'; 
import SchedulePage from './components/pages/schedule/SchedulePage'; 
import MapPage from './components/pages/map/MapPage';
import LoginPage from './components/pages/login/LoginPage';
 
function App() {
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
            <Route path="/:teamId/map" element = {<MapPage />} />
            <Route path="/login" element = {<LoginPage />} />
          </Routes>
        </div>
      </Router>
    </Provider>
  );
}

export default App;
