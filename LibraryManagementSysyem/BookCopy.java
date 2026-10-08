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

    public void setAvailable() {
        isAvailable = true;
    }

    public void returnCopy() {
        isAvailable = true;
    }

    public boolean borrowCopy() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        } else {
            return false;
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
