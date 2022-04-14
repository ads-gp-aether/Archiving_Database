Update Notes:
- Replaced packet deconstruction with use of dronefleet API


# Archiving Database
Requirements: The following list of software is required to run the archiving database software on the host machine: Mongo Community Server The archiving database requires Mongo Community Server in order for the processing software to operate correctly. The software is available for use in commercial applications and does not include any limitations of use. We have chosen to use the Mongo Shell for database interaction however alternative GUIs may be preferable in a commercial application. Java 1.8 (Java 8) The archiving database software requires Java 1.8 to compile and run. Java 1.8 is free to use for personal use however does require a license for use in commercial products. At this time, our software will not be sold therefore this limitation is acceptable. An alternative development kit or license would be acquired if the use of the software were to change. Java IDE (Optional) The archiving database software can be run in two ways based on user preference:

The software can be run within a dedicated IDE. This allowed greater ease-of-use when running the software and provides functionality to debug and alter the software as needed. This is the preferred method of execution for testing purposes as the user is able to modify the parameters of the software.
The software can be run as a standalone executable Jar file. This is the preferred method of delivery for commercial products as there are no additional software requirements other than the JDK and compiler. To utilise this method of execution the software must first be packaged as an executable Jar file.
How to run the archiving database software.

Ensure all required software is installed
Open a windows command prompt and navigate to the MongoDB bin directory a. This is usually found in: “C:\Program Files\MongoDB\Server\3.2\bin
Enter the command “mongod” into the command prompt a. This will start the MongoDB server service b. The server will open on the default port 27017 c. The shell should display “waiting for connections on port 27017”
In the IDE, start the archiving database software by running the initialisation method in the main Class, this is displayed as a green start icon near the method signature a. Alternatively, navigate to the location of the executable Jar file b. Run the executable Jar file with the following command: i. java –jar c. The software will run automatically without displaying a user interface
Once the software is running, all packets received via the desired port will be directed to the database and stored.
Interacting with the database Viewing the archived packets

Open a windows command prompt and navigate to the MongoDB bin directory a. This is usually found in: “C:\Program Files\MongoDB\Server\3.2\bin
Enter the command “mongo” to open the mongo shell a. The following sign should be displayed indicating you are in the mongo shell: “>”
Enter the command “show dbs” to display all databases in the shell
Select the required database by entering “use + database_name” a. Substitute database_name with the name of the database
Enter the command “show collections” to show the stored collections a. There may be multiple collections depending on the current state of the database
Enter the command “db.<collection_name>.find()” to display all entries in a collection a. Substitute <collection_name> with the name of the collection b. All archived packets in the collection will be displayed
