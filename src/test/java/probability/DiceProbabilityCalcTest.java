package probability;

import static probability.DiceProbabilityCalc.calc;

import org.junit.Test;

public class DiceProbabilityCalcTest {


  @Test
  public void calcTest() {
    calc(5);
  }

  @Test
  public void probabilityOfAnyOfTwo() {
    double prob = new DiceProbabilityCalc().probabilityOfAnyOfFour();
    System.out.println(prob);
  }
}
