package com.jpcc.CFBProject.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cfbdata.urls")
public class CFBApiConfig {
    private String base;
    private String boxScoreEndpoint;
    private String gamesEndpoint;
    private String fbsTeamsEndpoint;
    private String scoreboardEndpoint;
    private String recordsEndpoint;
    private String calendarEndpoint;
    private String gameMediaEndpoint;
    private String gameWeatherEndpoint;
    private String gamePlayersEndpoint;
    private String gameTeamsEndpoint;

    private String drivesEndpoint;
    private String playsEndpoint;
    private String livePlaysEndpoint;
    private String playTypesEndpoint;
    private String playStatsEndpoint;
    private String playStatTypesEndpoint;
    private String teamsEndpoint;
    private String rosterEndpoint;
    private String talentEndpoint;
    private String teamsMatchupEndpoint;
    private String conferencesEndpoint;
    private String venuesEndpoint;
    private String coachesEndpoint;
    private String playerSearchEndpoint;
    private String playerUsageEndpoint;
    private String playerReturningEndpoint;
    private String statsPlayerSeasonEndpoint;
    private String playerPortalEndpoint;
    private String rankingsEndpoint;
    private String linesEndpoint;
    private String recruitingPlayersEndpoint;
    private String recruitingTeamsEndpoint;
    private String recruitingGroupsEndpoint;
    private String ratingsSpEndpoint;
    private String ratingsSrsEndpoint;
    private String ratingsSpConferencesEndpoint;
    private String ratingsEloEndpoint;
    private String ratingsFpiEndpoint;
    private String ppaPredictedEndpoint;
    private String ppaTeamsEndpoint;
    private String ppaGamesEndpoint;
    private String ppaPlayersGamesEndpoint;
    private String ppaPlayersSeasonEndpoint;
    private String metricsFgEpEndpoint;
    private String metricsWpEndpoint;
    private String metricsWpPregameEndpoint;
    private String statsSeasonEndpoint;
    private String statsSeasonAdvancedEndpoint;
    private String statsGameAdvancedEndpoint;
    private String statsCategoriesEndpoint;
    private String draftTeamsEndpoint;
    private String draftPositionsEndpoint;
    private String draftPicksEndpoint;




    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getBoxScoreEndpoint() {
        return boxScoreEndpoint;
    }

    public void setBoxScoreEndpoint(String boxScoreEndpoint) {
        this.boxScoreEndpoint = boxScoreEndpoint;
    }

    public String getGamesEndpoint() {
        return gamesEndpoint;
    }

    public void setGamesEndpoint(String gamesEndpoint) {
        this.gamesEndpoint = gamesEndpoint;
    }

    public String getFbsTeamsEndpoint() {
        return fbsTeamsEndpoint;
    }

    public void setFbsTeamsEndpoint(String fbsTeamsEndpoint) {
        this.fbsTeamsEndpoint = fbsTeamsEndpoint;
    }

    public String getScoreboardEndpoint() {
        return scoreboardEndpoint;
    }

    public void setScoreboardEndpoint(String scoreboardEndpoint) {
        this.scoreboardEndpoint = scoreboardEndpoint;
    }

    public String getRecordsEndpoint() {
        return recordsEndpoint;
    }

    public void setRecordsEndpoint(String recordsEndpoint) {
        this.recordsEndpoint = recordsEndpoint;
    }

    public String getCalendarEndpoint() {
        return calendarEndpoint;
    }

    public void setCalendarEndpoint(String calendarEndpoint) {
        this.calendarEndpoint = calendarEndpoint;
    }

    public String getGameMediaEndpoint() {
        return gameMediaEndpoint;
    }

    public void setGameMediaEndpoint(String gameMediaEndpoint) {
        this.gameMediaEndpoint = gameMediaEndpoint;
    }

    public String getGameWeatherEndpoint() {
        return gameWeatherEndpoint;
    }

    public void setGameWeatherEndpoint(String gameWeatherEndpoint) {
        this.gameWeatherEndpoint = gameWeatherEndpoint;
    }

    public String getGamePlayersEndpoint() {
        return gamePlayersEndpoint;
    }

    public void setGamePlayersEndpoint(String gamePlayersEndpoint) {
        this.gamePlayersEndpoint = gamePlayersEndpoint;
    }

    public String getGameTeamsEndpoint() {
        return gameTeamsEndpoint;
    }

    public void setGameTeamsEndpoint(String gameTeamsEndpoint) {
        this.gameTeamsEndpoint = gameTeamsEndpoint;
    }

    public String getDrivesEndpoint() {
        return drivesEndpoint;
    }

    public void setDrivesEndpoint(String drivesEndpoint) {
        this.drivesEndpoint = drivesEndpoint;
    }

    public String getPlaysEndpoint() {
        return playsEndpoint;
    }

    public void setPlaysEndpoint(String playsEndpoint) {
        this.playsEndpoint = playsEndpoint;
    }

    public String getLivePlaysEndpoint() {
        return livePlaysEndpoint;
    }

    public void setLivePlaysEndpoint(String livePlaysEndpoint) {
        this.livePlaysEndpoint = livePlaysEndpoint;
    }

