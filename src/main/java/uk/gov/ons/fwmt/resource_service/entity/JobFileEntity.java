package uk.gov.ons.fwmt.resource_service.entity;

import lombok.Data;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Arrays;

@Data
@Entity
@Table(name = "input_file")
public class JobFileEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private byte[] file;

  @Column(nullable = false)
  private String filename;

  @Column(name = "file_timestamp", nullable = false)
  @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
  private LocalDateTime fileTime;

  @Column(name = "received_timestamp", nullable = false)
  @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
  private LocalDateTime fileReceivedTime;

  @Column(nullable = false)
  private boolean validated;

  /**
   * Getter and Setter to fix findBug issue with Mutable object.
   */
  public byte[] getFile() {
    final byte[] fileContents = Arrays.copyOf(file, file.length);
    return fileContents;
  }

  public void setFile(byte[] file) {
    final byte[] fileContents = Arrays.copyOf(file, file.length);
    this.file = fileContents;
  }
}
