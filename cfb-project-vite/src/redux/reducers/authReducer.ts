import { AuthActionTypes, LOGIN_SUCCESS, LOGOUT } from '../actions/authActions';

const initialState = {
    isAuthenticated: false,
    user: null,
    token: null,
  };
  
  const authReducer = (state = initialState, action: AuthActionTypes) => {
    switch (action.type) {
      case LOGIN_SUCCESS:
        return {
          ...state,
          isAuthenticated: true,
          user: action.payload.user,
          token: action.payload.token,
        };
      case LOGOUT:
        return {
          ...state,
          isAuthenticated: false,
          user: null,
          token: null,
        };
      // ... other cases
      default:
        return state;
    }
  };
  
  export default authReducer;
  