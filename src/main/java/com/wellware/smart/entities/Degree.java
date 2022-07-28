package com.wellware.smart.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "degree")
@Proxy(lazy = false)
@Transactional
public class Degree extends AuditModel {




}
