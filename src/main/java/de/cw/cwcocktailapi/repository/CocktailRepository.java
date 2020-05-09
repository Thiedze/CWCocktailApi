package de.cw.cwcocktailapi.repository;

import de.cw.cwcocktailapi.domain.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

}
