package application;

import domain.cypher.Cypher;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by kuro on 31.05.15.
 */

public interface CypherService {
    Iterator<String> getIdList();
    String getNameOf(String id);
    void transformFile(String input, String output, boolean mode, String id) throws FileNotFoundException;
    //Cypher getCypher(String id);
    //void transformFile(String input, String output, int mode, String id);

}
