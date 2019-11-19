package filesort;

import static filesort.PhoneNumberValidator.isInMSISDN_Format;

public class PhoneNumberNormalizer {

  /**
   * Normalizes the number to MSISDN format
   * @param phoneNumber Precondition assumes that param checked with isNotA_ValidMobilePhoneNumberInput
   * @see PhoneNumberValidator#isNotA_ValidMobilePhoneNumberInput(String)
   */
   static Long mixedNumberFormat2MSISDN_Form(String phoneNumber) {

    String strResult;

    if (phoneNumber.startsWith("0460")) {
      strResult = "46" + phoneNumber.substring(4);
    } else if (phoneNumber.startsWith("460")) {
      strResult = "46" + phoneNumber.substring(3);
    } else if (phoneNumber.startsWith("46")) {
      strResult = phoneNumber;
    } else if (phoneNumber.startsWith("0")) {
      strResult = "46" + phoneNumber.substring(1);
    } else {
      strResult = "46" + phoneNumber;
    }

    if (!isInMSISDN_Format(strResult)) {
      throw new RuntimeException(
          "Unexpected exception failed to normalize: " + phoneNumber + " result: " + strResult
              + " is Not On valid");
    }
    return new Long(strResult);


  }

}
