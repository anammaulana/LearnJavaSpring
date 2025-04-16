package learn.java.spring.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.java.spring.demo.models.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
