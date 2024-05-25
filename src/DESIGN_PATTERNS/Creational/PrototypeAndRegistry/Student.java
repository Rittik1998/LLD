package DESIGN_PATTERNS.Creational.PrototypeAndRegistry;

public class Student implements Prototype<Student> {
    private String name;
    private int age;
    private double psp;
    private String batch;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", psp=" + psp +
                ", batch='" + batch + '\'' +
                ", avgBatchPsp=" + avgBatchPsp +
                '}';
    }

    private double avgBatchPsp;

    Student(){}
    Student(Student s){
        this.batch = s.batch;
        this.avgBatchPsp = s.avgBatchPsp;
    }
    @Override
    public Student createClone() {
        return new Student(this);
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setAvgBatchPsp(double avgBatchPsp) {
        this.avgBatchPsp = avgBatchPsp;
    }

}
