package acme.cypher;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 22.05.15.
 */
public interface Cypher {
    void encrypt(InputStream i, OutputStream o, String key);
    void decrypt(InputStream i,OutputStream o, String key);
    String getName();
}
