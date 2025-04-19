package io.github.brunotanabe.generic_microservice_accounts.application.entities.schemas;

import io.github.brunotanabe.generic_microservice_accounts.util.listeners.LowerCaseListener;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The Abstract Class GenericSchema.
 * The GenericSchema abstract class is responsible for defining the default basic structure of the entities in the system.
 *
 * @Author Bruno Tanabe
 * @CreatedAt 2025-04-19
 */

/**
 * The type Generic schema.
 */
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, LowerCaseListener.class})
@Data
public abstract class GenericSchema implements Serializable {

    @Column(name = "id", length = 36, updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @Column(name = "created_at", length = 25, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", length = 25)
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(name = "disabled_at", length = 25)
    private LocalDateTime disabledAt;

    private boolean disabled;
}