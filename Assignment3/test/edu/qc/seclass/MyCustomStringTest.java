package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        // this test will count how many number are in your string
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
        // this test will see if it can correctly detect a string which only consist of integers as one.
        mycustomstring.setString("21321312");
        assertEquals(1, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers3() {
        // this test will see if it can read the empty string as 0
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers4() {
        // this test will see if it can take a string which contain two integers and output 2
        mycustomstring.setString("i have a number 2 cats and 10 birds");
        assertEquals(2, mycustomstring.countNumbers());
    }

    @Test(expected =NullPointerException.class)
    public void testCountNumbers5() {
        // this test should throw an exception regarding to a null string
        mycustomstring.setString(null);
        assertEquals("", mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers6() {
        // this test will see if it can take a string which contain 3 integers and output 3
        mycustomstring.setString("1dh 23 and 1qdwd");
        assertEquals(3, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        //this test will start from the beginning and output every 3 character
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        //this test will start from the end and get every 3 character
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        //this test will see if it can return every i in the string
        mycustomstring.setString("HiHiHiHi");
        assertEquals("iiii", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
}
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        //this test will see if it can return every letter that is seperated by two integers.
        mycustomstring.setString("23a74b82c94d28e83f");
        assertEquals("abcdef", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
}
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        //this test will see if it can return 3 whitespaces
        mycustomstring.setString("hi im in ");
        assertEquals("   ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        //this test will see if it will print out the exact string inputted
        mycustomstring.setString("hi");
        assertEquals("hi", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        //this test will start from the end and should print out the exact same string that was inputted
        mycustomstring.setString("hi");
        assertEquals("hi", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        //this test will see if it can print out the first character when starting from the end
        mycustomstring.setString("hello");
        assertEquals("h", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, true));
    }
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        //this test will see if it can output the last character when starting form the beginning
        mycustomstring.setString("hello");
        assertEquals("o", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        // this test should output every single character in the inputted string
        mycustomstring.setString("Hello my name is anthony");
        assertEquals("Hello my name is anthony", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        //thi test will see if it will output an empty string because the length of the string is less the 6
        mycustomstring.setString("pizza");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, false));
    }
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        //this test will see if it will output and empty string because the length of the string is less the 6 but it will start from the end
        mycustomstring.setString("donut");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, true));
    }

    @Test(expected =NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        //this test will take the input which is Null and output an exception
        mycustomstring.setString(null);
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test(expected =IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        // this test will throw an exception  because n<=0
        mycustomstring.setString("exception");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true));
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test(expected =IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring2() {
        //this test will see if it will throw an exception when starting position  is greater then that end position
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(23, 17);
        assertEquals("", mycustomstring.getString());
    }

    @Test(expected =MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() {
        //this test will see if it will throw an exception when the ending position is out of bound
        mycustomstring.setString("Hi, w5ere 3an i fi6d the notebook?");
        mycustomstring.convertDigitsToNamesInSubstring(5, 53);
        assertEquals("", mycustomstring.getString());
    }

    @Test(expected =NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring4() {
        //this test will see if it will throw an exception when the string is a null
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(5, 53);
        assertEquals("", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring5() {
        //this test should take the string full of integers and convert each one to a string
        mycustomstring.setString("4394");
        mycustomstring.convertDigitsToNamesInSubstring(1, 4);
        assertEquals("FourThreeNineFour", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        //this test should take the string with two sets of integers separated by a word and only convert the first set to strings
        mycustomstring.setString("23 hello 45");
        mycustomstring.convertDigitsToNamesInSubstring(1, 8);
        assertEquals("TwoThree hello 45", mycustomstring.getString());
    }

    @Test(expected =MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring7() {
        //this test will see if it will throw an exception when the starting position is out of bound
        mycustomstring.setString("Hi, w5ere 3an i fi6d the notebook?");
        mycustomstring.convertDigitsToNamesInSubstring(-3, 6);
        assertEquals("", mycustomstring.getString());    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        //this test will take the whole string from start to end and convert each integer to strings.
        mycustomstring.setString("hell0, tod4y is the 20");
        mycustomstring.convertDigitsToNamesInSubstring(1, 22);
        assertEquals("hellZero, todFoury is the TwoZero", mycustomstring.getString());    }

}
