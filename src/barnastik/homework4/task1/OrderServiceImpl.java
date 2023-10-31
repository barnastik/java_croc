package barnastik.homework4.task1;

import java.time.LocalDateTime;

public class OrderServiceImpl implements OrderService {
    @Override
    public void assembleOrder(Order order) {
        if (order.getStatus() == OrderStatus.CREATED) {
            order.setDateAssembled(LocalDateTime.now());
            order.setStatus(OrderStatus.COLLECTED);
        }
    }

    @Override
    public void deliverOrder(Order order) {
        if (order.canBeDelivered()) {
            order.setDateDelivered(LocalDateTime.now());
            order.setStatus(OrderStatus.CLOSED);
        }
    }

    @Override
    public void checkOrderExpiration(Order order) {
        if (order.getStatus() == OrderStatus.COLLECTED) {
            LocalDateTime expirationDate = order.getDateAssembled().plusWeeks(2);
            if (expirationDate.isBefore(LocalDateTime.now())) {
                order.setStatus(OrderStatus.EXPIRED);
            }
        }
    }
}
