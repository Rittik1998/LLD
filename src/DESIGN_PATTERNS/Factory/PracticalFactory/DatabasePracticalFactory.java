package DESIGN_PATTERNS.Factory.PracticalFactory;

public class DatabasePracticalFactory {
    public static Database getDatabaseInstance(String type){
        if(type=="MySQL"){
            return new MySQLDatabase();
        } else if (type=="Mongo") {
            return new MongoDatabase();
        }
        else{
            System.out.println("Database type not supported");
            return null;
        }
    }
}
