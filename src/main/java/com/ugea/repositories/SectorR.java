/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ugea.repositories;

import com.ugea.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eugenio
 */
public interface SectorR extends JpaRepository<Sector,Integer>{
    
}
