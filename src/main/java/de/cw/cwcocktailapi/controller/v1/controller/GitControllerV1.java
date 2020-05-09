package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.service.GitService;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1", method = RequestMethod.GET)
public class GitControllerV1 {

  private final GitService gitService;

  public GitControllerV1(GitService gitService) {
    this.gitService = gitService;
  }

  @RequestMapping(value = "/save")
  public void save() throws IOException {
    gitService.saveToDatabase();
  }

}
