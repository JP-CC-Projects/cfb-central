import axios from 'axios';
import axiosClient from '../../utils/axiosClient';
import { ThunkDispatch } from 'redux-thunk';
import { UnknownAction } from 'redux';
import { TeamMin, TeamDetails, TeamTimeline, TeamRecord, Player } from '../../types/teamTypes';
import { AppDispatch } from '../store';

// Define action type constants
const FETCH_TEAMS_SUCCESS = 'FETCH_TEAMS_SUCCESS';
const FETCH_TEAMS_FAILURE = 'FETCH_TEAMS_FAILURE';
const START_FETCHING_TEAMS = 'START_FETCHING_TEAMS';
const STOP_FETCHING_TEAMS = 'STOP_FETCHING_TEAMS';

const FETCH_TEAM_DETAILS_SUCCESS = 'FETCH_TEAM_DETAILS_SUCCESS';
const FETCH_TEAM_DETAILS_FAILURE = 'FETCH_TEAM_DETAILS_FAILURE';
const START_FETCHING_TEAM_DETAILS = 'START_FETCHING_TEAM_DETAILS';
const STOP_FETCHING_TEAM_DETAILS = 'STOP_FETCHING_TEAM_DETAILS';

const FETCH_TEAM_TIMELINE_SUCCESS = 'FETCH_TEAM_TIMELINE_SUCCESS';
const FETCH_TEAM_TIMELINE_FAILURE = 'FETCH_TEAM_TIMELINE_FAILURE';
const START_FETCHING_TEAM_TIMELINE = 'START_FETCHING_TEAM_TIMELINE';
const STOP_FETCHING_TEAM_TIMELINE = 'STOP_FETCHING_TEAM_TIMELINE';

const FETCH_TEAM_RECORD_SUCCESS = 'FETCH_TEAM_RECORD_SUCCESS';
const FETCH_TEAM_RECORD_FAILURE = 'FETCH_TEAM_RECORD_FAILURE';
const START_FETCHING_TEAM_RECORD = 'START_FETCHING_TEAM_RECORD';
const STOP_FETCHING_TEAM_RECORD = 'STOP_FETCHING_TEAM_RECORD';

const FETCH_TEAM_ROSTER_SUCCESS = 'FETCH_TEAM_ROSTER_SUCCESS';
const FETCH_TEAM_ROSTER_FAILURE = 'FETCH_TEAM_ROSTER_FAILURE';
const START_FETCHING_TEAM_ROSTER = 'START_FETCHING_TEAM_ROSTER';
const STOP_FETCHING_TEAM_ROSTER = 'STOP_FETCHING_TEAM_ROSTER';


// Generic error handler
const handleFetchError = (dispatch: any, failureType: string) => {
  dispatch({ type: failureType, error: 'Fetch error' });
};

// Base URL for API requests
const API_BASE_URL = 'http://192.168.12.112:8080/api';
// const API_BASE_URL = 'http://localhost:8080/api';



// Helper function for error handling
const handleAxiosError = (error: any, dispatch: any, failureType: string) => {
  const errorMessage = axios.isAxiosError(error) && error.message ? error.message : 'An unknown error occurred';
  console.error('Error with data:', errorMessage);
  dispatch({ type: failureType, error: errorMessage });
};

// Action creators using ThunkDispatch with UnknownAction
export const fetchTeams = () => async (dispatch: ThunkDispatch<{}, {}, UnknownAction>) => {
  dispatch({ type: START_FETCHING_TEAMS });
  try {
    const response = await axios.get<TeamMin[]>(`${API_BASE_URL}/teamlist-min`);
    dispatch({ type: FETCH_TEAMS_SUCCESS, payload: response.data });
  } catch (error) {
    handleAxiosError(error, dispatch, FETCH_TEAMS_FAILURE);
  } finally {
    dispatch({ type: STOP_FETCHING_TEAMS });
  }
};

