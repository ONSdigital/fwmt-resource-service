package uk.gov.ons.fwmt.resource_service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tm_users")
public class TMUserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(nullable = false)
  public String authNo;

  @Column
  public String tmUsername;

  @Column(nullable = false)
  public boolean active;

  // if this is set, it means that jobs designated for altAuthNo should be redirected to this user
  @Column
  public String alternateAuthNo;
}
