package com.jpcc.CFBProject.security.securitycontroller;

import com.jpcc.CFBProject.security.securitydomain.Authority;
import com.jpcc.CFBProject.security.securitydomain.User;
import com.jpcc.CFBProject.security.securityrepository.UserRepository;
import com.jpcc.CFBProject.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private TeamService teamService;
    private GameService gameService;
    private TeamRecordService teamRecordService;
    private PlayService playService;
    private PlayerService playerService;
    private SeasonCalendarService seasonCalendarService;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private DataCorrectionService dataCorrectionService;


    @Autowired
    public AdminController(TeamService teamService,
                           GameService gameService,
                           TeamRecordService teamRecordService,
                           PlayService playService,
                           PlayerService playerService,
                           SeasonCalendarService seasonCalendarService,
                           PasswordEncoder passwordEncoder,
                           UserRepository userRepository,
                           DataCorrectionService dataCorrectionService) {
        this.teamService = teamService;
        this.gameService = gameService;
        this.teamRecordService = teamRecordService;
        this.playService = playService;
        this.playerService = playerService;
        this.seasonCalendarService = seasonCalendarService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.dataCorrectionService = dataCorrectionService;
    }

    @Value("${admin.firstName}")
    private String adminFirstName;
    @Value("${admin.lastName}")
    private String adminLastName;
    @Value("${admin.email}")
    private String adminEmail;
    @Value("${admin.password}")
    private String adminUPassword;

    @PostConstruct // This annotation is used to create an admin user during application startup
    public void init() {
        createAdminUser();
    }

    public void createAdminUser() {
        User adminUser = new User();
        if (userRepository.findByEmail(adminEmail).isPresent()) {
            return;
        }
        adminUser.setFirstName(adminFirstName);
        adminUser.setLastName(adminLastName);
        adminUser.setEmail(adminEmail);
        adminUser.setPassword(passwordEncoder.encode(adminUPassword));

        Authority adminAuth = new Authority("ROLE_ADMIN", adminUser);
        adminUser.setAuthorities(Collections.singletonList(adminAuth));
        userRepository.save(adminUser);
    }


    @PostMapping("/triggerSeasonCalendarFetch")
    public ResponseEntity<?> fetchAndSaveSeasonCalendar(
            @RequestParam(required = true, name = "season") Integer season) throws Exception {
        seasonCalendarService.fetchAndSaveWeeks(season);
        return ResponseEntity.ok("Season " + season + " fetched and saved successfully.");
    }


    @PostMapping("/triggerTeamsFetch")
    public ResponseEntity<?> fetchAndSaveTeams() throws Exception {
        teamService.fetchAndSaveTeams();
        return ResponseEntity.ok("Teams fetched and saved successfully.");
    }
    @PostMapping("/triggerPlayersFetch") //Goes to Roster endpoint in CFB API
    public ResponseEntity<?> fetchAndSavePlayers(@RequestParam(required = true, name = "season") Integer season,
                                                 @RequestParam(required = false) String team) throws Exception {
        if (team == null || team.isBlank()) {
            playerService.fetchAndSaveAllPlayersByYear(season);
        }
        else {
            playerService.fetchAndSavePlayers(team, season);
        }
        return ResponseEntity.ok("Players for " + season + " fetched and saved successfully.");
    }

    @PostMapping("/triggerGamesFetch")
    public ResponseEntity<?> fetchAndSaveGames(@RequestParam(name = "season") Integer season) throws Exception {
        try {
            gameService.fetchAndSaveGames(season, "postseason");
            gameService.fetchAndSaveGames(season, "regular");
            return ResponseEntity.ok("Games for season " + season + " fetched and saved successfully.");
        } catch (Exception e) {
            // Log the error and potentially return a different response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching games for season " + season);
        }
    }

    @PostMapping("/triggerTeamRecordsFetch")
    public ResponseEntity<?> fetchAndSaveTeamRecords(
                                          @RequestParam(required = true, name = "season") Integer season) throws Exception {
        teamRecordService.fetchAndSaveTeamRecords(season);
        return ResponseEntity.ok("Team Records for season " + season + " fetched and saved successfully.");
    }

    @PostMapping("/triggerPlaysFetch")
    public ResponseEntity<?> fetchAndSavePlays(
                                    @RequestParam(required = true, name = "season") Integer season,
                                    @RequestParam(required = true, name = "week") Integer week) throws Exception {
        playService.fetchAndSavePlaysBySeason(season, week, "regular");
        playService.fetchAndSavePlaysBySeason(season, week, "postseason");
        return ResponseEntity.ok("Plays for season " + season + " and season " + week + " fetched and saved successfully.");
    }
    @PostMapping("/triggerCalculateQtrScores")
    public ResponseEntity<?> fetchAndSavePlays() throws Exception {
        gameService.calculateAllQuarterScores();
        return ResponseEntity.ok("Quarter scores successfully calculated");
    }
    @PostMapping("/removeNullPlayers")
    public ResponseEntity<?> removeNullPlayers() {
        dataCorrectionService.removeNullPlayers();
        dataCorrectionService.correctNullJerseys();
        dataCorrectionService.calculateAllPlayerDistances();
        return ResponseEntity.ok("Duplicate players removed. Null jerseys corrected");
    }
}
