// LoginForm.tsx

import { useState } from 'react';
import './LoginPage.css';

interface LoginProps {
  onLogin: (
    email: string,
    password: string) => void;
  errorMessage?: string;
}

const LoginForm: React.FC<LoginProps> = ({ onLogin, errorMessage }) => {
  const [email, setEmail ] = useState('email');
  const [password, setPassword] = useState('password');

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    onLogin(email, password);
  };

  

  return (
    <>
      <div className="login-container">
        <div className="login-form">
          <form onSubmit={handleSubmit}>
            {errorMessage && <div className="error-message">{errorMessage}</div>}
            <div className="input-group">
              <label htmlFor="email">Email</label>
              <input
                id="email"
                type="text"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>
            <div className="input-group">
              <label htmlFor="password">Password</label>
              <input
                id="password"
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>
            <button type="submit" className="login-button">Login</button>
          </form>
          <div>
            Register
          </div>
        </div>
      </div>
    </>
  );
};

export default LoginForm;
