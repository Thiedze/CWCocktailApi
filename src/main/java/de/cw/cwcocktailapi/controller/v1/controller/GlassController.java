package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.controller.v1.api.GlassesApi;
import de.cw.cwcocktailapi.controller.v1.model.GlassDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class GlassController implements GlassesApi {

  @Override
  public ResponseEntity<List<GlassDto>> glasses() {
    return null;
  }

}
