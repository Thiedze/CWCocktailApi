package de.cw.cwcocktailapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.cw.cwcocktailapi.domain.Cocktail;
import de.cw.cwcocktailapi.domain.Ingredient;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@DependsOn("dataSource")
public class JsonService {

  @Value("${git.data.url}")
  private String url;

  public List<Cocktail> getCocktails() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<List<Cocktail>> typeReference = new TypeReference<List<Cocktail>>() {
    };
    return mapper.readValue(new URL(url + "/cocktail/cocktail.json"), typeReference);

  }

  public List<Ingredient> getIngredients() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<List<Ingredient>> typeReference = new TypeReference<List<Ingredient>>() {
    };
    return mapper.readValue(new URL(url + "/ingredient/ingredient.json"), typeReference);

  }

  public String getUrl(String searchQuery) {
    /*RestTemplate restTemplate = new RestTemplate();
    String url =
        "https://api.qwant.com/api/search/images?count=1&t=images&safesearch=1&locale=en_US&uiv=4&q=" + searchQuery;
    ResponseEntity<SearchResponseDto> response = restTemplate.getForEntity(url, SearchResponseDto.class);
    return Objects.requireNonNull(response.getBody()).getData().getResult().getItems().get(0).getMedia();*/
    return null;
  }

}
