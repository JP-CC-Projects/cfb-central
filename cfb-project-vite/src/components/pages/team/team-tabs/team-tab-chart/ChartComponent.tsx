import React, { useRef, useEffect, useState } from 'react';
import { Chart, ChartConfiguration, registerables } from 'chart.js';
import { useSelector } from 'react-redux';
import { RootState, useAppDispatch } from '../../../../../redux/store';
import { fetchPlayerChartData, fetchAllTeamsAvgChartData } from '../../../../../redux/actions/chartActions';
import { PlayerChartData, TeamChartData } from '../../../../../types/chartTypes';
Chart.register(...registerables);
interface ChartComponentProps {
    teamId: number;
}
type AxisOption = 'Player' | 'Team';

const yAxisOptions: Record<AxisOption, { value: string; label: string }[]> = {
    Player: [
        { value: 'playerDistance', label: 'Player Distance' },
        { value: 'playerWeight', label: 'Player Weight' },
        { value: 'playerHeight', label: 'Player Height' }
        // Add more player-specific options here
    ],
    Team: [
        { value: 'teamAvgDistance', label: 'Avg Distance' },
        { value: 'teamAvgWeight', label: 'Avg Weight' },
        { value: 'teamAvgHeight', label: 'Avg Height' },
        { value: 'teamAvgYear', label: 'Avg Year' },
        { value: 'teamWinRate', label: 'Win Rate' }
        // Add more team-specific options here
    ]
};

const ChartComponent: React.FC<ChartComponentProps> = ({ teamId }) => {
    const dispatch = useAppDispatch();
    const playerChartData = useSelector((state: RootState) => state.chart.playerChartData);
    const teamChartData = useSelector((state: RootState) => state.chart.teamChartData); 

    const chartRef = useRef<HTMLCanvasElement>(null);
    const chartInstance = useRef<Chart<"bar", number[], string> | null>(null);

    const [xAxisOption, setXAxisOption] = useState<AxisOption>('Player');
    const [yAxis, setYAxis] = useState<string>(yAxisOptions['Player'][0].value);

    useEffect(() => {
        setYAxis(yAxisOptions[xAxisOption][0].value);
    }, [xAxisOption]);

    useEffect(() => {
        if (xAxisOption === 'Player') {
            dispatch(fetchPlayerChartData(teamId));
        } else if (xAxisOption === 'Team') {
            dispatch(fetchAllTeamsAvgChartData());
        }
    }, [dispatch, teamId, xAxisOption]);


    useEffect(() => {
        if (chartRef.current && (playerChartData || teamChartData)) {
            const ctx = chartRef.current.getContext('2d');
            if (ctx) {
                if (chartInstance.current) {
                    chartInstance.current.destroy();
                }

                let labels, dataset;
                if (xAxisOption === 'Player') {
                    // Logic for player data
                    labels = playerChartData?.map(item => `${item.playerFirstName} ${item.playerLastName} #${item.playerJersey}`);
                    dataset = playerChartData?.map(item => item[yAxis as keyof PlayerChartData]);
                } else if (xAxisOption === 'Team') {
                    // Logic for team data
                    labels = teamChartData?.map(item => item.teamName); // Adjust as needed
                    dataset = teamChartData?.map(item => item[yAxis as keyof TeamChartData]); // Adjust as needed
                }

                const config: ChartConfiguration<"bar", number[], string> = {
                    type: 'bar',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: yAxis,
                            backgroundColor: 'rgba(82, 45, 128, 0.5)',
                            borderColor: 'rgb(255, 99, 132)',
                            data: dataset?.map(item => typeof item === 'number' ? item : 0) || [],
                        }],
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true,
                            },
                        },
                    },
                };

                chartInstance.current = new Chart(ctx, config);
            }
        }

        return () => {
            if (chartInstance.current) {
                chartInstance.current.destroy();
            }
        };
    }, [playerChartData, teamChartData, xAxisOption, yAxis]);


    return (
        <div>
            <div>
                <label>X-Axis: </label>
                <select value={xAxisOption} onChange={e => setXAxisOption(e.target.value)}>
                    <option value="Player">Player</option>
                    <option value="Team">Team</option>
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
