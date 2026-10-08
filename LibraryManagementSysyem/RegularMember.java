package LibraryManagementSysyem;
import java.util.UUID;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class RegularMember implements LibraryMember {

    private final String id;
    private static final int BOOK_BORROWING_LIMIT = 5;
    private static final int BORROWING_DURATION_IN_DAYS = 14;
    private final Set<BorrowingRecord> activeBorrowings;

    public RegularMember() {
        this.id = UUID.randomUUID().toString();
        this.activeBorrowings = new HashSet<>();
    }
    public int getActiveBorrowingsCount() {
        return activeBorrowings.size();
    }
     public List<BorrowingRecord> getActiveBorrowings() {
        return new ArrayList<>(activeBorrowings);
    }

    public void removeActiveBorrowing(BorrowingRecord record) {
        activeBorrowings.remove(record);
    }

    public void addActiveBorrowing(BorrowingRecord record) {
        activeBorrowings.add(record);
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
