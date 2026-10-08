package LibraryManagementSysyem;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;
public class RegularMember implements LibraryMember {

    private final String id;
    private static final int BOOK_BORROWING_LIMIT = 5;
    private static final int BORROWING_DURATION_IN_DAYS = 14;
    private Set<BorrowingRecord> activeBorrowings;

    public RegularMember() {
        this.id = UUID.randomUUID().toString();
        this.activeBorrowings = new HashSet<>();
    }
    public int getActiveBorrowingsCount() {
        return activeBorrowings.size();
    }
    public Set<BorrowingRecord> getActiveBorrowings() {
        return activeBorrowings;
    }

    public void removeActiveBorrowing(BorrowingRecord record) {
        activeBorrowings.remove(record);
    }

    public void addActiveBorrowing(BorrowingRecord record) {
        activeBorrowings.add(record);
    }

    public MembershipType getMembershipType() {
        return MembershipType.Regular;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getBookBorrowingLimit() {
        return BOOK_BORROWING_LIMIT;
    }

    @Override
    public int getBorrowingDurationInDays() {
        return BORROWING_DURATION_IN_DAYS;
    }
    
}
