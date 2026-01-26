# 💇‍♂️ Salon Booking System (Backend)

A **Salon Booking System** built using **Java and Spring Boot** that provides a complete backend solution for managing users, salons, services, bookings, and payments. The system follows a **layered architecture** and exposes **RESTful APIs** with proper validation, error handling, and role-based security.

This project is designed to be **scalable, maintainable, and production-ready**, making it ideal for real-world use and for showcasing backend development skills.

---

## Features

* 👤 User Registration & Login (JWT-based authentication)
* 🔐 Role-Based Access Control (USER / ADMIN)
* 🏢 Salon Management (Admin)
* ✂️ Service Management (Admin)
* 📅 Appointment Booking System
* 💳 Payment Processing Linked to Bookings
* ✅ Validation (Email, Booking Date, Service Availability, Required Fields)
* 🧠 Global Exception Handling with Proper HTTP Status Codes
* 📦 DTO-Based Clean API Structure

---

## 🏗️ Architecture

The project follows a **Layered Architecture**:

```
Controller Layer  → Handles HTTP Requests/Responses
Service Layer     → Business Logic
Repository Layer → Database Operations (JPA)
DTO Layer        → Request/Response Models
Entity Layer     → Database Models
Security Layer  → Authentication & Authorization
```

---

## 🛠️ Tech Stack

| Technology      | Description                    |
| --------------- | ------------------------------ |
| Java            | Programming Language           |
| Spring Boot     | Backend Framework              |
| Spring Security | Authentication & Authorization |
| JWT             | Secure Token-Based Login       |
| Spring Data JPA | ORM & Database Access          |
| MySQL           | Relational Database            |
| Maven           | Build Tool                     |
| Postman         | API Testing                    |

---

## 📂 Project Structure

```
src/main/java/com/shaku/salon_booking
│
├── Controller
│   ├── BookingController.java
│   ├── PaymentController.java
│   ├── SalonController.java
│   └── ServiceController.java
│
├── DTO
│   ├── BookingRequest.java
│   ├── BookingResponse.java
│   ├── LoginRequest.java
│   ├── RegisterRequest.java
│   ├── ServiceRequest.java
│   └── ServiceResponse.java
│
├── Model
│   ├── Booking.java
│   ├── Payment.java
│   ├── Role.java
│   ├── Salon.java
│   ├── ServiceEntity.java
│   └── User.java
│
├── Repository
│   ├── BookingRepository.java
│   ├── PaymentRepository.java
│   ├── SalonRepository.java
│   ├── ServiceRepository.java
│   └── UserRepository.java
│
├── Security
│   └── SecurityConfig.java
│
├── Service
│   ├── BookingService.java
│   ├── BookingServiceImpl.java
│   ├── PaymentService.java
│   ├── PaymentServiceImpl.java
│   ├── ServiceService.java
│   ├── ServiceServiceImpl.java
│   └── UserService.java
│
└── Exception
    └── ResourceNotFoundException.java
```

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/salon-booking-system.git
cd salon-booking-system
```

### 2️⃣ Configure Database

Create a MySQL database:

```sql
CREATE DATABASE salon_booking;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/salon_booking
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

## ▶️ Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or using IDE:

> Run `SalonBookingApplication.java`

Server will start at:

```
http://localhost:8080
```

---

## 🔐 Authentication Flow

1. Register User
2. Login to get JWT Token
3. Use Token in Headers for API calls

### Header Example

```
Authorization: Bearer <your_jwt_token>
```

---

## 📬 API Flow (Correct Order)

### 1️⃣ Register User

`POST /api/auth/register`

### 2️⃣ Create Salon (Admin)

`POST /api/salons`

### 3️⃣ Create Service (Admin)

`POST /api/services`

### 4️⃣ Create Booking

`POST /api/bookings`

### 5️⃣ Make Payment

`POST /api/payments`

---

## 🧪 Sample Booking Request

```json
{
  "bookingDate": "2026-01-30",
  "timeSlot": "10:00 AM - 10:30 AM",
  "userId": 1,
  "salonId": 1,
  "serviceId": 1
}
```

---

## ⚠️ Error Handling

| Status Code | Meaning                            |
| ----------- | ---------------------------------- |
| 400         | Bad Request (Validation Failed)    |
| 401         | Unauthorized (JWT Missing/Invalid) |
| 404         | Resource Not Found                 |
| 500         | Internal Server Error              |

---

## 🏆 Key Highlights

* Clean Architecture & Separation of Concerns
* Secure JWT Authentication
* DTO-Based API Design
* Relational Data Integrity
* Global Exception Handling
* Production-Ready Backend

---

## 📌 Future Enhancements

* 📊 Admin Dashboard (Frontend)
* 📧 Email Notifications for Booking Confirmation
* ⏱️ Real-Time Slot Availability
* 📱 Mobile App Integration

---

## 👨‍💻 Author

**Shaikh Shaku Ahmed**
Java Backend Developer | Spring Boot | REST APIs | MySQL

---

## ⭐ Support

If you like this project, please consider giving it a **star ⭐ on GitHub** — it helps a lot!

---

## 📜 License

This project is licensed under the **MIT License** — feel free to use and modify it for learning and development purposes.
