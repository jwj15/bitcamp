// ## 키보드로부터 입력 받기 - 연습4
// - 다음과 같이 사용자로부터 이름, 이메일, 전화를 입력받아 출력하시오!
// - 실행 예) 
// 이름? 홍길동
// 이메일? hong@test.com
// 전화? 1111-1111
// 저장하시겠습니까?(y/n) y
// 저장하였습니다.
// 계속입력하시겠습니까?(y/n) y
// 이름? 임꺽정
// 이메일? leem@test.com
// 전화? 1111-1112
// 저장하시겠습니까?(y/n) y
// 저장하였습니다.
// 계속입력하시겠습니까?(y/n) y
// 이름? 유관순
// 이메일? yoo@test.com
// 전화? 1111-1113
// 저장하시겠습니까?(y/n) n
// 저장 취소하였습니다.
// 계속입력하시겠습니까?(y/n) y
// 이름? 안중근
// 이메일? ahn@test.com
// 전화? 1111-1114
// 저장하시겠습니까?(y/n) y
// 저장하였습니다.
// 계속입력하시겠습니까?(y/n) n
// ------------------------------
// 홍길동     hong@test.com 1111-1111
// 임꺽정     leem@test.com 1111-1112
// 안중근      ahn@test.com 1111-1114
// > 
package bitcamp.java100;

import java.io.Console;
import java.util.ArrayList;

public class Test21_8_my {
        
    static Console console;
    static void prepareConsole() {
        console = System.console();
        
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); 
        }
    }
    
    public static void main(String[] args) {
        prepareConsole();
        ArrayList mem = new ArrayList();
        ArrayList list = new ArrayList();
        String con;
        String save;
         
        while (true) {
            list.add(console.readLine("이름? "));
            list.add(console.readLine("이메일? "));
            list.add(console.readLine("전화? "));
            save = console.readLine("저장하시겠습니까?(y/n) ");
            if (save.equals("y")) {
                mem.add(list.get(0));
                mem.add(list.get(1));
                mem.add(list.get(2));
                list.clear();
                System.out.println("저장하였습니다.");
            }       
            else if (save.equals("n")){
                System.out.println("저장 취소하였습니다.");
                list.clear();
            }
            con = console.readLine("계속입력하시겠습니까?(y/n) ");
            if (con.equals("y")) {
                continue;
            }
            else if (con.equals("n")){
                break;
            }
        }
        
        int i = 0;
        for (Object a : mem) {
            if (i % 3 != 0) {
                System.out.printf("%10s",a);
                i++;
            }
            else {
               System.out.println(); 
               System.out.printf("%10s",a);
               i++;
               
            }
        }
        System.out.println();
        System.out.println("----------------------------------------");
       
        
               
    }
}











