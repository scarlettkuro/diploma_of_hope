package application;



import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * Created by kuro on 31.05.15.
 */

public interface CypherService {
    Iterator<String> getIdList();
    String getNameOf(String id);
    void transformFile(String input, String output, boolean mode, String id, String key) throws FileNotFoundException;
    //Cypher getCypher(String id);
    //void transformFile(String input, String output, int mode, String id);

}
