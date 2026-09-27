package Compressed_String_iterator;

class CompressedStringIterator {
    private final String compressedString;
    private int index;
    private char currentChar;
    private int currentCharCount;
    private int currentCount;
    public CompressedStringIterator(String compressedString) {
        this.compressedString = compressedString;
        this.index = 0;
        this.currentChar = '\0';
        this.currentCharCount = 0;
        this.currentCount = 0;
    }
    public boolean hasNext() {
        if(currentCount<currentCharCount || index<compressedString.length()){
            return true;
        }
        return false;
    }

    public char next(){
        if (!hasNext()) {
            return ' ';
        }
        if(currentCount<currentCharCount){
            currentCount++;
            return currentChar;
        }
         
        char ch=compressedString.charAt(index++);
        if(!Character.isLetter(ch)) { throw new IllegalArgumentException("Invalid compressed string format"); }
       
            currentChar = ch;
            currentCharCount = 0;
            while (index < compressedString.length() && Character.isDigit(compressedString.charAt(index))) {
                currentCharCount = currentCharCount * 10 + (compressedString.charAt(index) - '0');
                index++;
            }
            currentCount = 1;
            return currentChar;
    }
    
}
