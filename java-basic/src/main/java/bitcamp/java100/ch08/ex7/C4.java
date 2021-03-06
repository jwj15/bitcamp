package bitcamp.java100.ch08.ex7;

public class C4 extends C3 {
    
    @Override
    void m1() {
        System.out.println("C4.m1()");
    }
    
    @Override
    void m2() {
        System.out.println("C4.m2()");
    }
    
    void test1() {
        this.m1(); // 메서드 앞에 this를 주면 현재 클래스로부터 메서드를 찾는다.
        super.m1(); // 메서드 앞에 super를 주면 수퍼 클래스부터 메서드를 찾는다.
        
        this.m2();
        super.m2();
        
        this.m3();
        super.m3();
        
        this.m4();
        super.m4();
    }

    public static void main(String[] args) {
        C4 obj = new C4();
        obj.test1();
    }
}
