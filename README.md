
---

```md
# 📝 Notes App API with Spring Boot + PostgreSQL

Notes App ini adalah RESTful API yang dibuat menggunakan Java Spring Boot. Aplikasi ini digunakan untuk menyimpan, melihat, mengedit, dan menghapus catatan secara efisien. Data disimpan dalam database PostgreSQL.

---

## 🚀 Tech Stack

- ✅ Java 17+
- ✅ Spring Boot
- ✅ Spring Web
- ✅ Spring Data JPA
- ✅ PostgreSQL
- ✅ Bean Validation (Jakarta)
- ✅ Maven

---

## 📚 Fitur yang Sudah Dipelajari & Diimplementasikan

### ✅ 1. Struktur Dasar Spring Boot
- Konfigurasi project dengan `spring-boot-starter-*`
- Struktur folder sesuai best practice

### ✅ 2. CRUD dengan Spring Data JPA
- `@Entity`, `@Repository`, `@Service`, dan `@RestController`
- Menggunakan interface `JpaRepository`

### ✅ 3. DTO & Request Validation
- DTO dengan anotasi `@NotBlank`, `@Valid`
- Custom response wrapper (`ApiResponse<T>`)

### ✅ 4. Error Handling
- Global Exception Handler menggunakan `@ControllerAdvice`
- Custom Exception: `ResourceNotFoundException`

### ✅ 5. ResponseEntity & Status Code
- Penggunaan `ResponseEntity` untuk pengaturan status HTTP
- Status: `200 OK`, `201 CREATED`, `202 ACCEPTED`, `400 BAD REQUEST`, `404 NOT FOUND`

### ✅ 6. Logging SQL Query
- Hibernate auto SQL log saat insert/select

---

## 📁 API Endpoints

| Method | Endpoint           | Fungsi                         |
|--------|--------------------|-------------------------------|
| GET    | `/api/notes`       | Ambil semua note              |
| GET    | `/api/notes/{id}`  | Ambil note berdasarkan ID     |
| POST   | `/api/notes`       | Tambahkan note baru           |
| PUT    | `/api/notes/{id}`  | Edit note                     |
| DELETE | `/api/notes/{id}`  | Hapus note berdasarkan ID     |

---

## 🔖 Contoh Request JSON

### ➕ POST: Tambah Note

```json
{
  "title": "Belajar Spring Boot",
  "content": "Spring Boot itu powerful!"
}
```

---

## 📤 Contoh Response JSON

```json
{
  "success": true,
  "message": "Note berhasil ditambahkan",
  "data": {
    "id": 1,
    "title": "Belajar Spring Boot",
    "content": "Spring Boot itu powerful!",
    "createdAt": "2025-04-16T08:30:00"
  }
}
```

---

## 🛠️ Setup & Jalankan Project

1. Clone repo ini:
```bash
git clone https://github.com/username/notes-app-springboot.git
cd notes-app-springboot
```

2. Setup PostgreSQL dan buat database:
```sql
CREATE DATABASE notesdb;
```

3. Ubah `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/notesdb
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

4. Jalankan:
```bash
./mvnw spring-boot:run
```

---

## 📌 TODO Selanjutnya

- [ ] Integrasi JWT Authentication
- [ ] Dokumentasi Swagger
- [ ] Pagination dan Sorting
- [ ] Upload gambar/file
- [ ] Filter notes berdasarkan keyword

---

## ✍️ Author

> **Anam Maulana**  
> Spring Boot learner & backend enthusiast 🚀  
> [GitHub](https://github.com/anammaulana) | [LinkedIn](https://linkedin.com/in/anammaulana)

---

## ⚡ License

MIT License – bebas digunakan untuk belajar dan pengembangan.

```

Kalau kamu udah punya repo GitHub, aku bisa bantuin upload via panduan Git atau kasih commit message yang cocok. Mau? 😄
