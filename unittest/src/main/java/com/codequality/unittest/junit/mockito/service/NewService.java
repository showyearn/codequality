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
public class NewService {
	public static final String DATA = "new";
	
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String buildData() {
		if(null == this.getData()) {
			this.setData(DATA);
		}
		return this.getData();
	}
}
