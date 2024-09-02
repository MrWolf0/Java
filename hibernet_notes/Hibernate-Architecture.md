# Hibernate - Architecture

**Configuration Object**  
The Configuration object is the first Hibernate object you create in any Hibernate application. It is usually created only once during application initialization. It represents a configuration or properties file required by Hibernate.  
It checks whether the config file is syntactically correct or not.
If the config file is not valid then it will throw an exception. If it is valid then it creates a meta-data in memory and returns the meta-data to object to represent the config file.
The Configuration object provides two key components:

- **Database Connection** − This is handled through one or more configuration files supported by Hibernate. These files are `hibernate.properties` and `hibernate.cfg.xml`.
- **Class Mapping Setup** − This component creates the connection between the Java classes and database tables.

Hibernate is used to overcome the limitations of JDBC, such as:

- If we change our Database, then this query won’t work.
- JDBC code is not portable code across multiple database software.
- In JDBC, Exception handling is mandatory.
- While working with JDBC, there is no support for Object-level relationships. This means in JDBC, there is no built-in support for handling relationships between entities at the object level, such as one-to-one, one-to-many, or many-to-many relationships. You must manually write SQL queries to handle these relationships, and the responsibility of managing the relationships falls entirely on the developer.

## Object-level relationship
Database relationships are the associations between different tables in a relational database. In a relational database management system (RDBMS or DBMS), data is organized into tables. The relationships between these tables determine how the data in one table is connected to the data in another table.

1. **Primary key**: The unique identifier for each record in a table, ensuring that each row in a table is uniquely identified.
2. **Foreign key**: This is the field in the second table that connects to the primary key in the first table. It determines the link between the two tables. The foreign key establishes referential integrity, making sure that the relationships between two tables are valid.
3. **Referential integrity**: This ensures that the fields in the table from the foreign key correspond to fields in the table from the primary key. If the foreign key does not correspond to an appropriate primary key or the value is null, the referential integrity is violated.

There are three main types of relationships between tables in databases: **one-to-one**, **one-to-many**, and **many-to-many**. To best understand which relationship type is being used, you first need to understand the data, the tables, and the business rules behind them. If you’re creating tables in a database like MySQL or SQL Server, you can define these relationships when building tables, using primary and foreign keys.

### One-to-one
It is used to create a relationship between two tables in which a single row of the first table can only be related to one and only one record of a second table.

### One-to-many database relationship
Every record in the first table can have multiple corresponding records in the second table. However, every record in the second table corresponds to only one in the first table. A one-to-many relationship is the most common type of database relationship in modern databases.

**Example:**  
One database table has basic information about your customers. The other database has their orders. The orders table can have multiple orders for one customer. In the customers table, those multiple orders can only be linked to one customer at a time.

### Many-to-many database relationship
Many-to-many relationships are the most complex of the three. In this case, every record in the first table can have multiple corresponding records in the second table. To use many-to-many relationships, it’s necessary to introduce a third table, called a junction table or linking table. The third table connects the two tables and helps the relational database function smoothly.

**Example:**  
The first table contains students and their names, while the second table contains their courses. One student can attend many different courses. One course can have many different students.
# Hibernate Components and Workflow

## SessionFactory
The `SessionFactory` object configures Hibernate for the application using the supplied configuration file and allows for a `Session` object to be instantiated. The `SessionFactory` is a thread-safe object used by all the threads of an application.

The `SessionFactory` is a heavyweight object; it is usually created during application startup and kept for later use. You would need one `SessionFactory` object per database using a separate configuration file. So, if you are using multiple databases, you would have to create multiple `SessionFactory` objects.

## Session Object
A `Session` is used to get a physical connection with a database. The `Session` object is lightweight and designed to be instantiated each time an interaction is needed with the database. Persistent objects are saved and retrieved through a `Session` object.

- It opens the Connection/Session with the Database software through the Hibernate Framework.
- It is a lightweight object and is not thread-safe.
- The `Session` object is used to perform CRUD operations.
- The session objects should not be kept open for a long time because they are not usually thread-safe and should be created and destroyed as needed.

## Transaction Object
The `Transaction` object is used whenever we perform any operation that results in changes to the database.

- The `Transaction` object is used to instruct the database to make the changes permanent by using the `commit()` method.

## Query Object
`Query` objects use SQL or Hibernate Query Language (HQL) strings to retrieve data from the database and create objects. A `Query` instance is used to:

- Bind query parameters.
- Limit the number of results returned by the query.
- Execute the query.

## Criteria Object
`Criteria` objects are used to create and execute object-oriented criteria queries to retrieve objects.

## Flow of Operations in Hibernate Framework

Understanding how Hibernate saves an object to the database or retrieves an object involves several stages. Here’s a breakdown of the workflow:

### Stage I
In the first stage, we write the persistence logic to perform specific operations on the database with the help of the Hibernate Configuration file and Hibernate mapping file. After that, we create an object of the particular class on which we wrote the persistence logic.

### Stage II
In the second stage, our class containing the persistence logic interacts with the Hibernate framework, where Hibernate provides some abstraction to perform the task. At this stage, the role of the Java class ends. Hibernate now takes responsibility for executing the persistence logic with the help of internal layers.

### Stage III
In the third stage, the Hibernate framework interacts with JDBC, JNDI, JTA, etc., to access the database and perform the persistence logic.

### Stages IV & V
In the fourth and fifth stages, Hibernate interacts with the database through the JDBC driver. Hibernate executes the persistence logic, which typically involves CRUD operations. If the persistence logic is to retrieve a record, it will be displayed in the console of the Java program as an object.

