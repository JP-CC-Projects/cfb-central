import { ReactNode } from "react";
// Define types for your team data structure
export type TeamMin = {
  id: number;
  school: string;
  mascot?: string; // use '?' for optional properties
};


export type TeamDetails = {
  id: number;
  school: string;
  mascot: string;
  abbreviation: string;
  alt_name1: string | null;
  alt_name2: string;
  alt_name3: string;
  classification: string | null;
  conference: string;
  division: string | null;
  color: string;
  alt_color: string;
  logos: string[];
  twitter: string;
  location: {
    venue_image_url: string;
    venue_id: number;
    name: string;
    city: string;
    state: string;
    zip: string;
    country_code: string;
    timezone: string;
    latitude: number;
    longitude: number;
    elevation: number;
    capacity: number;
    year_constructed: number;
    grass: boolean;
    dome: boolean;
  };
};
export type TeamTimeline = {
  gameId: number;
  timelineContent: ReactNode;
  date: number;
  title: string;
  cardTitle: string;
  cardSubtitle: string;
  cardDetailedText: string; 
  url: string; 
  media: {
    source: {
      url: string; // URL of the media
      type: string; // Type of the media source, e.g., "mp4", "IMAGE"
    };
    type: string; // Type of the media, e.g., "VIDEO", "IMAGE"
    name: string; 
  };
  quarterScores: {
    q1HomeTeamScore: number;
    q1AwayTeamScore: number;
    q1HomeTeamPointsScored: number;
    q1AwayTeamPointsScored: number;
  
    q2HomeTeamScore: number;
    q2AwayTeamScore: number;
    q2HomeTeamPointsScored: number;
    q2AwayTeamPointsScored: number;
  
    q3HomeTeamScore: number;
    q3AwayTeamScore: number;
    q3HomeTeamPointsScored: number;
    q3AwayTeamPointsScored: number;
  
    q4HomeTeamScore: number;
    q4AwayTeamScore: number;
    q4HomeTeamPointsScored: number;
    q4AwayTeamPointsScored: number;
  
    // Fields for overtime periods
    ot1HomeTeamScore: number;
    ot1AwayTeamScore: number;
    ot1HomeTeamPointsScored: number;
    ot1AwayTeamPointsScored: number;
  
    ot2HomeTeamScore: number;
    ot2AwayTeamScore: number;
    ot2HomeTeamPointsScored: number;
    ot2AwayTeamPointsScored: number;
  
    ot3HomeTeamScore: number;
    ot3AwayTeamScore: number;
    ot3HomeTeamPointsScored: number;
    ot3AwayTeamPointsScored: number;
  
    ot4HomeTeamScore: number;
    ot4AwayTeamScore: number;
    ot4HomeTeamPointsScored: number;
    ot4AwayTeamPointsScored: number;
  
    ot5HomeTeamScore: number;
    ot5AwayTeamScore: number;
    ot5HomeTeamPointsScored: number;
    ot5AwayTeamPointsScored: number;
  
    ot6HomeTeamScore: number;
    ot6AwayTeamScore: number;
    ot6HomeTeamPointsScored: number;
    ot6AwayTeamPointsScored: number;
  
    ot7HomeTeamScore: number;
    ot7AwayTeamScore: number;
    ot7HomeTeamPointsScored: number;
    ot7AwayTeamPointsScored: number;
  
    ot8HomeTeamScore: number;
    ot8AwayTeamScore: number;
    ot8HomeTeamPointsScored: number;
    ot8AwayTeamPointsScored: number;
  };
};
export type TeamRecord = {
  id: number;
  year: number;
  teamId: number;
  team: string;
  conference: string;
  division: string;
  expectedWins: number;
  total: RecordDetail;
  conferenceGames: RecordDetail;
  homeGames: RecordDetail;
  awayGames: RecordDetail;
};

export type RecordDetail = {
  games?: number;
  wins?: number;
  losses?: number;
  ties?: number;
};


export type Player = {
  // For map and roster
  id: number;
  firstName: string;
  lastName: string;
  jersey: number;
  position: string;
  homeCity: string;
  homeState: string;

  // For roster only:
  teamSegment?: string;  // Processed in TeamRoster
  team: string;
  height: number;
  weight: number;
  year: number;
  onOffense: boolean; 
  onDefense: boolean; 
  onSpecialTeams: boolean;

  //For map only: 
  homeLatitude: number;
  homeLongitude: number;
};
