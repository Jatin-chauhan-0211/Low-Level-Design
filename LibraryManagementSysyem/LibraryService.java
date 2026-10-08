package LibraryManagementSysyem;

import java.util.List;
import java.time.LocalDate;

public class LibraryService {

    private static final int FINE_RATE = 5; // Assuming a fine of $5 per day late

    private Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public List<Book> searchBookByTitle(String title) {
        return library.searchBooksByTitle(title);
    }

    public Book searchBookByIsbn(String isbn) {
        return library.searchBookByIsbn(isbn);
    }

    public List<Book> searchBookByAuthor(String author) {
        return library.searchBooksByAuthor(author);
    }

    public BorrowingRecord borrowBook(String memberId, String isbn) {
        if (!library.isMemberExists(memberId)) {
            System.out.println("Member with ID " + memberId + " does not exist.");
            return null;
        }

        LibraryMember member = library.getMember(memberId);
        
        if (member.getActiveBorrowingsCount() >= member.getBookBorrowingLimit()) {
            System.out.println("Member with ID " + member.getId() + " has reached the borrowing limit.");
            return null;
        }

        
        Book book = library.searchBookByIsbn(isbn);

        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " does not exist.");
            return null;
        }

        BookCopy availableCopy = book.getAvailableCopy();

        if (availableCopy == null) {
            System.out.println("No available copies for book with ISBN " + isbn);
            return null;
        }

        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(member.getBorrowingDurationInDays());
        BorrowingRecord record = new BorrowingRecord(member, availableCopy, borrowDate, dueDate);

        if (availableCopy.borrowCopy()) {
            member.addActiveBorrowing(record);
        }

        System.out.println("Book borrowed successfully. Record ID: " + record.getRecordId());
        return record;
    }

    public int returnBook(String memberId, String recordId) {
        if (!library.isMemberExists(memberId)) {
            System.out.println("Member with ID " + memberId + " does not exist.");
            return -1;
        }

        LibraryMember member = library.getMember(memberId);
        BorrowingRecord recordToReturn = null;

        for (BorrowingRecord record : member.getActiveBorrowings()) {
            if (record.getRecordId().equals(recordId)) {
                recordToReturn = record;
                break;
            }
        }

        if (recordToReturn == null) {
            System.out.println("No borrowing record found with ID " + recordId + " for member " + memberId);
            return -1;
        }

        LocalDate returnDate = LocalDate.now();
        recordToReturn.closeRecord(returnDate);
        BookCopy bookCopy = recordToReturn.getBookCopy();
        bookCopy.returnCopy();
        member.removeActiveBorrowing(recordToReturn);

        int fine = calculateFine(recordToReturn);
        System.out.println("Book returned successfully. Fine: " + fine);
        return fine;
    }

    private int calculateFine(BorrowingRecord record) {
        LocalDate dueDate = record.getDueDate();
        LocalDate returnDate = record.getReturnDate();

        if (returnDate.isAfter(dueDate)) {
            long daysLate = java.time.temporal.ChronoUnit.DAYS.between(dueDate, returnDate);
            return (int) daysLate * FINE_RATE; // Assuming a fine of $5 per day late
        }
        return 0;
    }

    
}
