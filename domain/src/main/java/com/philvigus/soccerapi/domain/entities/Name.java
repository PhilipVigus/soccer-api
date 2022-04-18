package com.philvigus.soccerapi.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

/** Represents a name entity. */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "names")
public class Name {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "used_from")
  private Date usedFrom;

  @Column(name = "used_to")
  private Date usedTo;

  @Column(name = "is_primary", nullable = false)
  private Boolean primary;
}