export const fetchTeamDetails = (teamId: number) => async (dispatch: AppDispatch) => {
  dispatch({ type: START_FETCHING_TEAM_DETAILS });
  try {
    const response = await axios.get<TeamDetails>(`${API_BASE_URL}/team-default?teamId=${teamId}`);
    dispatch({ type: FETCH_TEAM_DETAILS_SUCCESS, payload: response.data });
  } catch (error) {
    handleAxiosError(error, dispatch, FETCH_TEAM_DETAILS_FAILURE);
  } finally {
    dispatch({ type: STOP_FETCHING_TEAM_DETAILS });
  }
};

export const fetchTeamTimeline = (teamId: number, season: number) => 
async (dispatch: AppDispatch) => {
  dispatch({ type: START_FETCHING_TEAM_TIMELINE });
  try {
    const response = await axiosClient.get<TeamTimeline[]>(`${API_BASE_URL}/team-timeline?teamId=${teamId}&season=${season}`);
    dispatch({ type: FETCH_TEAM_TIMELINE_SUCCESS, payload: response.data });
    console.log("Team Timeline Response Data:", response.data);
  } catch (error) {
    handleAxiosError(error, dispatch, FETCH_TEAM_TIMELINE_FAILURE);
  } finally {
    dispatch({ type: STOP_FETCHING_TEAM_TIMELINE });
  }
};

export const fetchTeamRecord = (teamId: number, season: number) => 
async (dispatch: AppDispatch) => {
  dispatch({ type: START_FETCHING_TEAM_RECORD });
  try {
    const response = await axiosClient.get<TeamRecord>(`${API_BASE_URL}/team-record?teamId=${teamId}&season=${season}`);
    dispatch({ type: FETCH_TEAM_RECORD_SUCCESS, payload: response.data });
    console.log("Team Record Response Data:", response.data);
  } catch (error) {
    handleAxiosError(error, dispatch, FETCH_TEAM_RECORD_FAILURE);
  } finally {
    dispatch({ type: STOP_FETCHING_TEAM_RECORD });
  }
};

export const fetchTeamRoster = (teamId: number, season: number) => 
    async (dispatch: ThunkDispatch<{}, {}, UnknownAction>) => {
  dispatch({ type: START_FETCHING_TEAM_ROSTER });
  try {
    const response = await axiosClient.get<Player[]>(`${API_BASE_URL}/team-roster?teamId=${teamId}&season=${season}`);
    dispatch({ type: FETCH_TEAM_ROSTER_SUCCESS, payload: response.data });
    console.log("Team Roster Response Data:", response.data);
  } catch (error) {
    handleAxiosError(error, dispatch, FETCH_TEAM_ROSTER_FAILURE);
  } finally {
    dispatch({ type: STOP_FETCHING_TEAM_ROSTER });
  }
};


// Export action type constants and new loading action types
export const actionTypes = {
  START_FETCHING_TEAMS,
  STOP_FETCHING_TEAMS,
  FETCH_TEAMS_SUCCESS,
  FETCH_TEAMS_FAILURE,
  
  START_FETCHING_TEAM_DETAILS,
  STOP_FETCHING_TEAM_DETAILS,
  FETCH_TEAM_DETAILS_SUCCESS,
  FETCH_TEAM_DETAILS_FAILURE,
  
  FETCH_TEAM_TIMELINE_SUCCESS,
  FETCH_TEAM_TIMELINE_FAILURE,
  START_FETCHING_TEAM_TIMELINE,
  STOP_FETCHING_TEAM_TIMELINE,

  FETCH_TEAM_RECORD_SUCCESS,
  FETCH_TEAM_RECORD_FAILURE,
  START_FETCHING_TEAM_RECORD,
  STOP_FETCHING_TEAM_RECORD,
  
  FETCH_TEAM_ROSTER_SUCCESS,
  FETCH_TEAM_ROSTER_FAILURE,
  START_FETCHING_TEAM_ROSTER,
  STOP_FETCHING_TEAM_ROSTER,
};
