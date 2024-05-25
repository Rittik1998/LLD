package DESIGN_PATTERNS.Creational.PrototypeAndRegistry;

public class IntelligentStudent extends Student{
    private int iq;

    IntelligentStudent(){}

    IntelligentStudent(IntelligentStudent s){
        super(s);
        this.iq = s.iq;
    }

    @Override
    public Student createClone() {
        return new IntelligentStudent(this);
    }
}
