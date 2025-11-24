package com.example.MyNotes.repository;

import com.example.MyNotes.model.Note;
import com.example.MyNotes.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByTenant(Tenant tenant);
}
