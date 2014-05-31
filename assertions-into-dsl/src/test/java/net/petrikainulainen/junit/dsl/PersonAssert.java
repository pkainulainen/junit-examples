package net.petrikainulainen.junit.dsl;

import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Petri Kainulainen
 */
public class PersonAssert extends AbstractAssert<PersonAssert, Person> {

    private PersonAssert(Person actual) {
        super(actual, PersonAssert.class);
    }

    public static PersonAssert assertThatPerson(Person actual) {
        return new PersonAssert(actual);
    }

    public PersonAssert hasEmail(String email) {
        isNotNull();

        assertThat(actual.getEmail())
                .overridingErrorMessage("Expected email to be <%s> but was <%s>",
                        email,
                        actual.getEmail()
                )
                .isEqualTo(email);

        return this;
    }

    public PersonAssert hasFirstName(String firstName) {
        isNotNull();

        assertThat(actual.getFirstName())
                .overridingErrorMessage("Expected first name to be <%s> but was <%s>",
                        firstName,
                        actual.getFirstName()
                )
                .isEqualTo(firstName);

        return this;
    }

    public PersonAssert hasId(Long id) {
        isNotNull();

        assertThat(actual.getId())
                .overridingErrorMessage( "Expected id to be <%d> but was <%d>",
                        id,
                        actual.getId()
                )
                .isEqualTo(id);

        return this;
    }

    public PersonAssert hasLastName(String lastName) {
        isNotNull();

        assertThat(actual.getLastName())
                .overridingErrorMessage( "Expected last name to be <%s> but was <%s>",
                        lastName,
                        actual.getLastName()
                )
                .isEqualTo(lastName);

        return this;
    }
}
