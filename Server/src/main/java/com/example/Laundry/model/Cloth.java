package com.example.Laundry.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="Clothing")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Cloth {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String size;
    private String color;
    private String status;
    @CreationTimestamp
    private LocalDateTime created_timestamp;
    @UpdateTimestamp
    private LocalDateTime updated_timestamp;
}
