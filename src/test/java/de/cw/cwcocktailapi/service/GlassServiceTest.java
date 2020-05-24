package de.cw.cwcocktailapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import de.cw.cwcocktailapi.domain.Glass;
import de.cw.cwcocktailapi.domain.GlassType;
import de.cw.cwcocktailapi.repository.GlassRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class GlassServiceTest {

  private GlassService glassService;

  @Mock
  private GlassRepository glassRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    glassService = new GlassService(glassRepository);

    List<Glass> glasses = new ArrayList<>();
    glasses.add(createGlas(1L, GlassType.HIGHBALL));
    glasses.add(createGlas(2L, GlassType.COUPE));
    when(glassRepository.findAll()).thenReturn(glasses);
  }

  private Glass createGlas(Long id, GlassType glassType) {
    Glass glass = new Glass();
    glass.setId(id);
    glass.setType(glassType);
    return glass;
  }

  @Test
  void glasses() {
    List<Glass> glasses = glassService.glasses();
    assertEquals(2, glasses.size());
    assertEquals(GlassType.COUPE, glasses.get(1).getType());
  }
}