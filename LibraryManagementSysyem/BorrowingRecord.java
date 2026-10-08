package LibraryManagementSysyem;

import java.time.LocalDate;

public class BorrowingRecord {
    private String recordId;
    private String memberId;
    private BookCopy bookCopy;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public String getRecordId() {
        return recordId;
    }

    public String getMemberId() {
        return memberId;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    BorrowingRecord(String memberId, BookCopy bookCopy, LocalDate borrowDate, LocalDate dueDate) {
        recordId = java.util.UUID.randomUUID().toString();
        this.memberId = memberId;
        this.bookCopy = bookCopy;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public void closeRecord(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

}
