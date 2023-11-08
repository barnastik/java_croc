package barnastik.homework4.task7;

import barnastik.homework3.task5.good.Fridge;
import barnastik.homework3.task5.good.Stove;
import barnastik.homework3.task5.good.WashingMachine;
import barnastik.homework3.task5.good.Appliance;

import barnastik.homework4.task7.order.Order;
import barnastik.homework4.task7.order.OrderService;
import barnastik.homework4.task7.order.OrderServiceImpl;

import java.time.ZonedDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Appliance[] appliances = new Appliance[3];

        appliances[0] = new Fridge("Mini Fridge", 200.0, "Compact fridge with freezer", "50x50x80 cm", 100);
        appliances[1] = new Stove("Gas Stove", 350.0, "Gas-powered stove with four burners", "60x60x85 cm", 500);
        appliances[2] = new WashingMachine("Washing Machine", 500.0, "Washer with a dryer", "70x70x100 cm", 800, 120, true);
        Order order;
        order = new Order(ZonedDateTime.now(), Arrays.asList(appliances[0], appliances[1], appliances[2]), "Иванов Иван Иванович", "+79990002545");


        OrderService orderService = new OrderServiceImpl();
        //NotificationService notificationService = new Notification();

        orderService.assembleOrder(order);
        //notificationService.sendNotification(order);

        System.out.println("Статус заказа: " + order.getStatus());

        orderService.checkOrderExpiration(order);

        System.out.println("Статус заказа после проверки истечения срока хранения: " + order.getStatus());

        orderService.deliverOrder(order);

        System.out.println("Статус заказа после доставки: " + order.getStatus());
    }
}
