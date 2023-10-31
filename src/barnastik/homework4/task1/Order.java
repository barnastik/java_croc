package barnastik.homework4.task1;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private final String number;
    private final LocalDateTime dateReceived;
    private LocalDateTime dateAssembled;
    private LocalDateTime dateDelivered;
    private final List<Item> items;
    private final String customerName;
    private final String customerPhoneNumber;
    private OrderStatus status;

    public Order(LocalDateTime dateReceived, List<String> items, String customerName, String customerPhoneNumber) {
        this.number = generateOrderNumber(customerPhoneNumber);
        this.dateReceived = dateReceived;
        this.dateAssembled = null;
        this.dateDelivered = null;
        this.items = new ArrayList<>();
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.status = OrderStatus.CREATED;
    }

    private String generateOrderNumber(String phoneNumber) {
        LocalDateTime now = LocalDateTime.now();
        String year = String.format("%02d", now.getYear() % 100);
        String month = String.format("%02d", now.getMonthValue());
        String day = String.format("%02d", now.getDayOfMonth());
        String hours = String.format("%02d", now.getHour());
        String minutes = String.format("%02d", now.getMinute());
        String seconds = String.format("%02d", now.getSecond());
        String phoneNumberSuffix = phoneNumber.substring(phoneNumber.length() - 4);
        return year + month + day + hours + minutes + seconds + phoneNumberSuffix;
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getDateReceived() {
        return dateReceived;
    }

    public LocalDateTime getDateAssembled() {
        return dateAssembled;
    }

    public void setDateAssembled(LocalDateTime dateAssembled) {
        this.dateAssembled = dateAssembled;
    }

    public LocalDateTime getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(LocalDateTime dateDelivered) {
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
            LocalDateTime expirationDate = dateAssembled.plusWeeks(2);
            return expirationDate.isAfter(LocalDateTime.now());
        }
        return false;
    }

}