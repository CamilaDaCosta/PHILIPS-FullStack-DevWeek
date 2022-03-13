package com.dio.PHILIPSFullStackDevWeek.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_regiao")
public class Regiao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private String regiao;
    private Long total_exames;

    public Regiao() {
    }

    public Regiao(String regiao, Long total_exames) {
        this.regiao = regiao;
        this.total_exames = total_exames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Long getTotal_exames() {
        return total_exames;
    }

    public void setTotal_exames(Long total_exames) {
        this.total_exames = total_exames;
    }
}
