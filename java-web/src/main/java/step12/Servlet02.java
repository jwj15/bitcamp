package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step12/Servlet02")
public class Servlet02 extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // 이 서블릿을 실행할 때 클라이언트가 세션 아이디를 요청헤더에 포함하여 쿠키로 보냈다면,
        // 그리고 세션아이디가 유효하다면 다음 getSession()이 리턴하는 것은
        // 기존의 HttpSession 객체이다.
        
        HttpSession session = req.getSession();
        
        String name = (String)session.getAttribute("name");
        
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("name=%s\n", name);
    }

}









