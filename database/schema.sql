-- NBSF Website Database Schema
-- Drop database if exists and create new
DROP DATABASE IF EXISTS nbsf_db;
CREATE DATABASE nbsf_db;
USE nbsf_db;
-- Students Table
CREATE TABLE IF NOT EXISTS students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    date_of_birth DATE,
    education VARCHAR(100),
    course_id BIGINT,
    address TEXT,
    city VARCHAR(100),
    state VARCHAR(100),
    pincode VARCHAR(10),
    resume_path VARCHAR(500),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_email (email),
    INDEX idx_phone (phone),
    INDEX idx_course_id (course_id)
);
-- Courses Table
CREATE TABLE IF NOT EXISTS courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(255) NOT NULL,
    description TEXT,
    duration VARCHAR(100),
    fees DECIMAL(10, 2),
    eligibility TEXT,
    syllabus TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
-- Enquiries Table
CREATE TABLE IF NOT EXISTS enquiries (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    message TEXT,
    status VARCHAR(50) DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_status (status),
    INDEX idx_email (email)
);
-- Contact Messages Table
CREATE TABLE IF NOT EXISTS contact_messages (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    subject VARCHAR(500),
    message TEXT NOT NULL,
    status VARCHAR(50) DEFAULT 'NEW',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_status (status)
);
-- Partners Table
CREATE TABLE IF NOT EXISTS partners (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(255) NOT NULL,
    logo_url VARCHAR(500),
    website_url VARCHAR(500),
    description TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
-- Placements Table
CREATE TABLE IF NOT EXISTS placements (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT,
    company_name VARCHAR(255) NOT NULL,
    position VARCHAR(255),
    salary DECIMAL(10, 2),
    placement_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE
    SET NULL,
        INDEX idx_student_id (student_id),
        INDEX idx_placement_date (placement_date)
);
-- Insert Sample Courses
INSERT INTO courses (
        course_name,
        description,
        duration,
        fees,
        eligibility
    )
VALUES (
        'Digital Marketing Executive',
        'Learn digital marketing strategies, SEO, SEM, and social media marketing',
        '3 months',
        15000.00,
        '10+2 or equivalent'
    ),
    (
        'Healthcare Assistant',
        'Training in patient care, medical terminology, and healthcare protocols',
        '6 months',
        25000.00,
        '10+2 with Science background'
    ),
    (
        'Retail Sales Associate',
        'Customer service, sales techniques, and retail management',
        '2 months',
        10000.00,
        '10th Pass or above'
    ),
    (
        'Data Entry Operator',
        'Computer basics, typing skills, and data management',
        '2 months',
        8000.00,
        '10th Pass or above'
    ),
    (
        'Electrician (ITI)',
        'Electrical installations, maintenance, and safety procedures',
        '1 year',
        30000.00,
        '10th Pass'
    ),
    (
        'Hotel Management Trainee',
        'Hospitality management, food service, and customer relations',
        '6 months',
        20000.00,
        '10+2 or equivalent'
    );
-- Insert Sample Partners
INSERT INTO partners (company_name, description, is_active)
VALUES (
        'Tech Solutions Pvt Ltd',
        'Leading IT services provider',
        TRUE
    ),
    (
        'Healthcare Plus',
        'Premium healthcare services',
        TRUE
    ),
    ('Retail Corp', 'National retail chain', TRUE),
    (
        'InfoTech Systems',
        'Data processing and IT solutions',
        TRUE
    );
COMMIT;