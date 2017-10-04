package venkat.eam;

import java.util.function.Consumer;

class Resource {

    private Resource() {
        System.out.println("Instance created");
    }

    public void op1() {
        System.out.println("op1 called....");
    }

    public void op2() {
        System.out.println("op2 called...");
    }

    private void close() {
        System.out.println("do any cleanup here...");
    }

    public static void use(Consumer<Resource> consume) {
        Resource resource = new Resource();
        try {
            consume.accept(resource);
        } finally {
            resource.close();
        }
    }
}

public class Sample {
    public static void main(String[] args) {
        //This is how the class will be used by fellow programmers.

        Resource.use(resource -> {
            resource.op1();
            resource.op2();
        });
    }
}

/*
Instance created
op1 called....
op2 called...
do any cleanup here...
*/