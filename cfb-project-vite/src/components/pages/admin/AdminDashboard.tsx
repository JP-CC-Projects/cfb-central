import React from 'react';
import axios from 'axios';
import styles from './AdminDashboard.module.css'; 

const ADMIN_BASE_URL = `${import.meta.env.VITE_APP_BASE_URL}/admin`;

// const API_BASE_URL = railway env; -- add in prod!!
const adminToken = import.meta.env.ADMIN_TOKEN || '';

const AdminDashboard: React.FC = () => {
    const handleFetchTeams = async () => {
        try {
          const response = await axios.get(`${ADMIN_BASE_URL}/fetchTeams`, {
            headers: {
              Authorization: `Bearer ${adminToken}`
            }
          });
          console.log(response.data);
          // Process your team data here
        } catch (error) {
          console.error('Error fetching teams:', error);
        }
      };

  const handleFetchPlayers = async () => {
    try {
      const response = await axios.get('YOUR_API_ENDPOINT_FOR_PLAYERS');
      console.log(response.data);
      // Process your player data here
    } catch (error) {
      console.error('Error fetching players:', error);
    }
  };

  return (
    <div className={styles.dashboard}>
      <div className={styles.row}>
        <span>Fetch teams to database:</span>
        <button onClick={handleFetchTeams}>Fetch</button>
      </div>
      <div className={styles.row}>
        <span>Fetch players</span>
        <button onClick={handleFetchPlayers}>Fetch</button>
      </div>
    </div>
  );
};
export default AdminDashboard;
