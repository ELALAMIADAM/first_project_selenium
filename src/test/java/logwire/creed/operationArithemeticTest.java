package logwire.creed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Executable;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class operationArithemeticTest {
    
    @Test 
    @Tag ("smoke")
    public void subPosTest(){
        int x=10, y=8;
        operationArithemetic oa = new operationArithemetic(x, y);
        if(x >= 0 && y >= 0){
            if(x-y>0) assertEquals(x-y, oa.subPos()); 
            else assertEquals(0, oa.subPos());
        }
        else {
            assertThrows(RuntimeException.class, ()->oa.subPos());
        }
    }
    @ParameterizedTest 
    @CsvFileSource(resources = "/jdd.csv", numLinesToSkip=1)
    @Tags ({@Tag ("smoke"),@Tag ("TNR")})
    public void subPosTestWithJdd(int x, int y, String result){
        operationArithemetic oa = new operationArithemetic(x, y);
        if(x >= 0 && y >= 0){
            assertEquals(Integer.parseInt(result), oa.subPos());
        }
        else {
            assertThrows(RuntimeException.class, ()->oa.subPos());
        }
    }
}
