package com.qa.test.config;

import com.google.inject.AbstractModule;
import com.qa.test.implementation.Registration;

public class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Registration.class);
    }
}
