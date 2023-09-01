/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugea.controller;
import com.ugea.model.Sector;
import com.ugea.model.TipoSector;
import com.ugea.repositories.SectorR;
import com.ugea.repositories.TiposectorR;
import com.ugea.util.Util;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Eugenio
 */
@Controller
public class Utiliador {
  
    @Autowired 
    TiposectorR tipo_sectorR;
    
    @Autowired 
    SectorR sectorR;
    
   @PostMapping("/cadastarTipoSector")
   public String cadastarTipoSector(TipoSector tipo_sector){
       tipo_sectorR.save(tipo_sector);
       return "redirect:/adminHome";
   }
   
   @PostMapping("/cadastarSector")
   public String cadastarSector(Sector sector){
       Util util = new Util();
       sector.setSenha(util.md5(sector.getSenha()));
       sectorR.save(sector);
       return "redirect:/adminHome";
   }
   
   
   @PostMapping("/efectuarLogin")
   public String efectuarLogin(Sector sector, HttpSession session, RedirectAttributes alerta){
       Sector logado = null;
       String retorno = "";
       String tipo_sector = "";
       List<Sector> todos_sectores = sectorR.findAll();
       List<TipoSector> tipoSectores = tipo_sectorR.findAll();
       Util util = new Util();
       String senhaCR = util.md5(sector.getSenha());
       for (Sector s: todos_sectores){
           if(s.getUsername().equalsIgnoreCase(sector.getUsername()) && s.getSenha().equalsIgnoreCase(senhaCR)){
               logado = s;
               for(TipoSector ts : tipoSectores){
                    if(ts.getCod_tipo_sector() == logado.getCod_tipo_sector()){
                        tipo_sector = ts.getTipo_acesso();
                        break;
                    }
                }
               break;
           }else if(sector.getSenha().equalsIgnoreCase("admin") && sector.getUsername().equalsIgnoreCase("admin") && sector.getCod_tipo_sector() == null && sector.getCodSector() == null){
               tipo_sector = "admin";
               break;
            }
       }
       
       if(tipo_sector != ""){
           if(tipo_sector.equalsIgnoreCase("DAF")){
               session.setAttribute("daf", logado);
               retorno = "redirect:/daf";
           }else if(tipo_sector.equalsIgnoreCase("UGEA")){
               session.setAttribute("ugea", logado);
               retorno = "redirect:/ugea";
           }else if(tipo_sector.equalsIgnoreCase("SECTOR")){
               session.setAttribute("sector", logado);
               retorno = "redirect:/sector";
           }else if(tipo_sector.equalsIgnoreCase("admin")){
                session.setAttribute("admin", "admin");
                retorno = "redirect:/adminHome";
            }else {
               retorno = "redirect:/erro";
           }
       }else {
            alerta.addFlashAttribute("alerta", "Nome Usuario ou Senha  Invalida");
            retorno = "redirect:/login";
        }
       
       
       return retorno;
   }
   
   
    
  
}
