package mytask;
/**
 * lab 1 <b>Task 4-5</b>
 * @author Oleg Greva
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Input in = new Input();
        in.input();
        Output out = new Output(in.getStart(),in.getEnd());
        Fibonacci row = new Fibonacci();
        row.fibonacci(in.getFibLen(),out.odd(),out.pair());
        System.out.print("Fibonacci sequence : \n");
        out.sequencePrint(row.getSequence());
        int pairP = row.percentPair();
        System.out.print("\nPercent of odd is : "+ (100 - pairP) +"%\n");
        System.out.print("Percent of pair is : "+pairP+"% ");
    }
}