import axios from 'axios';
import axiosClient from '../../utils/axiosClient';
import { NationAvgChartData, PlayerChartData, TeamChartData } from '../../types/chartTypes';
import { AppDispatch } from '../store';

// Define action type constants
const FETCH_PLAYER_CHART_SUCCESS = 'FETCH_PLAYER_CHART_SUCCESS';
const FETCH_PLAYER_CHART_FAILURE = 'FETCH_PLAYER_CHART_FAILURE';
const START_FETCHING_PLAYER_CHART = 'START_FETCHING_PLAYER_CHART';
const STOP_FETCHING_PLAYER_CHART = 'STOP_FETCHING_PLAYER_CHART';

const FETCH_TEAM_CHART_SUCCESS = 'FETCH_TEAM_CHART_SUCCESS';
const FETCH_TEAM_CHART_FAILURE = 'FETCH_TEAM_CHART_FAILURE';
const START_FETCHING_TEAM_CHART = 'START_FETCHING_TEAM_CHART';
const STOP_FETCHING_TEAM_CHART = 'STOP_FETCHING_TEAM_CHART';

const FETCH_NAT_AVG_CHART_SUCCESS = 'FETCH_NAT_AVG_CNAT_AVG_SUCCESS';
const FETCH_NAT_AVG_CHART_FAILURE = 'FETCH_NAT_AVG_CHART_FAILURE';
const START_FETCHING_NAT_AVG_CHART = 'START_FETCHING_NAT_AVG_CHART';
const STOP_FETCHING_NAT_AVG_CHART = 'STOP_FETCHING_NAT_AVG_CHART';

// Base URL for API requests
const API_BASE_URL = `${import.meta.env.VITE_APP_BASE_URL}/api`;


// Helper function for error handling
const handleAxiosError = (error: any, dispatch: any, failureType: string) => {
  const errorMessage = axios.isAxiosError(error) && error.message ? error.message : 'An unknown error occurred';
  console.error('Error with data:', errorMessage);
  dispatch({ type: failureType, error: errorMessage });
};

export const fetchPlayerChartData = (teamId: number) => 
async (dispatch: AppDispatch) => {
  dispatch({ type: START_FETCHING_PLAYER_CHART });
  try {
    const response = await axiosClient.get<PlayerChartData[]>(`${API_BASE_URL}/chart/players?teamId=${teamId}`);
    dispatch({ type: FETCH_PLAYER_CHART_SUCCESS, payload: response.data });
  } catch (error) {
    handleAxiosError(error, dispatch, FETCH_PLAYER_CHART_FAILURE);
  } finally {
    dispatch({ type: STOP_FETCHING_PLAYER_CHART });
  }
};

export const fetchAllTeamsAvgChartData = () => 
async (dispatch: AppDispatch) => {
  dispatch({ type: START_FETCHING_TEAM_CHART });
  try {
    const response = await axiosClient.get<TeamChartData[]>(`${API_BASE_URL}/chart/all-teams-avgs`);
    dispatch({ type: FETCH_TEAM_CHART_SUCCESS, payload: response.data });
  } catch (error) {
    handleAxiosError(error, dispatch, FETCH_TEAM_CHART_FAILURE);
  } finally {
    dispatch({ type: STOP_FETCHING_TEAM_CHART });
  }
};

export const fetchNatAvgChartData = () => 
async (dispatch: AppDispatch) => {
  dispatch({ type: START_FETCHING_TEAM_CHART });
  try {
    const response = await axiosClient.get<NationAvgChartData>(`${API_BASE_URL}/chart/nat-avg`);
    dispatch({ type: FETCH_TEAM_CHART_SUCCESS, payload: response.data });
  } catch (error) {
    handleAxiosError(error, dispatch, FETCH_TEAM_CHART_FAILURE);
  } finally {
    dispatch({ type: STOP_FETCHING_TEAM_CHART });
  }
};


// Export action type constants and new loading action types
export const actionTypes = {
  START_FETCHING_PLAYER_CHART,
  STOP_FETCHING_PLAYER_CHART,
  FETCH_PLAYER_CHART_SUCCESS,
  FETCH_PLAYER_CHART_FAILURE,
  
  START_FETCHING_TEAM_CHART,
  STOP_FETCHING_TEAM_CHART,
  FETCH_TEAM_CHART_SUCCESS,
  FETCH_TEAM_CHART_FAILURE,

  START_FETCHING_NAT_AVG_CHART,
  STOP_FETCHING_NAT_AVG_CHART,
  FETCH_NAT_AVG_CHART_SUCCESS,
  FETCH_NAT_AVG_CHART_FAILURE,
};
