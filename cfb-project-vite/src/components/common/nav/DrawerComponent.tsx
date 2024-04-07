import { Link, useParams } from 'react-router-dom';
import Drawer from '@mui/material/Drawer';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Toolbar from '@mui/material/Toolbar';
import Box from '@mui/material/Box';
import InboxIcon from '@mui/icons-material/MoveToInbox';
import MailIcon from '@mui/icons-material/Mail';

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
                <InboxIcon /> {/* This icon can be anything you choose */}
              </ListItemIcon>
              <ListItemText primary="Team Page" />
            </ListItemButton>
          </ListItem>
          {/* Roster Page Link */}
          <ListItem disablePadding>
            <ListItemButton component={Link} to={`/${teamId}/roster`}>
              <ListItemIcon>
                <MailIcon /> {/* This icon can be anything you choose */}
              </ListItemIcon>
              <ListItemText primary="Roster Page" />
            </ListItemButton>
          </ListItem>
          <ListItem disablePadding>
            <ListItemButton component={Link} to={`/${teamId}/timeline`}>
              <ListItemIcon>
                <InboxIcon /> 
              </ListItemIcon>
              <ListItemText primary="Timeline" />
            </ListItemButton>
          </ListItem>
          <ListItem disablePadding>
            <ListItemButton component={Link} to={`/${teamId}/chart`}>
              <ListItemIcon>
                <InboxIcon /> 
              </ListItemIcon>
              <ListItemText primary="Chart" />
            </ListItemButton>
          </ListItem>
          <ListItem disablePadding>
            <ListItemButton component={Link} to={`/${teamId}/map`}>
              <ListItemIcon>
                <InboxIcon /> 
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
