package nl.multicode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        if (args[0] != null && args[1] != null) {
            if ("validate".equals(args[0]) && args[2] != null && (args[2].length() == 9 || args[2].length() == 10)) {
                boolean result = false;
                boolean finished = false;

                int[] m = new int[0];
                int j = 0;
                if ("bsn".equals(args[1]) && args[2].length() == 9) {
                    j = 9;
                    m = new int[]{9, 8, 7, 6, 5, 4, 3, 2, -1};
                } else if ("bank".equals(args[1]) && args[2].length() == 10) {
                    j = 10;
                    m = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
                } else {
                    finished = true;
                }
                if (!finished) {
                    int sum = 0;
                    for (int i = 0; i < j; i++) {
                        sum += Character.getNumericValue(args[2].toCharArray()[i]) * m[i];
                    }
                    result = (sum % 11 == 0);
                }

                if (result) {
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
                        boolean result = false;
                        boolean finished = false;
                        String[] args1 = new String[]{"validate", "bsn", randomNumber};

                        int[] m = new int[0];
                        int j = 0;
                        if ("bsn".equals(args1[1]) && args1[2].length() == 9) {
                            j = 9;
                            m = new int[]{9, 8, 7, 6, 5, 4, 3, 2, -1};
                        } else if ("bank".equals(args1[1]) && args1[2].length() == 10) {
                            j = 10;
                            m = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
                        } else {
                            finished = true;
                        }
                        if (!finished) {
                            int sum = 0;
                            for (int i = 0; i < j; i++) {
                                sum += Character.getNumericValue(args1[2].toCharArray()[i]) * m[i];
                            }
                            result = (sum % 11 == 0);
                        }

                        if (result) {
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
                        boolean result = false;
                        boolean finished = false;
                        String[] args1 = new String[]{"validate", "bank", randomNumber};

                        int[] m = new int[0];
                        int j = 0;
                        if ("bsn".equals(args1[1]) && args1[2].length() == 9) {
                            j = 9;
                            m = new int[]{9, 8, 7, 6, 5, 4, 3, 2, -1};
                        } else if ("bank".equals(args1[1]) && args1[2].length() == 10) {
                            j = 10;
                            m = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
                        } else {
                            finished = true;
                        }
                        if (!finished) {
                            int sum = 0;
                            for (int i = 0; i < j; i++) {
                                sum += Character.getNumericValue(args1[2].toCharArray()[i]) * m[i];
                            }
                            result = (sum % 11 == 0);
                        }

                        if (result) {
                            log.info("generated :" + randomNumber);
                            break;
                        }
                    }
                }
            }
        }
    }

}