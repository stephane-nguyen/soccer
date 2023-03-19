package com.graphql.soccerDetails;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.graphql.soccerDetails.constant.SoccerPlayerAttributesEnum;
import com.graphql.soccerDetails.constant.SoccerPlayerRoleEnum;
import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.SoccerPlayer;
import com.graphql.soccerDetails.repository.ClubRepository;
import com.graphql.soccerDetails.repository.SoccerPlayerRepository;

@SpringBootApplication
public class SoccerDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerDetailsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(SoccerPlayerRepository soccerPlayerRepository, ClubRepository clubRepository) {
		return args -> {
			Club club1 = new Club(null, "FC Barcelona", "Spain", "La Liga", "Camp Nou", 91, "Ronald Koeman", null);
			clubRepository.save(club1);
			Club club2 = new Club(null, "Real Madrid", "Spain", "La Liga", "Santiago Bernabéu", 93, "Zinedine Zidane",
					null);
			clubRepository.save(club2);

			SoccerPlayer player1 = new SoccerPlayer(null, "Lionel", "Messi", SoccerPlayerRoleEnum.ST,
					SoccerPlayerAttributesEnum.SHO, 93.0f, 34, 25000000, 1.70f, "Argentina", club1);
			soccerPlayerRepository.save(player1);

			SoccerPlayer player2 = new SoccerPlayer(null, "Cristiano", "Ronaldo", SoccerPlayerRoleEnum.ST,
					SoccerPlayerAttributesEnum.PAC, 92.0f, 36, 30000000, 1.87f, "Portugal", club2);
			soccerPlayerRepository.save(player2);

			SoccerPlayer player3 = new SoccerPlayer(null, "Neymar", "Jr.", SoccerPlayerRoleEnum.CF,
					SoccerPlayerAttributesEnum.DRI, 90.0f, 29, 20000000, 1.75f, "Brazil", club2);
			soccerPlayerRepository.save(player3);
		};
	}

}
