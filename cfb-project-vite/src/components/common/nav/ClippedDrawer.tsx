import { ReactNode } from 'react';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import Box from '@mui/material/Box';
import Header from './Header';
import DrawerComponent from './DrawerComponent';

type ClippedDrawerProps = {
  children?: ReactNode; 
};

const ClippedDrawer: React.FC<ClippedDrawerProps> = ({ children }) => {
  return (
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <Header/>
     <DrawerComponent/>
      <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        <Toolbar />
        {children}
      </Box>
    </Box>
  );
}
export default ClippedDrawer;
