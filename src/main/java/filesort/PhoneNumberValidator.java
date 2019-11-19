package filesort;

public class PhoneNumberValidator {

  private static final String IS_VALID_INPUT_REGEX = "(46|046){0,1}(0){0,1}7(0|2|3|6|9)[0-9]{7,10}";
  private static final String IS_VALID_OUTPUT_REGEX = "467(0|2|3|6|9)[0-9]{7,10}";

  /**
   * @param pCandidate Precondition that string only consists of digits
   * @return true if we not recognise that number starts with a known Swedish mobile operator number
   * followed by seven to ten digits or 46 followed by the above
   */
   static boolean isNotA_ValidMobilePhoneNumberInput(String pCandidate) {
    return !pCandidate.matches(IS_VALID_INPUT_REGEX);
  }

  static boolean isInMSISDN_Format(String pCandidate) {
    return pCandidate.matches(IS_VALID_OUTPUT_REGEX);
  }
}
