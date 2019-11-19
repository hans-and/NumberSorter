package probability;

import java.util.List;

public interface CombinationProbabilityCalc {

  double getProbabilityAny(List<DiceNumber> keepers);

  double getProbabilityAcceptable(List<DiceNumber> keepers);


  int isAny(List<DiceNumber> keppers);

  int isAcceptable(List<DiceNumber> keppers);
}
