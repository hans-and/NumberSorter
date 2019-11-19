package probability;

public enum DiceNumber {
  ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6)
  ;
  private int value;

  DiceNumber(int i) {
    value=i;
  }
  int getValue(){
    return value;
  }
}
