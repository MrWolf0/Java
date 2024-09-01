# Hibernate - Architecture

**Configuration Object**  
The Configuration object is the first Hibernate object you create in any Hibernate application. It is usually created only once during application initialization. It represents a configuration or properties file required by Hibernate.  
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