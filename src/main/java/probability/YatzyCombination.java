package probability;

import java.util.List;

public enum YatzyCombination {
  ONES(new UpperComboCalc(DiceNumber.ONE)),
  TWOS(new UpperComboCalc(DiceNumber.TWO)),
  THREES(new UpperComboCalc(DiceNumber.THREE)),
  FOURS(new UpperComboCalc(DiceNumber.FOUR)),
  FIVES(new UpperComboCalc(DiceNumber.FIVE)),
  SIXES(new UpperComboCalc(DiceNumber.SIX));

  private CombinationProbabilityCalc calcylator;

  YatzyCombination(CombinationProbabilityCalc internalCalc) {
    calcylator = internalCalc;

  }

  public double getProbabilityAny(List<DiceNumber> keppers) {
    return calcylator.getProbabilityAny(keppers);
  }

  public double getProbabilityAcceptable(List<DiceNumber> keppers) {
    return calcylator.getProbabilityAcceptable(keppers);
  }

  public int isAny(List<DiceNumber> keppers) {
    return calcylator.isAny(keppers);
  }

  public int isAcceptable(List<DiceNumber> keppers) {
    return calcylator.isAcceptable(keppers);
  }
}
