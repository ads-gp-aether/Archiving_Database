import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // Start input stream, throw exception is stream fails
        try {
            InputStream.startInputStream();
            System.out.println("Input stream started successfully.");
        } catch (Exception e) {
            System.out.println("Input stream failed to start.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // Start database, throw exception if database fails
        try {
            Database.startNewDatabase();
            System.out.println("Database started successfully.");
        } catch (Exception e) {
            System.out.println("Database failed to start.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
