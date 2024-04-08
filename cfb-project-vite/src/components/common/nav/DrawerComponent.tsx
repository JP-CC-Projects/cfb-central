import { Link, useParams } from 'react-router-dom';
import Drawer from '@mui/material/Drawer';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Toolbar from '@mui/material/Toolbar';
import Box from '@mui/material/Box';
import MailIcon from '@mui/icons-material/Mail';
import Groups2TwoToneIcon from '@mui/icons-material/Groups2TwoTone';
import AvTimerTwoToneIcon from '@mui/icons-material/AvTimerTwoTone';
import SsidChartTwoToneIcon from '@mui/icons-material/SsidChartTwoTone';
import WhereToVoteTwoToneIcon from '@mui/icons-material/WhereToVoteTwoTone';



const drawerWidth = 240;
const DrawerComponent: React.FC = () => {
  const { teamId } = useParams();
  return (
    console.log(teamId),
    <Drawer
      variant="permanent"
      sx={{
        width: drawerWidth,
        flexShrink: 0,
        [`& .MuiDrawer-paper`]: { width: drawerWidth, boxSizing: 'border-box' },
      }}
    >
      <Toolbar />
      <Box sx={{ overflow: 'auto' }}>
        <br/>
        <List>
          {/* Team Page Link */}
          <ListItem disablePadding>
            <ListItemButton component={Link} to={`/${teamId}/team`}>
              <ListItemIcon>
                <Groups2TwoToneIcon /> {/* This icon can be anything you choose */}
              </ListItemIcon>
              <ListItemText primary="Team" />
            </ListItemButton>
          </ListItem>
          {/* Roster Page Link */}
          <ListItem disablePadding>
            <ListItemButton component={Link} to={`/${teamId}/roster`}>
              <ListItemIcon>
                <MailIcon /> {/* This icon can be anything you choose */}
              </ListItemIcon>
              <ListItemText primary="Roster" />
            </ListItemButton>
          </ListItem>
          <ListItem disablePadding>
            <ListItemButton component={Link} to={`/${teamId}/timeline`}>
              <ListItemIcon>
                <AvTimerTwoToneIcon /> 
              </ListItemIcon>
              <ListItemText primary="Timeline" />
            </ListItemButton>
          </ListItem>
          <ListItem disablePadding>
            <ListItemButton component={Link} to={`/${teamId}/chart`}>
              <ListItemIcon>
                <SsidChartTwoToneIcon /> 
              </ListItemIcon>
              <ListItemText primary="Chart" />
            </ListItemButton>
          </ListItem>
          <ListItem disablePadding>
            <ListItemButton component={Link} to={`/${teamId}/map`}>
              <ListItemIcon>
                <WhereToVoteTwoToneIcon /> 
              </ListItemIcon>
              <ListItemText primary="Map" />
            </ListItemButton>
          </ListItem>
        </List>
      </Box>
    </Drawer>
  );
};

export default DrawerComponent;
