/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.hibermate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.hibermate.dao.*;
import ru.hibermate.model.Engine;

public class ApplicationDemo {

	public static void main(String[] args) {
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			DAO<Engine, String> engineDAO = new EngineDAO(factory);

			final Engine engine = new Engine();
			engine.setModel("engine_model_03");
			engine.setPower(12345);

			engineDAO.create(engine);

//			final Engine result = engineDAO.read("engine_model_03");
//			System.out.println("Created : " + result);
//			System.out.println();
//
//			result.setPower(54321);
//			engineDAO.update(result);
//
//			final Engine update = engineDAO.read("engine_model_03");
//			System.out.println("Updated : " + update);
//			System.out.println();
//
//			engineDAO.delete(new Engine("engine_model_03", 54321));
//
//			System.out.println("Deleted(empty obj) : " + engineDAO.read("engine_model_03"));
		} finally {
			if (factory != null) {
				factory.close();
			}
		}
	}
}