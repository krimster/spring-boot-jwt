package com.erickrim.security.service;

import com.erickrim.domain.AppUser;
import com.erickrim.security.model.SpringSecurityUser;
import com.erickrim.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsServiceImpl
 * Created by krime on 3/15/17.
 */
@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = this.appUserService.loadUserByUsername(username);

        if (appUser == null) {
            throw new UsernameNotFoundException(String.format("No appUser found with username '%s'.", username));
        } else {
            return new SpringSecurityUser(
                    appUser.getId(),
                    appUser.getUsername(),
                    appUser.getPassword(),
                    null,
                    null,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(appUser.getAuthorities())
            );
        }
    }
}
