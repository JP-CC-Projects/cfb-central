import { useEffect } from 'react';
import { useSelector } from 'react-redux';
import { createSelector } from 'reselect';
import { RootState, useAppDispatch } from '../../../../../redux/store';
import { fetchAllTeamsAvgChartData, fetchPlayerChartData } from '../../../../../redux/actions/chartActions';

// Memoized selectors
const selectPlayerChartData = createSelector(
  (state: RootState) => state.chart.playerChartData,
  (playerChartData) => playerChartData
);

const selectTeamChartData = createSelector(
  (state: RootState) => state.chart.teamChartData,
  (teamChartData) => teamChartData
);

const useChartData = (teamId: number | null, xAxisOption: string, setYAxis: any) => {
  if (teamId === null) {
    return { playerChartData: null, teamChartData: null };
  }
  console.log('Team ID from Chart Component: ' + teamId)
  const playerChartData = useSelector(selectPlayerChartData);
  const teamChartData = useSelector(selectTeamChartData);
  const dispatch = useAppDispatch()
  useEffect(() => {

    setYAxis(xAxisOption === 'Player' ? 'playerDistance' : 'teamAvgDistance')
  }, [teamChartData, playerChartData])



  useEffect(() => {

    switch (xAxisOption) {
      case "Player":
        dispatch(fetchPlayerChartData(teamId));
        break;
      case "Team":
        dispatch(fetchAllTeamsAvgChartData());
        break;

      default:
        break;
    }



  }, [xAxisOption, dispatch]);



  return { playerChartData, teamChartData };
};

export default useChartData;