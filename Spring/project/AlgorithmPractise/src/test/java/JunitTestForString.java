import com.jiadong.String.*;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

public class JunitTestForString {

    @Test
    public void test1() {
        String word = "Hello New wordn";
        FindDupChar findDupChar = new FindDupChar();
        System.out.println(findDupChar.findDupChar(word));

    }

    @Test
    public void test2() {
        String word = "HelloNew";
        String anagram = "weNolleH";
        AnagramCheck anagramCheck = new AnagramCheck();
        System.out.println(anagramCheck.isAnagram("word", "wrdo"));
        System.out.println(anagramCheck.isAnagram("ccc", "ccc"));

    }


    @Test
    public void test3() {
        String word = "abcdefa";
        FirstUniqueChar firstUniqueChar  = new FirstUniqueChar();
        System.out.println(firstUniqueChar.firstUniqueChar(word));

    }

    @Test
    public void test4() {
        String word1 = "abcdef4";
        String word2 = "12345er0";
        String word3 = "12309345";
        CheckStringNum checkStringNum = new CheckStringNum();
        System.out.println(checkStringNum.onlyNum(word1));
        System.out.println(checkStringNum.onlyNum(word2));
        System.out.println(checkStringNum.onlyNum(word3));
    }

    @Test
    public void test5() {
        String word1 = "abcdef4";
        CheckVowelNum checkVowelNum = new CheckVowelNum();
        System.out.println(checkVowelNum.vowelNum(word1));
    }

    @Test
    public void test6(){
        String word1 = "aadeded";
        String word2 = "deeddaa";
        Rotation rotation = new Rotation();
        System.out.println(rotation.isRotated(word1, word2));
    }

}
