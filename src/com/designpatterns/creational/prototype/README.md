# Prototype Pattern
Prototype patterns enables your software to achieve object creation 
through creating a prototype first, and clone it for every client requesting
for it, as opposed to creating a brand new class instance each time. Thus, the state
of the cloned objects will be the same as that of the original one.
This is especially useful if creation of such object requires extensive 
amount of resource (API calls, I/O heavy tasks, database reads etc.).

### Shallow vs Deep Copy
We talked about object cloning, but we never mentioned which one to go for.
There is no hard and fast rule and it depends on the use case. If the fields are
But these are some points to keep in mind:  
    - If fields primitive or immutable, use shallow copy    
    - If references are not modified anytime, use shallow copy     
    - If the references will be modified and that may cause change of
    behaviour, go with deep-copy (i.e. override the ```Object.clone()``` method or use [object serialization](https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html)).

## The Problem Prototype Pattern Solves

### And now the Pattern

### Buzzwords
