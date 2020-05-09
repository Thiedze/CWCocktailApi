package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.controller.v1.dto.SearchResponseDto;
import java.util.Objects;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ImageService {

  public String getUrl(String searchQuery) {
    RestTemplate restTemplate = new RestTemplate();
    String url =
        "https://api.qwant.com/api/search/images?count=1&t=images&safesearch=1&locale=en_US&uiv=4&q=" + searchQuery;
    ResponseEntity<SearchResponseDto> response = restTemplate.getForEntity(url, SearchResponseDto.class);
    return Objects.requireNonNull(response.getBody()).getData().getResult().getItems().get(0).getMedia();
  }

}
