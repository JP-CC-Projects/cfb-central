package com.jpcc.CFBProject.dto;

import com.jpcc.CFBProject.domain.relationship.QuarterScores;

import java.time.Instant;

public class TimeLineSeasonGamesDTO {
    private Long gameId;
    private Instant date;
    private String homeTeam;
    private String awayTeam;
    private String homeTeamAbrv;
    private String awayTeamAbrv;
    private String url;
    private Media media;
    private QuarterScores quarterScores;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeamAbrv() {
        return homeTeamAbrv;
    }

    public void setHomeTeamAbrv(String homeTeamAbrv) {
        this.homeTeamAbrv = homeTeamAbrv;
    }

    public String getAwayTeamAbrv() {
        return awayTeamAbrv;
    }

    public void setAwayTeamAbrv(String awayTeamAbrv) {
        this.awayTeamAbrv = awayTeamAbrv;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public QuarterScores getQuarterScores() {
        return quarterScores;
    }

    public void setQuarterScores(QuarterScores quarterScores) {
        this.quarterScores = quarterScores;
    }

    public static class Media {
        private Source source;
        private String type;
        private String name;
        // Constructor, getters, and setters

        public Source getSource() {
            return source;
        }

        public void setSource(Source source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static class Source {
            private String url;
            private String type; // "mp4", "IMAGE", etc.

            // Constructor, getters, and setters

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
    public TimeLineSeasonGamesDTO(Long gameId, Instant date, String homeTeam, String awayTeam,
                                  String homeTeamAbrv, String awayTeamAbrv, String url, String mediaType,
                                  String mediaUrl, String mediaName, QuarterScores quarterScores) {
        this.gameId = gameId;
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamAbrv = homeTeamAbrv;
        this.awayTeamAbrv = awayTeamAbrv;
        this.url = url;
        this.media = new Media();
        this.media.type = mediaType;
        this.media.name = mediaName;
        this.media.source = new Media.Source();
        this.media.source.url = mediaUrl;
        this.media.source.type = mediaType; // Assuming same type as media
        this.quarterScores = quarterScores;

    }

}
