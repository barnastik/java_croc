package barnastik.homework7.task13;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AuctionLot lot = new AuctionLot(100000, "Густав Климт", System.currentTimeMillis() + 60000);

        for (int i = 0; i < 10; i++) {
            Thread participantThread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    double newPrice = lot.getCurrentPrice() + Math.random() * 1000;
                    String bidder = "Участник " + Thread.currentThread().getId();
                    if (lot.makeBid(newPrice, bidder)) {
                        System.out.println(bidder + " сделал ставку на " + newPrice);
                    }
                }
            });
            participantThread.start();
        }

        lot.waitForEnd();

        System.out.println("Победитель: " + lot.getCurrentBidder());
        System.out.println("Выигрышная ставка: " + lot.getCurrentPrice());
    }
}