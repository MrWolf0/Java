# Hibernate Entity LifeCycle
We know that Hibernate works with plain old Java objects (POJO). In raw form (without hibernate-specific annotations), it will not be able to identify these POJO classes.
so that's why we use annotation to draw the road to he hibernate framework. 

But when the POJOs are properly annotated with required annotations then hibernate will be able to identify and work with them e.g. store them in the database, update them, etc. These POJOs are said to be managed by hibernate’s persistent context or hibernate entities.

# Hibernate Entity Lifecycle

Hibernate works with Plain Old Java Objects (POJOs). Without Hibernate-specific annotations, POJOs are just regular Java objects and Hibernate cannot manage them. Once POJOs are properly annotated, Hibernate can identify, store, update, and perform other operations on them. These POJOs, when managed by Hibernate, are referred to as Hibernate entities.

## What is a POJO in Java?

A POJO (Plain Old Java Object) is a simple Java object that does not adhere to any special Java conventions or frameworks. It is used to describe an object that is not bound by any particular restriction other than those imposed by the Java language itself. Here are some key characteristics of a POJO:

- **No Special Requirements:** POJOs do not need to implement any specific interfaces or extend particular classes. They are not bound by any specific framework restrictions.
- **No Annotations or Dependencies:** POJOs are typically free of annotations and do not depend on external libraries or frameworks, making them simple and easy to use.
- **Encapsulation:** POJOs usually follow the principle of encapsulation, where fields are private and accessed via public getter and setter methods.
- **Java Beans vs. POJOs:** A Java Bean is a special kind of POJO with additional restrictions: it must be serializable, have a no-argument constructor, and provide getter and setter methods for its properties. However, not all POJOs are Java Beans.

### Example of a POJO

Here’s a simple example of a POJO in Java:

```java
public class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }
}
```
# Example Overview

In this example:

- **Person** is a POJO because it is a simple class with private fields (`name` and `age`), public getters and setters, and no dependency on any specific framework or library.
- POJOs are widely used in Java for modeling data and are often used in frameworks like Hibernate, Spring, and others where simplicity and flexibility are important.

## 1. Entity Lifecycle States

Given an instance of a class that is managed by a persistent context, it can be in any one of four different persistence states (known as Hibernate entity lifecycle states):

1. **Transient**
2. **Persistent or Managed**
3. **Detached**
4. **Removed**

### 1.1. Transient

- **Transient** entities exist in heap memory as normal Java objects. Hibernate does not manage transient entities. The persistent context does not track the changes done on them.
- In simple words, a transient entity has neither any representation in the datastore nor in the current Session.
- A transient entity is simply a POJO without any identifier So, if we make any changes in the data of the POJO Class then the database table is not altered. Transient objects are independent of Hibernate, and they exist in the heap memory.
Consider the Transient state as the beginning of the process when you plan to perform a database operation, such as saving or updating data. At this stage, you first prepare the data that you want to store or update in the database.
For example, if you have an employee entity, you need to assign values like name and age. This data is represented as a Plain Old Java Object (POJO). You would use setter methods to populate the POJO with the necessary data. At this point, the object is in the Transient state, meaning it is not yet associated with a Hibernate session or the database.
The next step involves moving this prepared data into the Persistent state by attaching it to a Hibernate session. This is when Hibernate starts managing the object, and it can be saved or updated in the database.
```java
Transient EmployeeEntity
EmployeeEntity employee = new EmployeeEntity();
```
### 1.2. Persistent or Managed

Persistent entities exist in the database, and Hibernate’s persistent context tracks all the changes made to these entities by the client code.

- A **persistent entity** is mapped to a specific database row, identified by the `ID` field or row name.
- Hibernate’s current running `Session` is responsible for tracking all changes made to a managed entity and propagating these changes to the database.

#### How to Obtain a Persistent Entity

You can obtain a persistent entity in one of two ways:

1. **Load the entity** Using the `get()` or `load()` method, Hibernate loads the entity that you want to update from the database into the current session. The prepared data, which was initially in the Transient state, is then attached to the current session. After performing any necessary logic or updates, Hibernate synchronizes the changes with the database, ensuring that the updated entity is saved.
2. **Persist a transient or detached entity** using one of the following methods:
   - `persist()`
   - `save()`
   - `update()`
   - `saveOrUpdate()`

```java
EmployeeEntity employee = session.load(1);

//or

EmployeeEntity employee = new EmployeeEntity();
session.save(employee);
```
In this state. each object represents one row in the database table. Therefore, if we make any changes in the data then hibernate will detect these changes and make changes in the database table.
### 1.3. Detached

Detached entities have a representation in the database, but they are not currently managed by the `Session`. Any changes made to a detached entity will not be reflected in the database, and changes in the database will not be reflected in the detached entity.

A detached entity can be created by either:

- Closing the session that it was associated with, or
- Evicting it from the session using the `evict()` method.

#### Converting an Object from Persistent State to Detached State

To convert an object from the Persistent state to the Detached state, you can:

- **Close the session**, or
- **Clear the session’s cache**.

#### Reconnecting a Detached Object to a Hibernate Session

When needed, a detached object can be reconnected to a new Hibernate session. The following methods can be used to reconnect a detached object to a session:

- `merge()`
- `update()`
- `load()`
- `refresh()`
- `save()`
- `update()`
### 1.4. Removed

Removed entities are objects that were previously managed by Hibernate (persistent entities) and have now been passed to the session’s `remove()` method.

When the application commits the changes held in the `Session`, the corresponding entries in the database for the removed entities are deleted.
## 2. Conclusion

- The newly created POJO object starts in the **Transient state**. A transient entity doesn’t represent any row in the database and is not associated with any Hibernate session. It’s simply a plain Java object.

- A **Persistent entity** represents one row in the database and is always associated with a unique Hibernate session. Hibernate tracks changes to persistent objects, and these changes are saved to the database when a commit occurs.

- **Detached entities** are those that were once persistent but are no longer managed by a session. To persist changes made to detached objects, you must re-attach them to a Hibernate session.

- **Removed entities** are persistent objects that have been passed to the session’s `remove()` method. These entities will be deleted from the database once the changes held in the session are committed.


