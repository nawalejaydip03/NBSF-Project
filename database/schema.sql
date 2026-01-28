-- Create Database
CREATE DATABASE IF NOT EXISTS nbsf_db;
USE nbsf_db;

-- Students Table
CREATE TABLE students (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15) NOT NULL,
    date_of_birth DATE,
    education VARCHAR(100),
    address TEXT,
    city VARCHAR(50),
    state VARCHAR(50),
    pincode VARCHAR(10),
    course_id BIGINT,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('PENDING', 'ENROLLED', 'COMPLETED', 'PLACED') DEFAULT 'PENDING',
    resume_path VARCHAR(255),
    INDEX idx_email (email),
    INDEX idx_status (status),
    INDEX idx_course (course_id)
);

-- Courses Table
CREATE TABLE courses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    sector VARCHAR(100),
    duration VARCHAR(50) NOT NULL,
    eligibility TEXT,
    description TEXT,
    syllabus TEXT,
    fee DECIMAL(10,2),
    government_subsidy DECIMAL(10,2),
    certification VARCHAR(100),
    placement_assistance BOOLEAN DEFAULT TRUE,
    batch_size INT,
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_sector (sector),
    INDEX idx_active (active)
);

-- Partners Table
CREATE TABLE partners (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    company_name VARCHAR(200) NOT NULL,
    logo VARCHAR(255),
    website VARCHAR(255),
    contact_person VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    address TEXT,
    partnership_type ENUM('PLACEMENT', 'TRAINING', 'SPONSOR', 'GOVERNMENT'),
    description TEXT,
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_type (partnership_type)
);

-- Enquiries Table
CREATE TABLE enquiries (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    enquiry_type ENUM('STUDENT', 'EMPLOYER', 'PARTNER', 'GENERAL') DEFAULT 'GENERAL',
    subject VARCHAR(200),
    message TEXT NOT NULL,
    status ENUM('NEW', 'CONTACTED', 'RESOLVED') DEFAULT 'NEW',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_status (status),
    INDEX idx_type (enquiry_type)
);

-- Placements Table
CREATE TABLE placements (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT NOT NULL,
    company_id BIGINT NOT NULL,
    position VARCHAR(100),
    salary DECIMAL(10,2),
    joining_date DATE,
    status ENUM('INTERVIEWED', 'SELECTED', 'JOINED', 'LEFT') DEFAULT 'INTERVIEWED',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
    FOREIGN KEY (company_id) REFERENCES partners(id) ON DELETE CASCADE,
    INDEX idx_student (student_id),
    INDEX idx_company (company_id)
);

-- Testimonials Table
CREATE TABLE testimonials (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    designation VARCHAR(100),
    company VARCHAR(100),
    testimonial TEXT NOT NULL,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    type ENUM('STUDENT', 'EMPLOYER') DEFAULT 'STUDENT',
    approved BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_type (type),
    INDEX idx_approved (approved)
);

-- Users Table (Admin)
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100),
    role ENUM('ADMIN', 'MANAGER', 'COUNSELOR') DEFAULT 'COUNSELOR',
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP,
    INDEX idx_username (username),
    INDEX idx_role (role)
);

-- Certificates Table
CREATE TABLE certificates (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    certificate_number VARCHAR(50) UNIQUE,
    issue_date DATE NOT NULL,
    expiry_date DATE,
    file_path VARCHAR(255) NOT NULL,
    verified BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE,
    INDEX idx_cert_number (certificate_number),
    INDEX idx_student (student_id)
);

-- Insert Sample Partners
INSERT INTO partners (company_name, partnership_type, active) VALUES
('Kaushlya Industries & Training India Pvt.Ltd', 'PLACEMENT', TRUE),
('SMS Vision Edutrain Pvt.Ltd', 'TRAINING', TRUE),
('Kaushlya Food Industries', 'PLACEMENT', TRUE),
('Oleander Venture Private Ltd', 'PLACEMENT', TRUE),
('APS Digital Solution', 'TRAINING', TRUE),
('Maharashtra State Skill Development Society', 'GOVERNMENT', TRUE);

-- Insert Sample Courses
INSERT INTO courses (title, sector, duration, fee, certification, active) VALUES
('Digital Marketing Executive', 'IT', '3 Months', 15000.00, 'MSSDS Certified', TRUE),
('Healthcare Assistant', 'Healthcare', '6 Months', 20000.00, 'Government Certified', TRUE),
('Retail Sales Associate', 'Retail', '2 Months', 8000.00, 'MSSDS Certified', TRUE),
('Data Entry Operator', 'IT', '2 Months', 6000.00, 'Government Certified', TRUE),
('Electrician (ITI)', 'Construction', '1 Year', 25000.00, 'ITI Certified', TRUE),
('Hotel Management Trainee', 'Hospitality', '4 Months', 12000.00, 'MSSDS Certified', TRUE);

-- Insert Admin User
INSERT INTO users (username, email, password, full_name, role) VALUES
('admin', 'admin@nbsfgroup.org', '$2a$10$YourHashedPasswordHere', 'System Administrator', 'ADMIN');