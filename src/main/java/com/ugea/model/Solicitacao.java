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
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

/**
 *
 * @author Eugenio
 */
@Entity
@Table(name = "solicitacao", catalog = "ugea", schema = "")
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_solicitacao", nullable = false)
    private Integer cod_solicitacao;
    @Column(name = "assunto", length = 150)
    private String assunto;
    @Lob
    @Column(name = "descricao", length = 65535)
    private String descricao;
    @Column(name = "documento", length = 255)
    private String documento;
    @Column(name = "data", length = 18)
    private String data;
    @Column(name = "cod_sector", nullable = false)
    private Integer cod_sector;
    
    @Column(name = "status", nullable = false, length = 10)
    private String status;

    @Column(name = "comentario", length = 255)
    private String comentario;
    
    public Solicitacao() {
    }

    public Integer getCod_solicitacao() {
        return cod_solicitacao;
    }

    public void setCod_solicitacao(Integer cod_solicitacao) {
        this.cod_solicitacao = cod_solicitacao;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getCod_sector() {
        return cod_sector;
    }

    public void setCod_sector(Integer cod_sector) {
        this.cod_sector = cod_sector;
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

    public Solicitacao findById(Integer cod_solicitacao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
