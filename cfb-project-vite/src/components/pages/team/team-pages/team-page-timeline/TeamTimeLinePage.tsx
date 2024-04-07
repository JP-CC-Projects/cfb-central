//TeamTimelinePage.tsx
import { useEffect } from 'react';
import { useSelector } from 'react-redux';
import { fetchTeamTimeline } from '../../../../../redux/actions/teamActions';
import { RootState, useAppDispatch } from '../../../../../redux/store';
import { useParams } from 'react-router-dom';
import { Chrono } from 'react-chrono';
import MyLoading from '../../../../common/MyLoading';
import TimelineReactNodeMaker from './TimelineReactNodeMaker';

const TeamTimelinePage: React.FC = () => {
    const dispatch = useAppDispatch();
    const { teamTimeline, isFetchingTimeline } = useSelector((state: RootState) => state.team);
    const { teamId: teamIdStr } = useParams<{ teamId?: string }>();
    const teamId = teamIdStr ? parseInt(teamIdStr, 10) : null;
    const teamSeason = 2023;
    console.log(teamId)

    useEffect(() => {
        if (teamId !== null && !isNaN(teamId)) {
            dispatch(fetchTeamTimeline(teamId, teamSeason));
        }
    }, [dispatch, teamId, teamSeason]);

    if (isFetchingTimeline) {
        return <MyLoading message="Loading timeline..." />;
    }

    // Create ReactNodes to replace default React-Chrono presentation
    const customContent = teamTimeline.map(item => (
        <TimelineReactNodeMaker key={item.gameId} {...item} />
    ));

    return (
        <div className="w-full">
            {teamTimeline.length > 0 ? (
                <Chrono
                    items={teamTimeline.map(item => ({
                        title: new Date(item.date * 1000).toLocaleString('en-US', {
                            year: 'numeric',
                            month: 'long',
                            day: 'numeric',
                            hour: '2-digit',
                            minute: '2-digit',
                        })
                    }))} mode='VERTICAL'
                    fontSizes={{ title: '.8rem' }}
                    hideControls='true'
                    lineWidth='2'
                    scrollable='true'
                >
                    {customContent}
                </Chrono>
            ) : (
                <p>No timeline data available.</p>
            )}
        </div>
    );
};

export default TeamTimelinePage;
