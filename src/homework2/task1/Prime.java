package homework2.task1;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        boolean prime = true;
        if (n < 2) {
            prime = false;
        } else {
            for (long i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    prime = false;
                    break;
                }
            }
        }
        if (prime) {
            System.out.println("Простое");
        } else {
            System.out.println("Составное");
        }

        //дальше проверка соседних чисел на близнецы
        //можно было еще через факториал красиво сделать, но факториал слишком большое число :(
        boolean prime_1 = true;
        boolean prime_2 = true;

        if (n - 2 < 2) {
            prime_1 = false;
        } else {
            for (long i = 2; i <= Math.sqrt(n - 2); i++) {
                if ((n - 2) % i == 0) {
                    prime_1 = false;
                    break;
                }
            }
        }

        if (n + 2 < 2) {
            prime_2 = false;
        } else {
            for (long i = 2; i <= Math.sqrt(n + 2); i++) {
                if ((n + 2) % i == 0) {
                    prime_2 = false;
                    break;
                }
            }
        }
        /*
        if (prime_1 || prime_2) {
            System.out.println("Близнец");
        } else {
            boolean prime = true;
            if (n < 2) {
                prime = false;
            } else {
                for (long i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        prime = false;
                        break;
                    }
                }
            }
            if (prime) {
                System.out.println("Простое");
            } else {
                System.out.println("Составное");
            }
        }
        */
    }

}