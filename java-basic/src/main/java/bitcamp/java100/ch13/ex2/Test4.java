package bitcamp.java100.ch13.ex2;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test4 {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        //System.out.printf("%d / %d = %d\n", 20, 0, 20 / 0);
        FileReader in = new FileReader("okok.txt");
        System.out.println("파일 읽기 준비 완료");
        
    }
}
