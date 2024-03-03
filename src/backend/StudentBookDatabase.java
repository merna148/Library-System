/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.time.LocalDate;
/**
 *
 * @author sss
 */
public class StudentBookDatabase extends Database {

    public StudentBookDatabase(String filename) {
        super(filename);
    }

    @Override
    public StudentBook createRecordFrom(String line) {
        String[] UserData = line.split(",");
        LocalDate x = LocalDate.parse(UserData[2]);
        StudentBook b1 = new StudentBook(UserData[0], UserData[1], x);
        return b1;
    }
}