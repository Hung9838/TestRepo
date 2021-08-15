package com.test.rest.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Ticket;
import com.test.service.impl.TicketServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class TicketRestController {
	
	@Autowired
	TicketServiceImpl ticketService;

	@GetMapping("/ticket")
	public ResponseEntity<List<Ticket>> getAllTicket(Model model) {
		List<Ticket> listTicket = ticketService.findAll();
		if (listTicket.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listTicket);
	}

	@GetMapping("/ticket/{id}")
	public ResponseEntity<Ticket> getOneTicket(@PathVariable("id") Integer id) {
		if (ticketService.findById(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ticketService.findById(id).get());
	}
	
	@PostMapping("/ticket")
	public ResponseEntity<Ticket> postTicket(@RequestBody Ticket ticket) {
		if (!ticketService.findById(ticket.getId()).isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		ticketService.createTicket(ticket);
		return ResponseEntity.ok(ticket);
	}

	@PutMapping("/ticket")
	public ResponseEntity<Ticket> putTicket(
			@RequestBody Ticket ticket) {
		if (ticketService.findById(ticket.getId()).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		ticketService.updateTicket(ticket);
		return ResponseEntity.ok(ticket);
	}

	@DeleteMapping("/ticket/{id}")
	public ResponseEntity<Ticket> dleteTicket(@PathVariable("id") int id) {
		if (ticketService.findById(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		ticketService.deleteTicket(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/ticketPhone/{phone}")
	public ResponseEntity<List<Ticket>> getPhoneTicket(@PathVariable("phone") String phone) {

		return ResponseEntity.ok(ticketService.findByPhoneNumber(phone));
	}
	
	@GetMapping("/ticketDate/{fromTime}/{endTime}")
	public ResponseEntity<List<Ticket>> getPostTimeTicket(
			@PathVariable("fromTime") String sFromTime, 
			@PathVariable("endTime") String sEndTime) throws ParseException {
		Date fromTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(sFromTime);
		Date endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(sEndTime);
		return ResponseEntity.ok(ticketService.findByPostTime(fromTime, endTime));
	}
}
