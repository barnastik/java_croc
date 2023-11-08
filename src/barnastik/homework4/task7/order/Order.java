package barnastik.homework4.task7.order;

//import java.time.LocalDateTime;
import barnastik.homework3.task5.good.Appliance;

import java.util.List;
import java.util.ArrayList;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
public class Order {
    private final String number;
    private final ZonedDateTime dateReceived;
    private ZonedDateTime dateAssembled;
    private ZonedDateTime dateDelivered;
    private final List<Item> items;
    private final String customerName;
    private final String customerPhoneNumber;
    private OrderStatus status;

    public Order(ZonedDateTime dateReceived, List<Appliance> items, String customerName, String customerPhoneNumber) {
        if (items.size() > 75) {
            throw new IllegalArgumentException("More than 75 items");
        }
        this.dateReceived = dateReceived;
        this.dateAssembled = null;
        this.dateDelivered = null;
        this.items = new ArrayList<>();
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.status = OrderStatus.CREATED;
        this.number = generateOrderNumber(customerPhoneNumber);
    }

    private String generateOrderNumber(String phoneNumber) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        return dateReceived.format(formatter) + customerPhoneNumber.substring(customerPhoneNumber.length() - 4);

    }

    public String getNumber() {
        return number;
    }

    public ZonedDateTime getDateReceived() {
        return dateReceived;
    }

    public ZonedDateTime getDateAssembled() {
        return dateAssembled;
    }

    public void setDateAssembled(ZonedDateTime dateAssembled) {
        this.dateAssembled = dateAssembled;
    }

    public ZonedDateTime getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(ZonedDateTime dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean canBeDelivered() {
        if (status == OrderStatus.COLLECTED) {
            ZonedDateTime expirationDate = dateAssembled.plusWeeks(2);
            return expirationDate.isAfter(ZonedDateTime.now());
        }
        return false;
    }

}