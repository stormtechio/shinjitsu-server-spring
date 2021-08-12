package com.stormtechio.shinjitsu.repository;

import java.util.List;
import java.util.Optional;

import com.stormtechio.shinjitsu.utils.SortType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.stormtechio.shinjitsu.model.Payment;

public interface PaymentRepository extends Repository<Payment, Integer>{
	void save(Payment payment);
	void deleteById(Integer id);
	List<Payment> findAll();
	Optional<Payment> findById(Integer id);

	@Query(nativeQuery = true,
			value = "SELECT * FROM (select p.id as payment_id,  p.user_id, p.amount, u.id,u.name,u.email,p.due_date, p.payment_date, p.paid from payment p join user u on p.user_id = u.id) AS t1 WHERE t1.paid = ?1 ORDER BY t1.name ASC")
	List<Payment> filterPaymentsASC(int paymentStatus);
	@Query(nativeQuery = true,
			value = "SELECT * FROM (select p.id as payment_id, p.user_id, p.amount, u.id,u.name,u.email,p.due_date, p.payment_date, p.paid from payment p join user u on p.user_id = u.id) AS t1 WHERE t1.paid = ?1 ORDER BY t1.name DESC")
	List<Payment> filterPaymentsDESC(int paymentStatus);
}
