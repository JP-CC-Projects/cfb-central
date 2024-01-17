import React, { useRef, useEffect, useState } from 'react';
import { Chart, ChartConfiguration, registerables } from 'chart.js';
import { useSelector } from 'react-redux';
import { RootState, useAppDispatch } from '../../../redux/store';
import { fetchPlayerChartData, fetchAllTeamsChartData } from '../../../redux/actions/chartActions';
import { PlayerChartData, TeamChartData } from '../../../types/chartTypes';
Chart.register(...registerables);
interface ChartComponentProps {
    teamId: number;
}

const ChartComponent: React.FC<ChartComponentProps> = ({ teamId }) => {
    const dispatch = useAppDispatch();
    const playerChartData = useSelector((state: RootState) => state.chart.playerChartData);
    const teamChartData = useSelector((state: RootState) => state.chart.teamChartData); 

    const chartRef = useRef<HTMLCanvasElement>(null);
    const chartInstance = useRef<Chart<"bar", number[], string> | null>(null);

    const [xAxisOption, setXAxisOption] = useState('Player');
    const [yAxis, setYAxis] = useState('playerWeight');

    useEffect(() => {
        if (xAxisOption === 'Player') {
            dispatch(fetchPlayerChartData(teamId));
        } else if (xAxisOption === 'Team') {
            dispatch(fetchAllTeamsChartData); // Implement this action
        }
    }, [dispatch, teamId, xAxisOption]);

    // ... (continues in the next chunk)
    // ... (continued from the previous chunk)
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

                // ... (continues in the next chunk)
                // ... (continued from the previous chunk)
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
        <div >
            <div>
                <label>X-Axis: </label>
                <select value={xAxisOption} onChange={e => setXAxisOption(e.target.value)}>
                    <option value="Player">Player</option>
                    <option value="Team">Team</option>
                </select>
                <label>  Y-Axis: </label>
                <select value={yAxis} onChange={e => setYAxis(e.target.value)}>
                    {/* Adjust the options based on your needs */}
                    <option value="playerWeight">Player Weight</option>
                    {/* Add more yAxis options here */}
                </select>
            </div>
            <canvas ref={chartRef}></canvas>
        </div>
    );
};

export default ChartComponent;
