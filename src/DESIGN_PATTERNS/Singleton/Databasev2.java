package DESIGN_PATTERNS.Singleton;

public class Databasev2 {

    String password;
    String uname;
    private static Databasev2 obj ;
    private Databasev2(String password,String uname){
        this.password = password;
        this.uname = uname;
    }

    public static synchronized Databasev2 getObj(String password,String uname) {
        if(obj==null) obj = new Databasev2(password, uname);
        return obj;
    }
}

//problems:
