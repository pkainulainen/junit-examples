package net.petrikainulainen.junit.dsl;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

/**
 * @author Petri Kainulainen
 */
public class PersonAssert  extends GenericAssert<PersonAssert, Person> {

    protected PersonAssert(Person actual) {
        super(PersonAssert.class, actual);
    }

    public static PersonAssert assertThat(Person actual) {
        return new PersonAssert(actual);
    }

    public PersonAssert hasEmail(String email) {
        isNotNull();

        String errorMessage = String.format(
                "Expected email to be <%s> but was <%s>",
                email,
                actual.getEmail()
        );

        Assertions.assertThat(actual.getEmail())
                .overridingErrorMessage(errorMessage)
                .isEqualTo(email);

        return this;
    }

    public PersonAssert hasFirstName(String firstName) {
        isNotNull();

        String errorMessage = String.format(
                "Expected first name to be <%s> but was <%s>",
                firstName,
                actual.getFirstName()
        );

        Assertions.assertThat(actual.getFirstName())
                .overridingErrorMessage(errorMessage)
                .isEqualTo(firstName);

        return this;
    }

    public PersonAssert hasId(Long id) {
        isNotNull();

        String errorMessage = String.format(
                "Expected id to be <%d> but was <%d>",
                id,
                actual.getId()
        );

        Assertions.assertThat(actual.getId())
                .overridingErrorMessage(errorMessage)
                .isEqualTo(id);

        return this;
    }

    public PersonAssert hasLastName(String lastName) {
        isNotNull();

        String errorMessage = String.format(
                "Expected last name to be <%s> but was <%s>",
                lastName,
                actual.getLastName()
        );

        Assertions.assertThat(actual.getLastName())
                .overridingErrorMessage(errorMessage)
                .isEqualTo(lastName);

        return this;
    }
}
