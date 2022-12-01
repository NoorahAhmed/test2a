package nl.multicode;

public class Application {


  public static final int[] BSN = new int[]{9, 8, 7, 6, 5, 4, 3, 2, -1};
  public static final int[] BANKACCOUNT = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

  public static void main(String[] args) {

    int j = 0;
    String t = null;
    int[] m;
    if (args[0] != null && args[1] != null && (args[1].length() == 9 || args[1].length() == 10)) {
      if ("bsn".equals(args[0]) && args[1].length() == 9) {
        j = 9;
        m = BSN;
        t = "bsn";
      } else if ("bank".equals(args[0]) && args[1].length() == 10) {
        j = 10;
        m = BANKACCOUNT;
        t = "bank account";
      } else {
        throw new IllegalArgumentException("wrong proof type");
      }

      int sum = 0;
      for (int i = 0; i < j; i++) {
        sum += Character.getNumericValue(args[1].toCharArray()[i]) * m[i];
      }
      if (sum % 11 == 0) {
        System.out.println(args[1] + " is a valid " + t);
      } else {
        System.out.println(args[1] + " is an invalid " + t);
      }
      return;
    }
    System.out.println(args[1] + " is an invalid " + t);
  }
}