import React, { useState } from 'react';
import axios from '../../../utils/axios';
import styles from './AdminDashboard.module.css';

const ADMIN_BASE_URL = `${import.meta.env.VITE_APP_BASE_URL}/admin`;
const accessToken = localStorage.getItem('accessToken');

const AdminDashboard: React.FC = () => {
  const [season, setSeason] = useState<number>(2024); // Default year
  const [week, setWeek] = useState<number>(1); // Default week

  const handleFetchTeams = async () => {
    try {
      const response = await axios.post(`${ADMIN_BASE_URL}/fetchTeams`, {}, {
        headers: {
          Authorization: `Bearer ${accessToken}`
        }
      });
      console.log(response.data);
    } catch (error) {
      console.error('Error fetching teams:', error);
    }
  };

  const handleFetchPlayers = async () => {
    try {
      const response = await axios.post(`${ADMIN_BASE_URL}/fetchPlayers`, {}, {
        headers: {
          Authorization: `Bearer ${accessToken}`
        },
        params: {
          year: season
        }
      });
      console.log(response.data);
    } catch (error) {
      console.error('Error fetching teams:', error);
    }
  };


  const handleFetchSeasonCalendar = async () => {
    try {
      const response = await axios.post(`${ADMIN_BASE_URL}/fetchSeasonCalendar`, null, {
        headers: {
          Authorization: `Bearer ${accessToken}`
        },
        params: {
          season: season
        }
      });
  
      console.log(response.data);
    } catch (error) {
      console.error('Error fetching season calendar:', error);
    }
  };

  const handleFetchGames = async () => {
    try {
      const response = await axios.post(`${ADMIN_BASE_URL}/fetchGames`, { season }, {
        headers: {
          Authorization: `Bearer ${accessToken}`
        },
        params: {
          season: season
        }
      });
      console.log(response.data);
    } catch (error) {
      console.error('Error fetching games:', error);
    }
  };

  const handleFetchTeamRecords = async () => {
    try {
      const response = await axios.post(`${ADMIN_BASE_URL}/fetchTeamRecords`, { year: season }, {
        headers: {
          Authorization: `Bearer ${accessToken}`
        },
        params: {
          year: season
        }
      });
      console.log(response.data);
    } catch (error) {
      console.error('Error fetching team records:', error);
    }
  };
  const handleFetchPlays = async () => {
    try {
      const response = await axios.post(`${ADMIN_BASE_URL}/fetchPlays`, { year: season, week }, {
        headers: {
          Authorization: `Bearer ${accessToken}`
        },
        params: {
          year: season
        }
      });
      console.log(response.data);
    } catch (error) {
      console.error('Error fetching plays:', error);
    }
  };

  return (
    <div className={styles.dashboard}>
      <div className={`${styles.row} ${styles.headerRow}`}>
        <span>Description:</span>
        <div>Season:</div>
        <div>Week:</div>
        <div></div>
        <div></div>
        <div></div>
      </div>
      <div className={styles.row}>
        <span>Fetch teams to database:</span>
        <div />
        <div />
        <div />
        <div />
        <button onClick={handleFetchTeams}>Fetch</button>
      </div>
      <div className={styles.row}>
        <span>Fetch players</span>
        <input type="number" value={season} onChange={(e) => setSeason(parseInt(e.target.value))} className={styles.seasonInput} />
        <div />
        <div />
        <div />
        <button onClick={handleFetchPlayers}>Fetch</button>
      </div>
      <div className={styles.row}>
        <span>Fetch season calendar for:</span>
        <input type="number" value={season} onChange={(e) => setSeason(parseInt(e.target.value))} className={styles.seasonInput} />
        <div />
        <div />
        <div />
        <button onClick={handleFetchSeasonCalendar}>Fetch</button>
      </div>

      <div className={styles.row}>
        <span>Fetch games for season:</span>
        <input type="number" value={season} onChange={(e) => setSeason(parseInt(e.target.value))} className={styles.seasonInput} />
        <div />
        <div />
        <div />
        <button onClick={handleFetchGames}>Fetch</button>
      </div>

      <div className={styles.row}>
        <span>Fetch team records for year:</span>
        <input type="number" value={season} onChange={(e) => setSeason(parseInt(e.target.value))} className={styles.seasonInput} />
        <div />
        <div />
        <div />
        <button onClick={handleFetchTeamRecords}>Fetch</button>
      </div>

      <div className={styles.row}>
        <span>Fetch plays for season and week:</span>
        <input type="number" value={season} onChange={(e) => setSeason(parseInt(e.target.value))} className={styles.seasonInput} />
        <input type="number" value={week} onChange={(e) => setWeek(parseInt(e.target.value))} className={styles.seasonInput} />
        <div />
        <div />
        <button onClick={handleFetchPlays}>Fetch</button>
      </div>
    </div>
  );
};

export default AdminDashboard;
