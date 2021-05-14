package helpers;

import static helpers.StringHelper.*;
import static junit.framework.TestCase.assertTrue;
import org.junit.Test;

public class StringHelperTest {

  @Test
  public void testKeepOnlyDigits() {
    assertTrue(keepOnlyDigits("87897koku#-_*+-7987").equals("878977987"));


  }
  
  @Test
  public void testSplitCamelCaps() {
     String[] split = splitCamelCase("101KatterIRad");
     
    assertTrue(split.length > 0);


  }
}

