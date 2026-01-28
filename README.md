# NBSF-Project

**Nirmal Bharat Skill Foundation - Website**

A full-stack web application for skill training and placement services, built with React (Frontend), Spring Boot (Backend), and MySQL (Database).

---

## 🚀 Features

- ✨ Student Registration System
- 📚 Course Management
- 💼 Placement Tracking
- 🤝 Partner Management
- 📧 Enquiry & Contact Forms
- 📊 Admin Dashboard
- 📱 Responsive Design
- 🔒 Secure Backend API

---

## 🛠️ Technology Stack

### Frontend
- **React.js 18** - UI Library
- **React Router** - Navigation
- **Bootstrap 5** - Styling
- **Axios** - HTTP Client
- **Formik & Yup** - Form Validation

### Backend
- **Spring Boot 3.1.5** - Java Framework
- **Spring Data JPA** - ORM
- **Spring Security** - Authentication
- **Spring Mail** - Email Service
- **MySQL Connector** - Database Driver

### Database
- **MySQL** - Relational Database

---

## 📁 Project Structure

```
nbsf-website/
├── Frontend (React.js)/     # React frontend application
├── backends/                # Spring Boot backend API
├── database/                # SQL schema and scripts
├── SETUP_GUIDE.md          # Detailed setup instructions
└── README.md               # This file
```

---

## ⚡ Quick Start

### Prerequisites
- Node.js (v14+)
- Java JDK 17
- MySQL Server (port 3305)
- Maven

### 1. Setup Database
```bash
mysql -u root -p -P 3305 < database/schema.sql
```

### 2. Start Backend
```bash
cd backends
mvn spring-boot:run
```
Backend runs on: **http://localhost:8080**

### 3. Start Frontend
```bash
cd "Frontend (React.js)"
npm install
npm start
```
Frontend runs on: **http://localhost:3000**

---

## 📖 Documentation

For detailed setup and configuration instructions, see **[SETUP_GUIDE.md](./SETUP_GUIDE.md)**

---

## 🔗 Connection Architecture

```
Frontend (React:3000) 
    ↓ (proxy)
Backend (Spring Boot:8080)
    ↓ (JDBC)
Database (MySQL:3305)
```

---

## 👨‍💻 Author

**Jaydip Nawale**
- GitHub: [@nawalejaydip03](https://github.com/nawalejaydip03)

---

## 📄 License

© 2026 Nirmal Bharat Skill Foundation. All Rights Reserved.
