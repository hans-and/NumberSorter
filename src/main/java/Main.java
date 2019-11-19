import filesort.PhoneNumberSorter;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    if(args==null||args.length!=2){
      throw new RuntimeException("Number sorter must be run with arguments: pSourceFilePath,String pDestinationFilePath. Exemple: kunder.txt, duplicateReport.txt");
    }
    PhoneNumberSorter phoneNumberSorter = new PhoneNumberSorter();
    phoneNumberSorter.createOrderedDuplicateNumberReport(args[0],args[1]);
  }


}
