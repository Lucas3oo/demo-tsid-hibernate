package com.example.tsid;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.tsid.book.BookController;
import com.example.tsid.book.BookDto;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class BookControllerTest {

  private static final Logger sLogger = LoggerFactory.getLogger(BookControllerTest.class);

  @Inject
  BookController mBookController;

  @Test
  void testCreateBook() {

    Long id = mBookController.add(new BookDto(1, "my book"));
    sLogger.info("id: {}", id);
    assertThat(id).isNotNull();

    Long id2 = mBookController.add(new BookDto(1, "your book"));
    sLogger.info("id2: {}", id2);
    assertThat(id2).isNotNull();

  }

}
