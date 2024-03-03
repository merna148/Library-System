/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import Constants.FilesNames;


import java.util.*;


/**
 *
 * @author sss
 */
public class AdminRole{
    private LibrarianUserDatabase database=new LibrarianUserDatabase(FilesNames.LIBRARIANS_FILENAME);

    public AdminRole() {

    }
    
    public void addLibrarian(String librarianId, String name, String email,String address, String phoneNumber){
        LibrarianUser i = new LibrarianUser(librarianId,name,email,address,phoneNumber);
        this.database.insertRecord(i);
    }
    
    public LibrarianUser[] getListOfLibrarians(){
         ArrayList<Record> l= this.database.returnAllRecords();
         LibrarianUser[] lib = new LibrarianUser[l.size()];
         int ind = 0;
        for(Record li: l){
            lib[ind++]=(LibrarianUser) li;
        }
        return lib;
    }
    
    public void removeLibrarian(String key){
       this.database.deleteRecord(key);
       
    }
    
    public void logout(){
        this.database.saveToFile();
    } 
    
}