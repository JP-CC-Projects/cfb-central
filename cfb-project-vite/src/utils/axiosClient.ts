// axiosClient.ts
import axios from 'axios';
import applyCaseMiddleware from 'axios-case-converter';

const axiosClient = applyCaseMiddleware(axios.create());
export default axiosClient;
