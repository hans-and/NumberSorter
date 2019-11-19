package probability;

import static probability.DiceOutcomePossibilitiesInitiator.getAllPossibleOutcomesForNoOfDices;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DiceProbabilityCalc {

  private List<List<DiceNumber>> possibleOutcomes1 = getAllPossibleOutcomesForNoOfDices(1);
  private List<List<DiceNumber>> possibleOutcomes2 = getAllPossibleOutcomesForNoOfDices(2);
  private List<List<DiceNumber>> possibleOutcomes3 = getAllPossibleOutcomesForNoOfDices(3);
  private List<List<DiceNumber>> possibleOutcomes4 = getAllPossibleOutcomesForNoOfDices(4);
  private List<List<DiceNumber>> possibleOutcomes5 = getAllPossibleOutcomesForNoOfDices(5);

  public static double calc(int noOfDices) {

    List<List<DiceNumber>> possibleOutcomes = getAllPossibleOutcomesForNoOfDices(noOfDices);
    possibleOutcomes.forEach(preDices -> {
      System.out.println(preDices);
    });

    return 0;
  }

  public double probabilityOfAnyOfFour(
  ) {
    AtomicInteger i= new AtomicInteger();
    possibleOutcomes1.forEach(outcome->{
      if(YatzyCombination.TWOS.isAny(outcome)>0){
        i.getAndIncrement();
      }
    });
    double anys = i.get();
    double totOutcomes = possibleOutcomes1.size();
    return  anys/ totOutcomes;
  }


}
