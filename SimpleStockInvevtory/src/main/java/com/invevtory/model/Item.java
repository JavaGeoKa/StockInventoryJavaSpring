package com.invevtory.model;



import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(of = {"code"})
@Entity
public class Item {
	
	@Id
	String code;
	String name;
	int amount;
}
