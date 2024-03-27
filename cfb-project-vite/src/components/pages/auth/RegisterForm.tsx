// RegisterForm.tsx

import React, { useState } from 'react';
import './AuthPages.css';

interface RegisterProps {
  onRegister: (email: string, password: string, confirmPassword: string) => void;
  errorMessage?: string;
}

const RegisterForm: React.FC<RegisterProps> = ({ onRegister, errorMessage }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    onRegister(email, password, confirmPassword);
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
                type="email"
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
            <div className="input-group">
              <label htmlFor="confirmPassword">Confirm Password</label>
              <input
                id="confirmPassword"
                type="password"
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
              />
            </div>
            <button type="submit" className="login-button">Register</button>
          </form>
        </div>
      </div>
    </>
  );
};

export default RegisterForm;
