package probability;

import java.util.List;

public class PairAcceptable implements IsAcceptAble {

  @Override
  public int isAny(List<DiceNumber> keppers) {
    return 0;
  }

  @Override
  public boolean isAcceptable(List<DiceNumber> keppers) {
    return false;
  }


}
