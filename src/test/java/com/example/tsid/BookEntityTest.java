package com.example.tsid;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.tsid.book.BookEntity;
import com.example.tsid.book.BookRepository;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class BookEntityTest {

  private static final Logger sLogger = LoggerFactory.getLogger(BookEntityTest.class);

  @Inject
  BookRepository mBookRepository;

  @Test
  void testCreateBook() {
    BookEntity entity = new BookEntity("my book");
    BookEntity saved = mBookRepository.save(entity);

    sLogger.info("{}", saved.getId());

    assertThat(saved.getId()).isNotNull();

  }

}
