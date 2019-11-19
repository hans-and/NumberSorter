package probability;

import java.util.List;

public class UpperComboCalc implements CombinationProbabilityCalc {

  private DiceNumber diceNumber;

  public UpperComboCalc(DiceNumber diceNumber) {
    this.diceNumber = diceNumber;
  }

  @Override
  public double getProbabilityAny(List<DiceNumber> keepers) {
    if (hasAny(keepers)) {
      return 1;
    } else {
      int dicesLeftToThrow = 5 - keepers.size();


      if( dicesLeftToThrow == 1 ){
        return 0.16666666666666666;
      }else if( dicesLeftToThrow == 2 ){
        return 0.3055555555555556;
      }else if( dicesLeftToThrow == 3 ){
        return 0.4212962962962963;
      }else if( dicesLeftToThrow == 4 ){
        return 0.5177469135802469;
      }else if( dicesLeftToThrow == 5 ){
        return 0.5981224279835391;
      }




    }
    return 0;

  }

  @Override
  public double getProbabilityAcceptable(List<DiceNumber> keepers) {
    return 0;
  }

  @Override
  public int isAny(List<DiceNumber> dices) {
    return ProbabilityHelper.numberOf(dices, diceNumber);
  }

  @Override
  public int isAcceptable(List<DiceNumber> dices) {
    int noOf = ProbabilityHelper.numberOf(dices, diceNumber);
    if (noOf > 2) {
      return noOf;
    } else {
      return 0;
    }
  }

  private boolean hasAny(List<DiceNumber> dices) {

    return ProbabilityHelper.hasAny(dices, diceNumber);
  }
}
