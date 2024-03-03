/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author sss
 */
public class Book implements Record  {
    
    
    private int quantity;
    private String bookId;
    private String title;
    private String authorName;
    private String publisherName;

    public Book( String bookId, String title, String authorName, String publisherName ,int quantity) {
        this.quantity = quantity;
        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
        this.publisherName = publisherName;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }
    
    public int getQuantity() {
        return this.quantity;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String lineRepresentation() {
        return this.bookId + "," + 
                this.title + "," + 
                this.authorName + "," + 
                this.publisherName + "," +
                this.quantity;
    }
    
    @Override
    public String getSearchKey() {
        return this.bookId;
    }
    
    
}