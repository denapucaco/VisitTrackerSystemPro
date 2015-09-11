package com.sparsh.tracker.visit.cilent.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.sparsh.tracker.visit.domain.Visit;
import com.sparsh.tracker.visit.service.VisitService;

public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		VisitService visitorService = (VisitService) context.getBean("visitorServiceImpl");

		PlatformTransactionManager transactionManager = (PlatformTransactionManager) context.getBean("transactionManager");

		TransactionDefinition def = new DefaultTransactionDefinition(); 
		TransactionStatus status = transactionManager.getTransaction(def);

		try {

			Visit  visit = new Visit();
//			visit.setEmployee(new Employ);
//			visitor.setEmployeeName("Prashant Swamy");
			visit.setVisitorName("Prashant Swamy");
			visit.setRepresenting("Self");
//			visitor.setAddress("Chakan");
//			visitor.setVehicleNumber("");
//			visitor.setMaterial("");
			visit.setPurpose("Lunch");
			visit.setInTime(new Date());
//			visitor.setOutTime();
			visit.setCreatedOn(new Date());
			visit.setIsCanceled(false);

			visitorService.create(visit);
			transactionManager.commit(status);
		} catch (TransactionException e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
	}
}
