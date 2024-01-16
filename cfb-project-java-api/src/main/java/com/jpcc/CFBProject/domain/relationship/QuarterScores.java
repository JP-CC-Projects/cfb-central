package com.jpcc.CFBProject.domain.relationship;
import jakarta.persistence.*;

@Embeddable
public class QuarterScores {
    // Fields for regular quarters

    private Integer q1HomeTeamScore;
    private Integer q1AwayTeamScore;
    private Integer q1HomeTeamPointsScored;
    private Integer q1AwayTeamPointsScored;

    private Integer q2HomeTeamScore;
    private Integer q2AwayTeamScore;
    private Integer q2HomeTeamPointsScored;
    private Integer q2AwayTeamPointsScored;

    private Integer q3HomeTeamScore;
    private Integer q3AwayTeamScore;
    private Integer q3HomeTeamPointsScored;
    private Integer q3AwayTeamPointsScored;

    private Integer q4HomeTeamScore;
    private Integer q4AwayTeamScore;
    private Integer q4HomeTeamPointsScored;
    private Integer q4AwayTeamPointsScored;

    // Fields for overtime periods
    private Integer ot1HomeTeamScore;
    private Integer ot1AwayTeamScore;
    private Integer ot1HomeTeamPointsScored;
    private Integer ot1AwayTeamPointsScored;

    private Integer ot2HomeTeamScore;
    private Integer ot2AwayTeamScore;
    private Integer ot2HomeTeamPointsScored;
    private Integer ot2AwayTeamPointsScored;

    private Integer ot3HomeTeamScore;
    private Integer ot3AwayTeamScore;
    private Integer ot3HomeTeamPointsScored;
    private Integer ot3AwayTeamPointsScored;

    private Integer ot4HomeTeamScore;
    private Integer ot4AwayTeamScore;
    private Integer ot4HomeTeamPointsScored;
    private Integer ot4AwayTeamPointsScored;

    private Integer ot5HomeTeamScore;
    private Integer ot5AwayTeamScore;
    private Integer ot5HomeTeamPointsScored;
    private Integer ot5AwayTeamPointsScored;

    private Integer ot6HomeTeamScore;
    private Integer ot6AwayTeamScore;
    private Integer ot6HomeTeamPointsScored;
    private Integer ot6AwayTeamPointsScored;

    private Integer ot7HomeTeamScore;
    private Integer ot7AwayTeamScore;
    private Integer ot7HomeTeamPointsScored;
    private Integer ot7AwayTeamPointsScored;

    private Integer ot8HomeTeamScore;
    private Integer ot8AwayTeamScore;
    private Integer ot8HomeTeamPointsScored;
    private Integer ot8AwayTeamPointsScored;

    public Integer getQ1HomeTeamScore() {
        return q1HomeTeamScore;
    }

    public void setQ1HomeTeamScore(Integer q1HomeTeamScore) {
        this.q1HomeTeamScore = q1HomeTeamScore;
    }

    public Integer getQ1AwayTeamScore() {
        return q1AwayTeamScore;
    }

    public void setQ1AwayTeamScore(Integer q1AwayTeamScore) {
        this.q1AwayTeamScore = q1AwayTeamScore;
    }

    public Integer getQ1HomeTeamPointsScored() {
        return q1HomeTeamPointsScored;
    }

    public void setQ1HomeTeamPointsScored(Integer q1HomeTeamPointsScored) {
        this.q1HomeTeamPointsScored = q1HomeTeamPointsScored;
    }

    public Integer getQ1AwayTeamPointsScored() {
        return q1AwayTeamPointsScored;
    }

    public void setQ1AwayTeamPointsScored(Integer q1AwayTeamPointsScored) {
        this.q1AwayTeamPointsScored = q1AwayTeamPointsScored;
    }

    public Integer getQ2HomeTeamScore() {
        return q2HomeTeamScore;
    }

    public void setQ2HomeTeamScore(Integer q2HomeTeamScore) {
        this.q2HomeTeamScore = q2HomeTeamScore;
    }

