# Builder Pattern

Builder pattern is a creational pattern where you can create complex objects. Take for example creation of a House
object. A house takes many steps to be built.

## The Problem Builder Pattern Solves

Let's start with a candidate solution that can do the job.

### Why not just pass the variables to the constructor and be done with the whole deal?
Well, that way we will have to pass all the possible arguments to the constructor signature. This creates a
telescopic constructor pattern as such:

```java
public House(String foundation, String structure, String roof) {...}
public House(String foundation, String structure, String roof, boolean painted){...}
public House(String foundation, String structure, String roof, boolean painted, boolean furnished){...}
```

### Okay, now, why not just create setters and have the client use them to create the House?
Well, at first glance that may sound like a good solution, but what will happen if the order is not right?
```java
House house=new House();
house.setBasement("Concrete, brick, and stone");
house.setRoof("Concrete and reinforced steel");
house.setStructure("Concrete, mortar, brick, and reinforced steel");
house.setFurnished(true);
```

Besides, the client could be confused as to "how built" is the House object at the point of creation. Does it have
the "basics"? But the, everyone might have a different definition of what "basic" means to a house upon creating it.

Also, don't forget that there are many types of houses too. It'll just create a mess on the client-side, as well
as the implementation itself. We need a better solution.

### And now the Pattern

Let's reverse engineer. We want the client code to look something like the following:

1- create a specific type of house building recipe holder   
2- pass the house building recipe holder object to a house building executor     
3- call the "build house" method on the executor, and get the house finally 

In code form we will have something like this:

```java

Builder houseBuilder = new ConcreteHouseBuilder()
ConstructionEngineer constructionEngineer = new ConstructionEngineer(houseBuilder) 
constructionEngineer.buildHouse()
House house = constructionEngineer.getHouse() // do something with the house
```

### Buzzwords

What stands out here are these couple of requirements:  

1- Create a complex object step by step where the order matters     
2- The focus is on **how** it's made rather than **what** is made.  