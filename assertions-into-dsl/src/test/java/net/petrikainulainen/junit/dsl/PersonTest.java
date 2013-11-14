package net.petrikainulainen.junit.dsl;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
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
    public void build_FESTAssert()  {
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
    public void build_FESTAssert_CustomMessages() {
        Person person = Person.getBuilder("Foo", "Bar")
                .email("foo.bar@email.com")
                .id(1L)
                .build();

        String idMessage = String.format("Expected id to be <%d> but was <%d>", 1L, person.getId());
        assertThat(person.getId())
                .overridingErrorMessage(idMessage)
                .isEqualTo(1L);

        String firstNameMessage = String.format("Expected firstName to be <%s> but was <%s>", "Foo", person.getFirstName());
        assertThat(person.getFirstName())
                .overridingErrorMessage(firstNameMessage)
                .isEqualTo("Foo");

        String lastNameMessage = String.format("Expected lastName to be <%s> but was <%s>", "Bar", person.getLastName());
        assertThat(person.getLastName())
                .overridingErrorMessage(lastNameMessage)
                .isEqualTo("Bar");

        String emailMessage = String.format("Expected email to be <%s> but was <%s>", "foo.bar@email.com", person.getEmail());
        assertThat(person.getEmail())
                .overridingErrorMessage(emailMessage)
                .isEqualTo("foo.bar@email.com");
    }

    @Test
    public void build_FESTAssert_DSL() {
        Person person = Person.getBuilder("Foo", "Bar")
                .email("foo.bar@email.com")
                .id(1L)
                .build();

        PersonAssert.assertThat(person)
                .hasId(1L)
                .hasFirstName("Foo")
                .hasLastName("Bar")
                .hasEmail("foo.bar@email.com");
    }
}
