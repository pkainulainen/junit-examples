package net.petrikainulainen.junit.dsl;

import org.junit.Test;

import static net.petrikainulainen.junit.dsl.PersonAssert.assertThatPerson;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * @author Petri Kainulainen
 */
public class PersonTest {

    @Test
    public void build_JUnitAssertions() {
        Person person = Person.getBuilder("Foo", "Bar")
                .email("foo.bar@email.com")
                .id(1L)
                .build();

        assertEquals(1L, person.getId().longValue());
        assertEquals("Foo", person.getFirstName());
        assertEquals("Bar", person.getLastName());
        assertEquals("foo.bar@email.com", person.getEmail());
    }

    @Test
    public void build_AssertJ()  {
        Person person = Person.getBuilder("Foo", "Bar")
                .email("foo.bar@email.com")
                .id(1L)
                .build();

        assertThat(person.getId()).isEqualTo(1L);
        assertThat(person.getFirstName()).isEqualTo("Foo");
        assertThat(person.getLastName()).isEqualTo("Bar");
        assertThat(person.getEmail()).isEqualTo("foo.bar@email.com");
    }

    @Test
    public void build_AssertJ_CustomMessages() {
        Person person = Person.getBuilder("Foo", "Bar")
                .email("foo.bar@email.com")
                .id(1L)
                .build();

        assertThat(person.getId())
                .overridingErrorMessage("Expected id to be <%d> but was <%d>",
                        1L,
                        person.getId()
                )
                .isEqualTo(1L);

        assertThat(person.getFirstName())
                .overridingErrorMessage("Expected firstName to be <%s> but was <%s>",
                        "Foo",
                        person.getFirstName()
                )
                .isEqualTo("Foo");

        assertThat(person.getLastName())
                .overridingErrorMessage("Expected lastName to be <%s> but was <%s>",
                        "Bar",
                        person.getLastName()
                )
                .isEqualTo("Bar");

        assertThat(person.getEmail())
                .overridingErrorMessage(
                        "Expected email to be <%s> but was <%s>",
                        "foo.bar@email.com",
                        person.getEmail()
                )
                .isEqualTo("foo.bar@email.com");
    }

    @Test
    public void build_AssertJ_DSL() {
        Person person = Person.getBuilder("Foo", "Bar")
                .email("foo.bar@email.com")
                .id(1L)
                .build();

        assertThatPerson(person)
                .hasId(1L)
                .hasFirstName("Foo")
                .hasLastName("Bar")
                .hasEmail("foo.bar@email.com");
    }
}
