package barnastik.homework7.task13;

//переменные, используемые потоками, теперь volatile
//изменена makeBid
//добавлено имя лота и победитель
//теперь чтение из файла
//цена теперь типа BigDecimal
//добавлен контроль параметров в public AuctionLot
//теперь чтение цены (ставки) и победителя не блокирует всё (теперь переменные volatile)
//добавлено выбрасывание ошибки при неправильной ставке цены

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class AuctionLot {
    private final String lotName;
    private final LocalDateTime endTime;
    volatile private BigDecimal currentPrice;
    volatile private String currentBidder;
    private String winner;

    public AuctionLot(String lotName, LocalDateTime endTime, BigDecimal firstPrice) {
        if (endTime == null || endTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("неправильно установлено время");
        }
        if (lotName == null) {
            throw new IllegalArgumentException("нет имени лота");
        }
        if (firstPrice == null || firstPrice.compareTo(new BigDecimal(0)) < 0) {
            throw new IllegalArgumentException("неправильно установлена цена");
        }
        this.endTime = endTime;
        this.lotName = lotName;
        this.currentPrice = firstPrice;
    }

    public void makeBid(BigDecimal curPrice, String user) throws PriceException {
        if (curPrice.compareTo(currentPrice) > 0) {
            synchronized (this) {
                if (!LocalDateTime.now().isBefore(endTime)) {
                    throw new PriceException("уже всё закончилось");
                } else if (!(curPrice.compareTo(currentPrice) > 0)) {
                    throw new PriceException("новая цена должна быть выше предыдущей");
                } else if (LocalDateTime.now().isBefore(endTime) && curPrice.compareTo(currentPrice) > 0) {
                    currentPrice = curPrice;
                    currentBidder = user;
                }
            }
        }
    }

    public BigDecimal getPrice() {
        return currentPrice;
    }

    public String getWinnerNow() {
        if (LocalDateTime.now().isAfter(endTime)) {
            String nowWinner = currentBidder;
            winner = nowWinner;
        }
        return winner;
    }

}



