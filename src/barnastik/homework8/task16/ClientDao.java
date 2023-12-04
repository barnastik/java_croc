package barnastik.homework8.task16;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static barnastik.homework8.task15.DataBase.connection;

public class ClientDao {
    public Client createClient(Client client) throws SQLException {
        final String CREATE_CLIENT = "INSERT INTO Client(first_name, second_name, number_phone) VALUES(?, ?, ?)";

        try(Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CLIENT)) {

            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getPhoneNumber());

            preparedStatement.execute();

            return client;
        } catch(SQLException e) {
            throw new SQLException("Error while creating client: " + e.getMessage());
        }
    }

    public Client updateClient(Client client) throws SQLException {
        String sql = "UPDATE client SET second_name = ?, first_name = ?, number_phone = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, client.getLastName());
        preparedStatement.setString(2, client.getFirstName());
        preparedStatement.setString(3, client.getPhoneNumber());
        preparedStatement.setInt(4, client.getId());
        preparedStatement.execute();
        sql = "SELECT * FROM client WHERE id_client = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, client.getId());
        ResultSet clientResult = preparedStatement.executeQuery();
        if (clientResult.next()) {
            return new Client(clientResult.getInt("id_client"), clientResult.getString("surname"), clientResult.getString("name"), clientResult.getString("number_phone"));
        }
        return client;
    }

    public Client findClient(Integer id) throws SQLException {
        String findClientQuery = "SELECT * FROM Client WHERE id_client = ?";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            final String FIND_CLIENT = "SELECT * FROM Client WHERE id_client = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CLIENT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Client(
                        resultSet.getInt("id_client"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("number_phone")
                );
            } else {
                return null;
            }

    }


    public void deleteClient(Integer id) throws SQLException {
        final String DELETE_CLIENT = "DELETE FROM Client WHERE id_client = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }


    public List<String> findClientPhoneNumbersBy(Pet pet) throws SQLException {
        final String sql = "SELECT number_phone FROM client_and_pet LEFT JOIN client ON id_client = id_pet WHERE id_pet = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, pet.getCardNumber());
        List<String> phoneNumbers = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            phoneNumbers.add(resultSet.getString(1));
        }
        return phoneNumbers;
    }


    public List<Pet> getAllPetsOf(Client client) throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet JOIN client_and_pet ON pet.id_pet = client_and_pet.id_pet WHERE client_and_pet.id_client = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, client.getId());
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            pets.add(new Pet(result.getInt("medical_card"), result.getString("name"), result.getInt("age")));
        }
        return pets;
    }
}


