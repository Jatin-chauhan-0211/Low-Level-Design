package Compressed_String_iterator;

public class Solution {
    
    public static void main(String[] args) {
        
        String compressedString = "RS4F";
        CompressedStringIterator iterator = new CompressedStringIterator(compressedString);
            System.out.println(iterator.next()); // return 'R'
            System.out.println(iterator.next()); // return 'S'
            System.out.println(iterator.next()); // return 'S'
            System.out.println(iterator.next()); // return 'S'
            System.out.println(iterator.next()); // return 'S'
            System.out.println(iterator.hasNext()); // return true
            System.out.println(iterator.next()); // return 'F'
            System.out.println(iterator.hasNext()); // return false
            System.out.println(iterator.next()); // return ' '
        
    }
}