    public Integer getQ2AwayTeamScore() {
        return q2AwayTeamScore;
    }

    public void setQ2AwayTeamScore(Integer q2AwayTeamScore) {
        this.q2AwayTeamScore = q2AwayTeamScore;
    }

    public Integer getQ2HomeTeamPointsScored() {
        return q2HomeTeamPointsScored;
    }

    public void setQ2HomeTeamPointsScored(Integer q2HomeTeamPointsScored) {
        this.q2HomeTeamPointsScored = q2HomeTeamPointsScored;
    }

    public Integer getQ2AwayTeamPointsScored() {
        return q2AwayTeamPointsScored;
    }

    public void setQ2AwayTeamPointsScored(Integer q2AwayTeamPointsScored) {
        this.q2AwayTeamPointsScored = q2AwayTeamPointsScored;
    }

    public Integer getQ3HomeTeamScore() {
        return q3HomeTeamScore;
    }

    public void setQ3HomeTeamScore(Integer q3HomeTeamScore) {
        this.q3HomeTeamScore = q3HomeTeamScore;
    }

    public Integer getQ3AwayTeamScore() {
        return q3AwayTeamScore;
    }

    public void setQ3AwayTeamScore(Integer q3AwayTeamScore) {
        this.q3AwayTeamScore = q3AwayTeamScore;
    }

    public Integer getQ3HomeTeamPointsScored() {
        return q3HomeTeamPointsScored;
    }

    public void setQ3HomeTeamPointsScored(Integer q3HomeTeamPointsScored) {
        this.q3HomeTeamPointsScored = q3HomeTeamPointsScored;
    }

    public Integer getQ3AwayTeamPointsScored() {
        return q3AwayTeamPointsScored;
    }

    public void setQ3AwayTeamPointsScored(Integer q3AwayTeamPointsScored) {
        this.q3AwayTeamPointsScored = q3AwayTeamPointsScored;
    }

    public Integer getQ4HomeTeamScore() {
        return q4HomeTeamScore;
    }

    public void setQ4HomeTeamScore(Integer q4HomeTeamScore) {
        this.q4HomeTeamScore = q4HomeTeamScore;
    }

    public Integer getQ4AwayTeamScore() {
        return q4AwayTeamScore;
    }

    public void setQ4AwayTeamScore(Integer q4AwayTeamScore) {
        this.q4AwayTeamScore = q4AwayTeamScore;
    }

    public Integer getQ4HomeTeamPointsScored() {
        return q4HomeTeamPointsScored;
    }

    public void setQ4HomeTeamPointsScored(Integer q4HomeTeamPointsScored) {
        this.q4HomeTeamPointsScored = q4HomeTeamPointsScored;
    }

    public Integer getQ4AwayTeamPointsScored() {
        return q4AwayTeamPointsScored;
    }

    public void setQ4AwayTeamPointsScored(Integer q4AwayTeamPointsScored) {
        this.q4AwayTeamPointsScored = q4AwayTeamPointsScored;
    }

    public Integer getOt1HomeTeamScore() {
        return ot1HomeTeamScore;
    }

    public void setOt1HomeTeamScore(Integer ot1HomeTeamScore) {
        this.ot1HomeTeamScore = ot1HomeTeamScore;
    }

    public Integer getOt1AwayTeamScore() {
        return ot1AwayTeamScore;
    }

    public void setOt1AwayTeamScore(Integer ot1AwayTeamScore) {
        this.ot1AwayTeamScore = ot1AwayTeamScore;
    }

    public Integer getOt1HomeTeamPointsScored() {
        return ot1HomeTeamPointsScored;
    }

    public void setOt1HomeTeamPointsScored(Integer ot1HomeTeamPointsScored) {
        this.ot1HomeTeamPointsScored = ot1HomeTeamPointsScored;
    }

    public Integer getOt1AwayTeamPointsScored() {
        return ot1AwayTeamPointsScored;
    }

