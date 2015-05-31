package application;

import domain.cypher.Cypher;
import domain.cypher.SimpleCypher;
import domain.cyphermethod.StraightCypherMethod;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kuro on 31.05.15.
 */
public class CypherServiceImpl implements CypherService {

    Map<String,Cypher> cyphers;

    public CypherServiceImpl() {
        cyphers = new HashMap<String,Cypher>();
        cyphers.put("straight",new SimpleCypher());
    }

    public Iterator<String> getIdList() { return cyphers.keySet().iterator(); }

    public String getNameOf(String id) {
        return cyphers.get(id).getName();
    }

    public void transformFile(String input, String output, boolean mode, String id) throws FileNotFoundException {
        InputStream finput;
        OutputStream foutput;

        finput = new FileInputStream(input);
        foutput = new FileOutputStream(output);

        if (mode)
            cyphers.get(id).crypt(finput,foutput);

    }
}
