// LoginPage.tsx
import LoginForm from './LoginForm';
import axios from 'axios';
import { useDispatch } from 'react-redux';

const LoginPage: React.FC = () => {
  const dispatch = useDispatch();
  const handleLogin = async (email: string, password: string) => {
    try {
      const response = await axios.post(`${import.meta.env.VITE_APP_BASE_URL}/login`, {
        email,
        password
      });
      console.log('Login successful:', response.data);
      const token = response.data.token;
      localStorage.setItem('token', token);
      dispatch({ type: 'LOGIN_SUCCESS', payload: token });
    } catch (error) {
      if (axios.isAxiosError(error)) {
        console.error('Login error:', error.response?.data || error.message);
        // Handle error here (e.g., show error message to user)
      } else {
        console.error('An unexpected error occurred:', error);
      }
    }
  }

  return (
    <div>
      <LoginForm onLogin={handleLogin} />
    </div>
  );
};

export default LoginPage;
