package com.stormtechio.shinjitsu.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.stormtechio.shinjitsu.utils.Filter;
import com.stormtechio.shinjitsu.utils.FilterType;
import com.stormtechio.shinjitsu.utils.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stormtechio.shinjitsu.model.Payment;
import com.stormtechio.shinjitsu.repository.PaymentRepository;
import com.stormtechio.shinjitsu.utils.Utils;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	public List<Payment> getPayments(){
		
		List<Payment> payments =  this.paymentRepository.findAll();
		Iterator<Payment> paymentsIterator =  payments.iterator();
		while(paymentsIterator.hasNext()) {
			Payment payment = paymentsIterator.next();
			payment.getUser().setPassword(null);
		}
		
		return payments;
	}

	public Map<String, String> makePayment(Payment payment) {
		Map<String, String> response = new HashMap<>();
		if(payment == null) {
			 response.put(Utils.STATUS_KEY, Utils.STATUS_FAIL);
			 response.put(Utils.MESSAGE_KEY, "No payment was sent to the server or the Id is not valid");
			 return response;
		}
		
		this.paymentRepository.save(payment);
		
		response.put(Utils.STATUS_KEY, Utils.STATUS_SUCCESS);
		response.put(Utils.MESSAGE_KEY, "Payment saved sucessfuly");
		return response;
			
		
	}

	public List<Payment> filter(Filter filter) {

		if(filter.getSortType().equals(SortType.ANY) && filter.getFilterType().equals(FilterType.ALL)){
			return getPayments();
		}

		if(filter.getSortType().equals(SortType.DESC)){
			switch (filter.getFilterType()){
				case PAID:
					return this.paymentRepository.filterPaymentsDESC(1);

				case NOT_PAID:
					return this.paymentRepository.filterPaymentsDESC(0);

			}
		}else{
			switch (filter.getFilterType()){
				case PAID:
					return this.paymentRepository.filterPaymentsASC(1);
				case NOT_PAID:
					return this.paymentRepository.filterPaymentsASC(0);
			}
		}

		return null;
	}
}
