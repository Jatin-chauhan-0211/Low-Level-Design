package LibraryManagementSysyem;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private List<BookCopy> copies;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        copies = new ArrayList<>();
    }

    public void addCopy(BookCopy copy) {
        copies.add(copy);
        copy.setBook(this);
    }

    public BookCopy getAvailableCopy() {
    
        for (BookCopy copy : copies) {
            if (copy.isAvailable()) {
                return copy;
            }
        }
        return null;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
}
