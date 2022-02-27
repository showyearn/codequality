/**
 * 
 */
package com.codequality.unittest.junit.mockito.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.codequality.unittest.junit.mockito.service.FinalService;
import com.codequality.unittest.junit.mockito.service.NormalService;

/**
 * @author qiuquanying
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MyDataControllerTest2 {
	private static final String DATA_OK = "ok";
	private static final String DATA_NO = "no";

	@InjectMocks
	MyDataController myDataController;

	@Mock
	FinalService finalService;
	@Mock
	NormalService normalService;

	@Test
	public void buildAll_final() {
		when(normalService.buildData()).thenReturn(null);
		when(finalService.buildData()).thenReturn(DATA_NO);

		String result = myDataController.buildAll();
		assertEquals(DATA_NO, result);
	}

	@Test
	public void buildAll_normal() {
		when(normalService.buildData()).thenReturn(DATA_OK);

		String result = myDataController.buildAll();
		assertEquals(DATA_OK, result);
	}

	@Test
	public void buildAll_new() {
		when(normalService.buildData()).thenReturn(DATA_OK);

//		NewService newService = mock(NewService.class);
//		doReturn(DATA_NO).when(newService).buildData();
		
//		NewService newService = new NewService();
//		NewService spy = spy(newService);
//		doReturn(DATA_NO).when(spy).buildData();
//		assertEquals(DATA_NO, newService.buildData());

		String result = myDataController.buildAll();
		assertEquals(DATA_OK, result);
	}
}
