public class Monkey extends RescueAnimal {  // Monkey inherits from RescueAnimal.
    // These attributes are specific to Monkey, and it pulls all other attributes from its superclass.
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;

    // Overloaded constructor requires parameters and sets all fields to desired values in one call.
    public Monkey(String name, String species, String tailLength, String height, String bodyLength,
                  String gender, String age, String weight, String acquisitionDate,
                  String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry) {
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    public String getTailLength() {  // Accessor that "gets" or returns the value of a private field.
        return tailLength;
    }

    public void setTailLength(String newTailLength) {  // Mutator that "sets" or assigns the value of a private field.
        this.tailLength = newTailLength;  // "this." is used to call private fields specifically from Monkey.
    }

    public String getHeight() {  // Accessor
        return height;
    }

    public void setHeight(String newHeight) {  // Mutator
        this.height = newHeight;
    }

    public String getBodyLength() {  // Accessor
        return bodyLength;
    }

    public void setBodyLength(String newBodyLength) {  // Mutator
        this.bodyLength = newBodyLength;
    }

    public String getSpecies() {  // Accessor
        return species;
    }

    public void setSpecies(String newSpecies) {  // Mutator
        this.species = newSpecies;
    }
}
