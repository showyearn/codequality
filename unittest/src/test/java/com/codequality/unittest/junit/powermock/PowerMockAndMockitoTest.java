package com.codequality.unittest.junit.powermock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import com.codequality.unittest.junit.mockito.service.FinalService;
import com.codequality.unittest.junit.mockito.service.NewService;
import com.codequality.unittest.junit.mockito.service.NormalService;
import com.codequality.unittest.junit.mockito.service.StaticService;
import com.codequality.unittest.junit.mockito.web.MyDataController;

/**
 * PowerMock和Mockito混合使用
 * 
 * @author qiuquanying
 *
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(MockitoJUnitRunner.class)
@PrepareForTest({ MyDataController.class, StaticService.class })
public class PowerMockAndMockitoTest {
	private static final String DATA_OK = "ok";
	private static final String DATA_NO = "no";

	@InjectMocks
	MyDataController myDataController;

	@Mock
	NormalService normalService;
	@Mock
	NewService newService;
	@Mock
	FinalService finalService;

	@Test
	public void testFinal() {
		String value = "x";
		FinalService finalService = PowerMockito.mock(FinalService.class);
		PowerMockito.when(finalService.buildData()).thenReturn(value);
		assertEquals(value, finalService.buildData());
	}

	@Test
	public void testStatic() {
		String value = "x";
		PowerMockito.mockStatic(StaticService.class);
		when(StaticService.buildData()).thenReturn("x");
		assertThat(StaticService.buildData()).as("Static method is mocked").isEqualTo(value);
	}

	@Test
	public void testNew() throws Exception {
		when(normalService.buildData()).thenReturn(DATA_OK);

		NewService newService = new NewService();
		newService.setData(DATA_NO);
		PowerMockito.whenNew(NewService.class).withAnyArguments().thenReturn(newService);

		assertThat(myDataController.buildAll()).as("NewService is not mocked").isEqualTo(DATA_NO);
	}
}
