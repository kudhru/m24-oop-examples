#### Singleton Pattern
- If there is a constraint that there can only be one object of a class, no matter what happens (even if 
  there are 1000 users accessing the application, calling the main function etc. etc.), then you have to 
  use Singleton Pattern.
- Private constructor
- public method for returning the instance of this singleton class. Within this method, you first check 
  whether the instance already exists. If it exists, you return it as is. If it does not exist (i.e. null),
  you create a new object (this is the first object of this class) of this class and then return it.

#### Builder Pattern
- There is a class which has many attributes.
  - Some of the attributes are mandatory, some are optional but surely the class has many attributes.
- Your goal is to create immutable objects of this class.
- Private constructor
- You create a builder class which allows you to update the optional parameters via different methods.
- Once you have updated all the optional parameters, you then create the actual object of the class by 
  calling the private constructor of that class (build method).

#### Factory Pattern
- Generally, comes into picture when multiple classes share the same interface. But not necessary. 
- Hide the instantiation logic from the client or user.
- Centralized place for creating objects of all the classes sharing the same interface.

#### Adapter Pattern
- Bridge the gap between incompatible interfaces.
- Allows reuse of existing classes with incompatible interfaces.
- Given two incompatible interfaces (or one interface and one class), you are adapting one interface to 
  the other.
- This means that you implement the first interface and within this interface's method, you call the 
  methods of the other interface/class which is incompatible.

#### Observer Pattern
- The Observer Design Pattern is widely used in real-world applications 
- It is especially useful in scenarios where the state of one object needs to be reflected in many dependent 
  objects.
- Observers are automatically updated when the subject changes.
- Subject and observers can operate independently.
- New observers can be added without changing the subject.