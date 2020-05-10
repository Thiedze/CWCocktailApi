package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.controller.v1.dto.SearchItemDto;
import de.cw.cwcocktailapi.controller.v1.dto.SearchResponseDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ImageService {

  public List<String> getUrls(String searchQuery) {
    RestTemplate restTemplate = new RestTemplate();
    String url =
        "https://api.qwant.com/api/search/images?count=20&t=images&safesearch=1&locale=en_US&uiv=4&q=" + searchQuery;
    List<String> imageUrls = new ArrayList<>();
    try {
      ResponseEntity<SearchResponseDto> response = restTemplate.getForEntity(url, SearchResponseDto.class);
      imageUrls = Objects.requireNonNull(response.getBody()).getData().getResult().getItems().stream()
          .map(SearchItemDto::getMedia).collect(Collectors.toList());
    } catch (Exception exception) {
      return imageUrls;
    }
    return imageUrls;
  }

}
