package pajerowski.tony;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthonypajerowski on 2/2/17.
 */
public class ConnectionManagerTest {
    ConnectionManager connectionManager;

    @Before
    public void setup(){
        connectionManager = new ConnectionManager();
    }

    @Test
    public void getIPTest() {
        String expected = "";
        String actual = connectionManager.getIP();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getProtocolTest() {
        Protocol expected = null;
        Protocol actual = connectionManager.getProtocol();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPortTest() {
        Integer expected = 0;
        Integer actual = connectionManager.getPort();
        Assert.assertEquals(expected, actual);
    }

}