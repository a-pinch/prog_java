package org.stepic.pinch.s41_10;

public class Main {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] ste = new Exception().getStackTrace();
        if(ste.length>2)
            return ste[2].getClassName()+"#"+ste[2].getMethodName();
        else
            return null;
    }
}
