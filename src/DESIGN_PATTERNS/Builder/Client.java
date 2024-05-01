package DESIGN_PATTERNS.Builder;

public class Client {
    public static void main(String[] args) {

        //v1
        Builder builder = new Builder();

        builder.setName("Rittik");
        builder.setAge(25);
        builder.setWeight(80);
        builder.setAddress("Bangalore");
        builder.setMarks(98);

        Student s = new Student(builder);

        //v2
        Builder builder1 = Student.getBuilder();

        builder1.setName("Rittik");
        builder1.setAge(25);
        builder1.setWeight(80);
        builder1.setAddress("Bangalore");
        builder1.setMarks(98);

        Student s1 = new Student(builder1);

        //v3
        Studentv2.Builderv2 builder2 = Studentv2.getBuilder();

        builder2.setName("Rittik");
        builder2.setAge(25);
        builder2.setWeight(80);
        builder2.setAddress("Bangalore");
        builder2.setMarks(98);

        Studentv2 s2 = builder2.build();

        //v4
        Studentv3 s3 = Studentv3.getBuilder().setName("Rittik")
                .setAge(25).setWeight(80).setAddress("Bangalore").setMarks(98).build();
    }
}
