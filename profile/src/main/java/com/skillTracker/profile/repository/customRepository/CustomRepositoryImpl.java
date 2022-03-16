package com.skillTracker.profile.repository.customRepository;

import com.skillTracker.profile.entity.EngineerProfile;
import com.skillTracker.profile.entity.TechnicalSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class CustomRepositoryImpl implements CustomRepository{

    private final EntityManager em;

    public CustomRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Autowired
    public CustomRepositoryImpl(JpaContext context){
        this.em=context.getEntityManagerByManagedType(EngineerProfile.class);
    }

    @Override
    public List<EngineerProfile> searchFilterTechnical(String name, String skill) {
        return (List<EngineerProfile>) em.createQuery("SELECT e FROM EngineerProfile e JOIN TechnicalSkills t ON e.technicalSkills=t.id WHERE t."+skill+">=10 AND e.name LIKE '%"+name+"%' ORDER BY t."+skill+" DESC" ).getResultList();
    }

    @Override
    public List<EngineerProfile> searchFilterNonTechnical(String name, String skill) {
        return (List<EngineerProfile>) em.createQuery("SELECT e FROM EngineerProfile e JOIN NonTechnicalSkills t ON e.nonTechnicalSkills=t.id WHERE t."+skill+">=10 AND e.name LIKE '%"+name+"%'" ).getResultList();
    }
}
