package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.domain.Glass;
import de.cw.cwcocktailapi.repository.GlassRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GlassService {

  private final GlassRepository glassRepository;

  public GlassService(GlassRepository glassRepository) {
    this.glassRepository = glassRepository;
  }

  public List<Glass> glasses() {
    return glassRepository.findAll();
  }

}
