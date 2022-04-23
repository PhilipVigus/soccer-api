package com.philvigus.soccerapi.dataimports.services;

import com.opencsv.CSVReaderHeaderAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class CsvFileImporterServiceImpl implements CsvFileImporterService {
  @Override
  public CSVReaderHeaderAware importFile(String fileLocation) throws IOException {
    final File file = new ClassPathResource(fileLocation).getFile();
    FileReader reader = new FileReader(file);

    return new CSVReaderHeaderAware(reader);
  }
}
