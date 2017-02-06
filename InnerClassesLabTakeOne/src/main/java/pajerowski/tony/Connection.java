package pajerowski.tony;

import java.io.Closeable;

/**
 * Created by anthonypajerowski on 2/2/17.
 */
interface Connection extends Closeable {
    public String getIP();
    public int getPort();
    public Protocol getProtocol();
    public String connect();
}
