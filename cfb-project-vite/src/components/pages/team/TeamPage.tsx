// src/components/pages/TeamPage.tsx
import { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { fetchTeamDetails } from '../../../redux/actions/teamActions';
import { AppDispatch, RootState } from '../../../redux/store';
import TeamTimelinePage from './team-pages/team-page-timeline/TeamTimeLinePage';
import TeamRosterPage from './team-pages/team-page-roster/TeamRosterPage';
import TeamOverviewPage from './team-pages/team-overview/TeamOverviewPage';
import MapComponent from '../map/MapComponent';
import ChartComponent from './team-pages/team-page-chart/ChartComponent';
import 'react-tabs/style/react-tabs.css';
import './TeamPage.css';

const TeamPage = () => {
  // Date-related Constants
  const currentDate = new Date();
  const currentMonth = currentDate.getMonth();
  const currentYear = currentDate.getFullYear();
  // Will list 2023 Season Stats until August:
  const teamSeason = currentMonth < 8 ? currentYear - 1 : currentYear;

  // Redux-related Constants
  const { teamId } = useParams<{ teamId?: string }>();
  const parsedTeamId = teamId ? parseInt(teamId, 10) : undefined;
  const dispatch = useDispatch<AppDispatch>();
  const teamDetails = useSelector((state: RootState) => state.team.teamDetails);

  // React Tabs component

  useEffect(() => {
    if (parsedTeamId && !isNaN(parsedTeamId)) {
      dispatch(fetchTeamDetails(parsedTeamId));
    }
  }, [dispatch, parsedTeamId]);

  if (!parsedTeamId || isNaN(parsedTeamId)) {
    return (
      <p>Invalid Team ID</p>
    );
  }

  return (
    <div className="flex flex-col sm:flex-row">
      <div className="sm:w-full p-0">
          {teamDetails && <TeamOverviewPage/>}
        </div>
    </div>
  );
};

export default TeamPage
