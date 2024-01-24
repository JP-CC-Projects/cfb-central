package com.jpcc.CFBProject.security.securitycontroller;

import com.jpcc.CFBProject.repository.GameRepository;
import com.jpcc.CFBProject.security.securitydomain.Authority;
import com.jpcc.CFBProject.security.securitydomain.User;
import com.jpcc.CFBProject.security.securityrepository.UserRepository;
import com.jpcc.CFBProject.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


    @Autowired
    public AdminController(TeamService teamService,
                           GameService gameService,
                           TeamRecordService teamRecordService,
                           PlayService playService,
                           PlayerService playerService,
                           SeasonCalendarService seasonCalendarService,
                           PasswordEncoder passwordEncoder,
                           UserRepository userRepository) {
        this.teamService = teamService;
        this.gameService = gameService;
        this.teamRecordService = teamRecordService;
        this.playService = playService;
        this.playerService = playerService;
        this.seasonCalendarService = seasonCalendarService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
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


    @PostMapping("/fetchSeasonCalendar")
    public ResponseEntity<?> fetchAndSaveSeasonCalendar(
            @RequestParam(required = true) Integer season) throws Exception {
        seasonCalendarService.fetchAndSaveWeeks(season);
        return ResponseEntity.ok("Season " + season + " fetched and saved successfully.");
    }


    @PostMapping("/fetchTeams")
    public ResponseEntity<?> fetchAndSaveTeams() throws Exception {
        teamService.fetchAndSaveTeams();
        return ResponseEntity.ok("Teams fetched and saved successfully.");
    }


    @PostMapping("/fetchGames")
    public ResponseEntity<?> fetchAndSaveGames(RedirectAttributes redirectAttributes,
                                    @RequestParam(required = true) Integer season) throws Exception {
        gameService.fetchAndSaveGames(season, "postseason");
        gameService.fetchAndSaveGames(season, "regular");
        return ResponseEntity.ok("Games for season " + season + " fetched and saved successfully.");
    }

    @PostMapping("/fetchTeamRecords")
    public ResponseEntity<?> fetchAndSaveTeamRecords(RedirectAttributes redirectAttributes,
                                          @RequestParam(required = true) Integer year) throws Exception {
        teamRecordService.fetchAndSaveTeamRecords(year);
        return ResponseEntity.ok("Team Records for season " + year + " fetched and saved successfully.");
    }

    @PostMapping("/fetchPlays")
    public ResponseEntity<?> fetchAndSavePlays(RedirectAttributes redirectAttributes,
                                    @RequestParam(required = true) Integer year,
                                    @RequestParam(required = true) Integer week) throws Exception {
        playService.fetchAndSavePlaysBySeason(year, week, "regular");
        gameService.calculateAllQuarterScores();
        return ResponseEntity.ok("Plays for season " + year + " and season " + week + " fetched and saved successfully.");
    }

    @PostMapping("/fetchPlayers") //Goes to Roster endpoint in CFB API
    public ResponseEntity<?> fetchAndSavePlayers(RedirectAttributes redirectAttributes,
                                      @RequestParam(required = true) Integer year,
                                      @RequestParam(required = false) String team) throws Exception {
        playerService.fetchAndSavePlayers(team, year);
        return ResponseEntity.ok("Players for " + team + " " + year + " fetched and saved successfully.");
    }
}
