/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugea.controller;

import com.ugea.model.Proposta;
import com.ugea.model.Solicitacao;
import com.ugea.repositories.PropostaR;
import com.ugea.repositories.SolicitacaoR;
import com.ugea.util.Util;
import jakarta.servlet.http.HttpSession;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Eugenio
 */
@Controller
public class Ugea {
    @Autowired
    PropostaR propostaR;
    
    @Autowired
    SolicitacaoR solicitacaoR;
    
    Util util = new Util();
    private String directorio  = "D:\\Web\\spring\\ugea\\src\\main\\resources\\static\\solicitacoes\\";
    
    
    @PostMapping("/proposta")
    public String proposta(Proposta proposta, @RequestParam("file") MultipartFile doc){
        
        Solicitacao s = solicitacaoR.getOne(proposta.getCod_solicitacao());
        try {
                if(!doc.isEmpty()){
                    byte[] bytes = doc.getBytes();
                    Path way = Paths.get(directorio, doc.getOriginalFilename());
                    Files.write(way, bytes);
                }
            }catch(Exception e){
                System.out.println("Contacte o admin!");
            }
            proposta.setAssunto(s.getAssunto());
            proposta.setDescricao(s.getDescricao());
            proposta.setScanner_proposta(doc.getOriginalFilename());
            proposta.setStatus("pendente");
            proposta.setData(util.getDataActual());
            
            propostaR.save(proposta);
           
        
        return "redirect:/propostas";
    }
    
    
    @GetMapping("/enviarProposta/{id}")
    public ModelAndView enviarPropostaId(@PathVariable("id") Integer id,HttpSession session){
        ModelAndView mv = new ModelAndView();
        if(session.getAttribute("ugea") != null){
            mv.addObject("sol",id);
            mv.addObject("proposta", new Proposta());
            mv.setViewName("ugea/enviarProposta");
        }else
            mv.setViewName("login/login");
        return mv;
    }
}
