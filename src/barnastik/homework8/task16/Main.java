package barnastik.homework8.task16;

import java.util.ArrayList;
import java.util.List;

import static barnastik.homework8.task15.DataBase.*;

//с закомментированными участками кода проблемы, не успела исправить, прости пожалуйста
//я понимаю, что все криво, но я пыталась исправить

public class Main {
    public static void main(String[] args) {
        try {
            dropTable();
            connectDb();
            createTables();

            ClientDao clientDao = new ClientDao();
            Client newClient = new Client(19 , "John", "Doe", "+123456789");
            Client createdClient = clientDao.createClient(newClient);
            System.out.println("Client created with ID: " + createdClient.getId());

            int clientIdToDelete = 19;
            clientDao.deleteClient(clientIdToDelete);
            System.out.println("Client deleted with ID: " + clientIdToDelete);

            int clientIdToUpdate = 19;
            Client optionalClient = clientDao.findClient(clientIdToUpdate);
            if (optionalClient!=null) {
                Client clientToUpdate = optionalClient;
                clientToUpdate.setFirstName("UpdatedFirstName");
                clientToUpdate.setLastName("UpdatedLastName");
                clientToUpdate.setPhoneNumber("+987654321");
                Client updatedClient = clientDao.updateClient(clientToUpdate);
                System.out.println("Client updated: " + updatedClient);
            } else {
                System.out.println("Client not found with ID: " + clientIdToUpdate);
            }

            int clientIdToFind = 1;
            Client optionalClient1 = clientDao.findClient(clientIdToFind);
            if (optionalClient1 != null) {
                System.out.println("Found Client: " + optionalClient1);
            } else {
                System.out.println("Client not found with ID: " + clientIdToFind);
            }


            Pet pet = new Pet(12,"Fluffy", 3);
//            List<String> phoneNumbers = clientDao.findClientPhoneNumbersBy(pet);
//            System.out.println("Phone numbers of clients associated with the pet: " + phoneNumbers);

            Client client = new Client(41 , "Johan", "Do", "+120056789");
            List<Pet> pets = clientDao.getAllPetsOf(client);
            System.out.println("Pets of the client: " + pets);


            PetDao petDao = new PetDao();
            List<Client> clients = new ArrayList<>();
            Client client1 = new Client(61 , "Johana", "Doen", "+123996789");
            clients.add(client1);
            Pet createdPet = petDao.createPet("Buddy", 2, clients);
            System.out.println("Pet created with Medical Card Number: " + createdPet.getCardNumber());

            int cardNumberToFind = 12;
            try {
                Pet foundPet = petDao.findPet(cardNumberToFind);
                System.out.println("Found Pet with Medical Card Number: " + foundPet.getCardNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            int cardNumberToUpdate = 1;
            Pet petToUpdate = petDao.findPet(cardNumberToUpdate);
            petToUpdate.setPetName("UpdatedBuddy");
            petToUpdate.setAge(3);
            Pet updatedPet = petDao.updatePet(petToUpdate);
            System.out.println("Pet updated with Medical Card Number: " + updatedPet.getCardNumber());

            int cardNumberToDelete = 41;
            petDao.deletePet(cardNumberToDelete);
            System.out.println("Pet deleted with Medical Card Number: " + cardNumberToDelete);

            closeDb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
