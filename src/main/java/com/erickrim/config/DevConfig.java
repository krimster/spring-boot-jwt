package com.erickrim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by krime on 3/15/17.
 */
@Configuration
@PropertySource("file:///${user.home}/.springbootjwt/application-dev.properties")
@Profile("dev")
public class DevConfig {
}
