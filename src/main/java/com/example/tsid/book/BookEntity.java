package com.example.tsid.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import io.micronaut.core.annotation.Introspected;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "description" }))
@Introspected
public class BookEntity {

  @Id
  @GeneratedValue(generator = "tsid")
  @GenericGenerator(name = "tsid", strategy = "io.hypersistence.utils.hibernate.id.TsidGenerator")
  private Long id;

  @NotEmpty(message = "can not be empty")
  @Size(min = 1, max = 255)
  @Column(nullable = false, length = 255)
  private String description;

  public BookEntity() {
  }

  public BookEntity(String description) {
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
