package com.graphql.soccerDetails;

import com.graphql.soccerDetails.model.FootballerStats;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.graphql.soccerDetails.constant.FootballerRoleEnum;
import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.Footballer;
import com.graphql.soccerDetails.repository.ClubRepository;
import com.graphql.soccerDetails.repository.FootballerRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SoccerDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerDetailsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(FootballerRepository footballerRepository, ClubRepository clubRepository) {
		return args -> {
			Footballer footballer1 = new Footballer("Lionel", "Messi", new Club("Paris Saint-Germain", "Parc des Princes", "Ligue 1"));
			footballer1.setAge(34);
			footballer1.setHeight(1.70f);
			footballer1.setNationality("Argentina");
			footballer1.setRole(FootballerRoleEnum.RW);
			FootballerStats stats1 = new FootballerStats(95, 95, 95, 96, 39, 66);
			footballer1.setStats(stats1);
			footballer1.setScore(stats1);

			Footballer footballer2 = new Footballer("Cristiano", "Ronaldo", new Club("Manchester United", "Old Trafford", "Premier League"));
			footballer2.setAge(37);
			footballer2.setHeight(1.87f);
			footballer2.setNationality("Portugal");
			footballer2.setRole(FootballerRoleEnum.ST);
			FootballerStats stats2 = new FootballerStats(88, 99, 85, 89, 34, 81);
			footballer2.setStats(stats2);
			footballer2.setScore(stats2);
		};
	}
}
