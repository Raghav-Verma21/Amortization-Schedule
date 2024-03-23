
import java.util.ArrayList;
import java.util.List;

public class AmortizationSchedule {

    private static List<AmortizationEntry> schedule(long amount, float interestRate, int tenureInMonths) {
        List<AmortizationEntry> schedule = new ArrayList<>();

        float monthlyInterestRate = interestRate / (12 * 100) ;  //Get Monthly Interest Rate

        float monthlyPayment = (float) ((amount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -tenureInMonths))); //Get Monthly Payments

        long remainingBalance = amount;

        for (int month = 1; month <= tenureInMonths; month++) {

            float interestPayment = monthlyInterestRate * remainingBalance;  

            float principalPayment = monthlyPayment - interestPayment;

            remainingBalance -= (long) principalPayment;

            schedule.add(new AmortizationEntry(month, remainingBalance, principalPayment,
                    interestPayment, monthlyPayment));
        }

        return schedule;
    }

    public static void main(String[] args) {

        long loanAmount = 100000;
        float interestRate = 5;
        int tenureInMonths = 36;

        List<AmortizationEntry> emiSchedule = schedule(loanAmount, interestRate, tenureInMonths);

        for (AmortizationEntry entry : emiSchedule) {
            System.out.println(entry);
        }
    }
}

class AmortizationEntry {
    int month;
    long remainingBalance;
    float principalPayment;
    float interestPayment;
    float totalPayment;

    public AmortizationEntry(int month, long remainingBalance, float principalPayment, float interestPayment, float totalPayment) {
        this.month = month;
        this.remainingBalance = remainingBalance;
        this.principalPayment = principalPayment;
        this.interestPayment = interestPayment;
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "Month: " + month +
                ", Remaining Balance: $" + remainingBalance +
                ", Principal Payment: $" + principalPayment +
                ", Interest Payment: $" + interestPayment +
                ", Total Payment: $" + totalPayment;
    }
}
