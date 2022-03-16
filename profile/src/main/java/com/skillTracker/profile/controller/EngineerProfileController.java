package com.skillTracker.profile.controller;

import com.skillTracker.profile.entity.EngineerProfile;
import com.skillTracker.profile.model.Response;
import com.skillTracker.profile.model.SearchProfile;
import com.skillTracker.profile.service.EngineerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("skilltracker/api/v1/engineer")
public class EngineerProfileController {
  @Autowired private EngineerProfileService engineerService;

  @PostMapping("/add-profile")
  public EngineerProfile addProfile(@RequestBody EngineerProfile engineerProfile) {
    engineerService.addProfile(engineerProfile);
    return engineerProfile;
  }

  @GetMapping("/get-all")
  public List<EngineerProfile> getProfile() {
    List<EngineerProfile> engineerProfile = new ArrayList<EngineerProfile>();
    engineerProfile = engineerService.getAll();
    return engineerProfile;
  }

  @PutMapping("/update-profile/{userId}")
  public EngineerProfile updateProfile(@RequestBody EngineerProfile engineerProfile) throws ParseException {
    return engineerService.updateProfile(engineerProfile);
  }

  @GetMapping("/profile/{userId}")
  public Optional<EngineerProfile> getById(@PathVariable Long userId) {
    return engineerService.getById(userId);
  }

  @PostMapping("/search-profile")
  public Response searchProfileByName(@RequestBody SearchProfile obj) throws ParseException {
    return engineerService.searchByName(obj);
  }

  @PostMapping("/search-associate-id")
  public Boolean searchByAssociateId(@RequestParam String associateId){
    return engineerService.searchByAssociateId(associateId);
  }
}
