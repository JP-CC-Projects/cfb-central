// src/components/pages/TeamPage.tsx
import { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { fetchTeamDetails } from '../../redux/actions/teamActions';
import MainLayout from '../layout/MainLayout';
import { AppDispatch, RootState } from '../../redux/store';
import TeamTimelineTab from '../features/tabs/timeline/TeamTimeLineTab';
import { Tab, Tabs, TabList, TabPanel, TabProps } from 'react-tabs';
import TeamRosterTab from '../features/tabs/team-roster/TeamRosterTab';
import TeamOverviewTab from '../features/tabs/team-details/TeamOverviewTab';
import MapComponent from '../features/map/MapComponent';
import ChartComponent from '../features/charts/ChartComponent';
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
  const dispatch = useDispatch<AppDispatch>();
  const parsedTeamId = teamId ? parseInt(teamId, 10) : undefined;
  const teamDetails = useSelector((state: RootState) => state.team.teamDetails);

  // Custom Tab component
  interface CustomTabProps extends TabProps {
    children: React.ReactNode;
  }
  function CustomTab({ children, ...otherProps }: CustomTabProps) {
    return (
      <Tab {...otherProps}>
        <h1>{children}</h1>
      </Tab>
    );
  }
  (CustomTab as any).tabsRole = 'Tab';

  useEffect(() => {
    if (parsedTeamId && !isNaN(parsedTeamId)) {
      dispatch(fetchTeamDetails(parsedTeamId));
    }
  }, [dispatch, parsedTeamId]);

  if (!parsedTeamId || isNaN(parsedTeamId)) {
    return (
      <MainLayout>
        <p>Invalid Team ID</p>
      </MainLayout>
    );
  }

  return (
    <MainLayout>
      <div className="flex flex-col sm:flex-row">
        {/* Team Details Section */}
        {/* Add/Remove borders during dev */}
        {/* <div className="sm:w-full p-0" style={{ border: '1px solid black' }}> */}
        <div className="sm:w-full p-0">
          <Tabs >
            <TabList>
              <CustomTab>Overview</CustomTab>
              <CustomTab>Timeline</CustomTab>
              <CustomTab>Roster</CustomTab>
              <CustomTab>Graphs</CustomTab>
              <CustomTab>Player Map</CustomTab>
            </TabList>


            <TabPanel>
              <div>
                {teamDetails && <TeamOverviewTab teamId={parsedTeamId} teamDetails={teamDetails} />}
              </div>
            </TabPanel>
            <TabPanel>
              <div>
                <TeamTimelineTab teamId={parsedTeamId} teamSeason={teamSeason} />
              </div>
            </TabPanel>
            <TabPanel>
              <TeamRosterTab teamId={parsedTeamId} teamSeason={teamSeason} />
            </TabPanel>
            <TabPanel>
              <div>
                <ChartComponent teamId={parsedTeamId} teamSeason={teamSeason}/>
              </div>
            </TabPanel>
            <TabPanel>
              <MapComponent teamId={parsedTeamId} teamSeason={teamSeason} />
            </TabPanel>
          </Tabs>
        </div>
      </div>
    </MainLayout>
  );
};

export default TeamPage
