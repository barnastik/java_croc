package barnastik.homework2.task2;

public class Sum {
    public static void main(String[] args) {

        int start = Integer.parseInt(args[0]);
        int difference = Integer.parseInt(args[1]);
        int count = Integer.parseInt(args[2]);

        long sum = start;
        for (int i = 1; i < count; i++) {
            start+=difference;
            sum += start;
        }

        System.out.println("Sum: " + sum);
    }
}
