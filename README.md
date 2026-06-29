# Library_Mangement_System
A simple web-based Library Management System developed using JSP, Servlets, JDBC, and Oracle Database.
The application allows users to manage author and book details through a dynamic web interface.

---

# Technologies Used

* Java
* JSP
* Servlets
* JDBC
* Oracle Database
* HTML
* Apache Tomcat
* Eclipse IDE

---

# Features

* Search author using Author Code
* Search author using Author Name
* Search book details using ISBN ID
* Create and manage BookBean objects
* Store and retrieve data from Oracle Database
* Exception handling for invalid inputs

---

# Project Structure

```text id="53l0aw"
LibraryManagementSystem/
│
├── src/main/java/com/wipro/book
│   │
│   ├── bean
│   │   ├── AuthorBean.java
│   │   └── BookBean.java
│   │
│   ├── dao
│   │   ├── AuthorDAO.java
│   │   └── BookDAO.java
│   │
│   ├── service
│   │   └── Administrator.java
│   │
│   ├── servlet
│   │   └── MainServlet.java
│   │
│   └── util
│       ├── DBUtil.java
│       └── InvalidInputException.java
│
├── src/main/webapp
│   ├── addbook.html
│   ├── displaybook.jsp
│   ├── failure.html
│   ├── invalid.html
│   ├── menu.html
│   └── view.jsp
```

---

# Functionality

* Retrieve author details using Author Code
* Retrieve author details using Author Name
* Search and display book details using ISBN ID
* Create BookBean and AuthorBean objects
* Display results using JSP pages

---

# JSP Pages

| Page Name       | Purpose                  |
| --------------- | ------------------------ |
| menu.html       | Main menu page           |
| addbook.html    | Add book details         |
| displaybook.jsp | Display book information |
| view.jsp        | View details             |
| invalid.html    | Invalid input page       |
| failure.html    | Failure/error page       |

---

# How to Run the Project

1. Import project into Eclipse IDE
2. Configure Apache Tomcat Server
3. Configure Oracle Database connection in `DBUtil.java`
4. Create required database tables in Oracle
5. Run the project on Tomcat Server
6. Open browser:

```text id="f8k2tv"
http://localhost:8080/LibraryManagementSystem
```

---

# Author

Tharika
