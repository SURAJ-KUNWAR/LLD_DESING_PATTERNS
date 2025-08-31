package Creational;

import java.io.Serializable;

public class Database implements Serializable {
    private  static Database database = null;
    private Database() {
        // reflection safeguard
        if(database!=null){
            throw new RuntimeException("Database instance already exists use getDatabaseInstance");
        }
    };

    public static  Database getDatabaseInstance(){
        // double checking for concurrency problems
        if(database==null){
            synchronized (Database.class){
                if(database==null){
                    database = new Database();
                }
            }
        }
        return database;
    }

    // serializzation safeguard
    protected Object readResolve(){
        return getDatabaseInstance();
    }

}
