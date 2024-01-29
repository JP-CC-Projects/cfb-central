import axios from '../../../utils/axios';

const ADMIN_BASE_URL = `${import.meta.env.VITE_APP_BASE_URL}/admin`;
const accessToken = localStorage.getItem('accessToken');

export const handleFetchTeams = async () => {
    try {
        const response = await axios.post(`${ADMIN_BASE_URL}/triggerTeamsFetch`, {}, {
            headers: {
                Authorization: `Bearer ${accessToken}`
            }
        });
        console.log(response.data);
    } catch (error) {
        console.error('Error fetching teams:', error);
    }
};



export const handleFetchPlayers = async (season: number) => {
    try {
        const response = await axios.post(`${ADMIN_BASE_URL}/triggerPlayersFetch`, {}, {
            params: { season: season },
            headers: { Authorization: `Bearer ${accessToken}` }
        });
        console.log(response.data);
    } catch (error) {
        console.error('Error fetching players:', error);
    }
};

export const handleFetchGames = async (season: number) => {
    try {
        const response = await axios.post(`${ADMIN_BASE_URL}/triggerGamesFetch`, null, {
            params: { season: season },
            headers: { Authorization: `Bearer ${accessToken}` }
        });
        console.log("Games fetch response:", response.data);
    } catch (error) {
        console.error('Error fetching games:', error);
    }
};

export const handleFetchTeamRecords = async (season: number) => {
    try {
        const response = await axios.post(`${ADMIN_BASE_URL}/triggerTeamRecordsFetch`, null, {
            params: { season: season },
            headers: { Authorization: `Bearer ${accessToken}` }
        });
        console.log("Games fetch response:", response.data);
    } catch (error) {
        console.error('Error fetching team records:', error);
    }
};

export const handleFetchPlays = async (season: number, week: number) => {
    try {
        const response = await axios.post(`${ADMIN_BASE_URL}/triggerPlaysFetch`, null, {
            params: {
                season: season,
                week: week
            },
            headers: { Authorization: `Bearer ${accessToken}` }
        });
        console.log("Games fetch response:", response.data);
    } catch (error) {
        console.error('Error fetching plays:', error);
    }
};


export const handleCalculateQtrScores = async () => {
    try {
        const response = await axios.post(`${ADMIN_BASE_URL}/triggerCalculateQtrScores`, {}, {
            headers: {
                Authorization: `Bearer ${accessToken}`
            }
        });
        console.log(response.data);
    } catch (error) {
        console.error('Error calculating quarter scores:', error);
    }
};



export const handleRemoveNullPlayers = async () => {
    try {
        const response = await axios.post(`${ADMIN_BASE_URL}/removeNullPlayers`, {}, {
            headers: {
                Authorization: `Bearer ${accessToken}`
            }
        });
        console.log(response.data);
    } catch (error) {
        console.error('Error fetching fixing player nulls:', error);
    }
};