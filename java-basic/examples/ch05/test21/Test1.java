// ## 키보드로부터 입력 받기 
// - Scanner 클래스를 사용하여 키보드로부터 입력 받는 방법을 알아보자!

package bitcamp.java100.test21;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        // System.in 객체
        // - System 클래스에 선언된 레퍼런스이다. 
        // - 표준 입력 장치인 '키보드' 정보가 들어있는 객체를 가리킨다. 
        // - 즉 그 객체의 주소를 갖고 있다.
        
        // System.out 객체
        // - System 클래스에 선언된 레퍼런스이다.
        // - 표준 출력 장치인 '콘솔 또는 명령창' 정보가 들어 있는 객체를 가리킨다.
        // - 즉 그 객체의 주소를 갖고 있다.
        
        // 키보드로부터 입력된 값을 읽으려면 도우미 객체가 필요하다.
        // Scanner 클래스에 입력 값을 다루는 유용한 메서드(기능)가 있다.
        
        // 1) 준비 
        // - Scanner 객체를 생성한다.
        // - 생성할 때 키보드 정보를 넘긴다.
        Scanner keyScan = new Scanner(System.in);
        
        // 2) 스캐너 객체를 이용하여 키보드로부터 들어온 데이터를 읽는다.
        // - nextLine() : 입력된 내용을 한 줄씩 잘라서 리턴한다.
        //                즉 사용자가 한 줄 입력을 완료할 때까지 리턴하지 않는다.
        // - 이렇게 입력 또는 출력이 끝날 때까지 리턴하지 않는 것을 
        //   "blocking I/O"라 부른다.
        // - 이와 반대로 입력 또는 출력 작업을 시켜 놓고 즉시 리턴하는 것을
        //   "non-blocking I/O"라 부른다.
        //
        System.out.print("입력하세요:");
        String line = keyScan.nextLine();
        
        System.out.println(line);
        
        // 3) 사용 완료 후 그 객체가 사용한 자원을 해제시킨다.
        // - OS에서 제공하는 자원 중에서 다른 프로그램이 사용할 수 있도록 
        //   풀어줘야 하는 자원이 있다.
        // - 이런 자원을 사용하는 경우, 쓸 때만 묶어두고 쓰지 않으면 즉시 풀어주는 
        //   방식으로 코드를 작성해야 한다.
        // - 사용 후 풀어줘야 하는 자원인 경우 보통 클래스에 close()라는 메서드를 갖고 있다.
        // - 이런 클래스를 사용할 때는 사용 후 close()를 반드시 호출하도록 하라!
        // - 단 즉시 JVM을 종료하는 경우, close()를 호출하지 않아도 된다.
        // - 왜? JVM이 종료되면 VM에서 사용한 모든 자원은 OS가 강제 수거한다.
        // 
        keyScan.close();
        
    }
}











