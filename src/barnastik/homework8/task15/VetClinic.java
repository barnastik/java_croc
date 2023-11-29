package barnastik.homework8.task15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class VetClinic {

    public static void main(String[] args) {
        if(args.length==0){
            throw new IllegalArgumentException("Необходимо передать файл");
        }

        String csvFile = args[0];
        String line;
        String cvsSplitBy = ",";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {

            String createClientsTable = "CREATE TABLE IF NOT EXISTS clients (" +
                    "id INTEGER PRIMARY KEY," +
                    "last_name VARCHAR(255)," +
                    "first_name VARCHAR(255)," +
                    "phone_number VARCHAR(20)" +
                    ")";
            String createPetsTable = "CREATE TABLE IF NOT EXISTS pets (" +
                    "id INTEGER PRIMARY KEY," +
                    "client_id INTEGER," +
                    "name VARCHAR(255)," +
                    "age INTEGER," +
                    "FOREIGN KEY (client_id) REFERENCES clients(id)" +
                    ")";

            connection.createStatement().executeUpdate(createClientsTable);
            connection.createStatement().executeUpdate(createPetsTable);


            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(cvsSplitBy);
                    int clientId = Integer.parseInt(data[0]);
                    String lastName = data[1];
                    String firstName = data[2];
                    String phoneNumber = data[3];
                    int petId = Integer.parseInt(data[4]);
                    String petName = data[5];
                    int petAge = Integer.parseInt(data[6]);

                    // Insert client into database
                    String insertClientQuery = "INSERT INTO clients (id, last_name, first_name, phone_number) VALUES (?, ?, ?, ?)";
                    PreparedStatement insertClientStmt = connection.prepareStatement(insertClientQuery);
                    insertClientStmt.setInt(1, clientId);
                    insertClientStmt.setString(2, lastName);
                    insertClientStmt.setString(3, firstName);
                    insertClientStmt.setString(4, phoneNumber);
                    insertClientStmt.executeUpdate();


                    String insertPetQuery = "INSERT INTO pets (id, client_id, name, age) VALUES (?, ?, ?, ?)";
                    PreparedStatement insertPetStmt = connection.prepareStatement(insertPetQuery);
                    insertPetStmt.setInt(1, petId);
                    insertPetStmt.setInt(2, clientId);
                    insertPetStmt.setString(3, petName);
                    insertPetStmt.setInt(4, petAge);
                    insertPetStmt.executeUpdate();
                }
            }

            System.out.println("Data imported successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

