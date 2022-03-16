package com.skillTracker.profile.repository;

import com.skillTracker.profile.entity.EngineerProfile;
import com.skillTracker.profile.repository.customRepository.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineerProfileRepository extends JpaRepository<EngineerProfile, Long>, CustomRepository {
  @Query(value = "SELECT u FROM EngineerProfile u WHERE  u.associateId=?1 AND u.name=?2")
  EngineerProfile getByNameAndId(String associateId, String name);

  @Query(value = "SELECT u FROM EngineerProfile u WHERE u.associateId=?1")
  EngineerProfile findByAssociateId(String associateId);

//  @Query(value = "SELECT e FROM EngineerProfile e JOIN TechnicalSkills t ON e.technicalSkills=t.id WHERE t.aws>=10 AND e.name LIKE %?1% ")
//  List<EngineerProfile> searchFilterTechnical( String name, String associateId, String skill);
//
//  @Query(value = "SELECT e FROM EngineerProfile e JOIN NonTechnicalSkills t ON e.nonTechnicalSkills=t.id WHERE t.communication>=10  ")
//  List<EngineerProfile> searchFilterNonTechnical( String name, String skill);
}
