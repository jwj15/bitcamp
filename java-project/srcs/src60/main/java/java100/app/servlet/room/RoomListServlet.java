package java100.app.servlet.room;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.RoomDao;
import java100.app.domain.Room;
import java100.app.listener.ContextLoaderListener;

@WebServlet("/room/list")
@SuppressWarnings("serial")
public class RoomListServlet extends HttpServlet {
    
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDao roomDao = ContextLoaderListener.iocContainer.getBean(
                RoomDao.class);
        List<Room> list = roomDao.selectList();
        
        // 작업한 결과를 JSP에게 넘겨주기 위해 ServletRequest 보관소에 저장한다.
        request.setAttribute("list", list);
        
        // 이 값을 출력할 JSP로 인클루딩한다.
        // => 인클루드를 실행하는 쪽에서 콘텐츠 타입을 설정해야 한다.
        // => 인클루드 되는 쪽에서는 여기에서 설정한 것을 그대로 따른다.
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd = request.getRequestDispatcher("/room/list.jsp");
        rd.include(request, response);
        
    }
}








