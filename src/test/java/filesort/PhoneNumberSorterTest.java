package filesort;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static testhelpers.FileArgsHelper.getTestArgs;

public class PhoneNumberSorterTest {

  @Test
  public void createOrderedDuplicateNumberReport() throws URISyntaxException, IOException {
    String[] args = getTestArgs();
    PhoneNumberSorter sorter = new PhoneNumberSorter();
    sorter.createOrderedDuplicateNumberReport(args[0],args[1]);
    File destination =  new File(args[1]);
    assertTrue(destination.exists());

    if(destination.exists()){
      destination.delete();
    }

  }

}
