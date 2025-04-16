package learn.java.spring.demo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import learn.java.spring.demo.handlers.NotFoundException;
import learn.java.spring.demo.models.Note;
import learn.java.spring.demo.repository.NoteRepository;
import learn.java.spring.demo.requests.NoteRequest;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note createNote(NoteRequest request) {
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setCreatedAt(LocalDateTime.now());
        return noteRepository.save(note);
    }

    @Override
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note updateNote(Long id, NoteRequest request) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Note dengan id " + id + " tidak ditemukan"));

        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setCreatedAt(LocalDateTime.now()); // atau pakai field updatedAt kalau punya

        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Note dengan id " + id + " tidak ditemukan"));
    
        noteRepository.delete(note);
    }
}
