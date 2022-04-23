package com.philvigus.soccerapi.domain.services;

import com.philvigus.soccerapi.domain.entities.Name;
import com.philvigus.soccerapi.domain.repositories.NameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("Name Service Test")
class NameServiceImplTest {
  NameServiceImpl nameService;

  @Mock NameRepository nameRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    nameService = new NameServiceImpl(nameRepository);
  }

  @Test
  @DisplayName("save should call save on the service repository")
  void saveShouldCallRepositorySave() {
    final Name name = new Name();
    name.setContent("test content");

    nameService.save(name);

    verify(nameRepository, times(1)).save(name);
  }
}
