package com.erickrim.repositories;

import com.erickrim.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by krime on 3/15/17.
 */
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
