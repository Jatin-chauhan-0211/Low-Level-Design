package LibraryManagementSysyem;

import java.util.List;

public interface LibraryMember { 
    public String getId();
    public int getBookBorrowingLimit();
    public int getBorrowingDurationInDays();
    public int getActiveBorrowingsCount();
    public void removeActiveBorrowing(BorrowingRecord record);
    public void addActiveBorrowing(BorrowingRecord record);
    public List<BorrowingRecord> getActiveBorrowings();
}
