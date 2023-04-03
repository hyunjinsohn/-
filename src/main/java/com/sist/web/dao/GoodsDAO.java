package com.sist.web.dao;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.GoodsEntity;

@Repository
public interface GoodsDAO extends JpaRepository<GoodsEntity, Integer> {
	@Query(value="SELECT * FROM minit_goods "
			+"LIMIT 0,6", nativeQuery = true)
	public List<GoodsEntity> goodsTop6Data();
	
	@Query(value = "SELECT * from minit_goods "
			+"ORDER BY gno ASC LIMIT :start,12",nativeQuery = true)
	public List<GoodsEntity> goodsListData(@Param("start") Integer start);
	
	@Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM minit_goods",nativeQuery = true)
	public int goodsTotalPage();
	
	public GoodsEntity findByGno(@Param("gno") Integer gno);
	
	@Query(value = "SELECT * from minit_goods "
			+"WHERE name LIKE CONCAT('%',:name,'%') "
			+"LIMIT :start,12", nativeQuery = true)
	public List<GoodsEntity> goodsFindData(@Param("name") String name, @Param("start") Integer start);
	
	@Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM minit_goods "
			+"WHERE name LIKE CONCAT('%',:name,'%') ",nativeQuery = true)
	public int goodsFindTotalPage(@Param("name") String name);
}
