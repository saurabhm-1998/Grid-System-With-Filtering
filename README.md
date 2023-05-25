# Student Grid System with filtering Backend

This project implements a grid system with filtering functionality for displaying student details and performing server-side filtering. It provides backend APIs for loading student details with pagination and implementing server-side filtering.

## Objective

The objective of this test assignment is to develop a grid system with filtering functionality in the backend. The grid system is designed to display student details (id, name, total marks, etc.) and allow filtering based on various columns.

## Requirements

1. *Load Student Details API*: Implement an API that retrieves student details from a file (CSV/JSON/any other format) and returns the data in a paginated manner. The API should accept parameters such as page number and page size to allow pagination.

2. *Server-side Filtering API*: Implement server-side filtering functionality in the backend. The filtering mechanism should allow the UI to send filter criteria to the backend API, which will then return the filtered results to the UI.

## Technologies Used

- Java
- Spring Boot
- H2 Database
- Maven

## Project Structure

The project has the following structure:

- `src/main/java`: Contains the Java source code.
  - `com.example.student`: Root package.
    - `controller`: Contains the controller classes for handling API requests.
    - `model`: Contains the entity classes representing the student data.
    - `repository`: Contains the repository interfaces for data access.
    - `service`: Contains the service classes for business logic.
- `src/main/resources`: Contains the application configuration files.
- `pom.xml`: Maven configuration file.

## Setup and Installation

1. Clone the repository:

git clone<repository-url>

2. Navigate to project directory :

```bash
cd student-grid-system

```
3. Build the project using Maven:
```bash
mvn clean install 

```
4. Run the application:

```bash
mvn spring-boot:run

```

## API Endpoints

- `GET /students`: Retrieves paginated student details.
- Query Parameters:
 - `page`: Page number (default: 1).
 - `pageSize`: Number of records per page (default: 10).

- `GET /students/filter`: Filters student details based on criteria.
- Query Parameters:
 - `column`: Column name to filter by (e.g., `id`, `name`, `totalMarks`).
 - `value`: Filter value.
 - `page`: Page number (default: 1).
 - `pageSize`: Number of records per page (default: 10).

- `POST /students`: Creates a new student.
- Request Body: JSON payload representing the student object.

## Examples

- GET `/students?page=1&pageSize=10`: Retrieves the first page of student details with 10 records per page.
- GET `/students/filter?column=id&value=1&page=1&pageSize=10`: Filters student details by ID and retrieves the first page of filtered results.
- POST `/students`: Creates a new student by providing the student object in the request body.

## Usage

1. Start the backend server by running the Spring Boot application.

2. Use Postman or any other similar tool to interact with the backend APIs.

3. Send requests to the following endpoints:

   - **GET /students**: Retrieves a paginated list of all students.

   - **GET /students/filter**: Filters students based on the specified criteria (column and value).

   - **POST /students**: Creates a new student by sending a JSON payload containing student details.

   Example JSON payload for creating a student:

   ```json

   {

       "name": "Saurabh Mishra",

       "totalMarks": 97

   }  
  



## Contributing

Contributions are welcome! If you find any issues or want to add new features, feel free to open a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
