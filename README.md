User Management with Multi-Factor Authentication (MFA)

This project is a Spring Boot application that implements a user management system with Multi-Factor Authentication (MFA). It uses JWT tokens for authentication and integrates with SendGrid for sending verification codes via email.

Features

User Login: Users can log in using their username and password.
JWT Authentication: After successful login, a JWT token is generated and returned to the user for subsequent requests.
Multi-Factor Authentication (MFA): An additional layer of security where a verification code is sent via email using SendGrid.
Token Validation: Tokens are validated for secured endpoints.
H2 In-Memory Database: For quick setup and testing purposes.
Technology Stack

Java 11
Spring Boot 2.7.5
Spring Security
Spring Data JPA
Spring Web
Spring Boot Test
JWT (JSON Web Token) for securing the API
H2 Database for in-memory persistence
SendGrid for email-based MFA
Maven for build and dependency management
Getting Started

Prerequisites

Java 11 or newer
Maven 3.6+
Running the Application

Clone the repository:

git clone https://github.com/Micky90-sys/user-management-mfa.git
cd user-management-mfa
Configure SendGrid API Key:

Open the application.properties file and add your SendGrid API key:
sendgrid.api.key=YOUR_SENDGRID_API_KEY
Build the project:

mvn clean install
Run the project:

mvn spring-boot:run
The application will start on http://localhost:8080.

Access the H2 database console:

URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave blank)
API Endpoints

Login Endpoint:

POST /api/auth/login
Request body:
{
  "username": "your-username",
  "password": "your-password"
}
Returns a JWT token on successful login.
Protected Endpoint Example:

Any secured API endpoints can be accessed by passing the JWT token in the Authorization header:
Authorization: Bearer <your-jwt-token>
SendGrid MFA Verification:

After login, an MFA verification code will be sent to the user's registered email. The user must input this code to complete the login process.
Testing

Run Unit Tests:
mvn test
Project Structure

user-management-mfa/
├── src/main/java/com/nerlin/mfa/
│   ├── controller/       # REST API Controllers
│   ├── security/         # JWT Security Configuration and Utility
│   ├── service/          # Services like MFA, SendGrid
│   ├── util/             # Utility classes (e.g., MFAUtil)
│   └── model/            # Model Classes (e.g., User, Roles)
├── src/test/java/com/nerlin/mfa/
│   ├── controller/       # Unit tests for controllers
├── src/main/resources/
│   ├── application.properties  # Application configuration
│   └── data.sql          # H2 database initialization script
└── pom.xml               # Maven configuration


Dependencies
Spring Boot Security: For managing authentication and authorization.
Spring Boot Data JPA: For database interactions.
JWT: For token-based authentication.
SendGrid: For sending verification codes via email.
H2 Database: In-memory database for development and testing.
JUnit & Mockito: For unit testing.
Possible Improvements
Password Reset Functionality: Implement a feature to reset user passwords.
Support for SMS MFA: Extend MFA functionality to support SMS verification using Twilio.
Role-based Access Control: Implement roles and permissions for different user types.
Production Database: Replace H2 with a persistent database like MySQL or PostgreSQL for production.
License
This project is licensed under the MIT License - see the LICENSE file for details.

Contact
For any questions or feedback, please contact Your Name.