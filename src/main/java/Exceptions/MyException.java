package Exceptions;

public class MyException extends Throwable {

    public MyException() {
        System.out.println("Error input");
        System.exit(0);
    }
}
