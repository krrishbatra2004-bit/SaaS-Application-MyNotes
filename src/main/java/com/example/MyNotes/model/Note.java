package com.example.MyNotes.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    private Tenant tenant;
    @ManyToOne
    private User user;
}

