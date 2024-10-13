
# Book Management System API

This project is a Book Management System built with Spring Boot, MongoDB, and React. The API allows you to perform CRUD operations (Create, Read, Update, Delete) on books.

## Prerequisites

- Java 8 or higher
- Maven
- MongoDB installed and running locally or remotely
- Postman for API testing

## Running the Application

1. Clone the repository to your local machine.
2. Navigate to the root directory of the project.
3. Run the following command to start the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```
4. The application will start on `http://localhost:8080`.

## Endpoints

### 1. Get All Books
- **URL**: `/api/books`
- **Method**: `GET`
- **Response**:
  ```json
  [
      {
          "title": "Book Title",
          "description": "Book description",
          "author": "Author Name",
          "genre": "Fiction",
          "yearPublished": 2021
      }
  ]
  ```

### 2. Find Books by Author
- **URL**: `/api/books/author/{authorName}`
- **Method**: `GET`
- **Response**: 
  ```json
  [
      {
          "title": "Book Title",
          "description": "Book description",
          "author": "Author Name",
          "genre": "Fiction",
          "yearPublished": 2021
      }
  ]
  ```

### 3. Create a Book
- **URL**: `/api/books`
- **Method**: `POST`
- **Body**:
  ```json
  {
      "title": "New Book",
      "description": "A description of the new book",
      "author": "New Author",
      "genre": "Non-fiction",
      "yearPublished": 2023
  }
  ```
- **Response**:
  ```json
  {
      "title": "New Book",
      "description": "A description of the new book",
      "author": "New Author",
      "genre": "Non-fiction",
      "yearPublished": 2023
  }
  ```

### 4. Update a Book
- **URL**: `/api/books/update/{id}`
- **Method**: `PUT`
- **Body**:
  ```json
  {
      "title": "Updated Book Title",
      "description": "Updated description",
      "author": "Updated Author",
      "genre": "Fiction",
      "yearPublished": 2022
  }
  ```
- **Response**:
  ```json
  {
      "title": "Updated Book Title",
      "description": "Updated description",
      "author": "Updated Author",
      "genre": "Fiction",
      "yearPublished": 2022
  }
  ```

### 5. Delete a Book
- **URL**: `/api/books/delete/{id}`
- **Method**: `DELETE`
- **Response**:
  ```json
  {
      "message": "Book deleted",
      "bookId": "12345"
  }
  ```

## Testing in Postman

1. Open Postman.
2. Create a new collection and add the following requests:

   - `GET http://localhost:8080/api/books`
   - `GET http://localhost:8080/api/books/author/{authorName}`
   - `POST http://localhost:8080/api/books`
     - Set the body to `raw` and `JSON`, then add the book data.
   - `PUT http://localhost:8080/api/books/update/{id}`
     - Set the body to `raw` and `JSON`, then update the book data.
   - `DELETE http://localhost:8080/api/books/delete/{id}`

3. Ensure your local MongoDB is running and the Spring Boot application is started before sending requests.

4. Use the collection to test the endpoints.

## MongoDB Setup

1. Install and run MongoDB.
2. Create a database called `bookdb`.
3. The `Book` data will be automatically stored when you interact with the API.

## Conclusion

This API allows you to manage books using basic CRUD operations. You can extend it further by adding more features or integrating it with a frontend built using React.
