package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.domain.Unit;
import de.cw.cwcocktailapi.repository.UnitRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

  private final UnitRepository unitRepository;

  public UnitService(UnitRepository unitRepository) {
    this.unitRepository = unitRepository;
  }

  public List<Unit> units() {
    return unitRepository.findAll();
  }

}
