package DESIGN_PATTERNS.PrototypeAndRegistry;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry implements Registry<Student>{
    Map<String,Student> map = new HashMap<>();
    private static  StudentRegistry obj;

    private StudentRegistry(){}

    public static StudentRegistry getObj(){
        if(obj==null){
            synchronized(StudentRegistry.class){
                if(obj==null){
                    obj = new StudentRegistry();
                }
            }
        }
        return obj;
    }
    @Override
    public void register(String key, Student obj) {
        map.put(key,obj);
    }

    @Override
    public Student getObj(String key) {
        return map.get(key);
    }
}

