package pajerowski.tony;

/**
 * Created by anthonypajerowski on 2/2/17.
 */
interface Connection extends Closeable{
    public String getIP();
    public int getPort();
    public Protocol getProtocol();
}
