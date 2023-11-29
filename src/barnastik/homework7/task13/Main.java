package barnastik.homework7.task13;

//изменена работа с потоками
//в файлах есть проверки на ошибки

import java.math.BigDecimal;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws PriceException {
        ArrayList<String> participantsList = null;
        try {
            participantsList = Reader.readParticipants("./src/barnastik/homework7/task13/sources/participants.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (participantsList == null) {
            System.out.println("нет участников");
            return;
        }

        AuctionLot lot = null;
        try {
            lot = Reader.readLot("./src/barnastik/homework7/task13/sources/test.txt", 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (lot == null) {
            System.out.println("нет лота");
            return;
        }
        
        List<Thread> participants = new ArrayList<>(participantsList.size());

        int participantsCounter = 0; //счетчик для потоков участников
        final AuctionLot newLot = lot;

        for (String participant : participantsList) { participants.add(new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    int bid = Math.abs((int) (Math.random() * 100000000));
                    newLot.makeBid(new BigDecimal(bid), participant);
                    System.out.println(participant + " сделал(-а) ставку на " + bid);
                }
            }));
            participants.get(participantsCounter++).start();
            System.out.println("цена лота: " + newLot.getPrice());
            if (newLot.getWinnerNow() == null) {
                System.out.println("сейчас нет победителя");
            } else {
                System.out.println(newLot.getWinnerNow());
            }
        }

        participants.forEach(participant -> {
            try {
                participant.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Победитель: " + newLot.getWinnerNow() + " " + newLot.getPrice());
    }
}