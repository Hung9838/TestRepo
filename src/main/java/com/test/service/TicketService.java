package com.test.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.test.entity.Ticket;

public interface TicketService {
	// Lay tat ca
	List<Ticket> findAll();
	// Them
	Ticket createTicket(Ticket ticket);
	// Sua
	Ticket updateTicket(Ticket ticket);
	// Xoa
	void deleteTicket(int id);
	// Tim kiem theo khoan thoi gian tiep nhan
	List<Ticket> findByPostTime(Date fromTime, Date endTime);	
	// Tim kiem theo so dien thoai khach hang
	List<Ticket> findByPhoneNumber(String phoneNumber);
	// Tim kiem theo id
	Optional<Ticket> findById(int id);
	// Tim kiem theo thoi gian xu ly
	List<Ticket> findByEndTime(Date fromTime, Date endTime);
}
