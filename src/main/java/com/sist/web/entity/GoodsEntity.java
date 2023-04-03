package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/*
 *  gno int
 * 	poster varchar(1000) 
	name varchar(1000) 
	price varchar(200) 
	info varchar(100)
 */
@Entity
@Getter
@Setter
@Table(name="minit_goods")
public class GoodsEntity {
	@Id
	private int gno;
	
	private String poster;
	
	private String name;
	
	private String price;
	
	private String info;
}
