// LoginPage.tsx
import LoginForm from './LoginForm'; 
import AuthContent from '../../../security/AuthContent';

const LoginPage: React.FC = () => {
    const handleLogin = (
        username: string, 
        password: string) => {
        console.log(username + password);
    }

  return (
    <div>
      <h1>Login Page</h1>
      <AuthContent/>
      <LoginForm onLogin={handleLogin}/>
    </div>
  );
};

export default LoginPage;
