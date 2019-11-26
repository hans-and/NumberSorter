package probability;

import static probability.DiceProbabilityCalc.calc;

import java.util.SortedSet;
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

  @Test
  public void allAcceptableOutcomes() {
    SortedSet<String> set = new DiceProbabilityCalc().allAcceptableOutcomes(YatzyCombination.SIXES);
    System.out.println(set);
  }
}
