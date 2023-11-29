package barnastik.homework8.task16;

import java.util.List;

public class Pet {
    private Integer medicalCardNumber;
    private String name;
    private Integer age;
    private List<Client> clients;

    public Integer getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public void setMedicalCardNumber(Integer medicalCardNumber) {
        this.medicalCardNumber = medicalCardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}