package barnastik.homework8.task15;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    public static Statement statement;
    public static Connection connection;

    public static void dropTable() throws SQLException {
        connectDb();
        statement.executeUpdate("DROP TABLE IF EXISTS pet");
        statement.executeUpdate("DROP TABLE IF EXISTS client");
        statement.executeUpdate("DROP TABLE IF EXISTS client_and_pet");
        closeDb();
    }
    public static void fillDb(List<List<String>> data) throws SQLException {
        List<List<String>> data_new = data.stream().distinct().toList();
        String insertClientSQL = "INSERT INTO client VALUES (?, ?, ?, ?)";
        String insertPetSQL = "INSERT INTO pet VALUES (?, ?, ?)";
        String insertClientPetSQL = "INSERT INTO client_and_pet(id_client, id_pet) VALUES (?, ?)";

        List<Client> clients = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        for (List<String> record : data_new) {
            int clientId = Integer.parseInt(record.get(0));
            String lastName = record.get(1);
            String firstName = record.get(2);
            String phoneNumber = record.get(3);
            int petId = Integer.parseInt(record.get(4));
            String petName = record.get(5);
            int petAge = Integer.parseInt(record.get(6));

            Client client = new Client(clientId, firstName, lastName, phoneNumber);
            if (!clients.contains(client)) {
                clients.add(client);
            }

            Pet pet = new Pet(petId, petName, petAge);
            if (!pets.contains(pet)) {
                pets.add(pet);
            }
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertClientSQL)) {
            for (Client client1 : clients) {
                preparedStatement.setInt(1, client1.getId());
                preparedStatement.setString(2, client1.getFirstName());
                preparedStatement.setString(3, client1.getLastName());
                preparedStatement.setString(4, client1.getPhoneNumber());
                preparedStatement.executeUpdate();
            }
        }

        try (PreparedStatement preparedStatement1 = connection.prepareStatement(insertPetSQL)) {
            for (Pet pet1 : pets) {
                preparedStatement1.setInt(1, pet1.getCardNumber());
                preparedStatement1.setString(2, pet1.getPetName());
                preparedStatement1.setInt(3, pet1.getAge());
                preparedStatement1.executeUpdate();
            }
        }

        try (PreparedStatement preparedStatementClientToPet = connection.prepareStatement(insertClientPetSQL)) {
            for (Client client2 : clients) {
                for (Pet pet2 : client2.getPets()) {
                    preparedStatementClientToPet.setInt(1, client2.getId());
                    preparedStatementClientToPet.setInt(2, pet2.getCardNumber());
                    preparedStatementClientToPet.executeUpdate();
                }
            }
        }
    }

    public static void connectDb() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        statement = connection.createStatement();
    }

    public static void createTables() throws SQLException {
        connectDb();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS client (id_client IDENTITY NOT NULL PRIMARY KEY , first_name VARCHAR NOT NULL, second_name VARCHAR NOT NULL, number_phone VARCHAR NOT NULL)");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS pet (id_pet INTEGER PRIMARY KEY , name_pet VARCHAR NOT NULL, age INTEGER NOT NULL)");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS client_and_pet (id INTEGER AUTO_INCREMENT PRIMARY KEY,id_pet INTEGER NOT NULL, id_client INTEGER NOT NULL)");

    }
    public static void closeDb() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}