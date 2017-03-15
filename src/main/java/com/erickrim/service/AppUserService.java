package com.erickrim.service;

import com.erickrim.domain.AppUser;
import com.erickrim.repositories.AppUserRepository;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * AppUserService
 * Created by krime on 3/15/17.
 */
@Service
public class AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @PersistenceContext
    EntityManager em;

    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    public long post(AppUser appUser) {
        return appUserRepository.save(appUser).getId();
    }


    public AppUser get(long id) {
        return appUserRepository.findOne(id);
    }

    public AppUser patch(AppUser appUser) {
        return em.merge(appUser);
    }

    public boolean delete(long id) {
        appUserRepository.delete(id);
        return true;
    }

}
