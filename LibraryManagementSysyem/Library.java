package LibraryManagementSysyem;

import java.util.List;
import java.util.Map;   
import java.util.HashMap;

public class Library {
    private Map<String, List<Book>> booksByTitle;
    private Map<String, List<Book>> booksByAuthor;
    private Map<String, Book> booksByIsbn;
    private Map<String, LibraryMember> members;

    public Library() {
        booksByTitle = new HashMap<>();
        booksByAuthor = new HashMap<>();
        booksByIsbn = new HashMap<>();
        members = new HashMap<>();
    }

    public void addMember(LibraryMember member) {
        members.put(member.getId(), member);
    }

    public boolean isMemberExists(String memberId) {
        return members.containsKey(memberId);
    }

    public LibraryMember getMember(String memberId) {
        return members.get(memberId);
    }
    

    public void addBook(Book book) {
        booksByTitle.computeIfAbsent(book.getTitle(), k -> new java.util.ArrayList<>()).add(book);
        booksByAuthor.computeIfAbsent(book.getAuthor(), k -> new java.util.ArrayList<>()).add(book);
        booksByIsbn.put(book.getIsbn(), book);
    }

    public List<Book> searchBooksByTitle(String title) {
        return booksByTitle.getOrDefault(title, java.util.Collections.emptyList());
    }

    public Book searchBookByIsbn(String isbn) {
        return booksByIsbn.get(isbn);
    }

    public List<Book> searchBooksByAuthor(String author) {
        return booksByAuthor.getOrDefault(author, java.util.Collections.emptyList());
    }
}
