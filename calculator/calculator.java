package calculator;
import java.util.*;

public class calculator {


		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        
		        // Enter the Value 
		        
		        System.out.println("Calculator");
		        System.out.println("Enter the first number:");
		        float  num1 = scanner.nextFloat();

		        System.out.println("Enter the second number:");
		        float num2 = scanner.nextFloat();
		        
		        // Enter the operation
		        
		        System.out.println("Enter the operation (+, -, *, /):");
		        char operation = scanner.next().charAt(0);

		        float result = 0;

		        switch (operation) {
		            case '+':
		                result = num1 + num2;
		                break;
		            case '-':
		                result = num1 - num2;
		                break;
		            case '*':
		                result = num1 * num2;
		                break;
		            case '/':
		                if (num2 != 0) {
		                    result = num1 / num2;
		                } else {
		                    System.out.println("Cannot divide by zero!");
		                    return;
		                }
		                break;
		            default:
		                System.out.println("Invalid operation!");
		                return;
		        }

		        System.out.println("Result: " + result);

		        scanner.close();
		    }
		}


