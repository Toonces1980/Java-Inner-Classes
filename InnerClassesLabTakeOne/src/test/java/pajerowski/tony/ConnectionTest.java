package pajerowski.tony;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthonypajerowski on 2/2/17.
 */

public class ConnectionTest {
    Connection connection;
    String ipAddress = "128.0.0.0";
    int port = 1000;
    Protocol protocol = Protocol.HTTP;

    @Before
    public void setup() {
        connection = new ConnectionManager().getConnection(ipAddress, port, protocol);
    }


    @Test
    public void getIpAddressConnectionClosedTest() {
        assertTrue(connection.getIP().equals("Connection Closed"));
    }

    @Test
    public void getIpAddressConnectionOpenTest() {
        String expected = "128.0.0.0";
        String actual = connection.getIP();
        assertEquals(expected, actual);
    }

    @Test
    public void getPortConnectionOpenTest() {
        int expected = 1000;
        int actual = connection.getPort();
        assertEquals(expected, actual);
    }

    @Test
    public void getPortConnectionClosedTest() {
        assertTrue(connection.getPort() == -1);
    }

    @Test
    public void getProtocolConnectionOpenTest() {
        Protocol expected = Protocol.HTTP;
        Protocol actual = connection.getProtocol();
        assertEquals(expected, actual);
    }

    @Test
    public void getProtocolConnectionClosedTest() {
        assertNull(connection.getProtocol());
    }

    @Test
    public void getStatusTest() {
        boolean expected = true;
       // boolean actual = connection.getStatus;
       // assertEquals(expected, actual);
    }

    @Test
    public void connectWhenConnectionOpenTest() {
        String expected = "Connected to 128.0.0.0:1000 via HTTP";
        String actual = connection.connect();
        assertEquals(expected, actual);
    }

    @Test
    public void connectWhenConnectionClosedTest() {
        String expected = "Connection closed";
        String actual = connection.connect();
        assertEquals(expected, actual);
    }

    @Test
    public void closeTest() {
      //  assertTrue(closeable.getStatus().equals(false));
    }
}