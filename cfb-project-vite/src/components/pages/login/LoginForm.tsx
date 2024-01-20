import { useState } from 'react';
import './LoginPage.css';

interface LoginProps {
  onLogin: (
    username: string,
    password: string) => void;
  errorMessage?: string;
}

const LoginForm: React.FC<LoginProps> = ({ onLogin, errorMessage }) => {
  const [username, setUsername] = useState('username');
  const [password, setPassword] = useState('password');

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    onLogin(username, password);
  };

  return (
    <>
      <div className="login-container">
        <div className="login-form">
          <form onSubmit={handleSubmit}>
            <h2>Login</h2>
            {errorMessage && <div className="error-message">{errorMessage}</div>}
            <div className="input-group">
              <label htmlFor="username">Username</label>
              <input
                id="username"
                type="text"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
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