package learn.java.spring.demo.services;

import java.util.List;
import java.util.Optional;

import learn.java.spring.demo.models.Note;
import learn.java.spring.demo.requests.NoteRequest;

public interface NoteService {
    Note createNote(NoteRequest request);
    List<Note> getAllNotes();
    Optional<Note> getNoteById(Long id);
    Note updateNote(Long id, Note updatedNote);
    void deleteNote(Long id);
}
