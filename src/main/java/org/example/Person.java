package org.example;

public abstract class Person {
    private final String firstName;
    private String lastName;
    final String initLastName;
    private final int age;
    private Person partner;

    Person (String firstName, String lastName, int age, Person partner) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.initLastName = lastName;
        this.age = age;

        this.partner = partner;
        System.out.printf("New %s %s was added\n", getGender(), getFullName());

        if (partner != null) {
            partner.setPartner(this);
            System.out.printf("Partner %s was registered for %s during initialisation\n",
                    partner.getFullName(), getFullName());
            setNewLastName(partner);
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

    public abstract boolean isRetired();

    public Person getPartner() {
        return partner;
    }

    void setPartner(Person newPartner) {
        this.partner = newPartner;
    }

    public abstract String getGender();

    public abstract void setNewLastName(Person newPartner);

    public abstract void revertName();

    public void registerPartnership(Person newPartner) {
        System.out.printf("Starting registration of new %s partner %s for %s\n",
                newPartner.getGender(), newPartner.getFullName(), this.getFullName());
        if (getPartner() == null && newPartner.getPartner() == null
                && !this.getGender().equals(newPartner.getGender())) {
            setPartner(newPartner);
            newPartner.setPartner(this);
            setNewLastName(newPartner);
        } else if (getPartner() != null || newPartner.getPartner() != null) {
            System.out.printf("ERROR: this action cannot be performed for %s and %s\n",
                    this.getFullName(), newPartner.getFullName());
            System.out.println("INFO: Two persons must have no other partners");
        } else {
            System.out.printf("ERROR: this action cannot be performed for %s and %s\n",
                    this.getFullName(), newPartner.getFullName());
            System.out.println("INFO: Two persons must be opposite gender");
        }
    }

    public void deRegisterPartnership(boolean isRevertNameRequested) {
        if (isRevertNameRequested) {
            System.out.printf("Starting deregistration of partner %s for %s with reverting name\n",
                    this.partner.getFullName(), this.getFullName());
            revertName();
        } else {
            System.out.printf("Starting deregistration of partner %s for %s without reverting name\n",
                    this.partner.getFullName(), this.getFullName());
        }
        this.partner.partner = null;
        this.partner = null;
    }
}
