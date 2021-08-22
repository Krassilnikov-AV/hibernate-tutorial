/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package ru.hibermate.model;

import lombok.*;
/*
условия для hibermate
1. пустой конструктор
2. геттеры и сеттеры
3. долно быть своё id - в таблице долно быть как PRIMARY KEY,
   т.е.первичный ключ, иначе не сможет работать с hibermate
4. класси не долден быть final
Все условия соблюдены в представленном классе.
 */
// дожен быть первыичный ключ
@Data 
@ToString 
@EqualsAndHashCode 
@NoArgsConstructor  // требование пустого конструктора - ламбук
@AllArgsConstructor

public class Engine {

	private String model;
	private int power;


	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setPower(int power) {
		this.power = power;
	}
}