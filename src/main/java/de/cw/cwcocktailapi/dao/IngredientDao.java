package de.cw.cwcocktailapi.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.cw.cwcocktailapi.domain.Ingredient;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IngredientDao {

  private static final String PATH = "ingredient";

  private static final String FILENAME = "ingredient.json";

  @Value("${git.data.url}")
  private String url;

  public List<Ingredient> getIngredients() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<List<Ingredient>> typeReference = new TypeReference<List<Ingredient>>() {
    };
    return mapper.readValue(new URL(url + "/" + PATH + "/" + FILENAME), typeReference);

  }

}
