package com.jpcc.CFBProject;

import com.jpcc.CFBProject.repository.PlayerRepository;
import com.jpcc.CFBProject.repository.PlayerTeamHistoryRepository;
import com.jpcc.CFBProject.repository.TeamRepository;
import com.jpcc.CFBProject.services.DataCorrectionService;
import com.jpcc.CFBProject.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class CfbProjectApplication implements CommandLineRunner {
	private final PlayerService playerService;
	private final PlayerRepository playerRepository;
	private final DataCorrectionService dataCorrectionService;
	private final PlayerTeamHistoryRepository playerTeamHistoryRepository;
	private final TeamRepository teamRepository;

	@Autowired
	public CfbProjectApplication(PlayerService playerService, PlayerRepository playerRepository, DataCorrectionService dataCorrectionService,
								 PlayerTeamHistoryRepository playerTeamHistoryRepository,
								 TeamRepository teamRepository) {
		this.playerService = playerService;
		this.playerRepository = playerRepository;
		this.dataCorrectionService = dataCorrectionService;
		this.playerTeamHistoryRepository = playerTeamHistoryRepository;
		this.teamRepository = teamRepository;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(CfbProjectApplication.class, args);
	}

	//Command Line Runner -- Run Experimental Methods Here
	@Override
	public void run(String... args) throws Exception {
	}
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
