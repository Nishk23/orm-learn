package com.cognizant.ormlearn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "st_id")
	private int id;

	@NonNull
	@Column(name = "st_code")
	private String code;

	@NonNull
	@Column(name = "st_date")
	private Date date;

	@Column(name = "st_open")
	private double open;

	@Column(name = "st_close")
	private double close;

	@Column(name = "st_volume")
	private int volume;
}
