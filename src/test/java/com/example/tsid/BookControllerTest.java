package com.example.tsid;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.tsid.book.BookController;
import com.example.tsid.book.BookDto;
import com.example.tsid.book.BookRepository;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class BookControllerTest {

  private static final Logger sLogger = LoggerFactory.getLogger(BookControllerTest.class);

  @Inject
  BookController mBookController;

  @Inject
  BookRepository mBookRepository;

  @Test
  void testCreateBook() {
    Long id = mBookController.add(new BookDto("1", "my book"));
    sLogger.info("id: {}", id);
    assertThat(id).isNotNull();

    Long id2 = mBookController.add(new BookDto("1", "your book"));
    sLogger.info("id2: {}", id2);
    assertThat(id2).isNotNull();
  }

  @Test
  void testUpdateBook() {
    // given a created book
    Long id = mBookController.add(new BookDto("my book"));

    // when updating the book's description
    String newDescription = "my book is updated";
    mBookController.update(id, new BookDto(id.toString(), newDescription));

    // then the updates shall be saved to the DB
    Optional<BookDto> book = mBookRepository.retrieveById(id);
    book.ifPresentOrElse(t -> assertThat(t.getDescription()).isEqualTo(newDescription),
        () -> fail("book with id '" + id + "' could not be found"));

  }
}
