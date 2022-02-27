package com.codequality.unittest.junit.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.codequality.unittest.junit.mockito.service.FinalService;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
	@Test
	public void testOk() {
		FinalService finalService = mock(FinalService.class);
		when(finalService.buildData()).thenReturn("x");
		assertEquals("x",finalService.buildData());
	}
}
