package com.aravind.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String type;
	private Double price;
	@Column(name = "insert_at",updatable = false)
	@CreationTimestamp
	private LocalDateTime insertt;
	@Column(name = "update_at",insertable  = false)
	@UpdateTimestamp
	private LocalDateTime updatee;
}
