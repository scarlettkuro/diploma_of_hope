package application;



import acme.cypher.BlockCypherA;
import acme.cypher.Cypher;
import acme.cypher.ElementaryStraightCypherFactory;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kuro on 31.05.15.
 */
public class CypherServiceImpl implements CypherService {
    static private final Logger LOG=Logger.getLogger(CypherServiceImpl.class);
    private  Map<String, Cypher> cyphers;

    public CypherServiceImpl() {
        cyphers = new HashMap<String,Cypher>();
       /* ElementaryStraightCypherFactory factory = new ElementaryStraightCypherFactory();
        cyphers.put("rule34",factory.getCypher(34));
        cyphers.put("rule110",factory.getCypher(110));
        cyphers.put("rule193",factory.getCypher(193));*/
        cyphers.put("blockA", new BlockCypherA());
    }

    public Iterator<String> getIdList() { return cyphers.keySet().iterator(); }

    public String getNameOf(String id) {
        return cyphers.get(id).getName();
    }

    public void transformFile(String input, String output, boolean mode, String id) throws FileNotFoundException {
        if (mode)
            LOG.info("Encryption of file: " + input + " to " + output + " with " + id);
        else
            LOG.info("Decryption of file: " + input + " to " + output + " with " + id);

        InputStream finput;
        OutputStream foutput;

        finput = new FileInputStream(input);
        foutput = new FileOutputStream(output);

        if (mode)
            cyphers.get(id).encrypt(finput,foutput,"");
        else
            cyphers.get(id).decrypt(finput,foutput,"");

        if (mode)
            LOG.info("Encryption finished properly");
        else
            LOG.info("Decryption finished properly");
    }
}
