/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sss
 */
public abstract class Database {

    private ArrayList<Record> records;
    private String filename;

    public Database(String filename) {
        this.filename = filename;
        this.records = new ArrayList<>();
        readFromFile();
    }

    public void readFromFile() {
       this.records=new ArrayList<>();
        try {
            File file = new File(this.filename);
            Scanner sc = new Scanner(file);

            int index = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                records.add(createRecordFrom(line));
                index++;
            }
            sc.close();
         }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

    }

    public abstract Record createRecordFrom(String line);

    public ArrayList<Record> returnAllRecords() {
        return this.records;

    }

    public boolean contains(String key) {
        boolean id = false;
        for (Record l : records) {
            if (key.equals(l.getSearchKey())) {
                id = true;
            }
        }
        return id;
    }

    public Record getRecord(String key) {
        for (Record l : records) {
            if (key.equals(l.getSearchKey())) {

                return l;

            }
        }
        return null;
    }

    public void insertRecord(Record record) {
        if(contains(record.getSearchKey()))
            return;
        records.add(record);
    }

    public void deleteRecord(String key) {
        Record l = null;
        for (Record b : records) {
            if (key.equals(b.getSearchKey())) {
                l = b;
                break;
            }
        }
        if (l != null) {
            records.remove(l);
        }
    }

    public void saveToFile() {
        try {
            FileWriter myWriter = new FileWriter(filename);
            for(Record l:records){
                myWriter.write(l.lineRepresentation() + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            records.clear();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
