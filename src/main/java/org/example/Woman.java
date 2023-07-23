package org.example;

public class Woman extends Person{

    Woman(String firstName, String lastName, int age, Person partner) {
        super(firstName, lastName, age, partner);
    }

    @Override
    public void registerPartnership(Person newPartner) {
        System.out.printf("Starting registration of new male partner %s for %s\n",
                newPartner.getFullName(), this.getFullName());
        if (getPartner() == null && newPartner.getPartner() == null) {
            setPartner(newPartner);
            newPartner.setPartner(this);
            if (newPartner.getClass() == Man.class) {
                setLastName(newPartner.getLastName());
                System.out.printf("%s (maiden name: %s) has registered new male partner %s\n",
                        getFullName(), initLastName, newPartner.getFullName());
            } else {
                System.out.printf("ERROR: this action cannot be performed for %s and %s\n",
                        this.getFullName(), newPartner.getFullName());
                System.out.println("INFO: Two persons must be opposite gender");
            }
        } else {
            System.out.printf("ERROR: this action cannot be performed for %s and %s\n",
                    this.getFullName(), newPartner.getFullName());
            System.out.println("INFO: Two persons must have no other partners");
        }
    }
}
