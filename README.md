# Task Manager
Финальный проект по Software Engineering.
REST API для управления задачами и проектами.

---

## Технологии
* **Java 17**
* **Spring Boot 4** (Web, Data JPA, Security)
* **PostgreSQL** (Database)
* **Flyway** (Migrations)
* **Docker & Docker Compose** (Containerization)
* **MapStruct** (DTO Mapping)
* **JUnit 5** (Tests)

---

## Авторизация
Проект использует **Basic Auth**. В Postman перейдите во вкладку **Auth** -> выберите **Basic Auth**.
**Тестовые пользователи (уже есть в базе):**
- Admin: `ilya / test123`
- User: `nurken / test456`
- User: `rafi / test789`

---

## API Endpoints
**1. Пользователи (Users)**
| Метод | URL | Описание |
|:---|:---|:---|
| `GET` | `/api/users` | Получить всех пользователей (Admin) |
| `GET` | `/api/users/{id}` | Получить пользователя по ID |
| `POST` | `/api/users/register` | Регистрация нового пользователя |
| `PUT` | `/api/users/{id}` | Обновить данные пользователя (email, username) |
| `DELETE`| `/api/users/{id}` | Удалить пользователя (Admin) |

**2. Проекты (Projects)**
| Метод | URL | Описание |
|:---|:---|:---|
| `GET`  | `/api/projects`  | Получить все проекты  |
| `GET`  | `/api/projects/{id}`  | Получить проект по ID  |
| `POST`  | `/api/projects/add?username={user}`  | Создать проект  |
| `POST`  | `/api/projects/{id}/members?username={user}`  | Добавить участника в проект  |
| `PUT`  | `/api/projects/{id}`  | Обновить проект (имя, описание)  |
| `DELETE`  | `/api/projects/{id}`  | Удалить проект  |

**3. Задачи (Tasks)**
| Метод | URL | Описание |
|:---|:---|:---|
| `GET`  | `/api/tasks?projectId={id}`  | Получить все задачи конкретного проекта  |
| `GET`  | `/api/tasks/{id}`  | Получить задачу по ID  |
| `POST`  | `/api/tasks/add`  | Создать задачу  |
| `PUT`  | `/api/tasks/{id}`  | Обновить задачу (заголовок, описание)  |
| `PATCH`  | `/api/tasks/{id}/status?status={STATUS}`  | Обновить статус задачи  |
| `DELETE`  | `/api/tasks/{id}`  | Удалить задачу  |
