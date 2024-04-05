// TeamSearchAutocomplete.tsx
import React, { useEffect } from 'react';
import Autocomplete from '@mui/joy/Autocomplete';
import { useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { TeamMin } from '../../types/teamTypes';
import { fetchTeams } from '../../redux/actions/teamActions';
import type { ThunkDispatch } from 'redux-thunk';
import type { UnknownAction } from 'redux';
import type { RootState } from '../../redux/store';


function TeamSearchAutocomplete() {
  const dispatch = useDispatch<ThunkDispatch<{}, {}, UnknownAction>>();
  const navigate = useNavigate();
  const teams = useSelector((state: RootState) => state.team.teams);

  useEffect(() => {
    const cachedTeams = localStorage.getItem('teams');
    if (cachedTeams) {
      dispatch({ type: 'FETCH_TEAMS_SUCCESS', payload: JSON.parse(cachedTeams) });
    } else {
      dispatch(fetchTeams());
    }
  }, [dispatch]);

  const handleSelection = (_: React.ChangeEvent<{}>, selectedTeam: TeamMin | null) => {
    if (selectedTeam) {
      navigate(`/${selectedTeam.id}/team`);
    }
  };

  const sortedTeams = [...teams].sort((a, b) => a.school.localeCompare(b.school));

  return (
    <>
      <Autocomplete 
        variant="soft"
        placeholder="Find your team"
        options={sortedTeams}
        getOptionLabel={(team: TeamMin) => `${team.school} ${team.mascot || ''}`.trim()}
        // renderInput={(params) => <TextField {...params} label="Find your team" />}
        onChange={handleSelection}
      />
    </>
  );
}

export default TeamSearchAutocomplete;
