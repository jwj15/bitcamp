package bitcamp.java100.ch09.ex7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Test11 {



    static class Contact {
        String name;
        String email;
        String tel;

        public Contact(String name, String email, String tel) {
            this.name = name;
            this.email = email;
            this.tel = tel;
        }

        @Override
        public String toString() {
            return "Contact [name=" + name + ", email=" + email + ", tel=" + tel + "]";
        }



    }
    public static void main(String[] args) {

        // HashMap 객체를 생성할때 key의 타입과 value타입 이름을 넘겨야 한다.
        HashMap<String, Contact> map = new HashMap<>();

        map.put("c01", new Contact("홍길동1", "hong@test.com", "1111-1111"));
        map.put("c02", new Contact("홍길동2", "hong@test.com", "1111-1111"));
        map.put("c03", new Contact("홍길동3", "hong@test.com", "1111-1111"));
        map.put("c04", new Contact("홍길동4", "hong@test.com", "1111-1111"));
        map.put("c05", new Contact("홍길동5", "hong@test.com", "1111-1111"));
        
        Collection<Contact> values = map.values();

        // 키 목록을 얻은 다음에 값 꺼내기
        
        for (Contact c : values) {
            System.out.println(c.toString());
        }
    }

}
