package cypher;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 22.05.15.
 */
public interface Cypher {
    void crypt(InputStream i,OutputStream o);
    void decrypt(InputStream i,OutputStream o);
    String getName();
}
