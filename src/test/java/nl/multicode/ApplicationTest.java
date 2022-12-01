package nl.multicode;



import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationTest {

  public static final ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
  public static final PrintStream PS = new PrintStream(BAOS);
  public static final PrintStream OLD = System.out;

  @BeforeEach
  public void setup(){
    // Create a stream to hold the output
    System.setOut(PS);
    System.out.flush();
  }

  @AfterEach
  public void teardown(){
    System.setOut(OLD);
  }

  @Test
  void main_valid_bsn() {
    Application.main(new String[]{"validate", "bsn", "218996755"});
    assertThat(BAOS.toString()).contains("218996755 is a valid bsn");
  }

  @Test
  void main_valid_bank() {
    Application.main(new String[]{"validate", "bank", "1015008577"});
    assertThat(BAOS.toString()).contains("1015008577 is a valid bank");
  }

  @Test
  void main_invalid_bsn() {
    Application.main(new String[]{"validate", "bsn", "228996755"});
    assertThat(BAOS.toString()).contains("228996755 is an invalid bsn");
  }

  @Test
  void main_invalid_bank() {
    Application.main(new String[]{"validate", "bank", "1115008577"});
    assertThat(BAOS.toString()).contains("1115008577 is an invalid bank");
  }


}