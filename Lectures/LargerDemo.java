/*
Notes 1
1. In Java, all code must be a part of a class
2. Define a class by "public class CLASSNAME"
3. Use { } at beginning and ending
4. Must end lines with ";"
5. public static void main(String[] args)

Notes 2
1. Variables must be declared before they are used
2. Variables must have type
3. Types can never change
4. Types are verifies before the code runs

Notes 3
1. Functions (methods) must be part of class
2. Use "public static" to define a function
3. Return values and parameters must have declared type
4. Only one return value for a function
 */

public class LargerDemo {
    public static int larger(int x, int y){
        if (x > y){
            return x;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println("Homework 1");

        int x = 0;
        while (x < 10){
            System.out.println(x);
            x++;
        }
        // Call function
        System.out.println(larger(-5, 100));
    }
}
