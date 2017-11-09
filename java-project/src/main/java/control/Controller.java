package control;

public interface Controller {
    
    void execute();
    
    default void init() {};
    default void destroy() {};
    
}
