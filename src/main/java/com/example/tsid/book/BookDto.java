package com.example.tsid.book;

import io.micronaut.core.annotation.Introspected;

// add @Introspected to avoid use of reflection
@Introspected
public class BookDto {

  private String mId;
  private String mDescription;

  public BookDto() {
  }

  public BookDto(String description) {
    super();
    mDescription = description;
  }

  public BookDto(String id, String description) {
    super();
    mId = id;
    mDescription = description;
  }

  public void setId(String id) {
    mId = id;
  }

  public String getId() {
    return mId;
  }

  public void setDescription(String description) {
    mDescription = description;
  }

  public String getDescription() {
    return mDescription;
  }

}
