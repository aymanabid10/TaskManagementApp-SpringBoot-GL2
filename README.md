# TaskManagementApp-SpringBoot-GL2
# 📝 Task Management App - Spring Boot & React

This is a full-stack Task Management application built with **Spring Boot** (backend REST API) and **React** (frontend), designed as part of the GL2 coursework. It includes CRUD operations, data validation, error handling, and CORS configuration for seamless integration with a frontend.

🔗 **Repository**: [TaskManagementApp-SpringBoot-GL2](https://github.com/aymanabid10/TaskManagementApp-SpringBoot-GL2)

---

## 📂 Project Structure

```
TaskManagementApp/
├── config/
│   ├── CorsConfig.java          # Global CORS configuration
│   └── OpenApiConfig.java       # Swagger/OpenAPI documentation config
├── controller/
│   └── TaskController.java      # REST endpoints for Task API
├── dto/
│   ├── TaskRequestDto.java      # DTO for incoming Task requests
│   └── TaskResponseDto.java     # DTO for Task responses
├── exception/
│   ├── ErrorDetails.java
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
├── mapper/
│   └── TaskMapper.java          # Manual mapping between Entity and DTO
├── model/
│   ├── Priority.java            # Enum: LOW, MEDIUM, HIGH
│   ├── Status.java              # Enum: TODO, IN_PROGRESS, DONE
│   └── Task.java                # JPA Entity
├── repository/
│   └── TaskRepository.java      # JPA Repository
├── service/
│   ├── TaskService.java         # Service Interface
│   └── TaskServiceImpl.java     # Business logic implementation
└── TaskManagementApp.java       # Main Spring Boot Application
```

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/aymanabid10/TaskManagementApp-SpringBoot-GL2.git
cd TaskManagementApp-SpringBoot-GL2
```

---

### 2. Backend Setup (Spring Boot)

#### ✅ Prerequisites

- Java 17+
- Maven
- MySQL or H2 database (default is H2 embedded)

#### 🔧 Configuration

By default, it uses **H2 in-memory DB**. You can modify `application.properties` to use MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

#### ▶️ Run the App

```bash
./mvnw spring-boot:run
```

> Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

### 3. Frontend Setup (React)

#### ✅ Prerequisites

- Node.js >= 18
- npm or yarn

#### 📦 Install Dependencies

```bash
git clone https://github.com/aymanabid10/Frontend-TaskManagementApp-GL2-AppRep
cd Frontend-TaskManagementApp-GL2-AppRep
npm install
```

#### ▶️ Start React App

```bash
npm start
```

> App will run on: [http://localhost:3000](http://localhost:3000)

---

## ⚙️ API Endpoints

| Method | Endpoint                          | Description                        |
|--------|-----------------------------------|------------------------------------|
| GET    | /api/tasks                        | Get all tasks                      |
| GET    | /api/tasks/{id}                   | Get task by ID                     |
| POST   | /api/tasks                        | Create new task                    |
| PUT    | /api/tasks/{id}                   | Update task by ID                  |
| DELETE | /api/tasks/{id}                   | Delete task by ID                  |
| GET    | /api/tasks/search?name={name}     | Search tasks by name               |
| GET    | /api/tasks/status/{status}        | Filter tasks by status             |
| GET    | /api/tasks/overdue                | Get tasks with past due dates      |

All endpoints support **CORS** with origin `http://localhost:3000`.

---

## 🔐 Exception Handling

Custom errors are handled globally via:

- `GlobalExceptionHandler.java`
- Custom DTO response: `ErrorDetails`

---

## 🧠 Task Attributes

Each task has:

- `title`: `String`
- `description`: `String`
- `status`: `TODO | IN_PROGRESS | DONE`
- `priority`: `LOW | MEDIUM | HIGH`
- `createdAt`: `Date`
- `updatedAt`: `Date`

---

## 🛠️ Technologies Used

### Backend
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 / MySQL
- Swagger/OpenAPI
- Lombok

### Frontend
- React.js
- React Router
- Axios
- Bootstrap

---

## 📌 Future Improvements

- JWT Authentication
- User roles and login
- Task filtering and pagination
- Notification system

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first.

---

## 📄 License

[MIT License](LICENSE)

---

## 📬 Contact

Made with 💻 by [Ayman Abid](https://github.com/aymanabid10)