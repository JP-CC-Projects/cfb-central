import { User } from '../../types/userTypes';


// Define and export action types and interfaces
export const LOGIN_SUCCESS = 'LOGIN_SUCCESS';
export const LOGOUT = 'LOGOUT';

export interface LoginSuccessAction {
  type: typeof LOGIN_SUCCESS;
  payload: {
    user: User; // Define User type as needed
    token: string;
  };
}

export interface LogoutAction {
  type: typeof LOGOUT;
}

export type AuthActionTypes = LoginSuccessAction | LogoutAction;
