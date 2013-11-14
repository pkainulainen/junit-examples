package net.petrikainulainen.junit.dsl;

/**
 * @author Petri Kainulainen
 */
public class Person {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private Person() {

    }

    public static PersonBuilder getBuilder(String firstName, String lastName) {
        return new PersonBuilder(firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class PersonBuilder {

        Person build;

        private PersonBuilder(String firstName, String lastName) {
            build = new Person();
            build.firstName = firstName;
            build.lastName = lastName;
        }

        public PersonBuilder email(String email) {
            build.email = email;
            return this;
        }

        public PersonBuilder id(Long id) {
            build.id = id;
            return this;
        }

        public Person build() {
            return build;
        }
    }
}
