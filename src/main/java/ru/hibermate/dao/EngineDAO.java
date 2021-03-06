/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.hibermate.dao;

//import com.sun.istack.internal.NotNull;

import com.sun.istack.internal.NotNull;
import org.hibernate.*;
import ru.hibermate.model.Engine;


public class EngineDAO implements DAO<Engine, String> {

	private final SessionFactory factory;

	public EngineDAO(@NotNull final SessionFactory factory) {
		this.factory = factory;
	}

	/**
	 * Create new engine in engines table.
	 *
	 * @param engine for add.
	 */
	@Override
	public void create(@NotNull final Engine engine) {
		try (final Session session = factory.openSession()) {
			session.beginTransaction();
			session.save(engine);
			session.getTransaction().commit();
		}
	}

	@Override
	public Engine read(@NotNull final String model) {
		try (final Session session = factory.openSession()) {

			final Engine result = session.get(Engine.class, model);

			return result != null ? result : new Engine();
		}
	}

	/**
	 * Update engine state.
	 *
	 * @param engine new state.
	 */
	@Override
	public void update(@NotNull final Engine engine) {
		try (Session session = factory.openSession()) {

			session.beginTransaction();

			session.update(engine);

			session.getTransaction().commit();
		}
	}

	/**
	 * Delete engine.
	 *
	 * @param engine for delete.
	 */
	@Override
	public void delete(@NotNull final Engine engine) {
		try (Session session = factory.openSession()) {

			session.beginTransaction();

			session.delete(engine);

			session.getTransaction().commit();
		}
	}
}