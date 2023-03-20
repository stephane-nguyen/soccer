package com.graphql.soccerDetails;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.graphql.soccerDetails.constant.FootballerAttributesEnum;
import com.graphql.soccerDetails.constant.FootballerRoleEnum;
import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.Footballer;
import com.graphql.soccerDetails.repository.ClubRepository;
import com.graphql.soccerDetails.repository.FootballerRepository;

@SpringBootApplication
public class SoccerDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerDetailsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(FootballerRepository footballerRepository, ClubRepository clubRepository) {
		return args -> {
			Club club1 = new Club(null, "FC Barcelona", "Spain", "Barcelona", "La Liga", "Camp Nou", 91, "Ronald Koeman", null);
			clubRepository.save(club1);
			Club club2 = new Club(null, "Real Madrid", "Spain","Madrid", "La Liga", "Santiago Bernabéu", 93, "Zinedine Zidane",
					null);
			clubRepository.save(club2);

			Footballer player1 = new Footballer(null, "Lionel", "Messi", FootballerRoleEnum.ST,
					FootballerAttributesEnum.SHO, 93.0f, 34, 25000000, 1.70f, "Argentina", club1);
			footballerRepository.save(player1);

			Footballer player2 = new Footballer(null, "Cristiano", "Ronaldo", FootballerRoleEnum.ST,
					FootballerAttributesEnum.PAC, 92.0f, 36, 30000000, 1.87f, "Portugal", club2);
			footballerRepository.save(player2);

			Footballer player3 = new Footballer(null, "Neymar", "Jr.", FootballerRoleEnum.CF,
					FootballerAttributesEnum.DRI, 90.0f, 29, 20000000, 1.75f, "Brazil", club2);
			footballerRepository.save(player3);
		};
	}

}
