import React, { useEffect, useState } from 'react';
import { Chart, registerables } from 'chart.js';
import useChartData from './useChartData';
import chartSetup from './chartSetup';

Chart.register(...registerables);

interface ChartComponentProps {
    teamId: number;
}

type AxisOption = 'Player' | 'Team';

const playerChartIncludedKeys = ['playerWeight', 'playerHeight', 'playerDistance'];
const teamChartIncludedKeys = ['teamAvgWeight', 'teamAvgHeight', 'teamAvgDistance', 'teamAvgYear'];

const playerChartOptions = playerChartIncludedKeys.map(key => ({
    value: key,
    label: key.charAt(0).toUpperCase() + key.slice(1).replace(/([A-Z])/g, ' $1')
}));

const teamChartOptions = teamChartIncludedKeys.map(key => ({
    value: key,
    label: key.charAt(0).toUpperCase() + key.slice(1).replace(/([A-Z])/g, ' $1')
}));

const yAxisOptions = {
    Player: playerChartOptions,
    Team: teamChartOptions
};

const ChartComponent: React.FC<ChartComponentProps> = ({ teamId }) => {
    const [xAxisOption, setXAxisOption] = useState<'Player' | 'Team'>('Player');
    const [yAxis, setYAxis] = useState<string>('playerDistance');
    const { playerChartData, teamChartData } = useChartData(teamId, xAxisOption, setYAxis);
    const chartRef = chartSetup({ playerChartData, teamChartData, xAxisOption, yAxis });



    return (
        <div>
            <div>
                <label>X-Axis: </label>
                <select value={xAxisOption} onChange={e => setXAxisOption(e.target.value as AxisOption)}>
                    <option value="Player" >Player</option>
                    <option value="Team" >Team</option>
                </select>
                <label> Y-Axis: </label>
                <select value={yAxis} onChange={e => setYAxis(e.target.value)}>
                    {yAxisOptions[xAxisOption].map(option => (
                        <option key={option.value} value={option.value}>
                            {option.label}
                        </option>
                    ))}
                </select>
            </div>
            <canvas ref={chartRef}></canvas>
        </div>
    );
};

export default ChartComponent;