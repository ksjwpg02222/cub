package com.cub.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "currency")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Currency extends BaseEntity {

    @Column
    private String name;

    @Column
    private String code;
}
