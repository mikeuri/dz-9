package org.example;

public class Man extends Person {

    Man(String firstName, String lastName, int age, Person partner) {
        super(firstName, lastName, age, partner);
    }

    @Override
    public void registerPartnership(Person newPartner) {
        System.out.printf("Starting registration of new female partner %s for %s\n",
                newPartner.getFullName(), this.getFullName());
        if (getPartner() == null && newPartner.getPartner() == null) {
            setPartner(newPartner);
            newPartner.setPartner(this);
            if (newPartner.getClass() == Woman.class) {
                newPartner.setLastName(this.getLastName());
                System.out.printf("%s has registered new female partner %s (maiden name: %s)\n",
                        this.getFullName(), newPartner.getFullName(), newPartner.initLastName);
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
