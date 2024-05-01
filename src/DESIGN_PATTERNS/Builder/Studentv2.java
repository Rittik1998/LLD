package DESIGN_PATTERNS.Builder;

public class Studentv2 {
    private String name;
    private int age;
    private double weight;
    private double marks;
    private String address;

    private Studentv2(Builderv2 builder) {
        this.name = builder.getName();
        this.age = builder.getAge();
        this.weight = builder.getWeight();
        this.marks = builder.getMarks();
        this.address = builder.getAddress();
    }

    public static Builderv2 getBuilder(){
        return new Builderv2();
    }

    static class Builderv2{
        private String name;
        private int age;
        private double weight;
        private double marks;
        private String address;

        public Studentv2 build(){
            return new Studentv2(this);
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getMarks() {
            return marks;
        }

        public void setMarks(double marks) {
            this.marks = marks;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
