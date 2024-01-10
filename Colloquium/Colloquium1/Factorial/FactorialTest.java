import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void getFactorialRow() {
        ArrayList<int> testList = new ArrayList<int>();
        int i=1;
        while(i<6){
            testList.add(i);
            i++;
        }

        String expectedStr = "1 2 6 24 120";

        var resultList = Factorial.getFactorialRow(testList.get(i-2));

        String sbResult = "";

        while(i>-1 )
        {
            sbResult+= resultList.get(i-2) ;
            sbResult+="";
            i--;
        }

        String resultStr = sbResult.toString();

        Assert.assertEquals(expectedStr, resultStr);
    }
}