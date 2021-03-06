package step7;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisInsert {

    public static void main(String[] args) throws Exception {
        
        InputStream inputStream = Resources.getResourceAsStream("step7/mybatis-config.xml");
        
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        // insert를 실행할 때 Board 객체를 넘겨줄 것이다.
        Board board = new Board();
        board.setTitle("오호라~ 제목이래요!2");
        board.setContents("내용이더래요~~~2");
        
        // insert(SQL문을 찾을 때 이름, 데이터가 저장된 객체)
        int count = sqlSession.insert("JdbcTestMapper.insert", board);
                
        // Mybatis는 기본으로 수동 commit이다.
        // 즉 개발자가 명시적으로 commit()을 호출해야 한다.
        sqlSession.commit();
        
        System.out.printf("%d 개가 입력되었습니다.\n", count);

        sqlSession.close();

    }
}
