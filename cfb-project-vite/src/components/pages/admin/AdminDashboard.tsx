import React, { useState } from 'react';
import styles from './AdminDashboard.module.css';
import { handleFetchTeams, handleFetchGames, handleFetchPlayers, handleFetchPlays, handleFetchTeamRecords, handleCalculateQtrScores } from './adminRequests';

const AdminDashboard: React.FC = () => {
  const [season, setSeason] = useState<number>(2024); // Default year
  const [week, setWeek] = useState<number>(1); // Default week


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
        <button onClick={() => handleFetchPlayers(season)}>Fetch</button>
      </div>
      <div className={styles.row}>
        <span>Fetch games for season:</span>
        <input type="number" value={season} onChange={(e) => setSeason(parseInt(e.target.value))} className={styles.seasonInput} />
        <div />
        <div />
        <div />
        <button onClick={() => handleFetchGames(season)}>Fetch</button>
      </div>

      <div className={styles.row}>
        <span>Fetch team records for season:</span>
        <input type="number" value={season} onChange={(e) => setSeason(parseInt(e.target.value))} className={styles.seasonInput} />
        <div />
        <div />
        <div />
        <button onClick={() => handleFetchTeamRecords(season)}>Fetch</button>
      </div>
      <div className={styles.row}>
        <span>Fetch plays for season and week:</span>
        <input type="number" value={season} onChange={(e) => setSeason(parseInt(e.target.value))} className={styles.seasonInput} />
        <input type="number" value={week} onChange={(e) => setWeek(parseInt(e.target.value))} className={styles.seasonInput} />
        <div />
        <div />
        <button onClick={() => handleFetchPlays(season, week)}>Fetch</button>
      </div>
      <div className={styles.row}>
        <span>Fetch teams to database:</span>
        <div />
        <div />
        <div />
        <div />
        <button onClick={handleCalculateQtrScores}>Fetch</button>
      </div>
    </div>
  );
};

export default AdminDashboard;
