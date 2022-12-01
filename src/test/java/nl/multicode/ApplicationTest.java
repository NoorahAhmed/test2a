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
    Application.main(new String[]{"validate", "bsn", "218996755"});
    assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains("218996755 is a valid bsn");
  }

  @Test
  void main_valid_bank() {
    Application.main(new String[]{"validate", "bank", "1015008577"});
    assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains("1015008577 is a valid bank");
  }

  @Test
  void main_invalid_bsn() {
    Application.main(new String[]{"validate", "bsn", "228996755"});
    assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains("228996755 is an invalid bsn");
  }

  @Test
  void main_invalid_bank() {
    Application.main(new String[]{"validate", "bank", "1115008577"});
    assertThat(TestAppender.getLogs(Level.INFO).get(0)).contains("1115008577 is an invalid bank");
  }

  @Test
  void main_generate_bsn() {
    Application.main(new String[]{"generate", "bsn"});
    assertThat(TestAppender.getLogs(Level.INFO).get(0).matches("^\\bgenerated :\\d{9}$")).isTrue();
  }  @Test
  void main_generate_bank() {
    Application.main(new String[]{"generate", "bank"});
    assertThat(TestAppender.getLogs(Level.INFO).get(0).matches("^\\bgenerated :\\d{10}$")).isTrue();
  }
}