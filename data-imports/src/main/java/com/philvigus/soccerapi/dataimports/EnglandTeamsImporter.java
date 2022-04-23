package com.philvigus.soccerapi.dataimports;

import com.opencsv.CSVReaderHeaderAware;
import com.philvigus.soccerapi.dataimports.services.CsvFileImporterService;
import com.philvigus.soccerapi.dataimports.services.TeamImporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.philvigus.soccerapi"})
@EntityScan("com.philvigus.soccerapi.domain.entities")
@EnableJpaRepositories(basePackages = {"com.philvigus.soccerapi.domain.repositories"})
@PropertySource("classpath:db-local.properties")
@Profile("!test")
public class EnglandTeamsImporter implements CommandLineRunner {
  @Autowired TeamImporterService teamImporterService;

  @Autowired CsvFileImporterService csvFileImporterService;

  public static void main(final String[] args) {
    SpringApplication.run(EnglandTeamsImporter.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    try (CSVReaderHeaderAware teams = csvFileImporterService.importFile("data/england/teams.csv")) {
      for (String[] team : teams) {
        teamImporterService.importTeam(team);
      }
    }
  }
}
