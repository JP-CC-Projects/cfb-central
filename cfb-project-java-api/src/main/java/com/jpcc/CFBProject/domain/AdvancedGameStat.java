package com.jpcc.CFBProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "advanced_game_stat")
public class AdvancedGameStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long gameId;
    private Integer season;
    private Integer week;
    private String team;
    private String opponent;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "plays", column = @Column(name = "offense_plays")),
            @AttributeOverride(name = "drives", column = @Column(name = "offense_drives")),
            @AttributeOverride(name = "ppa", column = @Column(name = "offense_ppa")),
            @AttributeOverride(name = "totalPPA", column = @Column(name = "offense_total_ppa")),
            @AttributeOverride(name = "successRate", column = @Column(name = "offense_success_rate")),
            @AttributeOverride(name = "explosiveness", column = @Column(name = "offense_explosiveness")),
            @AttributeOverride(name = "powerSuccess", column = @Column(name = "offense_power_success")),
            @AttributeOverride(name = "stuffRate", column = @Column(name = "offense_stuff_rate")),
            @AttributeOverride(name = "lineYards", column = @Column(name = "offense_line_yards")),
            @AttributeOverride(name = "lineYardsTotal", column = @Column(name = "offense_line_yards_total")),
            @AttributeOverride(name = "secondLevelYards", column = @Column(name = "offense_second_level_yards")),
            @AttributeOverride(name = "secondLevelYardsTotal", column = @Column(name = "offense_second_level_yards_total")),
            @AttributeOverride(name = "openFieldYards", column = @Column(name = "offense_open_field_yards")),
            @AttributeOverride(name = "openFieldYardsTotal", column = @Column(name = "offense_open_field_yards_total")),
            @AttributeOverride(name = "totalOpportunies", column = @Column(name = "offense_total_opportunities")),
            @AttributeOverride(name = "pointsPerOpportunity", column = @Column(name = "offense_points_per_opportunity"))
    })
    private OffenseStats offense;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "plays", column = @Column(name = "defense_plays")),
            @AttributeOverride(name = "drives", column = @Column(name = "defense_drives")),
            @AttributeOverride(name = "ppa", column = @Column(name = "defense_ppa")),
            @AttributeOverride(name = "totalPPA", column = @Column(name = "defense_total_ppa")),
            @AttributeOverride(name = "successRate", column = @Column(name = "defense_success_rate")),
            @AttributeOverride(name = "explosiveness", column = @Column(name = "defense_explosiveness")),
            @AttributeOverride(name = "powerSuccess", column = @Column(name = "defense_power_success")),
            @AttributeOverride(name = "stuffRate", column = @Column(name = "defense_stuff_rate")),
            @AttributeOverride(name = "lineYards", column = @Column(name = "defense_line_yards")),
            @AttributeOverride(name = "lineYardsTotal", column = @Column(name = "defense_line_yards_total")),
            @AttributeOverride(name = "secondLevelYards", column = @Column(name = "defense_second_level_yards")),
            @AttributeOverride(name = "secondLevelYardsTotal", column = @Column(name = "defense_second_level_yards_total")),
            @AttributeOverride(name = "openFieldYards", column = @Column(name = "defense_open_field_yards")),
            @AttributeOverride(name = "openFieldYardsTotal", column = @Column(name = "defense_open_field_yards_total")),
            @AttributeOverride(name = "totalOpportunies", column = @Column(name = "defense_total_opportunities")),
            @AttributeOverride(name = "pointsPerOpportunity", column = @Column(name = "defense_points_per_opportunity"))
    })
    private DefenseStats defense;


    // Nested OffenseStats class similar to the one in AdvancedSeasonStat
    @Embeddable
    public static class OffenseStats {
        private Integer plays;
        private Integer drives;
        private Double ppa;
        private Double totalPPA;
        private Double successRate;
        private Double explosiveness;
        private Double powerSuccess;
        private Double stuffRate;
        private Double lineYards;
        private Double lineYardsTotal;
        private Double secondLevelYards;
        private Integer secondLevelYardsTotal;
        private Double openFieldYards;
        private Integer openFieldYardsTotal;

        @Embeddable
        public static class StandardDowns {
            private Double rate;
            private Double ppa;
            private Double successRate;
            private Double explosiveness;

            // Getters and Setters

            public Double getRate() {
                return rate;
            }

            public void setRate(Double rate) {
                this.rate = rate;
            }

            public Double getPpa() {
                return ppa;
            }

            public void setPpa(Double ppa) {
                this.ppa = ppa;
            }

            public Double getSuccessRate() {
                return successRate;
            }

            public void setSuccessRate(Double successRate) {
                this.successRate = successRate;
            }

            public Double getExplosiveness() {
                return explosiveness;
            }

            public void setExplosiveness(Double explosiveness) {
                this.explosiveness = explosiveness;
            }
        }

        @Embeddable
        public static class PassingDowns {
            private Double rate;
            private Double ppa;
            private Double successRate;
            private Double explosiveness;

            // Getters and Setters

            public Double getRate() {
                return rate;
            }

            public void setRate(Double rate) {
                this.rate = rate;
            }

            public Double getPpa() {
                return ppa;
            }

            public void setPpa(Double ppa) {
                this.ppa = ppa;
            }

            public Double getSuccessRate() {
                return successRate;
            }

            public void setSuccessRate(Double successRate) {
                this.successRate = successRate;
            }

            public Double getExplosiveness() {
                return explosiveness;
            }

            public void setExplosiveness(Double explosiveness) {
                this.explosiveness = explosiveness;
            }
        }

        @Embeddable
        public static class RushingPlays {
            private Double rate;
            private Double ppa;
            private Double totalPPA;
            private Double successRate;
            private Double explosiveness;

            // Getters and Setters

            public Double getRate() {
                return rate;
            }

            public void setRate(Double rate) {
                this.rate = rate;
            }

            public Double getPpa() {
                return ppa;
            }

            public void setPpa(Double ppa) {
                this.ppa = ppa;
            }

            public Double getTotalPPA() {
                return totalPPA;
            }

            public void setTotalPPA(Double totalPPA) {
                this.totalPPA = totalPPA;
            }

            public Double getSuccessRate() {
                return successRate;
            }

            public void setSuccessRate(Double successRate) {
                this.successRate = successRate;
            }

            public Double getExplosiveness() {
                return explosiveness;
            }

            public void setExplosiveness(Double explosiveness) {
                this.explosiveness = explosiveness;
            }
        }

        @Embeddable
        public static class PassingPlays {
            private Double rate;
            private Double ppa;
            private Double totalPPA;
            private Double successRate;
            private Double explosiveness;

            // Getters and Setters

            public Double getRate() {
                return rate;
            }

            public void setRate(Double rate) {
                this.rate = rate;
            }

            public Double getPpa() {
                return ppa;
            }

            public void setPpa(Double ppa) {
                this.ppa = ppa;
            }

            public Double getTotalPPA() {
                return totalPPA;
            }

            public void setTotalPPA(Double totalPPA) {
                this.totalPPA = totalPPA;
            }

            public Double getSuccessRate() {
                return successRate;
            }

            public void setSuccessRate(Double successRate) {
                this.successRate = successRate;
            }

            public Double getExplosiveness() {
                return explosiveness;
            }

            public void setExplosiveness(Double explosiveness) {
                this.explosiveness = explosiveness;
            }
        }
    }

    @Embeddable
    public static class DefenseStats {
        @AttributeOverride(name = "plays", column = @Column(name = "defense_plays"))
        private Integer plays;

        @AttributeOverride(name = "drives", column = @Column(name = "defense_drives"))
        private Integer drives;

        @AttributeOverride(name = "ppa", column = @Column(name = "defense_ppa"))
        private Double ppa;

        @AttributeOverride(name = "totalPPA", column = @Column(name = "defense_total_ppa"))
        private Double totalPPA;

        @AttributeOverride(name = "successRate", column = @Column(name = "defense_success_rate"))
        private Double successRate;

        @AttributeOverride(name = "explosiveness", column = @Column(name = "defense_explosiveness"))
        private Double explosiveness;

        @AttributeOverride(name = "powerSuccess", column = @Column(name = "defense_power_success"))
        private Double powerSuccess;

        @AttributeOverride(name = "stuffRate", column = @Column(name = "defense_stuff_rate"))
        private Double stuffRate;

        @AttributeOverride(name = "lineYards", column = @Column(name = "defense_line_yards"))
        private Double lineYards;

        @AttributeOverride(name = "lineYardsTotal", column = @Column(name = "defense_line_yards_total"))
        private Double lineYardsTotal;

        @AttributeOverride(name = "secondLevelYards", column = @Column(name = "defense_second_level_yards"))
        private Double secondLevelYards;

        @AttributeOverride(name = "secondLevelYardsTotal", column = @Column(name = "defense_second_level_yards_total"))
        private Integer secondLevelYardsTotal;

        @AttributeOverride(name = "openFieldYards", column = @Column(name = "defense_open_field_yards"))
        private Double openFieldYards;

        @AttributeOverride(name = "openFieldYardsTotal", column = @Column(name = "defense_open_field_yards_total"))
        private Integer openFieldYardsTotal;

        @AttributeOverride(name = "totalOpportunies", column = @Column(name = "defense_total_opportunities"))
        private Integer totalOpportunies;

        @AttributeOverride(name = "pointsPerOpportunity", column = @Column(name = "defense_points_per_opportunity"))
        private Double pointsPerOpportunity;
        @Embeddable
        public static class FieldPosition {
            private Double averageStart;
            private Double averagePredictedPoints;

            // Getters and Setters

            public Double getAverageStart() {
                return averageStart;
            }

            public void setAverageStart(Double averageStart) {
                this.averageStart = averageStart;
            }

            public Double getAveragePredictedPoints() {
                return averagePredictedPoints;
            }

            public void setAveragePredictedPoints(Double averagePredictedPoints) {
                this.averagePredictedPoints = averagePredictedPoints;
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
        public static class StandardDowns {
            private Double rate;
            private Double ppa;
            private Double successRate;
            private Double explosiveness;

            // Getters and Setters

            public Double getRate() {
                return rate;
            }

            public void setRate(Double rate) {
                this.rate = rate;
            }

            public Double getPpa() {
                return ppa;
            }

            public void setPpa(Double ppa) {
                this.ppa = ppa;
            }

            public Double getSuccessRate() {
                return successRate;
            }

            public void setSuccessRate(Double successRate) {
                this.successRate = successRate;
            }

            public Double getExplosiveness() {
                return explosiveness;
            }

            public void setExplosiveness(Double explosiveness) {
                this.explosiveness = explosiveness;
            }
        }

        @Embeddable
        public static class PassingDowns {
            private Double rate;
            private Double ppa;
            private Double successRate;
            private Double explosiveness;

            // Getters and Setters

            public Double getRate() {
                return rate;
            }

            public void setRate(Double rate) {
                this.rate = rate;
            }

            public Double getPpa() {
                return ppa;
            }

            public void setPpa(Double ppa) {
                this.ppa = ppa;
            }

            public Double getSuccessRate() {
                return successRate;
            }

            public void setSuccessRate(Double successRate) {
                this.successRate = successRate;
            }

            public Double getExplosiveness() {
                return explosiveness;
            }

            public void setExplosiveness(Double explosiveness) {
                this.explosiveness = explosiveness;
            }
        }

        @Embeddable
        public static class RushingPlays {
            private Double rate;
            private Double ppa;
            private Double totalPPA;
            private Double successRate;
            private Double explosiveness;

            // Getters and Setters

            public Double getRate() {
                return rate;
            }

            public void setRate(Double rate) {
                this.rate = rate;
            }

            public Double getPpa() {
                return ppa;
            }

            public void setPpa(Double ppa) {
                this.ppa = ppa;
            }

            public Double getTotalPPA() {
                return totalPPA;
            }

            public void setTotalPPA(Double totalPPA) {
                this.totalPPA = totalPPA;
            }

            public Double getSuccessRate() {
                return successRate;
            }

            public void setSuccessRate(Double successRate) {
                this.successRate = successRate;
            }

            public Double getExplosiveness() {
                return explosiveness;
            }

            public void setExplosiveness(Double explosiveness) {
                this.explosiveness = explosiveness;
            }
        }

        @Embeddable
        public static class PassingPlays {
            private Double rate;
            private Double ppa;
            private Double totalPPA;
            private Double successRate;
            private Double explosiveness;

            // Getters and Setters

            public Double getRate() {
                return rate;
            }

            public void setRate(Double rate) {
                this.rate = rate;
            }

            public Double getPpa() {
                return ppa;
            }

            public void setPpa(Double ppa) {
                this.ppa = ppa;
            }

            public Double getTotalPPA() {
                return totalPPA;
            }

            public void setTotalPPA(Double totalPPA) {
                this.totalPPA = totalPPA;
            }

            public Double getSuccessRate() {
                return successRate;
            }

            public void setSuccessRate(Double successRate) {
                this.successRate = successRate;
            }

            public Double getExplosiveness() {
                return explosiveness;
            }

            public void setExplosiveness(Double explosiveness) {
                this.explosiveness = explosiveness;
            }
        }

        public Integer getPlays() {
            return plays;
        }

        public void setPlays(Integer plays) {
            this.plays = plays;
        }

        public Integer getDrives() {
            return drives;
        }

        public void setDrives(Integer drives) {
            this.drives = drives;
        }

        public Double getPpa() {
            return ppa;
        }

        public void setPpa(Double ppa) {
            this.ppa = ppa;
        }

        public Double getTotalPPA() {
            return totalPPA;
        }

        public void setTotalPPA(Double totalPPA) {
            this.totalPPA = totalPPA;
        }

        public Double getSuccessRate() {
            return successRate;
        }

        public void setSuccessRate(Double successRate) {
            this.successRate = successRate;
        }

        public Double getExplosiveness() {
            return explosiveness;
        }

        public void setExplosiveness(Double explosiveness) {
            this.explosiveness = explosiveness;
        }

        public Double getPowerSuccess() {
            return powerSuccess;
        }

        public void setPowerSuccess(Double powerSuccess) {
            this.powerSuccess = powerSuccess;
        }

        public Double getStuffRate() {
            return stuffRate;
        }

        public void setStuffRate(Double stuffRate) {
            this.stuffRate = stuffRate;
        }

        public Double getLineYards() {
            return lineYards;
        }

        public void setLineYards(Double lineYards) {
            this.lineYards = lineYards;
        }

        public Double getLineYardsTotal() {
            return lineYardsTotal;
        }

        public void setLineYardsTotal(Double lineYardsTotal) {
            this.lineYardsTotal = lineYardsTotal;
        }

        public Double getSecondLevelYards() {
            return secondLevelYards;
        }

        public void setSecondLevelYards(Double secondLevelYards) {
            this.secondLevelYards = secondLevelYards;
        }

        public Integer getSecondLevelYardsTotal() {
            return secondLevelYardsTotal;
        }

        public void setSecondLevelYardsTotal(Integer secondLevelYardsTotal) {
            this.secondLevelYardsTotal = secondLevelYardsTotal;
        }

        public Double getOpenFieldYards() {
            return openFieldYards;
        }

        public void setOpenFieldYards(Double openFieldYards) {
            this.openFieldYards = openFieldYards;
        }

        public Integer getOpenFieldYardsTotal() {
            return openFieldYardsTotal;
        }

        public void setOpenFieldYardsTotal(Integer openFieldYardsTotal) {
            this.openFieldYardsTotal = openFieldYardsTotal;
        }

        public Integer getTotalOpportunies() {
            return totalOpportunies;
        }

        public void setTotalOpportunies(Integer totalOpportunies) {
            this.totalOpportunies = totalOpportunies;
        }

        public Double getPointsPerOpportunity() {
            return pointsPerOpportunity;
        }

        public void setPointsPerOpportunity(Double pointsPerOpportunity) {
            this.pointsPerOpportunity = pointsPerOpportunity;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public OffenseStats getOffense() {
        return offense;
    }

    public void setOffense(OffenseStats offense) {
        this.offense = offense;
    }

    public DefenseStats getDefense() {
        return defense;
    }

    public void setDefense(DefenseStats defense) {
        this.defense = defense;
    }
}