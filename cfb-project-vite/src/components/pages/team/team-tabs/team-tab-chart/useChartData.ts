import { useEffect } from 'react';
import { useSelector } from 'react-redux';
import { createSelector } from 'reselect';
import { RootState, useAppDispatch } from '../../../../../redux/store';
import { fetchPlayerChartData, fetchAllTeamsAvgChartData } from '../../../../../redux/actions/chartActions';

// Memoized selectors
const selectPlayerChartData = createSelector(
  (state: RootState) => state.chart.playerChartData,
  (playerChartData) => playerChartData
);

const selectTeamChartData = createSelector(
  (state: RootState) => state.chart.teamChartData,
  (teamChartData) => teamChartData
);

const useChartData = (teamId: number) => {
    const dispatch = useAppDispatch();
    const playerChartData = useSelector(selectPlayerChartData);
    const teamChartData = useSelector(selectTeamChartData);

    useEffect(() => {
        dispatch(fetchPlayerChartData(teamId));
        dispatch(fetchAllTeamsAvgChartData());
    }, [dispatch, teamId]);

    return { playerChartData, teamChartData };
};

export default useChartData;
