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
@Table(name = "sector", catalog = "ugea", schema = "")
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_sector", nullable = false)
    private Integer codSector;
    @Basic(optional = false)
    @Column(name = "senha", nullable = false, length = 255)
    private String senha;
    @Basic(optional = false)
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "cod_tipo_sector", nullable = false)
    private Integer cod_tipo_sector;

    public Sector() {
    }

    public Integer getCodSector() {
        return codSector;
    }

    public void setCodSector(Integer codSector) {
        this.codSector = codSector;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCod_tipo_sector() {
        return cod_tipo_sector;
    }

    public void setCod_tipo_sector(Integer cod_tipo_sector) {
        this.cod_tipo_sector = cod_tipo_sector;
    }

    

    
}
