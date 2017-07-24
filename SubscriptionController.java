package com.example.steven1.demo1.restcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.steven1.demo1.services.TruncatorService;

@Controller
public class SubscriptionController {
	
	@Autowired
	TruncatorService truncatorService;

	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	@ResponseBody
	public String subscribe(HttpServletRequest request) {

		String orderDetails = getOrderDetails(request);
		String truncatedOrderDetails = truncate(orderDetails, 20);
		log(truncatedOrderDetails);

		return truncatedOrderDetails;
	}

	private String truncate(String orderDetail, int length) {

		return truncatorService.truncate(orderDetail, length);
	}

	private String getOrderDetails(HttpServletRequest request) {

		return "123456789012345678901234567890";
		//"123456789";
	}

	private void log(String message) {
		
		

	}

}
