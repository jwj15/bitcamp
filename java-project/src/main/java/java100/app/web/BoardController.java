package java100.app.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Board;
import java100.app.domain.Member;
import java100.app.domain.UploadFile;
import java100.app.service.BoardService;

//@Component 대신 @Controller를 붙여 페이지 컨트롤러임을 명시한다.
//
//스프링 IoC 컨테이너에서 애노테이션 중에서 객체 생성을 표시하는 애노테이션
//=> @Component
// - 일반 클래스에 대해 주로 붙인다.
//=> @Controller
// - 웹 애플리케이션에서 페이지 컨트롤러 역할을 수행하는 클래스에 주로 붙인다.
//=> @Service
// - MVC 아키텍처에서 Model 중에 비즈니스 로직을 담당하는 클래스에 붙인다.
//=> @Repository
// - MVC 아키텍처의 Model 중에서 데이터 처리를 담당하는 클래스에 붙인다.
// - 주로 DAO 클래스에 붙인다.
//
@Controller
@RequestMapping("/board")
@SessionAttributes("loginUser")
public class BoardController {
    @Autowired ServletContext servletContext;
    @Autowired BoardService boardService;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="nm", required=false) String[] names,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            Model model) throws Exception {
        if (pageNo < 1 ) {
            pageNo = 1;
        }
        
        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }
        HashMap<String,Object> options = new HashMap<>();
        if (names != null && names[0].length() > 0) {
            options.put("names", names);
        }
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        int totalCount = boardService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0 ) {
            lastPageNo++;
        }
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", boardService.list(pageNo, pageSize, options));
        return "board/list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        model.addAttribute("board", boardService.get(no));
        return "board/view";
        
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "board/form";
    }
    
    @RequestMapping("add")
    public String add(Board board,
            MultipartFile[] file,
            @ModelAttribute("loginUser") Member loginUser) throws Exception {
        
        String uploadDir = servletContext.getRealPath("/download");
        ArrayList<UploadFile> uploadFiles = new ArrayList<>();
        for (MultipartFile part : file) {
            if (part.isEmpty()) 
                continue;
            String filename = this.writeUploadFile(part, uploadDir);
            uploadFiles.add(new UploadFile(filename));
        }
        board.setFiles(uploadFiles);
        board.setWriter(loginUser);
        boardService.add(board);
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(Board board,
            MultipartFile[] file) throws Exception {
        String uploadDir = servletContext.getRealPath("/download");
        ArrayList<UploadFile> uploadFiles = new ArrayList<>();
        for (MultipartFile part : file) {
            if (part.isEmpty()) 
                continue;
            String filename = this.writeUploadFile(part, uploadDir);
            uploadFiles.add(new UploadFile(filename));
        }
        board.setFiles(uploadFiles);
        boardService.update(board);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        
        boardService.delete(no);
        return "redirect:list";
    }
    
    long prevMillis = 0;
    int count = 0;
    
    synchronized private String getNewFilename(String filename) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }
        
        return  currMillis + "_" + count++ + extractFileExtName(filename); 
    }
    
    private String extractFileExtName(String filename) {
        int dotPosition = filename.lastIndexOf(".");
        
        if (dotPosition == -1)
            return "";
        
        return filename.substring(dotPosition);
    }
    
    private String writeUploadFile(MultipartFile part, String path) throws IOException {
                
        String filename = getNewFilename(part.getOriginalFilename());
        
        part.transferTo(new File(path + "/" + filename));
        
        return filename;
    }
    
}








