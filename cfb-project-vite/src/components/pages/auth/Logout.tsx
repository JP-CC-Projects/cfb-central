import { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';

const Logout = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  useEffect(() => {
    localStorage.removeItem('token');
    dispatch({ type: 'LOGOUT' }); 
    navigate('/'); 
  }, [dispatch, navigate]);

  return null; 
};

export default Logout;
