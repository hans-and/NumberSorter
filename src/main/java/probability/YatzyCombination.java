package probability;

import java.util.List;

public enum YatzyCombination {
  ONES(new UpperComboIsAcceptable(DiceNumber.ONE)),
  TWOS(new UpperComboIsAcceptable(DiceNumber.TWO)),
  THREES(new UpperComboIsAcceptable(DiceNumber.THREE)),
  FOURS(new UpperComboIsAcceptable(DiceNumber.FOUR)),
  FIVES(new UpperComboIsAcceptable(DiceNumber.FIVE)),
  SIXES(new UpperComboIsAcceptable(DiceNumber.SIX));

  private IsAcceptAble calcylator;

  YatzyCombination(IsAcceptAble internalCalc) {
    calcylator = internalCalc;

  }

  public int isAny(List<DiceNumber> keppers) {
    return calcylator.isAny(keppers);
  }

  public boolean isAcceptable(List<DiceNumber> keppers) {
    return calcylator.isAcceptable(keppers);
  }
}
