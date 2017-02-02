package pajerowski.tony;

import java.util.List;

/**
 * Created by anthonypajerowski on 2/2/17.
 */
public class ConnectionManager implements Connection{

    private int connectionLimit;

    private int numberOfConnections;

    private List<Connection> listOfConnections;

    public String getIP(){
        return null;
    }

    public Protocol getProtocol() {
        return null;
    }

    public int getPort() {
        return -1;
    }

    public void close(){}

    class ManagedConnection {

        String ipAddress;

        int portNumber;

        Protocol protocol;

        boolean connectionStatus;

        boolean getConnectionStatus(){
            return false;
        }
    }
}
