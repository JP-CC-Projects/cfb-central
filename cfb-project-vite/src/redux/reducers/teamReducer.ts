// reducers/teamReducer.ts
import { TeamMin, TeamDetails, TeamTimeline, TeamRecord, Player } from '../../types/teamTypes';

// Define action types for the team reducer
export const FETCH_TEAMS_SUCCESS = 'FETCH_TEAMS_SUCCESS';
export const FETCH_TEAMS_FAILURE = 'FETCH_TEAMS_FAILURE';
const START_FETCHING_TEAMS = 'START_FETCHING_TEAMS';
const STOP_FETCHING_TEAMS = 'STOP_FETCHING_TEAMS';

export const FETCH_TEAM_DETAILS_SUCCESS = 'FETCH_TEAM_DETAILS_SUCCESS';
export const FETCH_TEAM_DETAILS_FAILURE = 'FETCH_TEAM_DETAILS_FAILURE';
const START_FETCHING_TEAM_DETAILS = 'START_FETCHING_TEAM_DETAILS';
const STOP_FETCHING_TEAM_DETAILS = 'STOP_FETCHING_TEAM_DETAILS';

export const FETCH_TEAM_TIMELINE_SUCCESS = 'FETCH_TEAM_TIMELINE_SUCCESS';
export const FETCH_TEAM_TIMELINE_FAILURE = 'FETCH_TEAM_TIMELINE_FAILURE';
const START_FETCHING_TEAM_TIMELINE = 'START_FETCHING_TEAM_TIMELINE';
const STOP_FETCHING_TEAM_TIMELINE = 'STOP_FETCHING_TEAM_TIMELINE';

export const FETCH_TEAM_RECORD_SUCCESS = 'FETCH_TEAM_RECORD_SUCCESS';
export const FETCH_TEAM_RECORD_FAILURE = 'FETCH_TEAM_RECORD_FAILURE';
const START_FETCHING_TEAM_RECORD = 'START_FETCHING_TEAM_RECORD';
const STOP_FETCHING_TEAM_RECORD = 'STOP_FETCHING_TEAM_RECORD';

export const FETCH_TEAM_ROSTER_SUCCESS = 'FETCH_TEAM_ROSTER_SUCCESS';
export const FETCH_TEAM_ROSTER_FAILURE = 'FETCH_TEAM_ROSTER_FAILURE';
const START_FETCHING_TEAM_ROSTER = 'START_FETCHING_TEAM_ROSTER';
const STOP_FETCHING_TEAM_ROSTER = 'STOP_FETCHING_TEAM_ROSTER';

// Define action types for teamReducer
type TeamAction =
  | { type: typeof FETCH_TEAMS_SUCCESS; payload: TeamMin[] }
  | { type: typeof FETCH_TEAMS_FAILURE; error: string }
  | { type: typeof START_FETCHING_TEAMS }
  | { type: typeof STOP_FETCHING_TEAMS }

  | { type: typeof FETCH_TEAM_DETAILS_SUCCESS; payload: TeamDetails }
  | { type: typeof FETCH_TEAM_DETAILS_FAILURE; error: string }
  | { type: typeof START_FETCHING_TEAM_DETAILS }
  | { type: typeof STOP_FETCHING_TEAM_DETAILS }

  | { type: typeof FETCH_TEAM_TIMELINE_SUCCESS; payload: TeamTimeline[] }
  | { type: typeof FETCH_TEAM_TIMELINE_FAILURE; error: string }
  | { type: typeof START_FETCHING_TEAM_TIMELINE }
  | { type: typeof STOP_FETCHING_TEAM_TIMELINE }

  | { type: typeof FETCH_TEAM_RECORD_SUCCESS; payload: TeamRecord }
  | { type: typeof FETCH_TEAM_RECORD_FAILURE; error: string }
  | { type: typeof START_FETCHING_TEAM_RECORD }
  | { type: typeof STOP_FETCHING_TEAM_RECORD }

  | { type: typeof FETCH_TEAM_ROSTER_SUCCESS; payload: Player[] }
  | { type: typeof FETCH_TEAM_ROSTER_FAILURE; error: string }
  | { type: typeof START_FETCHING_TEAM_ROSTER }
  | { type: typeof STOP_FETCHING_TEAM_ROSTER };


type TeamState = {
  teams: TeamMin[];
  teamDetails: TeamDetails | null;
  error: string | null;
  teamTimeline: TeamTimeline[];
  teamRecord: TeamRecord | null;
  teamRoster: Player[];
  isFetchingTeams: boolean; // Loading flag for fetching teams
  isFetchingDetails: boolean; // Loading flag for fetching team details
  isFetchingTimeline: boolean;
  isFetchingTeamRecord: boolean;
  isFetchingTeamRoster: boolean;
};

// Updated initial state with loading flags
const initialState: TeamState = {
  error: null,
  
  teams: [],
  teamDetails: null,
  teamTimeline: [],
  teamRecord: null,
  teamRoster: [],

  isFetchingTeams: false,
  isFetchingDetails: false,
  isFetchingTimeline: false,
  isFetchingTeamRecord: false,
  isFetchingTeamRoster: false,
};

// The teamReducer function
const teamReducer = (state = initialState, action: TeamAction): TeamState => {
  switch (action.type) {
    case START_FETCHING_TEAMS:
      return { ...state, isFetchingTeams: true };
    case STOP_FETCHING_TEAMS:
      return { ...state, isFetchingTeams: false };
    case FETCH_TEAMS_SUCCESS:
      return { ...state, teams: action.payload, error: null };
    case FETCH_TEAMS_FAILURE:
      return { ...state, error: action.error };

    case START_FETCHING_TEAM_DETAILS:
      return { ...state, isFetchingDetails: true };
    case STOP_FETCHING_TEAM_DETAILS:
      return { ...state, isFetchingDetails: false };
    case FETCH_TEAM_DETAILS_SUCCESS:
      return { ...state, teamDetails: action.payload, error: null };
    case FETCH_TEAM_DETAILS_FAILURE:
      return { ...state, error: action.error };


    case START_FETCHING_TEAM_TIMELINE:
      return { ...state, isFetchingTimeline: true };
    case STOP_FETCHING_TEAM_TIMELINE:
      return { ...state, isFetchingTimeline: false };
    case FETCH_TEAM_TIMELINE_SUCCESS:
      return { ...state, teamTimeline: action.payload, error: null };
    case FETCH_TEAM_TIMELINE_FAILURE:
      return { ...state, error: action.error };

    case START_FETCHING_TEAM_RECORD:
      return { ...state, isFetchingTeamRecord: true };
    case STOP_FETCHING_TEAM_RECORD:
      return { ...state, isFetchingTeamRecord: false };
    case FETCH_TEAM_RECORD_SUCCESS:
      return { ...state, teamRecord: action.payload, error: null };
    case FETCH_TEAM_RECORD_FAILURE:
      return { ...state, error: action.error };

    case START_FETCHING_TEAM_ROSTER:
      return { ...state, isFetchingTeamRoster: true };
    case STOP_FETCHING_TEAM_ROSTER:
      return { ...state, isFetchingTeamRoster: false };
    case FETCH_TEAM_ROSTER_SUCCESS:
      return { ...state, teamRoster: action.payload, error: null };
    case FETCH_TEAM_ROSTER_FAILURE:
      return { ...state, error: action.error };

    default:
      return state;
  }
};

export default teamReducer;
