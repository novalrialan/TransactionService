package com.transaction.dev.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Validation
 */
@Configuration
public class ValidationConfig {

    @Bean   
    public ValidatingMongoEventListener validationListener(){
        return new ValidatingMongoEventListener(validator());
    }

    @Bean
    public LocalValidatorFactoryBean validator(){
    return new LocalValidatorFactoryBean();
    }
}