package com.jpcc.CFBProject.dto;

import com.jpcc.CFBProject.domain.relationship.QuarterScores;

import java.time.Instant;

public class TimeLineSeasonGamesDTO {
    private Long gameId;
    private Instant date;
    private String cardTitle;
    private String cardSubtitle;
    private String cardDetailedText;
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

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getCardSubtitle() {
        return cardSubtitle;
    }

    public void setCardSubtitle(String cardSubtitle) {
        this.cardSubtitle = cardSubtitle;
    }

    public String getCardDetailedText() {
        return cardDetailedText;
    }

    public void setCardDetailedText(String cardDetailedText) {
        this.cardDetailedText = cardDetailedText;
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
    public TimeLineSeasonGamesDTO(Long gameId, Instant date, String cardTitle, String cardSubtitle,
                                  String cardDetailedText, String url, String mediaType,
                                  String mediaUrl, String mediaName, QuarterScores quarterScores) {
        this.gameId = gameId;
        this.date = date;
        this.cardTitle = cardTitle;
        this.cardSubtitle = cardSubtitle;
        this.cardDetailedText = cardDetailedText;
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
