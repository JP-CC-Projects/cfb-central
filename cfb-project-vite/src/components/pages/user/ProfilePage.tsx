// ProfilePage.tsx

import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '../../../redux/store';
import axios from 'axios';
import { fetchTeams } from '../../../redux/actions/teamActions';
import { ThunkDispatch } from 'redux-thunk';
import { UnknownAction } from 'redux';
import { User } from '../../../types/userTypes';

type UpdateProfileRequest = {
  email: string;
  firstName: string;
  lastName: string;
  currentPassword: string;
  favoriteTeamId: number;
};

export default function ProfilePage() {
  const dispatch = useDispatch<ThunkDispatch<{}, {}, UnknownAction>>();
  const teams = useSelector((state: RootState) => state.team.teams);
  const accessToken = localStorage.getItem('accessToken');
  const USER_BASE_URL = `${import.meta.env.VITE_APP_BASE_URL}/user`;

  const [user, setUser] = useState<User>({
    id: -1,
    firstName: '',
    lastName: '',
    email: '',
    favoriteTeamId: 0,
    favoriteTeam: '', // This field is not necessary
    currentPassword: '' // This will be used for updating the password
  });

  useEffect(() => {
    if (accessToken) {
      axios.get<User>(`${USER_BASE_URL}/get-user-details`, {
        headers: { Authorization: `Bearer ${accessToken}` }
      })
        .then(response => setUser(response.data))
        .catch(error => console.error('Error fetching user details:', error));
    }
  }, [accessToken]);

  useEffect(() => {
    dispatch(fetchTeams());
  }, [dispatch]);

  const handleSaveChanges = () => {
    const updateProfileRequest: UpdateProfileRequest = {
      email: user.email || '',
      firstName: user.firstName || '',
      lastName: user.lastName || '',
      currentPassword: user.currentPassword || '',
      favoriteTeamId: user.favoriteTeamId,
    };

    axios.post(`${USER_BASE_URL}/update-user-details`, updateProfileRequest, {
      headers: { Authorization: `Bearer ${accessToken}` }
    })
      .then(response => console.log('User details updated successfully:', response.data))
      .catch(error => console.error('Error updating user details:', error));
  };

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    const { name, value } = event.target;
    setUser(prevUser => ({ ...prevUser, [name]: value }));
  };

  return (
    <div>
      <h1>User Profile</h1>
      <form>
        <div>
          <label>First Name</label>
          <input
            type="text"
            name="firstName"
            value={user.firstName || ''}
            onChange={handleInputChange}
            placeholder="First Name"
          />
        </div>
        <div>
          <label>Last Name</label>
          <input
            type="text"
            name="lastName"
            value={user.lastName || ''}
            onChange={handleInputChange}
            placeholder="Last Name"
          />
        </div>
        <div>
          <label>Favorite Team</label>
          <select
            name="favoriteTeamId"
            value={String(user.favoriteTeamId)}
            onChange={handleInputChange}
          >
            {teams.map(team => (
              <option key={team.id} value={String(team.id)}>
                {team.school} {team.mascot}
              </option>
            ))}
          </select>
        </div>
        <div>
          <label>Password</label>
          <input
            type="password"
            name="password"
            value={user.currentPassword || ''}
            onChange={handleInputChange}
            placeholder="Your password"
          />
        </div>
        <div>
          <button type="button" onClick={handleSaveChanges}>Save Changes</button>
          <button type="button">Cancel</button>
        </div>
      </form>
    </div>
  );
}
