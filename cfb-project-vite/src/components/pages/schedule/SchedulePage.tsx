// src/components/pages/SchedulePage.tsx

import { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { fetchTeamDetails } from '../../../redux/actions/teamActions';
import type { RootState } from '../../../redux/store';
import MainLayout from '../../layout/MainLayout';
import CalAppTest from '../../features/calendar-test/CalAppTest';
import { AppDispatch } from '../../../redux/store';
const SchedulePage = () => {
    const { teamId } = useParams<{ teamId: string }>();
    const dispatch = useDispatch<AppDispatch>();
    const teamDetails = useSelector((state: RootState) => state.team.teamDetails);

    useEffect(() => {
        if (teamId) {
            const teamIdNum = parseInt(teamId, 10);
            if (!isNaN(teamIdNum)) {
                dispatch(fetchTeamDetails(teamIdNum));
            }
        }
    }, [dispatch, teamId]);

    return (
        <MainLayout>
            <div className="p-4">
                <h1 className="text-2xl font-bold mb-4">Team Schedule</h1>
                {teamDetails && (
                    <>
                        <p>School: {teamDetails.school}</p>
                    </>
                )}
                <CalAppTest />

            </div>
        </MainLayout>
    );
};

export default SchedulePage;
