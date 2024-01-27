// src/services/authService.ts
import axios from '../utils/axios'; 
const REFRESH_URL = `${import.meta.env.VITE_APP_BASE_URL}/refresh-token`;

const refreshToken = async (): Promise<string> => {
  try {
    const response = await axios.get(REFRESH_URL); 
    const newAccessToken = response.data.accessToken; 
    return newAccessToken;
  } catch (error) {
    console.error('Error refreshing token:', error);
    throw error; 
  }
};

export default refreshToken;
