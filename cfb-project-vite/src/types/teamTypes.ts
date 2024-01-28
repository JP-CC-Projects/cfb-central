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
  altName1: string | null;
  altName2: string;
  altName3: string;
  classification: string | null;
  conference: string;
  division: string | null;
  color: string;
  altColor: string;
  logos: string[];
  twitter: string;
  location: {
    venueImageUrl: string;
    venueId: number;
    name: string;
    city: string;
    state: string;
    zip: string;
    countryCode: string;
    timezone: string;
    latitude: number;
    longitude: number;
    elevation: number;
    capacity: number;
    yearConstructed: number;
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
    ot1HomeTeamScore: number | null;
    ot1AwayTeamScore: number | null;
    ot1HomeTeamPointsScored: number | null;
    ot1AwayTeamPointsScored: number | null;

    ot2HomeTeamScore: number | null;
    ot2AwayTeamScore: number | null;
    ot2HomeTeamPointsScored: number | null;
    ot2AwayTeamPointsScored: number | null;

    ot3HomeTeamScore: number | null;
    ot3AwayTeamScore: number | null;
    ot3HomeTeamPointsScored: number | null;
    ot3AwayTeamPointsScored: number | null;

    ot4HomeTeamScore: number | null;
    ot4AwayTeamScore: number | null;
    ot4HomeTeamPointsScored: number | null;
    ot4AwayTeamPointsScored: number | null;

    ot5HomeTeamScore: number | null;
    ot5AwayTeamScore: number | null;
    ot5HomeTeamPointsScored: number | null;
    ot5AwayTeamPointsScored: number | null;

    ot6HomeTeamScore: number | null;
    ot6AwayTeamScore: number | null;
    ot6HomeTeamPointsScored: number | null;
    ot6AwayTeamPointsScored: number | null;

    ot7HomeTeamScore: number | null;
    ot7AwayTeamScore: number | null;
    ot7HomeTeamPointsScored: number | null;
    ot7AwayTeamPointsScored: number | null;

    ot8HomeTeamScore: number | null;
    ot8AwayTeamScore: number | null;
    ot8HomeTeamPointsScored: number | null;
    ot8AwayTeamPointsScored: number | null;

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
