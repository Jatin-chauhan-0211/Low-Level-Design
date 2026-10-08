package LibraryManagementSysyem;

public class BookCopy {
    private String copyId;
    private Book book;
    private boolean isAvailable;
    
    public BookCopy(String copyId) {
        this.copyId = copyId;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void borrowCopy() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            throw new IllegalStateException("This copy is already borrowed.");
        }
    }

    public String getCopyId() {
        return copyId;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

}
