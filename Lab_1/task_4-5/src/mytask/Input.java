package mytask;
import java.util.Scanner;

public class Input {
    private int start;
    private int end;
    private int fibLen;
    private final Scanner input = new Scanner(System.in);

    public int getStart() {
        return start;
    }
    public int getEnd(){
        return end;
    }
    public int getFibLen(){
        return fibLen;
    }

    Input(){
        start = 0;
        end = 0;
        fibLen = 0;
    }

    /**
     * Inputs interval , length of Fibonacci sequence
     */
    public void input(){
        System.out.print("Input interval: ");
        start = input.nextInt();
        end = input.nextInt();
        System.out.print("Enter length of Fibonacci sequence: ");
        fibLen = input.nextInt();
    }
}