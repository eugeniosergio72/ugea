/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugea.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Eugenio
 */
@Entity
@Table(name = "proposta", catalog = "ugea", schema = "")
public class Proposta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_proposta", nullable = false)
    private Integer cod_proposta;
    @Column(name = "assunto", length = 150)
    private String assunto;
    @Column(name = "descricao", length = 250)
    private String descricao;
    @Column(name = "scanner_proposta", length = 255)
    private String scanner_proposta;
    @Column(name = "data", length = 18)
    private String data;
    @Column(name = "cod_solicitacao", nullable = false)
    private Integer cod_solicitacao;
    @Column(name = "status", nullable = false, length = 10)
    private String status;
    
    @Column(name = "comentario", length = 255)
    private String comentario;
    
    public Proposta() {
    }

    public Integer getCod_proposta() {
        return cod_proposta;
    }

    public void setCod_proposta(Integer cod_proposta) {
        this.cod_proposta = cod_proposta;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getScanner_proposta() {
        return scanner_proposta;
    }

    public void setScanner_proposta(String scanner_proposta) {
        this.scanner_proposta = scanner_proposta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public Integer getCod_solicitacao() {
        return cod_solicitacao;
    }

    public void setCod_solicitacao(Integer cod_solicitacao) {
        this.cod_solicitacao = cod_solicitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
   
}