    public String getPlayTypesEndpoint() {
        return playTypesEndpoint;
    }

    public void setPlayTypesEndpoint(String playTypesEndpoint) {
        this.playTypesEndpoint = playTypesEndpoint;
    }

    public String getPlayStatsEndpoint() {
        return playStatsEndpoint;
    }

    public void setPlayStatsEndpoint(String playStatsEndpoint) {
        this.playStatsEndpoint = playStatsEndpoint;
    }

    public String getPlayStatTypesEndpoint() {
        return playStatTypesEndpoint;
    }

    public void setPlayStatTypesEndpoint(String playStatTypesEndpoint) {
        this.playStatTypesEndpoint = playStatTypesEndpoint;
    }

    public String getTeamsEndpoint() {
        return teamsEndpoint;
    }

    public void setTeamsEndpoint(String teamsEndpoint) {
        this.teamsEndpoint = teamsEndpoint;
    }

    public String getRosterEndpoint() {
        return rosterEndpoint;
    }

    public void setRosterEndpoint(String rosterEndpoint) {
        this.rosterEndpoint = rosterEndpoint;
    }

    public String getTalentEndpoint() {
        return talentEndpoint;
    }

    public void setTalentEndpoint(String talentEndpoint) {
        this.talentEndpoint = talentEndpoint;
    }

    public String getTeamsMatchupEndpoint() {
        return teamsMatchupEndpoint;
    }

    public void setTeamsMatchupEndpoint(String teamsMatchupEndpoint) {
        this.teamsMatchupEndpoint = teamsMatchupEndpoint;
    }

    public String getConferencesEndpoint() {
        return conferencesEndpoint;
    }

    public void setConferencesEndpoint(String conferencesEndpoint) {
        this.conferencesEndpoint = conferencesEndpoint;
    }

    public String getVenuesEndpoint() {
        return venuesEndpoint;
    }

    public void setVenuesEndpoint(String venuesEndpoint) {
        this.venuesEndpoint = venuesEndpoint;
    }

    public String getCoachesEndpoint() {
        return coachesEndpoint;
    }

    public void setCoachesEndpoint(String coachesEndpoint) {
        this.coachesEndpoint = coachesEndpoint;
    }

    public String getPlayerSearchEndpoint() {
        return playerSearchEndpoint;
    }

    public void setPlayerSearchEndpoint(String playerSearchEndpoint) {
        this.playerSearchEndpoint = playerSearchEndpoint;
    }

    public String getPlayerUsageEndpoint() {
        return playerUsageEndpoint;
    }

    public void setPlayerUsageEndpoint(String playerUsageEndpoint) {
        this.playerUsageEndpoint = playerUsageEndpoint;
    }

    public String getPlayerReturningEndpoint() {
        return playerReturningEndpoint;
    }

    public void setPlayerReturningEndpoint(String playerReturningEndpoint) {
        this.playerReturningEndpoint = playerReturningEndpoint;
    }

    public String getStatsPlayerSeasonEndpoint() {
        return statsPlayerSeasonEndpoint;
    }

    public void setStatsPlayerSeasonEndpoint(String statsPlayerSeasonEndpoint) {
        this.statsPlayerSeasonEndpoint = statsPlayerSeasonEndpoint;
    }

    public String getPlayerPortalEndpoint() {
        return playerPortalEndpoint;
    }

    public void setPlayerPortalEndpoint(String playerPortalEndpoint) {
        this.playerPortalEndpoint = playerPortalEndpoint;
    }

    public String getRankingsEndpoint() {
        return rankingsEndpoint;
    }

    public void setRankingsEndpoint(String rankingsEndpoint) {
        this.rankingsEndpoint = rankingsEndpoint;
    }

    public String getLinesEndpoint() {
        return linesEndpoint;
    }

    public void setLinesEndpoint(String linesEndpoint) {
        this.linesEndpoint = linesEndpoint;
    }

    public String getRecruitingPlayersEndpoint() {
        return recruitingPlayersEndpoint;
    }

    public void setRecruitingPlayersEndpoint(String recruitingPlayersEndpoint) {
        this.recruitingPlayersEndpoint = recruitingPlayersEndpoint;
    }

    public String getRecruitingTeamsEndpoint() {
        return recruitingTeamsEndpoint;
    }

    public void setRecruitingTeamsEndpoint(String recruitingTeamsEndpoint) {
        this.recruitingTeamsEndpoint = recruitingTeamsEndpoint;
    }

    public String getRecruitingGroupsEndpoint() {
        return recruitingGroupsEndpoint;
    }

    public void setRecruitingGroupsEndpoint(String recruitingGroupsEndpoint) {
        this.recruitingGroupsEndpoint = recruitingGroupsEndpoint;
    }

    public String getRatingsSpEndpoint() {
        return ratingsSpEndpoint;
    }

    public void setRatingsSpEndpoint(String ratingsSpEndpoint) {
        this.ratingsSpEndpoint = ratingsSpEndpoint;
    }

    public String getRatingsSrsEndpoint() {
        return ratingsSrsEndpoint;
    }

