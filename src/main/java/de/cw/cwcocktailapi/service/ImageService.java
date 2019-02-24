package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

  @Autowired
  private ImageDao imageDao;

  public String getUrl(String searchQuery) {
    return imageDao.getUrl(searchQuery);
  }

}
