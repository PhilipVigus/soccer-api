package com.philvigus.soccerapi.dataimports.services;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public interface CsvFileImporterService {
  CSVReaderHeaderAware importFile(String fileLocation) throws IOException, CsvValidationException;
}
