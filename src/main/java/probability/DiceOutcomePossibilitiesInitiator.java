package probability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DiceOutcomePossibilitiesInitiator {
  public static List<List<DiceNumber>> getAllPossibleOutcomesForNoOfDices(int noOfDices ){
    return  intAllPossibleOutcomesForNoOfDices(noOfDices ,new ArrayList<List<DiceNumber>>());
  }

  private static List<List<DiceNumber>> intAllPossibleOutcomesForNoOfDices(int noOfDices ,List<List<DiceNumber>> possibleOutcomes){

    if(possibleOutcomes.size()==0){
      int lNoOfDices = doInitialDiceFill(noOfDices, possibleOutcomes);
      return intAllPossibleOutcomesForNoOfDices(lNoOfDices,possibleOutcomes);
    }else if(noOfDices>0){
      int lNoOfDices = addMultipleOfDiceNumbersToPossibleOutcome(noOfDices, possibleOutcomes);
      return intAllPossibleOutcomesForNoOfDices(lNoOfDices,possibleOutcomes);
    }else{
      Collections.sort(possibleOutcomes, new Comparator<List<DiceNumber>>() {
        @Override
        public int compare(List<DiceNumber> o1, List<DiceNumber> o2) {
          int res = 0;
          int i= 0;
          for (DiceNumber diceNumber : o1) {
            DiceNumber diceNumber2 = o2.get(i);
            res=diceNumber.compareTo(diceNumber2);
            if (res != 0) {
              return res;
            }
            i++;
          }

          return 0;
        }
      });
      return possibleOutcomes;
    }

  }

  private static int addMultipleOfDiceNumbersToPossibleOutcome(int noOfDices,
      List<List<DiceNumber>> possibleOutcomes) {
    List<List<DiceNumber>> tmp=new ArrayList<>();
    possibleOutcomes.forEach(preDices->{
          for (DiceNumber diceNumber : DiceNumber.values()) {

            ArrayList<DiceNumber> outCome = new ArrayList<DiceNumber>();
            outCome.add(diceNumber);
            outCome.addAll(preDices);
            tmp.add(outCome);
          }
        }

    );
    possibleOutcomes.clear();
    possibleOutcomes.addAll(tmp);
    return noOfDices-1;
  }

  private static int doInitialDiceFill(int noOfDices, List<List<DiceNumber>> possibleOutcomes) {
    for (DiceNumber diceNumber : DiceNumber.values()) {
      ArrayList<DiceNumber> outCome = new ArrayList<DiceNumber>();
      outCome.add(diceNumber);
      possibleOutcomes.add(outCome);
    }
    return noOfDices-1;
  }

}
