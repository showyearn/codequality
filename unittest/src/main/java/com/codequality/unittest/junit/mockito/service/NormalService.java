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
public class NormalService {
	public static final String DATA = "normal";

	public String buildData() {
		return DATA;
	}
}