    public void setOt1AwayTeamPointsScored(Integer ot1AwayTeamPointsScored) {
        this.ot1AwayTeamPointsScored = ot1AwayTeamPointsScored;
    }

    public Integer getOt2HomeTeamScore() {
        return ot2HomeTeamScore;
    }

    public void setOt2HomeTeamScore(Integer ot2HomeTeamScore) {
        this.ot2HomeTeamScore = ot2HomeTeamScore;
    }

    public Integer getOt2AwayTeamScore() {
        return ot2AwayTeamScore;
    }

    public void setOt2AwayTeamScore(Integer ot2AwayTeamScore) {
        this.ot2AwayTeamScore = ot2AwayTeamScore;
    }

    public Integer getOt2HomeTeamPointsScored() {
        return ot2HomeTeamPointsScored;
    }

    public void setOt2HomeTeamPointsScored(Integer ot2HomeTeamPointsScored) {
        this.ot2HomeTeamPointsScored = ot2HomeTeamPointsScored;
    }

    public Integer getOt2AwayTeamPointsScored() {
        return ot2AwayTeamPointsScored;
    }

    public void setOt2AwayTeamPointsScored(Integer ot2AwayTeamPointsScored) {
        this.ot2AwayTeamPointsScored = ot2AwayTeamPointsScored;
    }

    public Integer getOt3HomeTeamScore() {
        return ot3HomeTeamScore;
    }

    public void setOt3HomeTeamScore(Integer ot3HomeTeamScore) {
        this.ot3HomeTeamScore = ot3HomeTeamScore;
    }

    public Integer getOt3AwayTeamScore() {
        return ot3AwayTeamScore;
    }

    public void setOt3AwayTeamScore(Integer ot3AwayTeamScore) {
        this.ot3AwayTeamScore = ot3AwayTeamScore;
    }

    public Integer getOt3HomeTeamPointsScored() {
        return ot3HomeTeamPointsScored;
    }

    public void setOt3HomeTeamPointsScored(Integer ot3HomeTeamPointsScored) {
        this.ot3HomeTeamPointsScored = ot3HomeTeamPointsScored;
    }

    public Integer getOt3AwayTeamPointsScored() {
        return ot3AwayTeamPointsScored;
    }

    public void setOt3AwayTeamPointsScored(Integer ot3AwayTeamPointsScored) {
        this.ot3AwayTeamPointsScored = ot3AwayTeamPointsScored;
    }

    public Integer getOt4HomeTeamScore() {
        return ot4HomeTeamScore;
    }

    public void setOt4HomeTeamScore(Integer ot4HomeTeamScore) {
        this.ot4HomeTeamScore = ot4HomeTeamScore;
    }

    public Integer getOt4AwayTeamScore() {
        return ot4AwayTeamScore;
    }

    public void setOt4AwayTeamScore(Integer ot4AwayTeamScore) {
        this.ot4AwayTeamScore = ot4AwayTeamScore;
    }

    public Integer getOt4HomeTeamPointsScored() {
        return ot4HomeTeamPointsScored;
    }

    public void setOt4HomeTeamPointsScored(Integer ot4HomeTeamPointsScored) {
        this.ot4HomeTeamPointsScored = ot4HomeTeamPointsScored;
    }

    public Integer getOt4AwayTeamPointsScored() {
        return ot4AwayTeamPointsScored;
    }

    public void setOt4AwayTeamPointsScored(Integer ot4AwayTeamPointsScored) {
        this.ot4AwayTeamPointsScored = ot4AwayTeamPointsScored;
    }

    public Integer getOt5HomeTeamScore() {
        return ot5HomeTeamScore;
    }

    public void setOt5HomeTeamScore(Integer ot5HomeTeamScore) {
        this.ot5HomeTeamScore = ot5HomeTeamScore;
    }

    public Integer getOt5AwayTeamScore() {
        return ot5AwayTeamScore;
    }

    public void setOt5AwayTeamScore(Integer ot5AwayTeamScore) {
        this.ot5AwayTeamScore = ot5AwayTeamScore;
    }

