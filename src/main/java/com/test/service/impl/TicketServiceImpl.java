package com.test.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.dao.TicketDao;
import com.test.entity.Ticket;
import com.test.service.TicketService;

public class TicketServiceImpl implements TicketService{
	
	@Autowired 
	TicketDao ticketDao;

	@Override
	public List<Ticket> findAll() {
		return ticketDao.findAll();
	}

	@Override
	public Ticket createTicket(Ticket ticket) {
		return ticketDao.save(ticket);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		return ticketDao.save(ticket);
	}

	@Override
	public void deleteTicket(int id) {
		ticketDao.deleteById(id);;
	}

	@Override
	public List<Ticket> findByPostTime(Date fromTime, Date endTime) {
		return ticketDao.findByPostTime(fromTime, endTime);
	}

	@Override
	public List<Ticket> findByPhoneNumber(String phoneNumber) {
		return ticketDao.findByPhoneNumber(phoneNumber);
	}

	@Override
	public Optional<Ticket> finById(int id) {
		return ticketDao.findById(id);
	}

	@Override
	public List<Ticket> findByEndTime(Date fromTime, Date endTime) {
		return ticketDao.findByEndTime(fromTime, endTime);
	}

}
