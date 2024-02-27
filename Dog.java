public class Dog extends RescueAnimal {  // Dog inherits from RescueAnimal.
    // This attribute is specific to Dog, and it pulls all other attributes from its superclass.
    private String breed;

    // Overloaded constructor.
    public Dog(String name, String breed, String gender, String age, String weight, String acquisitionDate,
               String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    public String getBreed() {  // Accessor
        return breed;
    }

    public void setBreed(String dogBreed) {  // Mutator
        this.breed = dogBreed;  // "this." is used to call the private field specifically from Dog.
    }
}
