package com.example.tsid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
class DemoTsidHibernateTest {

  @Inject
  EmbeddedApplication<?> mApplication;

  @Test
  void testItWorks() {
    Assertions.assertTrue(mApplication.isRunning());
  }

}
