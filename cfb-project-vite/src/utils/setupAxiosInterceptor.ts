import axios from './axiosClient'; 
import store from '../redux/store';
import { LOGIN_SUCCESS, LOGOUT } from '../redux/actions/authActions';
import refreshToken from '../services/authService';

const setupAxiosInterceptor = () => {
  axios.interceptors.response.use(
    response => response,
    async error => {
      const originalRequest = error.config;
      if (error.response.status === 401 && !originalRequest._retry) {
        originalRequest._retry = true;
        try {
          // Refresh token logic here
          const newAccessToken = await refreshToken(); 
          // Update local storage with the new access token
          localStorage.setItem('accessToken', newAccessToken);
          // Update Redux store (optional, depends on how you manage state)
          store.dispatch({
            type: LOGIN_SUCCESS,
            payload: { accessToken: newAccessToken }
          });

          // Update the authorization header with the new token
          originalRequest.headers['Authorization'] = `Bearer ${newAccessToken}`;
          return axios(originalRequest);
        } catch (refreshError) {
          // Handle refresh token errors
          store.dispatch({ type: LOGOUT });
          return Promise.reject(refreshError);
        }
      }
      return Promise.reject(error);
    }
  );
};

export default setupAxiosInterceptor;
