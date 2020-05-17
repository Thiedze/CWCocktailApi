package de.cw.cwcocktailapi.repository;

import de.cw.cwcocktailapi.domain.Unit;
import de.cw.cwcocktailapi.domain.UnitType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

  Optional<Unit> findByType(UnitType type);

}
