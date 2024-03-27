// RegisterPage.tsx

import RegisterForm from './RegisterForm';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import React from 'react';

const RegisterPage: React.FC = () => {
  const REGISTER_URL = `${import.meta.env.VITE_APP_BASE_URL}/register`;
  const navigate = useNavigate();

  const handleRegister = async (email: string, password: string, confirmPassword: string) => {
    if (password !== confirmPassword) {
      alert("Passwords do not match.");
      return;
    }
    try {
      await axios.post(REGISTER_URL, { email, password });
      console.log('Registration successful');
      navigate('/login'); // Assuming '/login' is the route to your LoginPage
    } catch (error) {
      if (axios.isAxiosError(error)) {
        console.error('Registration error:', error.response?.data || error.message);
      } else {
        console.error('An unknown error occurred:', error);
      }
    }
  };

  return (
    <div>
      <RegisterForm onRegister={handleRegister} />
    </div>
  );
};

export default RegisterPage;
