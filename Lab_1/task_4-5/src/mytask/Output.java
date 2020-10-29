package mytask;
public class Output {
    private int start;
    private int end;

    public void setStart(int val) { start = val; }
    public void setEnd(int val) { end = val; }

    public int getEnd() { return end; }
    public int getStart() { return start; }

    Output(){
        start = 0;
        end = 0;
    }
    Output(int st ,int ed){
        start = st;
        end = ed;
    }
    public void sequencePrint(int[] row)
    {
        for(int t:row){
            System.out.print(" "+t+" ");
        }
    }

    /**
     * outputs all pair numbers in ascending sequence
     */
    public int pair(){
        int sum = 0;
        System.out.print("Pair numbers in range are : \n");
        for(int num = end;num != start;num--) {
            if(num % 2 == 0){
                System.out.print(num + " ");
                sum+=num;
            }
        }
        System.out.print("\nSum of pair : "+sum+";\n");
        return end % 2 == 0 ?end:end - 1;
    }

    /**
     * outputs all odd numbers in descending sequence
     */
    public int odd(){
        int sum = 0;
        System.out.print("Odd numbers in range are : \n");
        for(int num = start;num != end;num++) {
            if(num % 2 != 0){
                System.out.print(num + " ");
                sum += num;
            }
        }
        System.out.print("\nSum of odd : "+sum+ ";\n");
        return end % 2 == 0 ?end - 1:end;
    }
}