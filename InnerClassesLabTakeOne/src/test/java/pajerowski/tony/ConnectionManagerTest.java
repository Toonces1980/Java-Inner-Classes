package pajerowski.tony;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthonypajerowski on 2/2/17.
 */
public class ConnectionManagerTest {
    Connection connection;
    String ipAddress = "128.0.0.0";
    int port = 1000;
    Protocol protocol = Protocol.HTTP;

    @Before
    public void setup(){

        connection = new ConnectionManager().getConnection(ipAddress, port, protocol);
    }

    @Test
    public void getIPTest() {
        String expected = "";
        String actual = connection.getIP();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getProtocolTest() {
        Class expected = null;
        Class actual = connection.getProtocol().getClass();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPortTest() {
        Integer expected = 0;
        Integer actual = connection.getPort();
        Assert.assertEquals(expected, actual);
    }

}