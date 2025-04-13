import java.util.Scanner;
import java.util.InputMismatchException;

public class DoubleDice {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    Die die1 = new Die();
    Die die2 = new Die();
    
    double money = 100.00;
    double betAmount;
    
    // Using the floating-point comparison technique to avoid small differences
    while (Math.abs(money - 0.0) > 0.000001) {
      System.out.printf("You have $%.2f\n", money);
      System.out.println();
      System.out.println("How much would you like to bet (Enter 0 to quit)?");

      // The try-catch block stops the program from crashing in case of a non-numeric input
      try {
        betAmount = scnr.nextDouble();
        scnr.nextLine();

        if (betAmount == 0.0) {
          System.out.println("See you around, winner!");
          break;
        }

         if (betAmount < 0.0) {
          System.out.println("You cannot bet a negative amount");
          continue;
        }

        if (betAmount > money) {
          System.out.println("You cannot bet more than you have");
          continue;
        }
      }
      catch (InputMismatchException e) {
        System.out.println("Please enter a numeric bet");
        scnr.nextLine();
        continue;
      }

      // Roll the dice
      die1.roll();
      die2.roll();

      System.out.println("You rolled a " + die1.toString() + " and " + die2.toString());

      if (die1.equals(die2)) {
        System.out.printf("You win $%.2f\n", betAmount);
        money += betAmount;
      }
      else {
        System.out.printf("You lose $%.2f\n", betAmount);
        money -= betAmount;
      }

      System.out.println();
      System.out.println();
    }

    // Executes is player is out of money after the game ends
    if (money <= 0.0) {
      System.out.println("You are out of money!");
      System.out.println("Better luck next time");
    }
  }
}
