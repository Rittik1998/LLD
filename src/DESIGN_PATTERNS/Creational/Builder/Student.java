package DESIGN_PATTERNS.Creational.Builder;

public class Student {
    private String name;
    private int age;
    private double weight;
    private double marks;
    private String address;

    Student(Builder builder){
        this.name = builder.getName();
        this.age = builder.getAge();
        this.weight = builder.getWeight();
        this.marks = builder.getMarks();
        this.address = builder.getAddress();
    }

    public static Builder getBuilder() {
        return new Builder();
    }
}
