package com.spring.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "freeboard")
public class Freeboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long freeID;
    private String content;
    private String title;
    private String wirter;
}
