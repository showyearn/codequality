/**
 * 
 */
package com.codequality.unittest.junit.mockito.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.codequality.unittest.junit.mockito.util.TestFinalUtil;

/**
 * @author qiuquanying
 *
 */
@ExtendWith(MockitoExtension.class)
public class TestControllerTest {
	@InjectMocks
	TestController testController;

	@Mock
	TestFinalUtil testFinalUtil;

	@Test
	public void testFinal() {
		String result = testController.testFinal();
		assertEquals("ok", result);
	}
}
