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
 public class StudentBook implements Record {
    private String studentId ;
     private String bookId ;
     private LocalDate borrowDate;

    public StudentBook(String studentId, String bookId, LocalDate borrowDate) {
        this.studentId = studentId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getBookId() {
        return bookId;
    }
      public LocalDate getBorrowDate() {
        return borrowDate;
    }
    @Override
    public String lineRepresentation(){
        String data;
        data = this.studentId +","+this.bookId +","+this.borrowDate;
        return data;
    }
    @Override
    public String getSearchKey(){
        return this.studentId +","+ this.bookId;
    }

 }