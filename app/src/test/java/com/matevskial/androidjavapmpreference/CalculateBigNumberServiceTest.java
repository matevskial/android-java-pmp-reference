package com.matevskial.androidjavapmpreference;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculateBigNumberServiceTest {

    @Test
    public void testCalculateBigNumber() {
        CalculateBigNumberService service = new CalculateBigNumberService();
        long got = service.calculateBigNumber();
        assertNotEquals("result should not be zero", 0, got);
    }
}