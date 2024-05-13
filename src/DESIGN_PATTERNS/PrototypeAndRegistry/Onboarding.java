package DESIGN_PATTERNS.PrototypeAndRegistry;

public class Onboarding {
    public void fillRegistry(){
        Student apr22 = new Student();
        apr22.setAvgBatchPsp(70);
        apr22.setBatch("Apr2022");

        Registry<Student> registry = StudentRegistry.getObj();
        registry.register("Apr22",apr22);
    }
}
