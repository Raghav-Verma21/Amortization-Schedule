# Amortization Schedule Generator

This program generates an amortization schedule for a loan based on the loan amount, interest rate, and loan term provided by the user.

## Logic Behind the Amortization Schedule

### Input Parameters
1. **Loan Amount (Principal):** The initial amount of the loan.
2. **Interest Rate:** The annual interest rate as a percentage.
3. **Loan Term:** The duration of the loan in months.

### Monthly Payment Calculation
The monthly payment for a loan is calculated using the formula:


Where:
- **P:** Loan amount (principal)
- **r:** Monthly interest rate
- **n:** Number of payments (loan term in months)

To calculate the monthly payment:
1. Convert the annual interest rate to a monthly interest rate by dividing the annual rate by 12 and converting it to a decimal.
2. Substitute the values into the formula to calculate the monthly payment.

### Amortization Schedule Generation
Once the monthly payment is calculated, an amortization schedule is generated. The schedule lists the details of each monthly payment, including the payment number, remaining loan balance, principal payment, interest payment, and total payment.

```bash
   Monthly Payment = (P * r) / (1 - (1 + r)^-n)
```

1. Initialize the remaining loan balance to the loan amount.
2. For each month:
   - Calculate the interest payment based on the remaining loan balance and monthly interest rate.
   - Calculate the principal payment as the difference between the monthly payment and the interest payment.
   - Update the remaining loan balance by subtracting the principal payment.
   - Store the details of the payment (payment number, remaining balance, principal payment, interest payment, total payment) in the schedule.
3. Repeat the process until the remaining loan balance becomes zero or negative.

The amortization schedule provides a clear breakdown of how each payment is allocated between principal and interest, helping borrowers understand their repayment schedule and track their progress in paying off the loan.

## Usage
1. Compile and run the program.
2. Enter the loan amount, interest rate, and loan term when prompted.
3. The program will generate and display the amortization schedule.
