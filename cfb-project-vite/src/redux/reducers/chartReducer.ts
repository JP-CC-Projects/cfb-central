// reducers/chartReducer.ts
import { NationAvgChartData, PlayerChartData, TeamChartData } from '../../types/chartTypes';

// Define action types for the chart reducer
export const FETCH_PLAYER_CHART_SUCCESS = 'FETCH_PLAYER_CHART_SUCCESS';
export const FETCH_PLAYER_CHART_FAILURE = 'FETCH_PLAYER_CHART_FAILURE';
const START_FETCHING_PLAYER_CHART = 'START_FETCHING_PLAYER_CHART';
const STOP_FETCHING_PLAYER_CHART = 'STOP_FETCHING_PLAYER_CHART';

export const FETCH_TEAM_CHART_SUCCESS = 'FETCH_TEAM_CHART_SUCCESS';
export const FETCH_TEAM_CHART_FAILURE = 'FETCH_TEAM_CHART_FAILURE';
const START_FETCHING_TEAM_CHART = 'START_FETCHING_TEAM_CHART';
const STOP_FETCHING_TEAM_CHART = 'STOP_FETCHING_TEAM_CHART';

export const FETCH_NAT_AVG_CHART_SUCCESS = 'FETCH_NAT_AVG_CNAT_AVG_SUCCESS';
export const FETCH_NAT_AVG_CHART_FAILURE = 'FETCH_NAT_AVG_CHART_FAILURE';
const START_FETCHING_NAT_AVG_CHART = 'START_FETCHING_NAT_AVG_CHART';
const STOP_FETCHING_NAT_AVG_CHART = 'STOP_FETCHING_NAT_AVG_CHART';

// Define action types for teamReducer
type ChartAction =
    | { type: typeof FETCH_PLAYER_CHART_SUCCESS; payload: PlayerChartData[] }
    | { type: typeof FETCH_PLAYER_CHART_FAILURE; error: string }
    | { type: typeof START_FETCHING_PLAYER_CHART }
    | { type: typeof STOP_FETCHING_PLAYER_CHART }

    | { type: typeof FETCH_TEAM_CHART_SUCCESS; payload: TeamChartData[] }
    | { type: typeof FETCH_TEAM_CHART_FAILURE; error: string }
    | { type: typeof START_FETCHING_TEAM_CHART }
    | { type: typeof STOP_FETCHING_TEAM_CHART }

    | { type: typeof FETCH_NAT_AVG_CHART_SUCCESS; payload: NationAvgChartData }
    | { type: typeof FETCH_NAT_AVG_CHART_FAILURE; error: string }
    | { type: typeof START_FETCHING_NAT_AVG_CHART }
    | { type: typeof STOP_FETCHING_NAT_AVG_CHART };


type ChartState = {
    error: string | null;

    playerChartData: PlayerChartData[] | null;
    teamChartData: TeamChartData[] | null;
    natAvgChartData: NationAvgChartData | null;
    isFetchingPlayerChartData: boolean;
    isFetchingTeamChartData: boolean;
    isFetchingNationAvgChartData: boolean;

};

// Updated initial state with loading flags
const initialState: ChartState = {
    error: null,
    playerChartData: [],
    teamChartData: [],
    natAvgChartData: null,
    isFetchingPlayerChartData: false,
    isFetchingTeamChartData: false,
    isFetchingNationAvgChartData: false,
};

// The chartReducer function
const chartReducer = (state = initialState, action: ChartAction): ChartState => {
    switch (action.type) {
        case START_FETCHING_PLAYER_CHART:
            return { ...state, isFetchingPlayerChartData: true };
        case STOP_FETCHING_PLAYER_CHART:
            return { ...state, isFetchingPlayerChartData: false };
        case FETCH_PLAYER_CHART_SUCCESS:
            return { ...state, playerChartData: action.payload, error: null };
        case FETCH_PLAYER_CHART_FAILURE:
            return { ...state, error: action.error };

        case START_FETCHING_TEAM_CHART:
            return { ...state, isFetchingTeamChartData: true };
        case STOP_FETCHING_TEAM_CHART:
            return { ...state, isFetchingTeamChartData: false };
        case FETCH_TEAM_CHART_SUCCESS:
            return { ...state, teamChartData: action.payload, error: null };
        case FETCH_TEAM_CHART_FAILURE:
            return { ...state, error: action.error };

        case START_FETCHING_NAT_AVG_CHART:
            return { ...state, isFetchingNationAvgChartData: true };
        case STOP_FETCHING_NAT_AVG_CHART:
            return { ...state, isFetchingNationAvgChartData: false };
        case FETCH_NAT_AVG_CHART_SUCCESS:
            return { ...state, natAvgChartData: action.payload, error: null };
        case FETCH_NAT_AVG_CHART_FAILURE:
            return { ...state, error: action.error };

        default:
            return state;
    }
};

export default chartReducer;
