/**
 * Created by dplichta on 2015-08-04.
 */
public class Business {
    public String foo(){
        DAOS dataAccess = new DAOS();
        return dataAccess.test();
    }
    public String hello(){
        DAOS dataAccess = new DAOS();
        return dataAccess.hello();
    }
}
