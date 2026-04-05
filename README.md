# Job Portal System

A full stack web application built using Spring Boot and MySQL.
This project was built as part of our academic work and covers
user management, role based access control, job posting, 
application tracking, and dashboard features.

---

How this project matches the assignment requirements

User and Role Management
The system has three roles - Job Seeker, Employer, and Admin.
Roles are assigned at registration. Admin can manage and 
update user accounts and status.

Access Control
Spring Security is used to restrict actions based on roles.
Job Seekers can only view and apply for jobs. Employers can
manage their own job postings. Admin has full access to 
everything in the system.

CRUD Operations
Employers can create, update, and delete job postings.
Job Seekers can view and apply. Admin can manage all records.

Filtering
Jobs can be filtered by location, skills, salary range,
and experience level.

Dashboard
Employers have a dashboard showing their posted jobs and
applications received. Admin has a dashboard for platform
monitoring and user management.

Validation and Error Handling
All inputs are validated using Bean Validation. Errors return
proper HTTP status codes with clear messages.

Data Persistence
MySQL database with Spring Data JPA and Hibernate.
Tables are created automatically on first run.

---

Tech Stack

Backend - Spring Boot
Database - MySQL
Authentication - JWT
ORM - Spring Data JPA with Hibernate
Frontend - HTML, CSS, JavaScript, Bootstrap

---

Roles and What They Can Do

Job Seeker
- Register and login
- View and search jobs
- Apply for jobs
- Track application status

Employer
- Register and login
- Post, edit, delete job listings
- View and manage applications
- Access employer dashboard

Admin
- Full access to all features
- Manage all users
- Moderate job postings
- View platform statistics

---

How to Run the Project

Requirements
- Java 17 or above
- MySQL 8
- Maven

Step 1 - Clone the repository
git clone https://github.com/nhraj123/Job-Portal-System.git

Step 2 - Create a database in MySQL
CREATE DATABASE job_portal_db;

Step 3 - Update the database details in
src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/job_portal_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

Step 4 - Run the project
mvn spring-boot:run

Step 5 - Open browser and go to
http://localhost:8080

---

API Endpoints

POST   /api/auth/register       Register a new user
POST   /api/auth/login          Login and receive JWT token

GET    /api/jobs                View all jobs
POST   /api/jobs                Create a job (Employer, Admin)
PUT    /api/jobs/{id}           Update a job (Employer, Admin)
DELETE /api/jobs/{id}           Delete a job (Employer, Admin)

POST   /api/jobs/{id}/apply     Apply for a job (Job Seeker)
GET    /api/applications/my     View my applications (Job Seeker)
GET    /api/jobs/{id}/applications  View applicants (Employer, Admin)

GET    /api/admin/users         View all users (Admin)
GET    /api/admin/dashboard     View platform stats (Admin)

---

Assumptions

- JWT token expires after 24 hours
- Passwords are encrypted using BCrypt
- Employers can only edit or delete their own job postings
- Admin has unrestricted access to all data
- Database tables are auto created by Hibernate on startup

---

