/**
 * 
 */
package com.codequality.unittest.junit.mockito.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codequality.unittest.junit.mockito.service.FinalService;
import com.codequality.unittest.junit.mockito.service.NewService;
import com.codequality.unittest.junit.mockito.service.NormalService;

/**
 * @author qiuquanying
 *
 */
@Controller
@RequestMapping("/data")
public class MyDataController {
	@Autowired
	private FinalService finalService;
	@Autowired
	private NormalService normalService;

	@GetMapping("/buildAll")
	public final String buildAll() {
		String buildNomal = normalService.buildData();
		if (null != buildNomal) {
			NewService newService = new NewService();
			String buildNew = newService.buildData();
			if (NewService.DATA.equals(buildNew)) {
				return buildNomal;
			} else {
				return buildNew;
			}
		} else {
			return finalService.buildData();
		}
	}
}
