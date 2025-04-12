import java.util.Random

public class Die {
  private int value;
  private Random randGen = new Random();

  public Die() {
    value = 0;
  }
  
  public void roll() {
    value = randGen.nextInt(6) + 1;
  }

  @Override
  public boolean equals(Die die2) {
    return this.value == die2.value;
  }

  @Override
  public String toString() {
    if (value == 1) {
      return "one";
    }
    else if (value == 2) {
      return "two";
    }
    else if (value == 3) {
      return "three";
    }
    else if (value == 4) {
      return "four";
    }
    else if (value == 5) {
      return "five";
    }
    else if (value == 6) {
      return "six";
    }
  }
    
