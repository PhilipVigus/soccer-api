package com.philvigus.soccerapi.dataimports.services;

import java.io.IOException;
import java.util.List;

/** The TextFileImporterService interface. */
public interface TextFileImporterService {
  /**
   * Import a resource file.
   *
   * @param resourceLocation the resource location
   * @return a list of lines of text in the resource
   * @throws IOException thrown if the resource could not be imported
   */
  List<String> importFile(String resourceLocation) throws IOException;
}
