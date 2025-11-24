package com.example.MyNotes.service;
import com.example.MyNotes.model.Note;
import com.example.MyNotes.model.Tenant;
import com.example.MyNotes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteService {
    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public List<Note> getNotesByTenant(Tenant tenant) {
        return repository.findByTenant(tenant);
    }

    public Note saveNote(Note note) {
        return repository.save(note);
    }

    public Note getNoteById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + id));
    }

    public Note updateNote(Long id, Note updatedNote) {
        Note existing = getNoteById(id);
        existing.setContent(updatedNote.getContent());
        return repository.save(existing);
    }

    public void deleteNoteById(Long id) {
        repository.deleteById(id);
    }
}
