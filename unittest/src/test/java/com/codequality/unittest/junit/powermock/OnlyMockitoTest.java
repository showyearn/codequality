package com.codequality.unittest.junit.powermock;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class OnlyMockitoTest {

	@Test
	public void should_mock_final_class() {

		final String mockedValue = "xyz";

		FinalClass finalClass = Mockito.mock(FinalClass.class);

		when(finalClass.ask()).thenReturn(mockedValue);

		assertThat(finalClass.ask()).as("Class is mocked").isEqualTo(mockedValue);

	}

	@Test
	public void should_mock_final_method() {
		final FinalClass finalClass = Mockito.mock(FinalClass.class);

		doNothing().when(finalClass).say(anyString());

		Throwable throwable = catchThrowable(new ThrowingCallable() {
			@Override
			public void call() throws Throwable {
				finalClass.say("xyz");
			}
		});

		assertThat(throwable).as("Final method is mocked and exception is not thrown").isNull();

	}

}