# Singleton Pattern

Singleton design pattern ensures that there is at most one and only one instance of an object available at runtime.
Note that the implementation must take into account the multi-threaded case so as to ensure no two threads create 
the singleton object separately. So we need to make sure the implementation is thread-safe.

## The Problem Singleton Pattern Solves
Singleton design pattern is especially useful for **manager** type of objects such as file data readers. In gaming,
you'd want, for example, the score manager a singleton, so that no two different score managers try to update a unique 
score.

### And now the Pattern
We need to have a way to get the instance, which is an initially unset static variable. 
The getter has inside it the logic to check whether the instance's value is set to null. Otherwise, it creates the
object. To ensure thread-safety, we create a mutex object and use it to create a synchronized section in the code 
just when the object needs to be created. That way, only one thread at one time can instantiate the object, and once
set, the next threads will never reach that block of code since the instance is already set.


Taking a manager-type example, imagine a factory with 5 line workers. The manager will run these track workers upon
creation. The singleton pattern ensures that there is only one manager, and hence only 5 line workers have been started. 

### Buzzwords
Management of resources, typically calls for a singleton design pattern.
