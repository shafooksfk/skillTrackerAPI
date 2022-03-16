package com.skillTracker.profile.service;

import com.skillTracker.profile.entity.EngineerProfile;
import com.skillTracker.profile.model.AdminSearchFilter;
import com.skillTracker.profile.model.Response;
import com.skillTracker.profile.model.SearchProfile;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface EngineerProfileService {
    EngineerProfile addProfile(EngineerProfile engineerProfile);

    List<EngineerProfile> getAll();

    EngineerProfile updateProfile(EngineerProfile engineerProfile) throws ParseException;

    Optional<EngineerProfile> getById(Long userId);

    Response searchByName(SearchProfile obj) throws ParseException;

    Response searchByFilter(AdminSearchFilter adminSearchFilter);

    Boolean searchByAssociateId(String associateId);
}
