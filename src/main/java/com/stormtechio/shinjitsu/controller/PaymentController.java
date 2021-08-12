package com.stormtechio.shinjitsu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.stormtechio.shinjitsu.utils.Filter;
import com.stormtechio.shinjitsu.utils.FilterType;
import com.stormtechio.shinjitsu.utils.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.web.bind.annotation.*;

import com.stormtechio.shinjitsu.model.Payment;
import com.stormtechio.shinjitsu.service.PaymentService;

@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@GetMapping("/")
	@ResponseBody
	public List<Payment> getPayments() {
		return this.paymentService.getPayments();
	}
	
	@PostMapping("/")
	@ResponseStatus
	public Map<String, String> makePayment(@RequestBody Payment payment) {
		return this.paymentService.makePayment(payment);
	}

	@GetMapping("/filter/{sort}/{type}")
	@ResponseBody
	public List<Payment> filterPayments(@PathVariable SortType sort, @PathVariable FilterType type){
		Filter filter = new Filter();
		filter.setFilterType(type);
		filter.setSortType(sort);

		return this.paymentService.filter(filter);

	}

	
}
