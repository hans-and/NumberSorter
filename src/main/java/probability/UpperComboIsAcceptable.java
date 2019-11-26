package probability;

import java.util.List;

public class UpperComboIsAcceptable implements IsAcceptAble {

  private DiceNumber diceNumber;
  private String diceAcceptSub;

  public UpperComboIsAcceptable(DiceNumber diceNumber) {
    this.diceNumber = diceNumber;
    diceAcceptSub = getDiceAcceptSub(diceNumber);
  }

  private String getDiceAcceptSub(DiceNumber pDiceNumber) {
    StringBuilder strbul = new StringBuilder();

    for (int i = 0; i <= 2; i++) {
      strbul.append(pDiceNumber.getValue());
    }
    return strbul.toString();
  }


  @Override
  public int isAny(List<DiceNumber> dices) {
    return ProbabilityHelper.numberOf(dices, diceNumber);
  }

  @Override
  public boolean isAcceptable(List<DiceNumber> dices) {
    String sorted = ProbabilityHelper.asSortedString(dices);
    return isAcceptable(sorted);
  }

  public boolean isAcceptable(String dicesAsSortedStr) {
    return dicesAsSortedStr.contains(diceAcceptSub);
  }

  private boolean hasAny(List<DiceNumber> dices) {
    return ProbabilityHelper.hasAny(dices, diceNumber);
  }
}
