package mytask;
public class Fibonacci {
    private int[] sequence;
    private int length;

    public void setLength(int val){
        length = val;
    }

    public int getLength() { return length; }

    public int[] getSequence(){
        return sequence;
    }

    Fibonacci(){
        length = 0;
    }
    /**
     * outputs Fibonacci sequence with adjusted length , percent of odd and pair numbers in it
     * @param first first member of sequence
     * @param second second member of sequence
     */
    public void fibonacci(int len, int first,int second){
        sequence = new int[len];
        length = len;
        sequence[0] = first;
        sequence[1] = second;
        len-=2;
        for(int count = 2;len != 0;len--,count++){
            sequence[count] = sequence[count-1]+sequence[count - 2];
        }
    }

    /**
     * Counts percent of odd and pair numbers in sequence
     */
    public int percentPair(){
        int pairC = 0;
        for(int i:sequence){
            if(i%2 == 0){
               pairC++;
            }
        }
        return (pairC*100/length);
    }
}