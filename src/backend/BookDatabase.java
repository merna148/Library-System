/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author sss
 */
public class BookDatabase extends Database {

    public BookDatabase(String filename) {
        super(filename);
    }

    @Override
    public Book createRecordFrom(String line) {
        String[] UserData = line.split(",");
        int x = Integer.parseInt(UserData[4]);
        return new Book(UserData[0], UserData[1], UserData[2], UserData[3], x);
    }
}