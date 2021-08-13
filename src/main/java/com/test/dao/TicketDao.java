package com.test.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer>{
	@Query("SELECT t FROM Ticket t where t.department.id =:id")
	List<Ticket> findByDepartmentId(@Param("id") String id);
	
	@Query("SELECT t FROM Ticket t where t.phoneNumber =:phone")
	List<Ticket> findByPhoneNumber(@Param("phone") String phone);
	
	@Query("SELECT t FROM Ticket t where t.postTime BETWEEN :timeFrom and :timeEnd")
	List<Ticket> findByPostTime(@Param("timeFrom") Date timeFrom, @Param("timeEnd") Date timeEnd);
	
	@Query("SELECT t FROM Ticket t where t.endTime BETWEEN :timeFrom and :timeEnd")
	List<Ticket> findByEndTime(@Param("timeFrom") Date timeFrom, @Param("timeEnd") Date timeEnd);
}
