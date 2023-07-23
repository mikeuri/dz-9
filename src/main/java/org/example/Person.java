package org.example;

public abstract class Person {
    private final String firstName;
    private String lastName;
    final String initLastName;
    private final int age;
    private Person partner;
    final String gender;

    Person (String firstName, String lastName, int age, Person partner) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.initLastName = lastName;
        this.age = age;

        if (this.getClass() == Man.class) {
            gender = "male";
        } else {
            gender = "female";
        }

        this.partner = partner;
        System.out.printf("New %s %s was added\n",gender, getFullName());

        if (partner != null) {
            partner.setPartner(this);
            System.out.printf("Partner %s was registered for %s during initialisation\n",
                    partner.getFullName(), getFullName());
        }
        System.out.println("----------------------------------------------------------------------------");
    }

    public int getAge() {
        return age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return this.firstName + " " + lastName;
    }

    //considered not to implement this method as abstract because the logic is quite simple,
    // and implementing it separately for Man and Woman will double the code
    public boolean isRetired() {
        if (this.getClass() == Man.class) {
            return this.age >= 65;
        } else {
            return this.age >= 60;
        }
    }

    public Person getPartner() {
        return partner;
    }

    void setPartner(Person newPartner) {
        this.partner = newPartner;
    }

    public abstract void registerPartnership(Person newPartner);

    //considered not to implement this method as abstract because the logic is quite simple,
    // and implementing it separately for Man and Woman will double the code
    public void deRegisterPartnership(boolean revertName) {
        if (revertName) {
            System.out.printf("Starting deregistration of partner %s for %s with reverting name\n",
                    this.partner.getFullName(), this.getFullName());
            if (this.getClass() == Woman.class) {
                this.lastName = this.initLastName;
            } else {
            this.partner.lastName = this.partner.initLastName;
            }
        } else {
            System.out.printf("Starting deregistration of partner %s for %s without reverting name\n",
                    this.partner.getFullName(), this.getFullName());
        }
        this.partner.partner = null;
        this.partner = null;
    }
}
