/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugea.controller;

import com.ugea.model.Proposta;
import com.ugea.model.Solicitacao;
import com.ugea.repositories.PropostaR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Eugenio
 */
@Controller
public class Daf {
    @Autowired
    PropostaR propostaR;
    
    @GetMapping("/deferirDaf/{id}")
    public String deferirUgea(@PathVariable("id") Integer id){
        propostaR.getById(id);
        Proposta updateSol = new Proposta();
        for(Proposta s : propostaR.findAll()){
            if (s.getCod_proposta() == id){
                updateSol.setCod_proposta(id);
                updateSol.setCod_solicitacao(s.getCod_solicitacao());
                updateSol.setAssunto(s.getAssunto());
                updateSol.setComentario(s.getComentario());
                updateSol.setData(s.getData());
                updateSol.setDescricao(s.getDescricao());
                updateSol.setScanner_proposta(s.getScanner_proposta());
                updateSol.setStatus("true");
                propostaR.save(updateSol);
            }
        }
        return "redirect:/daf";
    }
    
    
    @GetMapping("/indeferirDaf/{id}")
    public ModelAndView indeferirDaf(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("prop", propostaR.getById(id));
        mv.setViewName("daf/indeferirDaf");
        return mv;
    }
    
    @PostMapping("/indeferirD")
    public String indeferir(Proposta prop){
        prop.setStatus("false");
        propostaR.save(prop);
        return "redirect:/daf";
    }

}