    public Integer getOt5HomeTeamPointsScored() {
        return ot5HomeTeamPointsScored;
    }

    public void setOt5HomeTeamPointsScored(Integer ot5HomeTeamPointsScored) {
        this.ot5HomeTeamPointsScored = ot5HomeTeamPointsScored;
    }

    public Integer getOt5AwayTeamPointsScored() {
        return ot5AwayTeamPointsScored;
    }

    public void setOt5AwayTeamPointsScored(Integer ot5AwayTeamPointsScored) {
        this.ot5AwayTeamPointsScored = ot5AwayTeamPointsScored;
    }

    public Integer getOt6HomeTeamScore() {
        return ot6HomeTeamScore;
    }

    public void setOt6HomeTeamScore(Integer ot6HomeTeamScore) {
        this.ot6HomeTeamScore = ot6HomeTeamScore;
    }

    public Integer getOt6AwayTeamScore() {
        return ot6AwayTeamScore;
    }

    public void setOt6AwayTeamScore(Integer ot6AwayTeamScore) {
        this.ot6AwayTeamScore = ot6AwayTeamScore;
    }

    public Integer getOt6HomeTeamPointsScored() {
        return ot6HomeTeamPointsScored;
    }

    public void setOt6HomeTeamPointsScored(Integer ot6HomeTeamPointsScored) {
        this.ot6HomeTeamPointsScored = ot6HomeTeamPointsScored;
    }

    public Integer getOt6AwayTeamPointsScored() {
        return ot6AwayTeamPointsScored;
    }

    public void setOt6AwayTeamPointsScored(Integer ot6AwayTeamPointsScored) {
        this.ot6AwayTeamPointsScored = ot6AwayTeamPointsScored;
    }

    public Integer getOt7HomeTeamScore() {
        return ot7HomeTeamScore;
    }

    public void setOt7HomeTeamScore(Integer ot7HomeTeamScore) {
        this.ot7HomeTeamScore = ot7HomeTeamScore;
    }

    public Integer getOt7AwayTeamScore() {
        return ot7AwayTeamScore;
    }

    public void setOt7AwayTeamScore(Integer ot7AwayTeamScore) {
        this.ot7AwayTeamScore = ot7AwayTeamScore;
    }

    public Integer getOt7HomeTeamPointsScored() {
        return ot7HomeTeamPointsScored;
    }

    public void setOt7HomeTeamPointsScored(Integer ot7HomeTeamPointsScored) {
        this.ot7HomeTeamPointsScored = ot7HomeTeamPointsScored;
    }

    public Integer getOt7AwayTeamPointsScored() {
        return ot7AwayTeamPointsScored;
    }

    public void setOt7AwayTeamPointsScored(Integer ot7AwayTeamPointsScored) {
        this.ot7AwayTeamPointsScored = ot7AwayTeamPointsScored;
    }

    public Integer getOt8HomeTeamScore() {
        return ot8HomeTeamScore;
    }

    public void setOt8HomeTeamScore(Integer ot8HomeTeamScore) {
        this.ot8HomeTeamScore = ot8HomeTeamScore;
    }

    public Integer getOt8AwayTeamScore() {
        return ot8AwayTeamScore;
    }

    public void setOt8AwayTeamScore(Integer ot8AwayTeamScore) {
        this.ot8AwayTeamScore = ot8AwayTeamScore;
    }

    public Integer getOt8HomeTeamPointsScored() {
        return ot8HomeTeamPointsScored;
    }

    public void setOt8HomeTeamPointsScored(Integer ot8HomeTeamPointsScored) {
        this.ot8HomeTeamPointsScored = ot8HomeTeamPointsScored;
    }

    public Integer getOt8AwayTeamPointsScored() {
        return ot8AwayTeamPointsScored;
    }

    public void setOt8AwayTeamPointsScored(Integer ot8AwayTeamPointsScored) {
        this.ot8AwayTeamPointsScored = ot8AwayTeamPointsScored;
    }

