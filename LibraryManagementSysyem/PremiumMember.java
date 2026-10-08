package LibraryManagementSysyem;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

public class PremiumMember implements LibraryMember {
    
    private static final int BOOK_BORROWING_LIMIT = 10;
    private static final int BORROWING_DURATION_IN_DAYS = 30;
    private final String id;
    private final Set<BorrowingRecord> activeBorrowings;
    
    public PremiumMember() {
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
