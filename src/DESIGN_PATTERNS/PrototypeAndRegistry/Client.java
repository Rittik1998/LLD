package DESIGN_PATTERNS.PrototypeAndRegistry;

public class Client {
    public static void main(String[] args) {
        Onboarding onboarding = new Onboarding();
        onboarding.fillRegistry();
        Registry<Student> registry = StudentRegistry.getObj();
        Student apr22PrototypeStudent = registry.getObj("Apr22");
        Student s1 = apr22PrototypeStudent.createClone();
        s1.setName("Rittik");
        s1.setAge(25);
        s1.setPsp(55.6);
        System.out.println(s1);
    }
}
