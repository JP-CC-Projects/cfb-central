export type PlayerChartData = {
    playerId: number;
    playerJersey: number;
    playerFirstName: string;
    playerLastName: string;
    playerWeight: number;
    playerHeight: number;
    playerDistance: number;
    playerYear: number; 
    playerPosition: string;
  };
  export type TeamChartData = {
    teamId: number;
    teamName: string;
    teamAvgWeight: number;
    teamAvgHeight: number;
    teamAvgDistance: number;
    teamAvgYear: number;
    teamWinRate: number;
  };
  export type NationAvgChartData = {
    natAvgWeight: number;
    natAvgHeight: number;
    natAvgDistance: number;
    natAvgYear: number;
    natWinRate: number;
  };