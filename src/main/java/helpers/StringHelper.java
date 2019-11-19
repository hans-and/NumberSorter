package helpers;

public class StringHelper {
  public static final String keepOnlyDigits(String pMixedString) {
    return pMixedString.replaceAll("\\D","");
  }

}
