// src/services/authService.ts
import axios from '../utils/axios'; 

const refreshToken = async (): Promise<string> => {
  try {
    const response = await axios.get('/refresh-token'); 
    const newAccessToken = response.data.accessToken; 
    return newAccessToken;
  } catch (error) {
    console.error('Error refreshing token:', error);
    throw error; 
  }
};

export default refreshToken;
