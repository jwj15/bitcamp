package java100.app.domain;

public class UploadFile {
    
    int no;
    String filename;
    int boardNo;
    
    public UploadFile() {};
    
    public UploadFile(String filename) {
        this(0, filename);
    }

    public UploadFile(int no, String filename) {
        this.no = no;
        this.filename = filename;
    }
    
    
    public int getNo() {
        return this.no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getFilename() {
        return this.filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getBoardNo() {
        return this.boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }
    
}
