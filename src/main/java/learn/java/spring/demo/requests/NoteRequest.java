package learn.java.spring.demo.requests;

import jakarta.validation.constraints.NotBlank;

public class NoteRequest {
    
    @NotBlank(message = "Judul tidak boleh kosong")
    private String title;

    @NotBlank(message = "Konten tidak boleh kosong")
    private String content;

    // Getter & Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}