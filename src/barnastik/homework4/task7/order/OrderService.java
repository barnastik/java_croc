package barnastik.homework4.task7.order;

public interface OrderService {
    void assembleOrder(Order order);
    void deliverOrder(Order order);
    void checkOrderExpiration(Order order);
}

