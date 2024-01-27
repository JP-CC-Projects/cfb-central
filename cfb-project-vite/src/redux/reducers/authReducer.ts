import { AuthActionTypes, LOGIN_SUCCESS, LOGOUT } from '../actions/authActions';

const initialState = {
    isAuthenticated: false,
    accessToken: null,
  };
  
  const authReducer = (state = initialState, action: AuthActionTypes) => {
    switch (action.type) {
      case LOGIN_SUCCESS:
        return {
          ...state,
          isAuthenticated: true,
          accessToken: action.payload.accessToken,
        };
      case LOGOUT:
        return {
          ...state,
          isAuthenticated: false,
          accessToken: null,
        };
      default:
        return state;
    }
  };
  
  export default authReducer;
  