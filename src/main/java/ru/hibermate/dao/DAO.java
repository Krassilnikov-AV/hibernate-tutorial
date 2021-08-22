/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.hibermate.dao;


public interface DAO<Entity, Key> {
	void create(Entity entity);
	Entity read(Key key);
	void update(Entity entity);
	void delete(Entity entity);
}