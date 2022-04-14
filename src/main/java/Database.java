import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.dronefleet.mavlink.Mavlink2Message;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Database {

    static MongoCollection<Document> collection;

    public static void startNewDatabase() {
        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {

            String databaseName = "ArchivingDatabase";
            String collectionName = "IncomingPacketsCollection";

            MongoDatabase database = mongoClient.getDatabase(databaseName);
            collection = database.getCollection(collectionName);

            System.out.println("New database created successfully." +
                    "\nDatabase name: " + databaseName +
                    "\nCollection name: " + collectionName);
        }
    }

    public static void addEntryToDatabase(Mavlink2Message message) {
        try {
            ObjectId generatedId = new ObjectId();
            Document document = new Document();
            document.put("_id", generatedId);
            document.put("message", message);
            collection.insertOne(document);
            System.out.println("Packet " + generatedId + " has been added" +
                    "to the collection as " + document);
        } catch (Exception e) {
            System.out.println("Failed to add entry to database due to error code: " + e);
        }
    }
}
