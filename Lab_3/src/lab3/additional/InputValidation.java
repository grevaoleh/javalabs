package lab3.additional;

public class InputValidation {
    public static Integer validateInput(Integer lowerBorder, Integer upperBorder, Integer choice) {

        if (choice > upperBorder) {
            System.out.printf("\nInvalid choice, corrected to : %d\n",upperBorder);
            return upperBorder;
        }
        else if(choice < lowerBorder) {
            System.out.printf("\nInvalid choice, corrected to : %d\n",lowerBorder);
            return lowerBorder;
        }

        return choice;
    }
}
