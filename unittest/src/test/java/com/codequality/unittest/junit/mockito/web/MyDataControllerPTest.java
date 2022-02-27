package com.codequality.unittest.junit.mockito.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.codequality.unittest.junit.mockito.service.NewService;
import com.codequality.unittest.junit.mockito.service.NormalService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MyDataController.class, NewService.class, NormalService.class })
public class MyDataControllerPTest {
	private static final String DATA_OK = "ok";
	private static final String DATA_NO = "no";

	@Test
	public void buildAll_new() {
		MyDataController myDataController = new MyDataController();

		NormalService normalService = mock(NormalService.class);
		when(normalService.buildData()).thenReturn(DATA_OK);

		String result = myDataController.buildAll();
		assertEquals(DATA_NO, result);
	}
}
