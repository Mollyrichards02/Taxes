import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;


public class Taxes {
    public static double userSalary(Scanner scanner) {
        double salary = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Please enter your yearly salary: ");
            try {
                salary = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        System.out.println("Taxes for the yearly salary of £" + salary + ":");
        return salary;

    }
        public static double calculateTax(double salary, double limit, double rate){
        return (salary - limit) * rate;
    }

    public static void calculateTaxes(){
        Scanner scanner = new Scanner(System.in);
        double salary = userSalary(scanner);
        double taxAmount = 0;
        System.out.println();

        if (salary >= 0 && salary <= 14999){
            System.out.println("You will have up to £14,999 tax free.");
        } else if (salary >= 15000 && salary <= 19999) {
            taxAmount = calculateTax(salary, 14999, 0.10);
            System.out.println("Your tax for the year will be £" + taxAmount);
            double taxedBasic = salary - taxAmount;
            System.out.println("You salary after tax will be £" + taxedBasic);
            System.out.println();
        } else if (salary >= 20000 && salary <= 29999) {
            taxAmount = calculateTax(salary, 19999, 0.15) + calculateTax(19999, 14999, 0.10 );
            System.out.println("Your tax for the year will be £" + taxAmount);
            double taxedBasic = salary - taxAmount;
            System.out.println("You salary after tax will be £" + taxedBasic);
            System.out.println();
        }else if (salary >= 30000 && salary <= 44999) {
            taxAmount = calculateTax(salary, 29999, 0.20) + calculateTax(29999, 19999, 0.15) + calculateTax(19999, 14999, 0.10 );
            System.out.println("Your tax for the year will be £" + taxAmount);
            double taxedBasic = salary - taxAmount;
            System.out.println("You salary after tax will be £" + taxedBasic);
            System.out.println();
        }else if (salary >= 45000){
            taxAmount = calculateTax(salary, 44999, 0.25) + calculateTax(44999, 29999, 0.20) + calculateTax(29999, 19999, 0.15) + calculateTax(19999, 14999, 0.10 );
            System.out.println("Your tax for the year will be £" + taxAmount);
            double taxedBasic = salary - taxAmount;
            System.out.println("You salary after tax will be £" + taxedBasic);
            System.out.println();
        }

    }
    }



