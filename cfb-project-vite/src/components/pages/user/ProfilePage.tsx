// ProfilePage.tsx

import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '../../../redux/store';
import axios from 'axios';
import Box from '@mui/joy/Box';
import Button from '@mui/joy/Button';
import FormControl from '@mui/joy/FormControl';
import FormLabel from '@mui/joy/FormLabel';
import Input from '@mui/joy/Input';
import Stack from '@mui/joy/Stack';
import Select from '@mui/joy/Select';
import Option from '@mui/joy/Option';
import Typography from '@mui/joy/Typography';
import { User } from '../../../types/userTypes';
import { fetchTeams } from '../../../redux/actions/teamActions';
import { ThunkDispatch } from 'redux-thunk';
import { UnknownAction } from 'redux';

export default function ProfilePage() {
  const dispatch = useDispatch<ThunkDispatch<{}, {}, UnknownAction>>();
  const teams = useSelector((state: RootState) => state.team.teams);
  console.log(teams);
  const accessToken = localStorage.getItem('accessToken');
  const USER_BASE_URL = `${import.meta.env.VITE_APP_BASE_URL}/user`;
  const [user, setUser] = useState({ firstName: '', lastName: '', email: '' });

  useEffect(() => {
    const config = {
      headers: { Authorization: `Bearer ${accessToken}` }
    };
    axios.get<User>(`${USER_BASE_URL}/get-user-details`, config)
      .then(response => {
        setUser(response.data);
      })
      .catch(error => console.error(error));
  }, [accessToken]);

  useEffect(() => {
    const cachedTeams = localStorage.getItem('teams');
    if (cachedTeams) {
      dispatch({ type: 'FETCH_TEAMS_SUCCESS', payload: JSON.parse(cachedTeams) });
    } else {
      dispatch(fetchTeams());
    }
  }, [dispatch]);

  return (
    <div>
      <Box sx={{ flex: 1, width: '90vw', p: 4 }}>
        <Typography level="h4" component="h1" sx={{ mb: 2 }}>
          User Profile
        </Typography>
        <Stack spacing={3} component="form">
          <Stack direction={{ xs: 'column', sm: 'row' }} spacing={2}>
            <FormControl>
              <FormLabel>First Name</FormLabel>
              <Input size="sm" placeholder={user.firstName || 'First Name'} />
            </FormControl>
            <FormControl>
              <FormLabel>Last Name</FormLabel>
              <Input size="sm" placeholder={user.lastName || 'Last Name'} />
            </FormControl>
          </Stack>
          <FormControl>
            <FormLabel>Favorite Team</FormLabel>
            <Select size="sm" defaultValue="">
              {/* Populate options based on available teams */}
              <Option value="team1">Team 1</Option>
              <Option value="team2">Team 2</Option>
              {/* ... other teams */}
            </Select>
          </FormControl>
          <FormControl>
            <FormLabel>Email</FormLabel>
            <Input size="sm" type="email" placeholder={user.email || 'Your Email'} />
          </FormControl>
          <FormControl>
            <FormLabel>Password</FormLabel>
            <Input size="sm" type="password" placeholder="Your password" />
          </FormControl>
          <Stack direction="row" spacing={2}>
            <Button variant="solid" size="sm">Save Changes</Button>
            <Button variant="outlined" size="sm">Cancel</Button>
          </Stack>
        </Stack>
      </Box>
    </div>
  );
}
