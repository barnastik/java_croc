package barnastik.homework4.task7.notification;

import barnastik.homework4.task7.order.Order;

public interface NotificationService {
    void sendNotification(Order order);
}

