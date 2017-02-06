package pajerowski.tony;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthonypajerowski on 2/2/17.
 */

public class ConnectionManager {
        private int connectionLimit;
        private int numConnections;
        private List<Connection> connectionList;
        public int getConnectionLimit() { return connectionLimit; }
        public int getNumConnections()  { return numConnections;  }
        public List<Connection>getConnectionList() { return connectionList; }

    ConnectionManager() {
        numConnections = 0;
        connectionList = new ArrayList<>();
    }

        public Connection getConnection(String ip, Protocol protocol) {
            return getConnection(ip, 1, protocol);
        }

        public Connection getConnection(String ip, int port) {
            return getConnection(ip, port, Protocol.HTTP);
        }

        public Connection getConnection(String ip, int port, Protocol protocol) {
            if (numConnections < connectionLimit) {
                Connection connection = new ManagedConnection(ip, port, protocol);
                addConnectionToList(connection);
                return connection;
            } else {
                return null;
            }
        }

        private void addConnectionToList(Connection connection) {
            connectionList.add(connection);
            numConnections++;
        }

        private class ManagedConnection implements Connection {  //private inner class
            private String ipAddress;
            private int port;
            private Protocol protocol;
            private boolean connectionIsOpen;

            public ManagedConnection(String ipAddress, int port, Protocol protocol) {
                this.ipAddress = ipAddress;
                this.port = port;
                this.protocol = protocol;
                this.connectionIsOpen = true;
            }

            public String getIP() {
                ManagedConnection connection = new ManagedConnection(this.ipAddress, this.port, this.protocol);
                if (connectionIsOpen) {
                    return ipAddress;
                } else {
                    return "CONNECTION CLOSED";
                }
            }

            public int getPort()
            {
                if (connectionIsOpen){
                    return port;
                } else {
                    return -1;
                }
            }

            public Protocol getProtocol() {
                if (connectionIsOpen) {
                    return protocol;
                } else {
                    return null;
                }
            }

            public boolean getStatus() {
                return connectionIsOpen;
            }

            public String connect() {
                if (connectionIsOpen) {
                    return "Connected to " + getIP() + ":" + getPort() + " via " + getProtocol();
                } else {
                    return "Connection closed";
                }
            }

            public void close() {
                ConnectionManager.this.numConnections--;
                this.connectionIsOpen = false;
            }
        }
    }