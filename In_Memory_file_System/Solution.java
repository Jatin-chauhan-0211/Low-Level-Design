
import java.util.*;

class Solution {
    public static void main(String[] arg){

        FileSystem fs = new FileSystem();

        System.out.println(fs.ls("/"));

        fs.mkdir("/a/b/c");

        fs.addContentToFile("/a/b/c/d", "hello");

        System.out.println(fs.ls("/"));
        System.out.println(fs.ls("/a"));
        System.out.println(fs.readContentFromFile("/a/b/c/d"));
    }
}
