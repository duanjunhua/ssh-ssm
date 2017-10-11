package com.djh;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import junit.framework.TestCase;

public class EmployeeTest extends TestCase {

	public void test() {

		// 0
		SessionFactory sessionFactory = null;
		// 2
		Configuration configuration = new Configuration().configure();
		configuration.addClass(Employee.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		// 3
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		// 4
		Session session = sessionFactory.openSession();
		// 5
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee(4400, "Michael", 5000, new Date(new java.util.Date().getTime()));

		session.save(employee);

		transaction.commit();

		session.close();

		sessionFactory.close();
	}
}
