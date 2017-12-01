package java100.app.control;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.dao.RoomDao;
import java100.app.domain.Room;
@Component("/room")
public class RoomController implements Controller {
    @Autowired
    RoomDao roomDao;
    
    @Override
    public void destroy() {}
    
    @Override
    public void init() {}
    
    @Override // 이 애노테이션은 붙이지 않아도 된다.
    public void execute(Request request, Response response) {
            
            switch (request.getMenuPath()) {
            case "/room/list": this.doList(request, response); break;
            case "/room/add": this.doAdd(request, response); break;
            case "/room/delete": this.doDelete(request, response); break;
            case "/room/view": this.doView(request, response); break;
            case "/room/update": this.doUpdate(request, response); break;
            default: 
                response.getWriter().println("해당 명령이 없습니다.");
            }
       
    }
    
    private void doList(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[강의실 목록]");
        try {
            List<Room> list = roomDao.selectList();
            for (Room room : list) {
                out.printf("%4d,%-4s, %4s, %4d\n",
                        room.getNo(),
                        room.getLocation(), 
                        room.getName(), 
                        room.getCapacity()
                        );
            }//while
        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
        
    }
    
    private void doAdd(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[강의실 등록]");
        
        try {
            Room room = new Room();
            room.setLocation(request.getParameter("loc"));
            room.setName(request.getParameter("name"));
            room.setCapacity(Integer.parseInt(request.getParameter("capacity")));
            roomDao.insert(room);
            out.println("저장하였습니다.");

        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
        
        
    } 
    
    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[강의실 삭제]");
        
        try {
            int no = Integer.parseInt(request.getParameter("no"));

            if (roomDao.delete(no) > 0) {
                out.println("삭제하였습니다.");
            } else {
                out.printf("'%s'의 강의실 정보가 없습니다.\n", no);
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
        
        
    }
    private void doView(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[강의실 상세 정보]");
        
        try {
            
            int no = Integer.parseInt(request.getParameter("no"));

            Room room = roomDao.selectOne(no);

            if (room != null) {
                out.printf("   번호   : %d\n", room.getNo());
                out.printf("   위치   : %s\n", room.getLocation());
                out.printf("강의실이름: %s\n", room.getName());
                out.printf(" 수용인원 : %d\n", room.getCapacity());
            } else {
                out.printf("'%s'의 강의실 정보가 없습니다.\n", no);
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
        
        
    } 
    
    private void doUpdate(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[강의실 정보 변경]");
        
        try {
            Room room = new Room();
            room.setNo(Integer.parseInt(request.getParameter("no")));
            room.setLocation(request.getParameter("loc"));
            room.setName(request.getParameter("name"));
            room.setCapacity(Integer.parseInt(request.getParameter("capacity")));
            if(roomDao.update(room) > 0) {
                out.println("변경하였습니다.");
            } else {
                out.printf("'%s'의 강의실 정보가 없습니다.\n",room.getNo());
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
        
        
        
    }
    
  
}










