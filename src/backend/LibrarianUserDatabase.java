/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author sss
 */
public class  LibrarianUserDatabase extends Database {

   
    public LibrarianUserDatabase(String filename) {
        super(filename);
    }
   
    @Override
    public LibrarianUser createRecordFrom(String line) {
        String[] UserData = line.split(",");
        LibrarianUser person = new LibrarianUser(UserData[0], UserData[1], UserData[2], UserData[3], UserData[4]);
        return person;
    }
}
