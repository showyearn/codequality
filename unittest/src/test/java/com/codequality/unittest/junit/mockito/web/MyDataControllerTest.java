/**
 * 
 */
package com.codequality.unittest.junit.mockito.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.codequality.unittest.junit.mockito.service.FinalService;
import com.codequality.unittest.junit.mockito.service.NormalService;

/**
 * @author qiuquanying
 *
 */
@ExtendWith(MockitoExtension.class)
public class MyDataControllerTest {
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
}
