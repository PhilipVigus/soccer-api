package com.philvigus.soccerapi.api;

import com.philvigus.soccerapi.domain.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.philvigus.soccerapi"})
@EntityScan("com.philvigus.soccerapi.domain.entities")
@EnableJpaRepositories(basePackages = {"com.philvigus.soccerapi.domain.repositories"})
public class ApiApplication {
  @Autowired TeamService teamService;

  public static void main(String[] args) {
    SpringApplication.run(ApiApplication.class, args);
  }
}
