package nl.multicode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

  private static final Logger log = LogManager.getLogger(Application.class);


  public static final int[] BSN = new int[]{9, 8, 7, 6, 5, 4, 3, 2, -1};
  public static final int[] BA = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

  public static void main(String[] args) {

    if (args[0] != null && args[1] != null) {
      if ("validate".equals(args[0]) && args[2] != null && (args[2].length() == 9 || args[2].length() == 10)) {
        if (validate(args)) {
          log.info(args[2] + " is a valid " + args[1]);
        } else {
          log.info(args[2] + " is an invalid " + args[1]);
        }
      } else if ("generate".equals(args[0])) {
        if ("bsn".equals(args[1])) {
          int l = 9;
          while (true) {

            String n = "";
            for (int i = 0; i < l; i++) {
              n += (int) Math.floor(Math.random() * (9 - 0 + 1) + 0);
            }
            String randomNumber = n;
            if (validate(new String[]{"validate", "bsn", randomNumber})) {
              log.info("generated :" + randomNumber);
              break;
            }
          }
        } else if ("bank".equals(args[1])) {
          int l = 10;
          while (true) {

            String n = "";
            for (int i = 0; i < l; i++) {
              n += (int) Math.floor(Math.random() * (9 - 0 + 1) + 0);
            }
            String randomNumber = n;
            if (validate(new String[]{"validate", "bank", randomNumber})) {
              log.info("generated :" + randomNumber);
              break;
            }
          }
        }
      }
    }
  }

  private static boolean validate(String[] args) {

    int[] m;
    String t;
    int j;
    if ("bsn".equals(args[1]) && args[2].length() == 9) {
      j = 9;
      m = BSN;
    } else if ("bank".equals(args[1]) && args[2].length() == 10) {
      j = 10;
      m = BA;
    } else {
      return false;
    }

    int sum = 0;
    for (int i = 0; i < j; i++) {
      sum += Character.getNumericValue(args[2].toCharArray()[i]) * m[i];
    }
    return (sum % 11 == 0);
  }
}