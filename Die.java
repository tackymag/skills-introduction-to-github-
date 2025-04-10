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
