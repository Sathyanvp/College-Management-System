# College Management System

This is a Spring Boot application for managing college and student data. It provides RESTful APIs to create, read, and delete college and student records.

## Features

* **College Management:**
    * Create a new college.
    * Retrieve all colleges.
    * Search for a college by name.
    * Delete a college by name.
* **Student Management:**
    * Create a new student.
    * Retrieve all students.
    * Search for a student by roll number.
    * Delete a student by roll number.
* **Data Validation:**
    * Email validation for student records.
    * Unique constraints for roll number and email.
* **Database Integration:**
    * Uses JPA and Hibernate for database interaction.
    * Uses H2 in-memory database.
* **RESTful APIs:**
    * Provides RESTful endpoints for all operations.
* **Error Handling:**
    * Handles exceptions and returns appropriate HTTP status codes.

## Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* H2 Database
* Maven

## Prerequisites

* Java Development Kit (JDK) 17 or higher
* Maven

## How to Run

1.  **Clone the Repository:**
    ```bash
    git clone [repository URL]
    cd [repository directory]
    ```
2.  **Build the Project:**
    ```bash
    mvn clean install
    ```
3.  **Run the Application:**
    ```bash
    mvn spring-boot:run
    ```
4.  **Access the APIs:**
    * The application will run on `http://localhost:8080`.
    * You can use tools like Postman or curl to interact with the APIs.

## API Endpoints

### College Management

* **Create a College:**
    * `POST /colleges`
    * Request Body: JSON object representing the college.
    * Example Request Body:
        ```json
        {
          "collegeName": "Example College",
          "address": "123 Main St",
          "contactNumber": 1234567890
        }
        ```
* **Get All Colleges:**
    * `GET /colleges`
* **Search for a College:**
    * `GET /colleges/{collegeName}`
* **Delete a College:**
    * `DELETE /colleges/{collegeName}`

### Student Management

* **Create a Student:**
    * `POST /students`
    * Request Body: JSON object representing the student.
    * Example Request Body:
        ```json
        {
          "rollNo": 12345,
          "name": "John Doe",
          "email": "[email address removed]",
          "department": "Computer Science",
          "collegeName": {
            "collegeName": "Example College"
          },
          "phoneNum": 9876543210,
          "year": 2024
        }
        ```
* **Get All Students:**
    * `GET /students`
* **Search for a Student:**
    * `GET /students/{rollNo}`
* **Delete a Student:**
    * `DELETE /students/{rollNo}`

## Database

* The application uses an H2 in-memory database, which means data will be lost when the application stops.
* To use a persistent database, you can modify the `application.properties` file.

## Error Handling

* The application returns appropriate HTTP status codes for different scenarios:
    * `200 OK`: Successful operation.
    * `201 CREATED`: Resource created successfully.
    * `404 NOT FOUND`: Resource not found.
    * `409 CONFLICT`: Resource already exists.
    * `500 INTERNAL SERVER ERROR`: Internal server error.
    * `400 BAD REQUEST`: Invalid Input.

## Future Improvements

* Implement user authentication and authorization.
* Add update functionality for colleges and students.
* Implement pagination for large datasets.
* Add more comprehensive error handling and logging.
* Add unit and integration tests.
* Add front end.
* Add better exception handling for edge cases.
