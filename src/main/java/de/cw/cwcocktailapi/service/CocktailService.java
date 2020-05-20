package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.domain.Cocktail;
import de.cw.cwcocktailapi.domain.CocktailSearch;
import de.cw.cwcocktailapi.repository.CocktailRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CocktailService {

  private final CocktailRepository cocktailRepository;

  public CocktailService(CocktailRepository cocktailRepository) {
    this.cocktailRepository = cocktailRepository;
  }

  public List<Cocktail> cocktails(CocktailSearch cocktailSearch) {
    return null;
  }

}
