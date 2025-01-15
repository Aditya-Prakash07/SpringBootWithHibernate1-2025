package com.aditya.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aditya.main.entities.User;

@SpringBootApplication
public class SpringBootWithHibernate1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithHibernate1Application.class, args);

		Configuration cfg = new Configuration();
		cfg.configure("com/aditya/main/config/hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); // for getting values from database we do not need any
																// kind of transaction

		try {
			User user = session.get(User.class, 1L);
			if (user != null) {
				System.out.println("----------------------------------------");
				System.out.println(user.getName());
				System.out.println(user.getEmail());
				System.out.println("----------------------------------------");
			} else {
				System.out.println("USER NOT FOUND!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
