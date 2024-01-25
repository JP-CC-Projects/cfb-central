
// Define and export action types and interfaces
export const LOGIN_SUCCESS = 'LOGIN_SUCCESS';
export const LOGOUT = 'LOGOUT';

export interface LoginSuccessAction {
  type: typeof LOGIN_SUCCESS;
  payload: {
    accessToken: string;
    refreshToken: string;
  };
}

export interface LogoutAction {
  type: typeof LOGOUT;
}

export type AuthActionTypes = LoginSuccessAction | LogoutAction;
