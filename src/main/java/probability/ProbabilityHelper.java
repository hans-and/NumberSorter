package probability;

import java.util.Collection;
import java.util.List;

public class ProbabilityHelper {

  static boolean isEmptyOrNull(Collection c){
    return c==null||c.isEmpty();
  }

  static boolean hasAny(List<DiceNumber> candidates, DiceNumber number){
    if (isEmptyOrNull(candidates)){
      return false;
    }
    for (DiceNumber dice : candidates) {
      if (dice==number){
        return true;
      }
    }
    return false;
  }
  static boolean hasExactly(List<DiceNumber> candidates, DiceNumber number,int numberToMatch){
    int matches=0;
    for (DiceNumber dice : candidates) {
      if (dice==number){
        matches++;
      }
    }
    return matches==numberToMatch;
  }

  static int sumOf(List<DiceNumber> candidates, DiceNumber number){
    int sum=0;
    for (DiceNumber dice : candidates) {
      if (dice==number){
        sum=sum+number.getValue();
      }
    }
    return sum;
  }

  static int numberOf(List<DiceNumber> candidates, DiceNumber number){
    int numberOf=0;
    for (DiceNumber dice : candidates) {
      if (dice==number){
        numberOf++;
      }
    }
    return numberOf;
  }

  static boolean hasMoreThan(List<DiceNumber> candidates, DiceNumber number,int minToMatch){
    int matches=0;
    for (DiceNumber dice : candidates) {
      if (dice==number){
        matches++;
      }
    }
    return matches>=minToMatch;
  }
}
