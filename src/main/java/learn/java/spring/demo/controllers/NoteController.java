package learn.java.spring.demo.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import learn.java.spring.demo.handlers.BadRequestException;
import learn.java.spring.demo.handlers.NotFoundException;
import learn.java.spring.demo.models.Note;
import learn.java.spring.demo.requests.NoteRequest;
import learn.java.spring.demo.responses.ApiResponse;
import learn.java.spring.demo.services.NoteService;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Note>> createNote(@Valid @RequestBody NoteRequest request) {
        Note savedNote = noteService.createNote(request);
        ApiResponse<Note> response = new ApiResponse<>(true, "Catatan berhasil di tambahkan", savedNote);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Note>> updateNote(@PathVariable Long id, @Valid @RequestBody NoteRequest updatedNote) {
        Note updateNote = noteService.updateNote(id, updatedNote);
        ApiResponse<Note> response = new ApiResponse<>(true, "Catatan berhasil di-update", updateNote);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<Note>>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        if(notes.isEmpty()){
            throw new NotFoundException("Data Tidak di Temukan");
        }
        ApiResponse<List<Note>> response = new ApiResponse<>(true, "Semua data berhasil diambil", notes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Note>> getNoteById(@PathVariable Long id) {
        if (id <= 0){
            throw new BadRequestException("jangan nol");
        }
        Note note = noteService.getNoteById(id)
                .orElseThrow(() -> new NotFoundException("Note dengan ID " + id + " tidak ditemukan"));
        ApiResponse<Note> response = new ApiResponse<>(true, "Data ditemukan", note);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        ApiResponse<String> response = new ApiResponse<>(true, "Catatan berhasil dihapus", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
