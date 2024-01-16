package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;



@Entity
@Table(name = "conference_sp_rating")
public class ConferenceSPRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer year;
    private String conference;
    private Double rating;
    private Double secondOrderWins;
    private Double sos;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "rating", column = @Column(name = "offense_rating")),
            @AttributeOverride(name = "success", column = @Column(name = "offense_success")),
            @AttributeOverride(name = "explosiveness", column = @Column(name = "offense_explosiveness")),
            @AttributeOverride(name = "rushing", column = @Column(name = "offense_rushing")),
            @AttributeOverride(name = "passing", column = @Column(name = "offense_passing")),
            @AttributeOverride(name = "standardDowns", column = @Column(name = "offense_standard_downs")),
            @AttributeOverride(name = "passingDowns", column = @Column(name = "offense_passing_downs")),
            @AttributeOverride(name = "runRate", column = @Column(name = "offense_run_rate")),
            @AttributeOverride(name = "pace", column = @Column(name = "offense_pace"))
    })
    private Offense offense;


    @Embedded
    @AttributeOverrides({
            // Assuming Defense has the same fields as Offense, adjust if different
            @AttributeOverride(name = "rating", column = @Column(name = "defense_rating")),
            @AttributeOverride(name = "success", column = @Column(name = "defense_success")),
            @AttributeOverride(name = "explosiveness", column = @Column(name = "defense_explosiveness")),
            @AttributeOverride(name = "rushing", column = @Column(name = "defense_rushing")),
            @AttributeOverride(name = "passing", column = @Column(name = "defense_passing")),
            @AttributeOverride(name = "standardDowns", column = @Column(name = "defense_standard_downs")),
            @AttributeOverride(name = "passingDowns", column = @Column(name = "defense_passing_downs")),
            @AttributeOverride(name = "runRate", column = @Column(name = "defense_run_rate")),
            @AttributeOverride(name = "pace", column = @Column(name = "defense_pace"))
    })
    private Defense defense;


    @Embedded
    @AttributeOverrides({
            // Assuming Defense has the same fields as Offense, adjust if different
            @AttributeOverride(name = "rating", column = @Column(name = "special_teams_rating"))
    })
    private SpecialTeams specialTeams;

    @Embeddable
    public static class Offense {
        private Double rating;
        private Double success;
        private Double explosiveness;
        private Double rushing;
        private Double passing;
        private Double standardDowns;
        private Double passingDowns;
        private Double runRate;
        private Double pace;

        // Getters and Setters

        public Double getRating() {
            return rating;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }

        public Double getSuccess() {
            return success;
        }

        public void setSuccess(Double success) {
            this.success = success;
        }

        public Double getExplosiveness() {
            return explosiveness;
        }

        public void setExplosiveness(Double explosiveness) {
            this.explosiveness = explosiveness;
        }

        public Double getRushing() {
            return rushing;
        }

        public void setRushing(Double rushing) {
            this.rushing = rushing;
        }

        public Double getPassing() {
            return passing;
        }

        public void setPassing(Double passing) {
            this.passing = passing;
        }

        public Double getStandardDowns() {
            return standardDowns;
        }

        public void setStandardDowns(Double standardDowns) {
            this.standardDowns = standardDowns;
        }

        public Double getPassingDowns() {
            return passingDowns;
        }

        public void setPassingDowns(Double passingDowns) {
            this.passingDowns = passingDowns;
        }

        public Double getRunRate() {
            return runRate;
        }

        public void setRunRate(Double runRate) {
            this.runRate = runRate;
        }

        public Double getPace() {
            return pace;
        }

        public void setPace(Double pace) {
            this.pace = pace;
        }
    }

    @Embeddable
    public static class Defense {
        private Double rating;
        private Double success;
        private Double explosiveness;
        private Double rushing;
        private Double pasing;
        private Double standardDowns;
        private Double passingDowns;

        @Embedded
        private Havoc havoc;

        // Getters and Setters

        public Double getRating() {
            return rating;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }

        public Double getSuccess() {
            return success;
        }

        public void setSuccess(Double success) {
            this.success = success;
        }

        public Double getExplosiveness() {
            return explosiveness;
        }

        public void setExplosiveness(Double explosiveness) {
            this.explosiveness = explosiveness;
        }

        public Double getRushing() {
            return rushing;
        }

        public void setRushing(Double rushing) {
            this.rushing = rushing;
        }

        public Double getPasing() {
            return pasing;
        }

        public void setPasing(Double pasing) {
            this.pasing = pasing;
        }

        public Double getStandardDowns() {
            return standardDowns;
        }

        public void setStandardDowns(Double standardDowns) {
            this.standardDowns = standardDowns;
        }

        public Double getPassingDowns() {
            return passingDowns;
        }

        public void setPassingDowns(Double passingDowns) {
            this.passingDowns = passingDowns;
        }

        public Havoc getHavoc() {
            return havoc;
        }

        public void setHavoc(Havoc havoc) {
            this.havoc = havoc;
        }
    }

    @Embeddable
    public static class Havoc {
        private Double total;
        private Double frontSeven;
        private Double db;

        // Getters and Setters

        public Double getTotal() {
            return total;
        }

        public void setTotal(Double total) {
            this.total = total;
        }

        public Double getFrontSeven() {
            return frontSeven;
        }

        public void setFrontSeven(Double frontSeven) {
            this.frontSeven = frontSeven;
        }

        public Double getDb() {
            return db;
        }

        public void setDb(Double db) {
            this.db = db;
        }
    }

    @Embeddable
    public static class SpecialTeams {
        private Double rating;

        // Getters and Setters

        public Double getRating() {
            return rating;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getSecondOrderWins() {
        return secondOrderWins;
    }

    public void setSecondOrderWins(Double secondOrderWins) {
        this.secondOrderWins = secondOrderWins;
    }

    public Double getSos() {
        return sos;
    }

    public void setSos(Double sos) {
        this.sos = sos;
    }

    public Offense getOffense() {
        return offense;
    }

    public void setOffense(Offense offense) {
        this.offense = offense;
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }

    public SpecialTeams getSpecialTeams() {
        return specialTeams;
    }

    public void setSpecialTeams(SpecialTeams specialTeams) {
        this.specialTeams = specialTeams;
    }
}
