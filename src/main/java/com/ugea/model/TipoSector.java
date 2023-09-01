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
@Table(name = "tipo_sector", catalog = "ugea", schema = "")
public class TipoSector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tipo_sector", nullable = false)
    private Integer cod_tipo_sector;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 250)
    private String nome;
    @Basic(optional = false)
    @Column(name = "responsavel", nullable = false, length = 100)
    private String responsavel;

    @Column(name = "tipo_acesso", nullable = false, length = 100)
    private String tipo_acesso;
    
    public TipoSector() {
    }

    
    public Integer getCod_tipo_sector() {
        return cod_tipo_sector;
    }

    public void setCod_tipo_sector(Integer cod_tipo_sector) {
        this.cod_tipo_sector = cod_tipo_sector;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTipo_acesso() {
        return tipo_acesso;
    }

    public void setTipo_acesso(String tipo_acesso) {
        this.tipo_acesso = tipo_acesso;
    }

    

}
