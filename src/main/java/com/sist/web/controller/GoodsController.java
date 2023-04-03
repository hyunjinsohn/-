package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.GoodsDAO;
import com.sist.web.entity.GoodsEntity;
import com.sist.web.entity.GoodsFindVO;
import com.sist.web.entity.MinitPageVO;


@RestController
@CrossOrigin("http://localhost:3000")
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	
	@GetMapping("goods/goods_top6")
	public List<GoodsEntity> goodstop6(){
		List<GoodsEntity> list=dao.goodsTop6Data();
		return list;
	}
	
	
	@GetMapping("goods/goods_list_react")
	public List<GoodsEntity> goods_list_react(String page){
		if(page==null) 
			page="1";
		int rowSize=15;
		int start=rowSize*(Integer.parseInt(page)-1);
		List<GoodsEntity> list=dao.goodsListData(start);
		return list;
		}
	
	@GetMapping("goods/goods_page_react")
	public MinitPageVO goodsPageData(String page) {
		if(page==null)
			page="1";
		  int curpage=Integer.parseInt(page);
	      int totalpage=dao.goodsTotalPage();
	      final int BLOCK=5;
	      int startpage=((curpage-1)/BLOCK*BLOCK)+1;
	      int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	      if(endpage>totalpage) endpage=totalpage;
	      MinitPageVO vo=new MinitPageVO();
	      vo.setCurpage(curpage);
	      vo.setEndPage(endpage);
	      vo.setStartPage(startpage);
	      vo.setTotalpage(totalpage);
	      return vo;
	}
	
	@GetMapping("goods/goods_detail_react")
	public GoodsEntity goods_detail(int gno)
	{
		GoodsEntity vo=dao.findByGno(gno);
		return vo;
	}
	
	@GetMapping("goods/goods_find_react")
	public List<GoodsFindVO> goods_find(String page, String name)
	{
		List<GoodsFindVO> list=new ArrayList<GoodsFindVO>();
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int start=(curpage*12)-12;
		List<GoodsEntity> gList=dao.goodsFindData(name,start);
		int totalpage=dao.goodsFindTotalPage(name);
		int i=0;
		for(GoodsEntity gvo:gList)
		{
			GoodsFindVO vo=new GoodsFindVO();
			vo.setGno(gvo.getGno());
			vo.setPoster(gvo.getPoster());
			vo.setName(gvo.getName());
			if(i==0)
			{
				vo.setCurpage(curpage);
				vo.setTotalpage(totalpage);
			}
			list.add(vo);
			i++;
		}
		return list;
	}
}


























