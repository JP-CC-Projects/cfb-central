// TeamSearchAutocompleteSelector.tsx
import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import type { ThunkDispatch } from 'redux-thunk';
import type { UnknownAction } from 'redux';
import Autocomplete from '@mui/joy/Autocomplete';
import type { RootState } from '../../redux/store';
import { TeamMin } from '../../types/teamTypes';
import { fetchTeams } from '../../redux/actions/teamActions';

// Added prop for selection callback
interface TeamSearchAutocompleteSelectorProps {
  onTeamSelected: (selectedTeam: TeamMin) => void; 
}

function TeamSearchAutocompleteSelector({ onTeamSelected }: TeamSearchAutocompleteSelectorProps) {
  const dispatch = useDispatch<ThunkDispatch<{}, {}, UnknownAction>>();
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
      onTeamSelected(selectedTeam);
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
        // Prop for styling
        // renderInput={(params) => <TextField {...params} label="Find your team" />}
        onChange={handleSelection}
      />
    </>
  );
}

export default TeamSearchAutocompleteSelector;
