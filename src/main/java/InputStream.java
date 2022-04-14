import io.dronefleet.mavlink.Mavlink2Message;
import io.dronefleet.mavlink.MavlinkConnection;
import io.dronefleet.mavlink.MavlinkMessage;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class InputStream {

    public static void startInputStream() {

        try (Socket socket = new Socket("127.0.0.1", 5760)) {
            System.out.println("Connection has been established.");
            MavlinkConnection connection = MavlinkConnection.create(
                    socket.getInputStream(),
                    socket.getOutputStream());

            MavlinkMessage message;
            while ((message = connection.next()) != null) {
                // Verify the received message is mavlink 2
                if (message instanceof Mavlink2Message) {
                    Mavlink2Message message2 = (Mavlink2Message)message;

                    if (message2.isSigned()) {
                        Database.addEntryToDatabase(message2);

//                        // Signature verification to in use
//                        // Verify signature with validation key
//                        if (message2.validateSignature(validationKey)) {
//                            System.out.println("Signature validation successful.");
//                        } else {
//                            System.out.println("Signature validation failed.");
//                        }
                    } else {
                        // This is an unsigned message.
                        // Signature verification not in use, add entry regardless
                        Database.addEntryToDatabase(message2);
                    }
                } else {
                    System.out.println("Incorrect message type.");
                }
//                Message payload type validation not in use
//                if (message.getPayload() instanceof Heartbeat) {
//                    // This is a heartbeat message
//                    MavlinkMessage<Heartbeat> heartbeatMessage = (MavlinkMessage<Heartbeat>)message;
//                }
            }
        } catch (EOFException eof) {
            System.out.println("Input stream has ended.");
        } catch (UnknownHostException e) {
            System.out.println("The host is unknown.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            throw new RuntimeException(e);
        }
    }
}
