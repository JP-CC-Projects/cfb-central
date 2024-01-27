import axios from './axiosClient'; 
import store from '../redux/store';
import { LOGIN_SUCCESS, LOGOUT } from '../redux/actions/authActions';

const setupAxiosInterceptor = () => {
  axios.interceptors.response.use(
    response => response,
    async error => {
      const originalRequest = error.config;
      if (error.response.status === 401 && !originalRequest._retry) {
        originalRequest._retry = true;
        try {
          // Refresh token logic here
          const newAccessToken = await refreshToken(); // Implement this function
          store.dispatch({
            type: LOGIN_SUCCESS,
            payload: { accessToken: newAccessToken }
          });
          originalRequest.headers['Authorization'] = `Bearer ${newAccessToken}`;
          return axios(originalRequest);
        } catch (refreshError) {
          store.dispatch({ type: LOGOUT });
          // Redirect to login or handle error
          return Promise.reject(refreshError);
        }
      }
      return Promise.reject(error);
    }
  );
};

export default setupAxiosInterceptor;
