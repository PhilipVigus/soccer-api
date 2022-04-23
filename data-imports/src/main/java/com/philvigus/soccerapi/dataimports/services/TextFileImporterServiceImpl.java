package com.philvigus.soccerapi.dataimports.services;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/** An implementation of the TextFileImporterService interface. */
@Service
public class TextFileImporterServiceImpl implements TextFileImporterService {
  @Override
  public List<String> importFile(final String resourceLocation) throws IOException {
    final File data = new ClassPathResource(resourceLocation).getFile();

    return Files.readAllLines(data.toPath());
  }
}
