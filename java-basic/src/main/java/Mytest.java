
//테스트용

public class Mytest {

    public static void main(String[] args) throws Exception {

        Parent p = new Child();
        Child c = new Child();
        System.out.println("p.x = " + p.x);//100
        p.method();//p
        System.out.println("c.x = " + c.x);//200
        c.method();//c
    }
}

class Parent {
    int x = 100;
    void method() {
        System.out.println("Parent Method");
    }
}


class Child extends Parent {
    int x = 200;
    void method() {
        System.out.println("Child Method");


    }
}


