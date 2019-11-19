package filesort;

import static filesort.PhoneNumberNormalizer.mixedNumberFormat2MSISDN_Form;
import static filesort.PhoneNumberValidator.isNotA_ValidMobilePhoneNumberInput;
import static helpers.StringHelper.keepOnlyDigits;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

public class PhoneNumberSorter {

  private HashSet<Long> fAllNumbers = new HashSet<>();
  private SortedMap<Long, AtomicLong> fDuplicates = new TreeMap<>();

  /**
   * Takes a file with phone numbers and finds duplicates. Creates a new "report file" and puts
   * any duplicates in the new file. In the format +460721234567;2 where the second column is number
   * of occurrences
   * @param pSourceFilePath File with duplicate candidates
   * @param pDestinationFilePath Destination of the report file
   */
  public void createOrderedDuplicateNumberReport(String pSourceFilePath,
      String pDestinationFilePath)
      throws IOException {
    initalize();
    handleEachLineInFile(pSourceFilePath);
    writeDuplicatesToFile(pDestinationFilePath);
  }

  private void writeDuplicatesToFile(String pDestinationFilePath) throws FileNotFoundException {
    try (PrintWriter writer = new PrintWriter(new File(pDestinationFilePath))) {
      fDuplicates.keySet().forEach(key -> writer.println("+" + key + ":" + fDuplicates.get(key)));
    }
  }

  private void initalize() {
    fAllNumbers.clear();
    fDuplicates.clear();
  }

  private void handleEachLineInFile(String pSourceFilePath) throws IOException {
    Files.lines(new File(pSourceFilePath).toPath()).map(phoneNumberLine -> phoneNumberLine.trim())
        .filter(phoneNumberLine -> !phoneNumberLine.isEmpty())
        .forEach(phoneNumberLine -> handlePhoneNumberLine(phoneNumberLine));
  }

  /**
   * Check that the line read from the file is a valid mobile number. If so normalizes it so that
   * same numbers in different formats can be recognized as duplicates and sorts the normalized
   * numbers into allNumbers and duplicates
   */
  private void handlePhoneNumberLine(String phoneNumberLine) {
    String onlyDigits = keepOnlyDigits(phoneNumberLine);
    if (isNotA_ValidMobilePhoneNumberInput(onlyDigits)) {
      System.out
          .println("Warning: " + phoneNumberLine + " can not be \"normalized\" to MSISDN Form");
      return;
    }

    Long number = mixedNumberFormat2MSISDN_Form(onlyDigits);

    if (!fAllNumbers.add(number)) {
      if (fDuplicates.keySet().contains(number)) {
        fDuplicates.get(number).incrementAndGet();
      } else {
        fDuplicates.put(number, new AtomicLong(2));
      }
    }
  }


}
