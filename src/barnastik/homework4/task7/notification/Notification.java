package barnastik.homework4.task7.notification;

import barnastik.homework4.task7.order.Item;
import barnastik.homework4.task7.order.Order;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Notification implements NotificationService {
    @Override
    public void sendNotification(Order order) {
        StringBuilder notificationBuilder = new StringBuilder();
        notificationBuilder.append("Уважаемый ")
                .append(order.getCustomerName())
                .append("!\n\n")
                .append("Рады сообщить, что Ваш заказ ")
                .append(order.getNumber())
                .append(" готов к выдаче.\n\n")
                .append("Состав заказа:\n");
        for (Item item : order.getItems()) {
            notificationBuilder.append(item).append("\n");
        }
        double totalPrice = calculateTotalPrice(order.getItems());
        LocalDateTime expirationDate = order.getDateAssembled().plusWeeks(2);
        notificationBuilder.append("\nСумма к оплате: ")
                .append(String.format("%.2f", totalPrice))
                .append("₽\n\n")
                .append("Срок хранения заказа ")
                .append(expirationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .append(".\n\n")
                .append("С наилучшими пожеланиями, магазин \"Кошки и картошки\"");
        String notification = notificationBuilder.toString();
        // Отправка уведомления
    }

    private double calculateTotalPrice(List<Item> items) {
        // Вычисление общей суммы заказа
        return 5.55;
    }


}