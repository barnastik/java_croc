package barnastik.homework4.task1;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(
                LocalDateTime.of(2023, 10, 25, 19, 50, 25),
                Arrays.asList("Товар 1", "Товар 2", "Товар 3"),
                "Иванов Иван Иванович",
                "+79990002545"
        );


        OrderService orderService = new OrderServiceImpl();
        NotificationService notificationService = new Notification();

        orderService.assembleOrder(order);
        notificationService.sendNotification(order);

        System.out.println("Статус заказа: " + order.getStatus());

        orderService.checkOrderExpiration(order);

        System.out.println("Статус заказа после проверки истечения срока хранения: " + order.getStatus());

        orderService.deliverOrder(order);

        System.out.println("Статус заказа после доставки: " + order.getStatus());
    }
}