    public void setRatingsSrsEndpoint(String ratingsSrsEndpoint) {
        this.ratingsSrsEndpoint = ratingsSrsEndpoint;
    }

    public String getRatingsSpConferencesEndpoint() {
        return ratingsSpConferencesEndpoint;
    }

    public void setRatingsSpConferencesEndpoint(String ratingsSpConferencesEndpoint) {
        this.ratingsSpConferencesEndpoint = ratingsSpConferencesEndpoint;
    }

    public String getRatingsEloEndpoint() {
        return ratingsEloEndpoint;
    }

    public void setRatingsEloEndpoint(String ratingsEloEndpoint) {
        this.ratingsEloEndpoint = ratingsEloEndpoint;
    }

    public String getRatingsFpiEndpoint() {
        return ratingsFpiEndpoint;
    }

    public void setRatingsFpiEndpoint(String ratingsFpiEndpoint) {
        this.ratingsFpiEndpoint = ratingsFpiEndpoint;
    }

    public String getPpaPredictedEndpoint() {
        return ppaPredictedEndpoint;
    }

    public void setPpaPredictedEndpoint(String ppaPredictedEndpoint) {
        this.ppaPredictedEndpoint = ppaPredictedEndpoint;
    }

    public String getPpaTeamsEndpoint() {
        return ppaTeamsEndpoint;
    }

    public void setPpaTeamsEndpoint(String ppaTeamsEndpoint) {
        this.ppaTeamsEndpoint = ppaTeamsEndpoint;
    }

    public String getPpaGamesEndpoint() {
        return ppaGamesEndpoint;
    }

    public void setPpaGamesEndpoint(String ppaGamesEndpoint) {
        this.ppaGamesEndpoint = ppaGamesEndpoint;
    }

    public String getPpaPlayersGamesEndpoint() {
        return ppaPlayersGamesEndpoint;
    }

    public void setPpaPlayersGamesEndpoint(String ppaPlayersGamesEndpoint) {
        this.ppaPlayersGamesEndpoint = ppaPlayersGamesEndpoint;
    }

    public String getPpaPlayersSeasonEndpoint() {
        return ppaPlayersSeasonEndpoint;
    }

    public void setPpaPlayersSeasonEndpoint(String ppaPlayersSeasonEndpoint) {
        this.ppaPlayersSeasonEndpoint = ppaPlayersSeasonEndpoint;
    }

    public String getMetricsFgEpEndpoint() {
        return metricsFgEpEndpoint;
    }

    public void setMetricsFgEpEndpoint(String metricsFgEpEndpoint) {
        this.metricsFgEpEndpoint = metricsFgEpEndpoint;
    }

    public String getMetricsWpEndpoint() {
        return metricsWpEndpoint;
    }

    public void setMetricsWpEndpoint(String metricsWpEndpoint) {
        this.metricsWpEndpoint = metricsWpEndpoint;
    }

    public String getMetricsWpPregameEndpoint() {
        return metricsWpPregameEndpoint;
    }

    public void setMetricsWpPregameEndpoint(String metricsWpPregameEndpoint) {
        this.metricsWpPregameEndpoint = metricsWpPregameEndpoint;
    }

    public String getStatsSeasonEndpoint() {
        return statsSeasonEndpoint;
    }

    public void setStatsSeasonEndpoint(String statsSeasonEndpoint) {
        this.statsSeasonEndpoint = statsSeasonEndpoint;
    }

    public String getStatsSeasonAdvancedEndpoint() {
        return statsSeasonAdvancedEndpoint;
    }

    public void setStatsSeasonAdvancedEndpoint(String statsSeasonAdvancedEndpoint) {
        this.statsSeasonAdvancedEndpoint = statsSeasonAdvancedEndpoint;
    }

    public String getStatsGameAdvancedEndpoint() {
        return statsGameAdvancedEndpoint;
    }

    public void setStatsGameAdvancedEndpoint(String statsGameAdvancedEndpoint) {
        this.statsGameAdvancedEndpoint = statsGameAdvancedEndpoint;
    }

    public String getStatsCategoriesEndpoint() {
        return statsCategoriesEndpoint;
    }

    public void setStatsCategoriesEndpoint(String statsCategoriesEndpoint) {
        this.statsCategoriesEndpoint = statsCategoriesEndpoint;
    }

    public String getDraftTeamsEndpoint() {
        return draftTeamsEndpoint;
    }

    public void setDraftTeamsEndpoint(String draftTeamsEndpoint) {
        this.draftTeamsEndpoint = draftTeamsEndpoint;
    }

    public String getDraftPositionsEndpoint() {
        return draftPositionsEndpoint;
    }

    public void setDraftPositionsEndpoint(String draftPositionsEndpoint) {
        this.draftPositionsEndpoint = draftPositionsEndpoint;
    }

    public String getDraftPicksEndpoint() {
        return draftPicksEndpoint;
    }

    public void setDraftPicksEndpoint(String draftPicksEndpoint) {
        this.draftPicksEndpoint = draftPicksEndpoint;
    }
}
