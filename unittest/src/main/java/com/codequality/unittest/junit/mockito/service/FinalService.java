/**
 * 
 */
package com.codequality.unittest.junit.mockito.service;

import org.springframework.stereotype.Component;

/**
 * @author qiuquanying
 *
 */
@Component
public final class FinalService {
	public static final String DATA = "final";

	public final String buildData() {
		return DATA;
	}
}