    @Override
    public String toString() {
        return "QuarterScores{" +
                "q1HomeTeamScore=" + q1HomeTeamScore +
                ", q1AwayTeamScore=" + q1AwayTeamScore +
                ", q1HomeTeamPointsScored=" + q1HomeTeamPointsScored +
                ", q1AwayTeamPointsScored=" + q1AwayTeamPointsScored +
                ", q2HomeTeamScore=" + q2HomeTeamScore +
                ", q2AwayTeamScore=" + q2AwayTeamScore +
                ", q2HomeTeamPointsScored=" + q2HomeTeamPointsScored +
                ", q2AwayTeamPointsScored=" + q2AwayTeamPointsScored +
                ", q3HomeTeamScore=" + q3HomeTeamScore +
                ", q3AwayTeamScore=" + q3AwayTeamScore +
                ", q3HomeTeamPointsScored=" + q3HomeTeamPointsScored +
                ", q3AwayTeamPointsScored=" + q3AwayTeamPointsScored +
                ", q4HomeTeamScore=" + q4HomeTeamScore +
                ", q4AwayTeamScore=" + q4AwayTeamScore +
                ", q4HomeTeamPointsScored=" + q4HomeTeamPointsScored +
                ", q4AwayTeamPointsScored=" + q4AwayTeamPointsScored +
                ", ot1HomeTeamScore=" + ot1HomeTeamScore +
                ", ot1AwayTeamScore=" + ot1AwayTeamScore +
                ", ot1HomeTeamPointsScored=" + ot1HomeTeamPointsScored +
                ", ot1AwayTeamPointsScored=" + ot1AwayTeamPointsScored +
                ", ot2HomeTeamScore=" + ot2HomeTeamScore +
                ", ot2AwayTeamScore=" + ot2AwayTeamScore +
                ", ot2HomeTeamPointsScored=" + ot2HomeTeamPointsScored +
                ", ot2AwayTeamPointsScored=" + ot2AwayTeamPointsScored +
                ", ot3HomeTeamScore=" + ot3HomeTeamScore +
                ", ot3AwayTeamScore=" + ot3AwayTeamScore +
                ", ot3HomeTeamPointsScored=" + ot3HomeTeamPointsScored +
                ", ot3AwayTeamPointsScored=" + ot3AwayTeamPointsScored +
                ", ot4HomeTeamScore=" + ot4HomeTeamScore +
                ", ot4AwayTeamScore=" + ot4AwayTeamScore +
                ", ot4HomeTeamPointsScored=" + ot4HomeTeamPointsScored +
                ", ot4AwayTeamPointsScored=" + ot4AwayTeamPointsScored +
                ", ot5HomeTeamScore=" + ot5HomeTeamScore +
                ", ot5AwayTeamScore=" + ot5AwayTeamScore +
                ", ot5HomeTeamPointsScored=" + ot5HomeTeamPointsScored +
                ", ot5AwayTeamPointsScored=" + ot5AwayTeamPointsScored +
                ", ot6HomeTeamScore=" + ot6HomeTeamScore +
                ", ot6AwayTeamScore=" + ot6AwayTeamScore +
                ", ot6HomeTeamPointsScored=" + ot6HomeTeamPointsScored +
                ", ot6AwayTeamPointsScored=" + ot6AwayTeamPointsScored +
                ", ot7HomeTeamScore=" + ot7HomeTeamScore +
                ", ot7AwayTeamScore=" + ot7AwayTeamScore +
                ", ot7HomeTeamPointsScored=" + ot7HomeTeamPointsScored +
                ", ot7AwayTeamPointsScored=" + ot7AwayTeamPointsScored +
                ", ot8HomeTeamScore=" + ot8HomeTeamScore +
                ", ot8AwayTeamScore=" + ot8AwayTeamScore +
                ", ot8HomeTeamPointsScored=" + ot8HomeTeamPointsScored +
                ", ot8AwayTeamPointsScored=" + ot8AwayTeamPointsScored +
                '}';
    }
}
