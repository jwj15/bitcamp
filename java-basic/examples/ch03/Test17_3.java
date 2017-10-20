// ## 메서드 - 메서드 정의 문법 II
// - 메서드 정의 기본 문법을 알아 보자!
//

package bitcamp.java100;

public class Test17_3 {

    // 2) 파라미터가 있는 메서드
    // 파라미터(parameter)?
    // - 호출한 쪽에서 보낸 값을 저장하기 위해 선언한 로컬 변수를 말한다.
    // - 아래 m1() 메서드에서 name 변수가 바로 "파라미터"이다.
    //
    // 호출한 쪽에서 보낸 값을 받고 싶다면 그 값을 저장할 적절한 메모리를 선언해야 한다.
    // 
    static void m1(String name) {
        System.out.printf("%s님 반갑습니다!\n", name);
    }
    
    // 여러 개의 값이 넘어올 때는 각각의 값을 저장할 변수를 선언하면 된다.
    // - 괄호() 안에 콤마(,)를 사용하여 각각의 변수를 선언하라!
    static void m2(String name, int age) {
        System.out.printf("%s(%d)님 반갑습니다!\n", name, age);
    }
    
    public static void main(String[] args) {
        // 메서드를 호출할 때 값을 전달하기
        // - 메서드를 호출할 때 파라미터에 넘기는 값을 "아규먼트(argument)"라 부른다.
        // 
        m1("홍길동");
        m1("임꺽정");
        m1("유관순");
        
        // 메서드를 호출할 때 여러 개의 값을 전달하기
        // - 각각의 값을 콤마(,)로 구분하여 나열하면 된다.
        m2("홍길동", 20);
        m2("임꺽정", 30);
        m2("유관순", 16);
        
        // 컴파일 오류!
        // 1) 파라미터 개 수 만큼 정확하게 값을 전달해야 한다.
        //    빠뜨리거나 더하면 오류이다.
        //m1(); 
        //m1("홍길동", 20);
        
        // 2) 파라미터의 타입과 다른 종류의 값을 전달하면 안된다.
        //m1(20);
        
        // 3) 파라미터의 순서도 정확해야 한다.
        //m2(20, "홍길동");
    }
}














