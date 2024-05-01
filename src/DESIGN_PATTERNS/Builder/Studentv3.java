package DESIGN_PATTERNS.Builder;

public class Studentv3 {
    private String name;
    private int age;
    private double weight;
    private double marks;
    private String address;

    private Studentv3(Builderv3 builder) {
        this.name = builder.getName();
        this.age = builder.getAge();
        this.weight = builder.getWeight();
        this.marks = builder.getMarks();
        this.address = builder.getAddress();
    }

    public static Builderv3 getBuilder(){
        return new Builderv3();
    }

    static class Builderv3{
        private String name;
        private int age;
        private double weight;
        private double marks;
        private String address;

        public Studentv3 build(){
            return new Studentv3(this);
        }
        public String getName() {
            return name;
        }

        public Builderv3 setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builderv3 setAge(int age) {
            this.age = age;
            return this;
        }

        public double getWeight() {
            return weight;
        }

        public Builderv3 setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public double getMarks() {
            return marks;
        }

        public Builderv3 setMarks(double marks) {
            this.marks = marks;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public Builderv3 setAddress(String address) {
            this.address = address;
            return this;
        }
    }
}
