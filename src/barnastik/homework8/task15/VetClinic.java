package barnastik.homework8.task15;

import java.util.List;

import static barnastik.homework8.task15.DataBase.connectDb;
import static barnastik.homework8.task15.DataBase.createTables;
import static barnastik.homework8.task15.FileReader.readCsv;
import static barnastik.homework8.task15.DataBase.*;

public class VetClinic {

    public static void main(String[] args) {
        if(args.length==0){
            throw new IllegalArgumentException("Необходимо передать файл");
        }

        String csvFile = args[0];
        //String csvFile= "./src/barnastik/homework8/task15/data.csv";
        try {
            dropTable();
            List<List<String>> records = readCsv(csvFile);
            connectDb();
            createTables();
            fillDb(records);
            System.out.println("Данные в базе данных.");
            closeDb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

