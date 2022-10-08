package Polymorphism;

// Definition of Overriding :
/**
 *  In Java, method overriding occurs when a subclass (child class) has the same method as the parent class
 *  The function should have same signatures in the terms of name or anything except the inner body
 *  let us see an example of it first
 */



// First class which is going to be extended by some other class
class A {
    void printString(int a){                    // This function is already defined here
        System.out.println("The Value of a is "+a);
    }
}


// Second class that is extending the A class ( extends is used for inheritance )
class B extends A{

    void printString(int a){                    // Again the same function is redefined with same signature and name
        // Every thing is same , only the inside code is different
        System.out.println("The value of a+a+a is "+3*a);
    }

}

public class Overriding {
    public static void main(String[] args) {
        B objectOfB = new B();
        objectOfB.printString(4);  // Function of B class printString is followed instead of A class's printString
    }

}

// Uses
/**
 * Here as you can see that an interface act as a template for the Rectangle and Square class.
 * Also Rectangle and Square class uses "area" function that is already defined in the interface.
 * Thus showing us the use case of overriding.
 */
interface Area{
    public void area(int a,int b);
}

class Rectangle implements Area{
    public void area(int a,int b){
        System.out.println("The area of rectangle is "+ a*b);
    }
}

class Square implements Area{
    public void area(int a,int b){
        System.out.println("The area of rectangle is "+ a*a);
    }
}