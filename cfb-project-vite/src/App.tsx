// src/App.tsx
import { Provider } from 'react-redux';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import store from './redux/store';
import TeamPage from './components/pages/TeamPage'; // Import the component for individual team page
import HomePage from './components/pages/HomePage'; // Import the component for individual team page
import SchedulePage from './components/pages/SchedulePage'; // Adjust the path as necessary
import LoginPage from './components/pages/LoginPage';
import MapPage from './components/pages/MapPage';

function App() {
  return (
    <Provider store={store}>
      <Router>
        <div className="App">
          <header className="App-header">
            {/* Put some common header content or navigation here */}
          </header>
          <Routes>
            <Route path="/" element={<HomePage />} /> {/* HomePage component */}
            <Route path="/:teamId/team" element={<TeamPage />} /> {/* TeamPage component for individual team */}
            <Route path="/schedule" element={<SchedulePage />} /> {/* SchedulePage component */}
            {/* <Route path="/login" element = {<LoginPage />} /> */}
            <Route path="/:teamId/map" element = {<MapPage />} />
          </Routes>
        </div>
      </Router>
    </Provider>
  );
}

export default App;
