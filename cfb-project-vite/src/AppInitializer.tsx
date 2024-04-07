import React, { useEffect, ReactNode } from 'react';
import { useDispatch } from 'react-redux';
import setupAxiosInterceptor from './utils/setupAxiosInterceptor';

type AppInitializerProps = {
    children: ReactNode;
};


const AppInitializer: React.FC<AppInitializerProps> = ({ children }) => {
    const dispatch = useDispatch();

    useEffect(() => {
        setupAxiosInterceptor();
        const accessToken = localStorage.getItem('accessToken');
        if (accessToken) {
            dispatch({ type: 'LOGIN_SUCCESS', payload: accessToken });
        }
    }, [dispatch]);

    return <>{children}</>;
};

export default AppInitializer;
