package bitcamp.java100.ch20.ex6;

public class CD {
    
    private String title;
    private String singer;
    public CD() {
        System.out.println("CD()");
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSinger() {
        return singer;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }
    
    @Override
    public String toString() {
        return "CD [title=" + title + ", singer=" + singer + "]";
    }
    
    
    
    
}
