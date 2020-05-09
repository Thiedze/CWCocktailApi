package de.cw.cwcocktailapi.repository;

import de.cw.cwcocktailapi.domain.MakingStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakingStepRepository extends JpaRepository<MakingStep, Long> {

}
