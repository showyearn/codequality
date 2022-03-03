package com.codequality.unittest.junit.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.codequality.unittest.junit.mockito.service.FinalService;
import com.codequality.unittest.junit.mockito.service.StaticService;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
	@Test
	public void testFinal() {
		FinalService finalService = mock(FinalService.class);
		when(finalService.buildData()).thenReturn("x");
		assertEquals("x", finalService.buildData());
	}

	@Test
	public void testStatic() {
		mockStatic(StaticService.class);
		when(StaticService.buildData()).thenReturn("x");
		assertEquals("x", StaticService.buildData());
	}
}
