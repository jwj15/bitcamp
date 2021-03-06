package bitcamp.java100.ch21.ex1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext appCtx = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java100/ch21/ex1/application_context.xml");

        // 어떤 객체가 만들어졌는지 확인
        String[] names = appCtx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("%s => %s\n",name, appCtx.getBean(name).getClass().getName());
        }
        System.out.println("------------------------");
        
        // 이름을 모르겠으면 타입으로 찾아라!
        // 타입의 객체가 여러개 있을 때는 이름을 지정해서 찾아라!
        Front obj = (Front) appCtx.getBean(Front.class);
        obj.test();
        
    }
    
    
}
