package de.cw.cwcocktailapi.repository;

import de.cw.cwcocktailapi.domain.Glass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlassRepository extends JpaRepository<Glass, Long> {

}
