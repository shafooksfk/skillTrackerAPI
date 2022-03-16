package com.skillTracker.profile.service;

import com.skillTracker.profile.entity.EngineerProfile;
import com.skillTracker.profile.model.AdminSearchFilter;
import com.skillTracker.profile.model.Response;
import com.skillTracker.profile.model.SearchProfile;
import com.skillTracker.profile.repository.EngineerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class EngineerProfileServiceImpl implements EngineerProfileService {
  @Autowired private EngineerProfileRepository engineerProfileRepository;

  private boolean checkDate(Date date) throws ParseException {
    Boolean rtnVal = false;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String tDate = sdf.format(date);
    date = sdf.parse(sdf.format(date));
    Date currentDate = new Date();
    currentDate = sdf.parse(sdf.format(currentDate));

    long diff = currentDate.getTime() - date.getTime();

    TimeUnit time = TimeUnit.DAYS;
    long difference = time.convert(diff, TimeUnit.MILLISECONDS);
    if (difference >= 0 && difference <= 10) {
      rtnVal = false;
    } else {
      rtnVal = true;
    }
    return rtnVal;
  }

  @Override
  public EngineerProfile addProfile(EngineerProfile engineerProfile) {
    Date date = new Date();
    engineerProfile.setCreatedDate(date);
    engineerProfile.setModifiedDate(date);
    engineerProfileRepository.save(engineerProfile);
    return engineerProfile;
  }

  @Override
  public List<EngineerProfile> getAll() {
    List<EngineerProfile> engineerProfile = new ArrayList<EngineerProfile>();
    engineerProfile = engineerProfileRepository.findAll();
    return engineerProfile;
  }

  @Override
  public Optional<EngineerProfile> getById(Long userId) {
    Optional<EngineerProfile> engineerProfile = Optional.empty();
    engineerProfile = engineerProfileRepository.findById(userId);
    if (engineerProfile.isPresent()) {
      return engineerProfile;
    } else {
      return null;
    }
  }

  @Override
  public EngineerProfile updateProfile(EngineerProfile engineerProfile) throws ParseException {
    EngineerProfile data = null;
     EngineerProfile engineerProfile1 = new EngineerProfile();
    engineerProfile1 = engineerProfileRepository.findById(engineerProfile.getId()).get();
    if (engineerProfile1 != null) {
      if (engineerProfile1.getEmail().equals(engineerProfile.email)
          && engineerProfile1.getAssociateId().equals(engineerProfile.associateId)
          && engineerProfile1.getName().equals(engineerProfile.name)
          && engineerProfile1.getPhoneNumber().equals(engineerProfile.phoneNumber)) {
        Date date = new Date();
        engineerProfile.setModifiedDate(date);
        data = engineerProfileRepository.save(engineerProfile);
      }
    }
    return data;
  }

  @Override
  public Response searchByName(SearchProfile obj) throws ParseException {
    Response res = new Response();
    EngineerProfile engineerProfile = new EngineerProfile();
    engineerProfile = engineerProfileRepository.getByNameAndId(obj.associateId, obj.name);
    if (engineerProfile != null) {
      if (checkDate(engineerProfile.getModifiedDate())) {
        res.setMessage("Successfully Fetched data");
        res.setStatus("SUCCESS");
        res.setData(engineerProfile);
      } else {
        res.setMessage("Updated less than 10 days ago");
      }
    } else {
      res.setMessage("Invalid Username or Associate Id");
    }
    return res;
  }

  @Override
  public Response searchByFilter(AdminSearchFilter adminSearchFilter) {
    Response res = new Response();
    List<EngineerProfile> engineerProfiles = new ArrayList<EngineerProfile>();
    if (adminSearchFilter.getSkillCategory().equals("technicalSkills")) {
      engineerProfiles =
          engineerProfileRepository.searchFilterTechnical(
              adminSearchFilter.getName(), adminSearchFilter.getSkill());
      res.setListData(engineerProfiles);
      if (!engineerProfiles.isEmpty()) {
        res.setMessage("Successfully Fetched Data ");
        res.setStatus("SUCCESS");
      } else {
        res.setMessage("No Results Found");
        res.setStatus("FAILED");
      }
    } else {
      if (adminSearchFilter.getSkillCategory().equals("nonTechnicalSkills")) {
        engineerProfiles =
            engineerProfileRepository.searchFilterNonTechnical(
                adminSearchFilter.getName(), adminSearchFilter.getSkill());
        if (!engineerProfiles.isEmpty()) {
          res.setMessage("Successfully Fetched Data ");
          res.setStatus("SUCCESS");
          res.setListData(engineerProfiles);
        } else {
          res.setMessage("No Profiles Found");
          res.setStatus("FAILED");
        }
      }
    }
    return res;
  }

  @Override
  public Boolean searchByAssociateId(String associateId) {
    EngineerProfile engineerProfile = new EngineerProfile();
    engineerProfile = engineerProfileRepository.findByAssociateId(associateId);
    if (engineerProfile != null) return true;
    else return false;
  }
}
