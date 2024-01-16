package com.jpcc.CFBProject.domain.boxscore;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jpcc.CFBProject.domain.Game;
import jakarta.persistence.*;

@Entity
public class BoxScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;
    @Embedded
    @JsonProperty("gameInfo")
    private BoxScoreGameInfo boxScoreGameInfo;

    @OneToOne(mappedBy = "boxScore", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("teams")
    private BoxScoreTeam teams;
    @OneToOne(mappedBy = "boxScore", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("players")
    private BoxScorePlayer players;


    // Add fields to store basic game information if needed
    // Constructors, getters, setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public BoxScoreGameInfo getBoxScoreGameInfo() {
        return boxScoreGameInfo;
    }

    public void setBoxScoreGameInfo(BoxScoreGameInfo boxScoreGameInfo) {
        this.boxScoreGameInfo = boxScoreGameInfo;
    }

    public BoxScoreTeam getTeams() {
        return teams;
    }

    public void setTeams(BoxScoreTeam teams) {
        this.teams = teams;
    }

    public BoxScorePlayer getPlayers() {
        return players;
    }

    public void setPlayers(BoxScorePlayer players) {
        this.players = players;
    }
}
