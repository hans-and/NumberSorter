package helpers;

import static helpers.StringHelper.keepOnlyDigits;
import static junit.framework.TestCase.assertTrue;
import org.junit.Test;

public class StringHelperTest {

  @Test
  public void testKeepOnlyDigits() {
    assertTrue(keepOnlyDigits("87897koku#-_*+-7987").equals("878977987"));


  }
}
