import { useEffect, useRef } from 'react';
import { Chart, ChartConfiguration } from 'chart.js';
import { PlayerChartData, TeamChartData } from '../../../../../types/chartTypes';

interface UseChartProps {
    playerChartData: PlayerChartData[] | null;
    teamChartData: TeamChartData[] | null;
    xAxisOption: 'Player' | 'Team';
    yAxis: string;
}

const chartSetup = ({ playerChartData, teamChartData, xAxisOption, yAxis }: UseChartProps) => {
    const chartRef = useRef<HTMLCanvasElement>(null);
    const chartInstance = useRef<Chart | null>(null);

    useEffect(() => {
        const ctx = chartRef.current?.getContext('2d');
        if (ctx) {
            chartInstance.current?.destroy();

            let labels, dataset;
            if (xAxisOption === 'Player') {
                labels = playerChartData?.map(item => `${item.playerFirstName} ${item.playerLastName} #${item.playerJersey}`);
                dataset = playerChartData?.map(item => item[yAxis as keyof PlayerChartData]);
            } else if (xAxisOption === 'Team') {
                labels = teamChartData?.map(item => item.teamName);
                dataset = teamChartData?.map(item => item[yAxis as keyof TeamChartData]);
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
                            beginAtZero: false,
                        },
                    },
                },
            };

            chartInstance.current = new Chart(ctx, config);
        }

        return () => {
            if (chartInstance.current) {
                chartInstance.current.destroy();
            }
        };
    }, [playerChartData, teamChartData, xAxisOption, yAxis]);

    return chartRef;
};

export default chartSetup;
