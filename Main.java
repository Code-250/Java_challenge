import java.util.*;

public class Main {
    // ACADEMY EVALUATIONS
    final static int ACADEMY_MONTHS = 3;
    final static double ACADEMY_RATE = 31/100.0;
    final static int ACADEMY_MONTHLY_GROSS = 650;
    final static int ACADEMY_GROSS = ACADEMY_MONTHS * ACADEMY_MONTHLY_GROSS;

    // PERMANENT EVALUATIONS
    final static double PERMANENT_RATE = 40/100.00;
    final static int PERMANENT_MONTHLY_GROSS = 1600;

    public static void main(String[] args){
        final Scanner scanner = new Scanner(System.in);

        System.out.println("How many months would you like to pay in?");
        int input = scanner.nextInt();
        if (input > 0  && input <= 6) {
            Map<String, String> x = calculator(input);
            System.out.println("PHASE 2: " + x.get("permanentEarnings"));

            System.out.println("TOTAL: " + x.get("totalEarnings"));
        } else {
            System.out.println(" INVALID INPUT");
        }

    }

    public static Map<String, String> calculator(int numberOfMonths){

        double academyPaidFees = ACADEMY_GROSS * ACADEMY_RATE;

        final int PERMANENT_GROSS = numberOfMonths * PERMANENT_MONTHLY_GROSS;

        int monthsDifference = 6 - numberOfMonths;
        double DISCOUNT_RATE = 1;
        if (numberOfMonths < 6) {
            DISCOUNT_RATE = (10/ 100.0) * monthsDifference;
        }

        double permanentPaidFees = 3840;


        // Building output
        if(numberOfMonths < 6){
             permanentPaidFees = permanentPaidFees - (permanentPaidFees * DISCOUNT_RATE);

        }
        System.out.println(permanentPaidFees);

        double permanentEarnings = PERMANENT_GROSS - permanentPaidFees;
        double totalEarnings = PERMANENT_GROSS - permanentPaidFees + ACADEMY_GROSS - academyPaidFees;

        Map<String, String> output = new HashMap<>();
        output.put("permanentEarnings", Double.toString(permanentEarnings));
        output.put("totalEarnings", Double.toString(totalEarnings));

        return output;

    }
}