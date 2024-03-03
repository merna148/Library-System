/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.time.*;
import java.time.Period;
import java.util.*;
import Constants.FilesNames;

/**
 *
 * @author sss
 */
public class LibrarianRole {

    BookDatabase booksDatabase= new BookDatabase(FilesNames.BOOKS_FILENAME) ;
    StudentBookDatabase sBDatabase= new StudentBookDatabase(FilesNames.STUDENTSBOOKS_FILENAME);

    public LibrarianRole() {
    }

    public void addBook(String id, String title, String authorName, String publisherName, int quantity) {
        Book i = new Book(id, title, authorName, publisherName, quantity);
        this.booksDatabase.insertRecord(i);
    }

    public Book[] getListOfBooks() {
        ArrayList<Record> l = this.booksDatabase.returnAllRecords();
        Book[] lib = new Book[l.size()];
        int ind = 0;
        for (Record li : l) {
            lib[ind++] = (Book) li;
        }
        return lib;
    }

    public StudentBook[] getListOfBorrowingOperations() {
        ArrayList<Record> l = this.sBDatabase.returnAllRecords();
        StudentBook[] lib = new StudentBook[l.size()];
        int ind = 0;
        for (Record li : l) {
            lib[ind++] = (StudentBook) li;
        }
        return lib;
    }

    public int borrowBook(String studentId, String bookId, LocalDate borrowDate) {
        ArrayList<Record> l = this.booksDatabase.returnAllRecords();
        ArrayList<Record> f = this.sBDatabase.returnAllRecords();
        for (Record li : l) {
            String s = li.lineRepresentation();
            String[] r = s.split(",");
            if (r[0].equals(bookId)) {
                return 0;
            }

        }
        for (Record li : f) {
            String s = li.lineRepresentation();
            String[] r = s.split(",");
            if (r[0].equals(studentId)) {
                return 1;
            }
        }
        for (Record li : l) {
            if (li.getSearchKey().equals(bookId)) {
                Book v = (Book) li;
                v.setQuantity(v.getQuantity() - 1);
                li = (Record) v;

                break;
            }

        }
        Record a = new StudentBook(studentId, bookId, borrowDate);
        f.add(a);
        return 2;

    }

    public double returnBook(String studentId, String bookId, LocalDate returnDate) {
        ArrayList<Record> l = this.booksDatabase.returnAllRecords();
        ArrayList<Record> f = this.sBDatabase.returnAllRecords();
        for (Record li : l) {
            if (li.getSearchKey().equals(bookId)) {
                Book v = (Book) li;
                v.setQuantity(v.getQuantity() + 1);
                li = (Record) v;

                break;
            }

        }
        LocalDate x = null;
        for (Record li : f) {
            String s = studentId + "," + bookId;
            if (s.equals(li.getSearchKey())) {
                StudentBook z = (StudentBook) li;
                x = z.getBorrowDate();
                f.remove(li);
                break;

            }
        }
        if(x==null)
            return 0;
            
        Period period = Period.between(returnDate, x);
        int z = period.getDays();
        if (z < 7) {
            return 0;
        }

        double fee = (z - 7) * 0.5;
        return fee;

    }

    public void logout() {
        booksDatabase.saveToFile();
        sBDatabase.saveToFile();
    }
}