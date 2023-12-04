package barnastik.homework8.task16;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import static barnastik.homework8.task15.DataBase.connection;

public class PetDao {
    static int medCard = 1;
    public Pet createPet(String name, Integer age, List<Client> clients) throws SQLException {
        String sql = "INSERT INTO pet VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, medCard);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, age);
        preparedStatement.executeUpdate();
        for (Client client : clients) {
            sql = "INSERT INTO client_and_pet (id_client, id_pet) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, client.getId());
            preparedStatement.setInt(2, medCard);
            preparedStatement.execute();
        }
        Pet pet = new Pet(medCard, name, age);
        medCard++;
        return pet;
    }

    public Pet findPet(Integer cardNumber) throws SQLException {
        String sql = "SELECT * FROM pet WHERE id_pet = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, cardNumber);
        ResultSet petResult = preparedStatement.executeQuery();
        if (petResult.next()) {
            return new Pet(petResult.getInt("id_pet"), petResult.getString("name_pet"), petResult.getInt("age"));
        }
        throw new IllegalArgumentException("No pet with this number");
    }

    public Pet updatePet(Pet pet) throws SQLException {

        String sql = "UPDATE pet SET name_pet = ?, age = ? WHERE id_pet = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, pet.getPetName());
        preparedStatement.setInt(2, pet.getAge());
        preparedStatement.setInt(3, pet.getCardNumber());
        preparedStatement.execute();
        sql = "SELECT * FROM pet WHERE id_pet = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, pet.getCardNumber());
        ResultSet petResult = preparedStatement.executeQuery();
        if (petResult.next()) {
            return new Pet(petResult.getInt("id_pet"), petResult.getString("name_pet"), petResult.getInt("age"));
        }
        return pet;

    }

    public void deletePet(Integer cardNumber) throws SQLException {
        final String DELETE_PET = "DELETE FROM Pet WHERE id_pet = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PET);
        preparedStatement.setInt(1, cardNumber);
        preparedStatement.execute();
    }

    public List<Pet> getAllPetsOf(Client client) throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet JOIN client_and_pet pet.id_pet = client_pet.id_pet WHERE client_pet.id_client = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, client.getId());
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            pets.add(new Pet(result.getInt("medical_card"), result.getString("name"), result.getInt("age")));
        }
        return pets;
    }

}