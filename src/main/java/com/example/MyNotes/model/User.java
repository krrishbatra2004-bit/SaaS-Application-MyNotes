package com.example.MyNotes.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @ManyToOne
    private Tenant tenant;
}

