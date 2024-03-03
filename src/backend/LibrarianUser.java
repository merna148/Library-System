/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author sss
 */
public class LibrarianUser implements Record {
    private String librarianId;
    private String Name;
    private String Email;
    private String Address;
    private String PhoneNumber;

    public LibrarianUser(String librarianId, String Name, String Email, String Address, String PhoneNumber) {
        this.librarianId = librarianId;
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    public void setLibrarianId(String librarianId) {
        this.librarianId = librarianId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getLibrarianId() {
        return librarianId;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    
    @Override
    public String lineRepresentation(){
        String data;
        data = this.librarianId +","+this.Name +","+this.Email+","+this.Address+","+this.PhoneNumber;
        return data;
    }
    @Override
    public String getSearchKey(){
        return this.librarianId;
    }

    

}
