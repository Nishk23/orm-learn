package com.orm.ormlearn.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orm.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	@Query("select s from Stock s where s.code like %:code% order by s.code ASC")
	List<Stock> findStockByCode(String code);

	@Query("select s from Stock s where s.code like %:code% and s.date between :startDate and :endDate")
	List<Stock> fbStockInSep19(String code, Date startDate, Date endDate);

	@Query("select s from Stock s where s.code like %:code% and s.close > :price")
	List<Stock> googleStocks(String code, double price);

	@Query(value = "select * from Stock order by st_volume desc limit 3", nativeQuery = true)
	List<Stock> topVolume();

	@Query(value = "select * from Stock where st_code like %:code% order by st_close asc limit 3", nativeQuery = true)
	List<Stock> lowNetflixStocks(String code);
}
