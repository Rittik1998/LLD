package DESIGN_PATTERNS.Singleton;

public class Databasev3 {

    String password;
    String uname;
    private static volatile Databasev3 obj ;
    private Databasev3(String password, String uname){
        this.password = password;
        this.uname = uname;
    }

    public static Databasev3 getObj(String password, String uname) {
        if(obj==null){
            synchronized (Databasev2.class){
                if(obj==null){
                    obj = new Databasev3(password, uname);
                }
            }
        }
        return obj;
    }
}

//problems:
