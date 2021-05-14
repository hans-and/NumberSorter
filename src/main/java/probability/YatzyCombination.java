package probability;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public enum YatzyCombination {
   ONES(new UpperComboIsAcceptable(DiceNumber.ONE)), TWOS(new UpperComboIsAcceptable(DiceNumber.TWO)), THREES(new UpperComboIsAcceptable(DiceNumber.THREE)), FOURS(
            new UpperComboIsAcceptable(DiceNumber.FOUR)), FIVES(new UpperComboIsAcceptable(DiceNumber.FIVE)), SIXES(new UpperComboIsAcceptable(DiceNumber.SIX));

   private IsAcceptAble calcylator;

   YatzyCombination(IsAcceptAble internalCalc)
   {
      calcylator = internalCalc;

   }

   public int isAny(List<DiceNumber> keppers)
   {
      return calcylator.isAny(keppers);
   }

   public boolean isAcceptable(List<DiceNumber> keppers)
   {
      return calcylator.isAcceptable(keppers);
   }

   public static void printSubsets()
   {
      YatzyCombination set[] = YatzyCombination.values();
      int n = set.length;

      // Run a loop for printing all 2^n
      // subsets one by obe
      for (int i = 0; i < (1 << n); i++)
      {
         System.out.print("{ ");

         // Print current subset
         for (int j = 0; j < n; j++)

            // (1<<j) is a number with jth bit 1
            // so when we 'and' them with the
            // subset number we get which numbers
            // are present in the subset and which
            // are not
            if ((i & (1 << j)) > 0) System.out.print(set[j] + " ");

         System.out.println("}");
      }
   }

   public static void printSubsets2()
   {
//      Comparator<Developer> byName = new Comparator<Developer>() {
//         @Override
//         public int compare(Developer o1, Developer o2) {
//            return o1.getName().compareTo(o2.getName());
//         }
//      };
//      Set<Set<YatzyCombination>> result = new TreeSet<>((Set<YatzyCombination> o1, Set<YatzyCombination> o2)->o1.));
      Set<Set<YatzyCombination>> result = new HashSet<Set<YatzyCombination>>();
      YatzyCombination set[] = YatzyCombination.values();
      int n = set.length;

      // Run a loop for printing all 2^n
      // subsets one by obe
      for (int i = 0; i < (1 << n); i++)
      {
         System.out.print("{ ");
         Set<YatzyCombination> subset = new TreeSet<>();
         // Print current subset
         for (int j = 0; j < n; j++)
         {
            // (1<<j) is a number with jth bit 1
            // so when we 'and' them with the
            // subset number we get which numbers
            // are present in the subset and which
            // are not
            if ((i & (1 << j)) > 0)
            {
               System.out.print(set[j] + " ");
               subset.add(set[j]);
            }
         }
         result.add(subset);
         System.out.println("}");
      }

      result.forEach(yatzyComboSet -> {
         System.out.print("{ ");
         yatzyComboSet.forEach(actionyatzyCombo -> {

            System.out.print(actionyatzyCombo + " ");

         });
         System.out.println("}");
      });
   }

   public static void printAllSubsets(YatzyCombination set[])
   {
      Set<Set<YatzyCombination>> all = getAllSubsets();
      all.forEach(yatzyComboSet -> {
         yatzyComboSet.forEach(actionyatzyCombo -> {
//            System.out.print("{ ");
//            System.out.print(actionyatzyCombo + " ");
//            System.out.println("}");
         });
      });

      int n = set.length;

      // Run a loop for printing all 2^n
      // subsets one by obe
      for (int i = 0; i < (1 << n); i++)
      {
         System.out.print("{ ");
         Set<YatzyCombination> subset = new HashSet<>();
         // Print current subset
         for (int j = 0; j < n; j++)

            // (1<<j) is a number with jth bit 1
            // so when we 'and' them with the
            // subset number we get which numbers
            // are present in the subset and which
            // are not
            if ((i & (1 << j)) > 0) System.out.print(set[j] + " ");

         System.out.println("}");
      }
   }

   public static Set<Set<YatzyCombination>> getAllSubsets()
   {
      YatzyCombination set[] = YatzyCombination.values();
      Set<Set<YatzyCombination>> result = new HashSet<>();
      int n = set.length;

      // Run a loop for printing all 2^n
      // subsets one by obe
      for (int i = 0; i < (1 << n); i++)
      {
         Set<YatzyCombination> subset = new HashSet<>();

         // Print current subset
         for (int j = 0; j < n; j++)
            if ((i & (1 << j)) > 0) subset.add(set[j]);

         // (1<<j) is a number with jth bit 1
         // so when we 'and' them with the
         // subset number we get which numbers
         // are present in the subset and which
         // are not

      }
      return result;
   }

}
