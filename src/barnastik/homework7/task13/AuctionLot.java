package barnastik.homework7.task13;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class AuctionLot {
    private double currentPrice;
    private String currentBidder;
    private long endTime;
    private final Lock lock = new ReentrantLock();
    private final Condition notExpired = lock.newCondition();

    public AuctionLot(double initialPrice, String initialBidder, long endTime) {
        this.currentPrice = initialPrice;
        this.currentBidder = initialBidder;
        this.endTime = endTime;
    }

    public boolean makeBid(double newPrice, String bidder) {
        lock.lock();
        try {
            if (System.currentTimeMillis() > endTime || newPrice <= currentPrice) {
                return false;
            }
            currentPrice = newPrice;
            currentBidder = bidder;
            notExpired.signalAll();
            return true;
        } finally {
            lock.unlock();
        }
    }

    public double getCurrentPrice() {
        lock.lock();
        try {
            return currentPrice;
        } finally {
            lock.unlock();
        }
    }

    public String getCurrentBidder() {
        lock.lock();
        try {
            return currentBidder;
        } finally {
            lock.unlock();
        }
    }

    public void waitForEnd() throws InterruptedException {
        lock.lock();
        try {
            while (System.currentTimeMillis() < endTime) {
                notExpired.await();
            }
        } finally {
            lock.unlock();
        }
    }
}
