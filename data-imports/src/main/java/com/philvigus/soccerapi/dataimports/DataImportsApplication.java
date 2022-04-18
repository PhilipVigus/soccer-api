package com.philvigus.soccerapi.dataimports;

import com.philvigus.soccerapi.dataimports.services.TeamImporterService;
import com.philvigus.soccerapi.dataimports.services.TextFileImporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.philvigus.soccerapi"})
@EntityScan("com.philvigus.soccerapi.domain.entities")
@EnableJpaRepositories(basePackages = {"com.philvigus.soccerapi.domain.repositories"})
@PropertySource("classpath:db-local.properties")
@Profile("!test")
public class DataImportsApplication implements CommandLineRunner {
  @Autowired TextFileImporterService textFileImporterService;
  @Autowired TeamImporterService teamImporterService;

  public static void main(final String[] args) {
    SpringApplication.run(DataImportsApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<String> data =
        textFileImporterService.importFile("data/rsss/england/divisional-movements.txt");
    teamImporterService.importTeams(data);
  }
}
