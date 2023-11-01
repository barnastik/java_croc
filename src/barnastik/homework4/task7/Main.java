package barnastik.homework4.task7;

import barnastik.homework4.task7.notification.Notification;
import barnastik.homework4.task7.notification.NotificationService;
import barnastik.homework4.task7.order.Order;
import barnastik.homework4.task7.order.OrderService;
import barnastik.homework4.task7.order.OrderServiceImpl;

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
