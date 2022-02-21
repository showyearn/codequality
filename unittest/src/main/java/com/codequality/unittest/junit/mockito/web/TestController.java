/**
 * 
 */
package com.codequality.unittest.junit.mockito.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codequality.unittest.junit.mockito.util.TestFinalUtil;

/**
 * @author qiuquanying
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestFinalUtil testFinalUtil;

	@GetMapping("/testFinal")
	public String testFinal() {
		return testFinalUtil.testFinal();
	}
}
