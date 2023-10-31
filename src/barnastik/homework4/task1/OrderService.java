package barnastik.homework4.task1;

public interface OrderService {
    void assembleOrder(Order order);
    void deliverOrder(Order order);
    void checkOrderExpiration(Order order);
}

