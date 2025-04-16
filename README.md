Mantap bro! Ini dia **rangkuman lengkap pembelajaran Spring Boot** yang udah kamu pelajari, lengkap dengan fitur dan penjelasan singkatnya—cocok banget buat dokumentasi di GitHub 💻🔥

---

## 📘 Spring Boot Notes App – Belajar Step by Step

### 🚀 Tech Stack
- **Java 17+**
- **Spring Boot**
- **PostgreSQL**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **Lombok** *(optional)*
- **Validation (Jakarta Bean Validation)*
- **Postman** / Insomnia untuk API testing

---

### ✅ Fitur & Materi yang Sudah Dipelajari

#### 📁 Struktur Dasar Project
- Struktur folder MVC (Model, Controller, Service, Repository, DTO)
- Penggunaan `@RestController`, `@Service`, `@Repository`, `@Autowired`

---

#### 📝 CRUD Endpoint untuk `Note`

| Method | Endpoint       | Fungsi                      |
|--------|----------------|-----------------------------|
| GET    | `/api/notes`   | Menampilkan semua notes     |
| GET    | `/api/notes/{id}` | Menampilkan note by ID   |
| POST   | `/api/notes`   | Menambahkan note baru       |
| PUT    | `/api/notes/{id}` | Mengedit note by ID      |
| DELETE | `/api/notes/{id}` | Menghapus note by ID     |

---

#### 📦 Entity `Note`
```java
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
```

---

#### 📤 DTO / Request Object

- Menggunakan `NoteRequest` untuk memisahkan input dari entity
```java
public class NoteRequest {
    @NotBlank(message = "Judul tidak boleh kosong")
    private String title;

    @NotBlank(message = "Konten tidak boleh kosong")
    private String content;
}
```

---

#### ✅ Response Wrapper (Generic)
```java
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
}
```

---

#### 📡 Service Layer (Business Logic)
- Interface `NoteService`
- Implementasi: `NoteServiceImpl`
- Menangani logika `createNote`, `getAllNotes`, `getNoteById`, dst.

---

#### 🔁 Repository Layer
- Menggunakan `JpaRepository`
```java
public interface NoteRepository extends JpaRepository<Note, Long> {
}
```

---

#### ⚠️ Exception Handling

- Global Exception Handling dengan `@ControllerAdvice`
- Handling:
  - `ResourceNotFoundException`
  - `MethodArgumentNotValidException` (validasi input)
```java
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ApiResponse<Object>> handleValidationErrors(...) {
   ...
}
```

---

#### 📦 Dependency Injection
- Menggunakan `@Autowired` untuk inject repository dan service

---

#### 🌐 Testing Endpoint dengan Postman
- Mengirim request JSON untuk test:
```json
{
  "title": "Belajar Spring",
  "content": "Spring itu keren!"
}
```

---

### 📄 Contoh JSON Response
```json
{
  "success": true,
  "message": "Note berhasil dibuat",
  "data": {
    "id": 1,
    "title": "Judul",
    "content": "Konten",
    "createdAt": "2025-04-16T08:30:00"
  }
}
```

---

## 📁 Struktur Folder Project
```
src/
 └── main/
     └── java/
         └── learn/java/spring/demo/
             ├── controllers/
             ├── services/
             │   └── impl/
             ├── models/
             ├── repository/
             ├── requests/
             ├── responses/
             └── exceptions/
```

---

Kalau kamu upload ke GitHub, bisa bikin file `README.md` berisi ringkasan ini + cara run project:

### ✅ Cara Run Aplikasi

./mvnw spring-boot:run


Kalau kamu mau aku bantuin buatin `README.md` full atau dokumentasi API Swagger, tinggal bilang aja bro! Mau lanjut ke testing, auth JWT, atau pagination juga bisa 💪
