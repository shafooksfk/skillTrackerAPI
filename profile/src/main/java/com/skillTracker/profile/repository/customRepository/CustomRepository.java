package com.skillTracker.profile.repository.customRepository;

import com.skillTracker.profile.entity.EngineerProfile;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomRepository {

    List<EngineerProfile> searchFilterTechnical(String name, String skill);
    List<EngineerProfile> searchFilterNonTechnical( String name, String skill);

}

