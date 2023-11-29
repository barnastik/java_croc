package barnastik.homework7.task13;

//новый класс для чтения файлов c контролем входных данных и выбрасыванием ошибок

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.math.BigDecimal;

public record Reader() {
    private static String[] readFile(String path) throws IOException {
        try (var reader = new BufferedReader(new FileReader(path))) {
            return reader.lines()
                    .map(String::trim)
                    .toArray(String[]::new);
        }
    }

    public static ArrayList<String> readParticipants(String path) throws IOException {
        var data = readFile(path);
        if (data.length == 0) {
            throw new IOException("участники отсутствуют");
        }
        return new ArrayList<>(Arrays.stream(data).distinct().toList());
    }
    public static AuctionLot readLot(String path, int second) throws IOException {
        String[] data = readFile(path);
        if (data.length != 2) {
            throw new IOException("плохие данные");
        }
        BigDecimal initialPrice = null;
        try {
            initialPrice = new BigDecimal(data[1]);
        } catch (RuntimeException e) {
            throw new RuntimeException("нет изначальной цены");
        }
        if (initialPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("цена не может быть отрицательной");
        }
        return new AuctionLot(data[0], LocalDateTime.now().plusSeconds(second), initialPrice);
    }

}