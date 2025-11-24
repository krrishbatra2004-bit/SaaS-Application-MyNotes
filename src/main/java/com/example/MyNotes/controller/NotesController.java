package com.example.MyNotes.controller;
import com.example.MyNotes.model.Note;
import com.example.MyNotes.model.Tenant;
import com.example.MyNotes.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/notes")
public class NotesController {
    private final NoteService service;
    public NotesController(NoteService service) {
        this.service = service;
    }
    @GetMapping("/{tenantId}")
    public List<Note> getNotes(@PathVariable Long tenantId) {
        Tenant tenant = new Tenant();
        tenant.setId(tenantId);
        return service.getNotesByTenant(tenant);
    }
    @PostMapping("/{tenantId}")
    public Note addNote(@PathVariable Long tenantId, @RequestBody Note note) {
        Tenant tenant = new Tenant();
        tenant.setId(tenantId);
        note.setTenant(tenant);
        return service.saveNote(note);
    }
    @PutMapping("/update/{noteId}")
    public Note updateNote(@PathVariable Long noteId, @RequestBody Note note) {
        return service.updateNote(noteId, note);
    }
    @DeleteMapping("/delete/{noteId}")
    public void deleteNote(@PathVariable Long noteId) {
        service.deleteNoteById(noteId);
    }
}
