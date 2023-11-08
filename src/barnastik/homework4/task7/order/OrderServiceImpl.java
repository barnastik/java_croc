package barnastik.homework4.task7.order;

import java.time.ZonedDateTime;

public class OrderServiceImpl implements OrderService {
    @Override
    public void assembleOrder(Order order) {
        if (order.getStatus() == OrderStatus.CREATED) {
            order.setDateAssembled(ZonedDateTime.now());
            order.setStatus(OrderStatus.COLLECTED);
        }
    }

    @Override
    public void deliverOrder(Order order) {
        if (order.canBeDelivered()) {
            order.setDateDelivered(ZonedDateTime.now());
            order.setStatus(OrderStatus.CLOSED);
        }
    }

    @Override
    public void checkOrderExpiration(Order order) {
        if (order.getStatus() == OrderStatus.COLLECTED) {
            ZonedDateTime expirationDate = ZonedDateTime.from(order.getDateAssembled().plusWeeks(2));
            if (expirationDate.isBefore(ZonedDateTime.now())) {
                order.setStatus(OrderStatus.EXPIRED);
            }
        }
    }
}
