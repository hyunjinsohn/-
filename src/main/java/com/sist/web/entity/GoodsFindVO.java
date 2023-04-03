package com.sist.web.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsFindVO {
	private int gno;
	private String name,poster,info;
	private int curpage, totalpage;
}
