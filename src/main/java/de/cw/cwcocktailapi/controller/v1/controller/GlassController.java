package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.controller.v1.api.GlassesApi;
import de.cw.cwcocktailapi.controller.v1.mapper.GlassMapper;
import de.cw.cwcocktailapi.controller.v1.model.GlassDto;
import de.cw.cwcocktailapi.service.GlassService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class GlassController implements GlassesApi {

  private final GlassService glassService;

  public GlassController(GlassService glassService) {
    this.glassService = glassService;
  }

  @Override
  public ResponseEntity<List<GlassDto>> glasses() {
    List<GlassDto> glasses = GlassMapper.MAPPER.convert(glassService.glasses());
    return new ResponseEntity<>(glasses, HttpStatus.OK);
  }

}
