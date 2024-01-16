// rootReducer
import { combineReducers } from 'redux';
import teamReducer from './teamReducer.ts';
import authReducer from './authReducer.ts'; 
import chartReducer from './chartReducer.ts';

const rootReducer = combineReducers({
  chart: chartReducer,
  team: teamReducer,
  auth: authReducer, 
});

export default rootReducer;