package com.example.tsid;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class DemoTsidHibernateTest {

  @Inject
  EmbeddedApplication<?> mApplication;

  @Test
  void testItWorks() {
    Assertions.assertTrue(mApplication.isRunning());
  }

}
