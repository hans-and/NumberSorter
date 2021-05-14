package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class StringHelper {
  public static final String keepOnlyDigits(String pMixedString) {
    return pMixedString.replaceAll("\\D","");
  }

  private static final String CAMEL_CAPS = "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])";
  
  
  
  public static String[] splitCamelCase(String s){
     return s.split(CAMEL_CAPS);
  }
  
  public void parse(File file) throws FileNotFoundException, IOException {
     try(FileReader reader = new FileReader(file)){
        CSVParser parser = CSVFormat.DEFAULT.parse(reader);
        parser.forEach(record->parseRecord(record));
     }
     
        
  }
  
  
  
  private Object parseRecord(CSVRecord record)
{
    String col = record.get("");
   return null;
}

public static String toCamelCase(String s){
     String[] parts = s.split("-");
     String camelCaseString = "";
     for (String part : parts){
        camelCaseString = camelCaseString + toProperCase(part);
     }
    // System.out.println(camelCaseString);
     return camelCaseString;
  }

  private static String toProperCase(String s) {
      return s.substring(0, 1).toUpperCase() +
                 s.substring(1).toLowerCase();
  }
}
