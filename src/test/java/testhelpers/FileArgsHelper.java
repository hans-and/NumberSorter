package testhelpers;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class FileArgsHelper {
  public static String[] getTestArgs() throws URISyntaxException {
    return new FileArgsHelper().internalGetTestArgs();
  }
  private String[] internalGetTestArgs() throws URISyntaxException {
    File source = new File(getClass().getClassLoader().getResource("kunder.txt").toURI());
    File destination = new File(
        Paths.get(source.getParent(), "dubplicateReport" + source.getName()).toString());
    return toArgsArray(source.getPath(), destination.getPath());
  }

  private static String[] toArgsArray(String... args) {
    return args;
  }
}
