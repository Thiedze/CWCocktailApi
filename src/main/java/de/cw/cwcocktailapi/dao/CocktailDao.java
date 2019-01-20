package de.cw.cwcocktailapi.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.cw.cwcocktailapi.domain.Cocktail;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CocktailDao {

  private static final String PATH = "cocktail";

  private static final String FILENAME = "cocktail.json";

  @Value("${git.data.url}")
  private String url;

  public List<Cocktail> getCocktails() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<List<Cocktail>> typeReference = new TypeReference<List<Cocktail>>() {
    };
    return mapper.readValue(new URL(url + "/" + PATH + "/" + FILENAME), typeReference);

  }

}
