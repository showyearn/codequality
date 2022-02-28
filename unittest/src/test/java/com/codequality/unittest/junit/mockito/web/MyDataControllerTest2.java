/**
 * 
 */
package com.codequality.unittest.junit.mockito.web;

import static org.assertj.core.api.Assertions.assertThat;
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

/**
 * @author qiuquanying
 *
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(MockitoJUnitRunner.class)
@PrepareForTest({ MyDataController.class, StaticService.class })
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
	public void testNew() throws Exception {
		when(normalService.buildData()).thenReturn(DATA_OK);

		NewService newService = new NewService();
		newService.setData(DATA_NO);
		PowerMockito.whenNew(NewService.class).withAnyArguments().thenReturn(newService);

		assertThat(myDataController.buildAll()).as("NewService is not mocked").isEqualTo(DATA_NO);
	}
}
