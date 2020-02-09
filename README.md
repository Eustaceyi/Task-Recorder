# Task-Recorder
## A Spring Boot Web application that could record tasks.
### This application utilizes: 
- Spring Boot as platform
- MySQL as database

### This application could finish the following tasks:

#### Welcome page: 
- by sending `GET host:port/`

#### Task management
- show all tasks: `GET host:port/task/tasks`
- create new task: `POST host:port/task/create` with parameters `owner` and `description`
- mark task as finished: `PUT host:port/task/finish/{id}` with parameter `id`
- find task by its id: `GET host:port/task/{id}` with parameter `id`
- find tasks by its owner: `GET host:port/task/owner` with parameter `owner`
- delete task by its id: `PUT host:port/delete/{id}` with parameter `id`

All of above requests cooperate with a table in MySQL, which look up, change status, remove and add items in the table.
