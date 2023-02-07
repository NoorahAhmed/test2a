package nl.multicode;



import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import nl.multicode.util.TestAppender;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationTest {

  @BeforeEach
  public void setup() {

    TestAppender.clear();
  }

  @AfterEach
  public void tearDown() {

    TestAppender.clear();
  }

  @Test
  void main_valid_bsn() {
    Application.main(new String[]{ "218996755"});
    assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains("218996755 is a valid bsn");
  }

  @Test
  void main_invalid_bsn() {
    Application.main(new String[]{"228996755"});
    assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains("228996755 is an invalid bsn");
  }
}