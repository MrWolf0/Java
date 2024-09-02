# Hibernate Entity LifeCycle
We know that Hibernate works with plain old Java objects (POJO). In raw form (without hibernate-specific annotations), it will not be able to identify these POJO classes.

But when the POJOs are properly annotated with required annotations then hibernate will be able to identify and work with them e.g. store them in the database, update them, etc. These POJOs are said to be managed by hibernate’s persistent context or hibernate entities.
what is POJO in java
ChatGPT said:
ChatGPT
A POJO (Plain Old Java Object) is a simple Java object that does not adhere to any special Java conventions or frameworks. It is a term used to describe an object that is not bound by any particular restriction other than those forced by the Java language itself. Here are some key characteristics of a POJO:

No Special Requirements:

POJOs do not need to implement any specific interfaces or extend any particular classes, unlike objects in certain frameworks that require specific base classes or interfaces.
No Annotations or Dependencies:

A POJO is typically free of annotations and does not depend on any external libraries or frameworks. This makes it simple and easy to use.
Encapsulation:

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
- A transient entity is simply a POJO without any identifier.

