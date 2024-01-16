// src/components/layout/MainLayout.tsx
import { ReactNode } from 'react';
import Header from '../common/header/Header';

type MainLayoutProps = {
  children: ReactNode;
};
const MainLayout = ({ children }: MainLayoutProps) => {
  return (
    <div className="flex flex-col min-h-screen">
      <Header />
      <main className="flex-grow container mx-auto px-4 sm:px-6 lg:px-8 pt-0 mt-0">
        {children}
      </main>
    </div>
  );
};

export default MainLayout;
