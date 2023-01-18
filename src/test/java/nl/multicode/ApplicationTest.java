package nl.multicode;


import nl.multicode.model.Person;
import nl.multicode.util.TestAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {

    private Application application;

    @BeforeEach
    public void setup() {

        application = new Application();
        TestAppender.clear();
    }

    @AfterEach
    public void tearDown() {

        TestAppender.clear();
    }

    @Test
    void test_empty_list() {

        final var result = application.getFilteredPersons(List.of(), 4, "e", 0);
        assertThat(result).isEmpty();
    }

    @Test
    void test_children() {

        final var result = application.getFilteredPersons(getPersonList(), 4, "e", 0);
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(4);
        assertThat(result.get(0).getName()).isEqualTo("Eric");
        assertThat(result.get(1).getName()).isEqualTo("Lawrence");
        assertThat(result.get(2).getName()).isEqualTo("Jitske");
        assertThat(result.get(3).getName()).isEqualTo("Henry");
    }

    @Test
    void test_no_children() {

        final var result = application.getFilteredPersons(getPersonList(), 20, "e", 0);
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getName()).isEqualTo("Jitske");
        assertThat(result.get(1).getName()).isEqualTo("Henry");
    }

    @Test
    void test_with_children() {

        final var result1child = application.getFilteredPersons(getPersonList(), 30, "a", 1);
        assertThat(result1child).hasSize(1);
        assertThat(result1child.get(0).getName()).isEqualTo("Eva");
        assertThat(result1child.get(0).getChildren()).hasSize(1);

        final var result2children = application.getFilteredPersons(getPersonList(), 30, "i", 2);
        assertThat(result2children).hasSize(2);
        assertThat(result2children.get(1).getName()).isEqualTo("Dipu");
        assertThat(result2children.get(1).getChildren()).hasSize(2);
        assertThat(result2children.get(0).getName()).isEqualTo("Jamie");
        assertThat(result2children.get(0).getChildren()).hasSize(2);

        final var result3children = application.getFilteredPersons(getPersonList(), 50, "a", 3);
        assertThat(result3children).hasSize(1);
        assertThat(result3children.get(0).getName()).isEqualTo("Maya");
        assertThat(result3children.get(0).getChildren()).hasSize(3);
    }

    private List<Person> getPersonList() {

        // CHILDREN
        final var juju = new Person("Juju", 3);
        final var gazal = new Person("Gazal", 10);
        final var lawrence = new Person("Lawrence", 13);
        final var eric = new Person("Eric", 15);
        final var latifa = new Person("Latifa", 18);
        final var bob = new Person("Bob", 21);

        // NO CHILDREN
        final var henry = new Person("Henry", 25);
        final var jitske = new Person("Jitske", 28);

        // WITH CHILDREN
        final var eva = new Person("Eva", 30, List.of(juju));
        final var dipu = new Person("Dipu", 37, List.of(gazal, lawrence));
        final var jamie = new Person("Jamie", 51, List.of(gazal, lawrence));
        final var bella = new Person("John", 58, List.of(eric));
        final var maya = new Person("Maya", 71, List.of(eric, latifa, bob));

        return List.of(
                bob,
                eva,
                eric,
                jamie,
                lawrence,
                maya,
                latifa,
                juju,
                gazal,
                dipu,
                jitske,
                bella,
                henry
        );
    }
}