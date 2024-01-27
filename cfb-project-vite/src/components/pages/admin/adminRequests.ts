import axios from '../../../utils/axios';

const ADMIN_BASE_URL = `${import.meta.env.VITE_APP_BASE_URL}/admin`;
const accessToken = localStorage.getItem('accessToken');

export const handleFetchTeams = async () => {
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



export const handleFetchSeasonCalendar = async (season: number) => {
    try {
        const response = await axios.post(`${ADMIN_BASE_URL}/fetchSeasonCalendar`, null, {
            params: {
                season: season  // Send 'season' as a query parameter
            },
            headers: {
                Authorization: `Bearer ${accessToken}`
            }
        });
        console.log(response.data);
    } catch (error) {
        console.error('Error fetching season calendar:', error);
    }
};


export const handleFetchGames = async (season : number) => {
    try {
        const response = await axios.post(`${ADMIN_BASE_URL}/fetchGames`, null, {
            params: {
                season: season  
            },
            headers: {
                Authorization: `Bearer ${accessToken}`
            }
        });
        console.log(response.data);
    } catch (error) {
        console.error('Error fetching games:', error);
    }
};

export const handleFetchPlayers = async (season: number) => {
    try {
        const response = await axios.post(`${ADMIN_BASE_URL}/fetchPlayers`, {}, {
            params: {
                year: season  
            },
            headers: {
                Authorization: `Bearer ${accessToken}`
            }
        });
        console.log(response.data);
    } catch (error) {
        console.error('Error fetching players:', error);
    }
};

export const handleFetchTeamRecords = async (season: number) => {
    try {
        const response = await axios.post(`${ADMIN_BASE_URL}/fetchTeamRecords`, { year: season }, {
            headers: {
                Authorization: `Bearer ${accessToken}`
            }
        });
        console.log(response.data);
    } catch (error) {
        console.error('Error fetching team records:', error);
    }
};
export const handleFetchPlays = async (season : number, week : number) => {
    try {
        const response = await axios.post(`${ADMIN_BASE_URL}/fetchPlays`, { year: season, week }, {
            headers: {
                Authorization: `Bearer ${accessToken}`
            }
        });
        console.log(response.data);
    } catch (error) {
        console.error('Error fetching plays:', error);
    }
};
