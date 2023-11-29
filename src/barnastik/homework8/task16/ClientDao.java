package barnastik.homework8.task16;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ClientDao {
    public Client createClient(Client client) throws SQLException {
        final String CREATE_CLIENT = "INSERT INTO Client(first_name, second_name, phone_number) VALUES(?, ?, ?)";

        try(Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CLIENT)) {

            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getPhoneNumber());

            preparedStatement.execute();

            return client;
        } catch(SQLException e) {
            throw new SQLException("Error occurred while creating client: " + e.getMessage());
        }
    }


    public Optional<Client> findClient(Integer id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        final String FIND_CLIENT = "SELECT * FROM Client WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_CLIENT);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getInt(1));
            client.setFirstName(resultSet.getString(2));
            client.setLastName(resultSet.getString(3));
            client.setPhoneNumber(resultSet.getString(4));
            return Optional.of(client);
        } else {
            return Optional.empty();
        }
    }



    public void deleteClient(Integer id) throws SQLException {
        final String DELETE_CLIENT = "DELETE FROM Client WHERE id = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }




    //public List<String> findClientPhoneNumbersBy(Pet pet) {
    //}

    public List<Pet> getAllPetsOf(Client client) {
        return null;
    }

}
