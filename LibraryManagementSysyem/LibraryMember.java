package LibraryManagementSysyem;
import java.util.Set;

public interface LibraryMember { 
    public String getId();
    public int getBookBorrowingLimit();
    public int getBorrowingDurationInDays();
    public MembershipType getMembershipType();
    public int getActiveBorrowingsCount();
    public void removeActiveBorrowing(BorrowingRecord record);
    public void addActiveBorrowing(BorrowingRecord record);
    public Set<BorrowingRecord> getActiveBorrowings();
}
