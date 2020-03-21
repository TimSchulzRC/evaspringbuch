package de.evaspringbuch.eva04p4howtodi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

  @Autowired
  private SecondShowService secondShowService;

  public ShowService() {
  }

//  @Autowired
//  public ShowService(SecondShowService secondShowService) {
//      this.secondShowService = secondShowService;
//  }

//  @Autowired
//  public void setSecondShowService(SecondShowService secondShowService) {
//      this.secondShowService = secondShowService;
//  }

  public void doSomething() {
      secondShowService.doIt();
  }

}

