package com.erickrim.controller;

import com.erickrim.domain.AppUser;
import com.erickrim.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by krime on 3/15/17.
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    AppUserService appUserService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> home() {
        AppUser appUser = appUserService.get(1);
        return ResponseEntity.ok(appUser);
    }
}
