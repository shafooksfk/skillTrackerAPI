package com.skillTracker.profile.controller;

import com.skillTracker.profile.model.AdminSearchFilter;
import com.skillTracker.profile.model.Response;
import com.skillTracker.profile.service.EngineerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skilltracker/api/v1/admin")
public class AdminController {
  @Autowired private EngineerProfileService engineerProfileService;

  @PostMapping("/search")
  public Response adminSearch(@RequestBody AdminSearchFilter adminSearchFilter) {
    Response res = new Response();
    res = engineerProfileService.searchByFilter( adminSearchFilter);
    return res;
  }
}
