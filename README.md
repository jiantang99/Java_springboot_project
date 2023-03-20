# Takehome_assignment

Download code and run SpringbootDtoApplication class inside src/main/java/net/javaguides/springboot/SpringbootDtoApplication

To test the endpoints, you can use Postman and run the following scripts:

To test GET: Enter http://localhost:8080/api/tasks after Springboot server has started.

To test GET for certain Id: Enter http://localhost:8080/api/tasks/{ID}, where ID is the Id that you are looking for.

To test PUT: Enter http://localhost:8080/api/tasks/{Id}, where Id is the Id of the table entry you would like to update.
- Followed by entering some data in the following format:
  {
  "title": null,
  "description": "Testing1",
  "completed": null,
  "id": 2
  }

To test POST: Enter http://localhost:8080/api/tasks, followed by some data in the following format:
{
"title": "Testing post",
"description": "Testing post 1",
"completed": true,
"id": 3
}

To test DELETE: Enter http://localhost:8080/api/tasks/{Id}, where Id is the Id of the entry you would like to delete.

