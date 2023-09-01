/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugea.controller;

import com.ugea.model.Solicitacao;
import com.ugea.repositories.SolicitacaoR;
import com.ugea.util.Util;
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
public class Sector {
    
    private String directorio  = "D:\\Web\\spring\\ugea\\src\\main\\resources\\static\\solicitacoes\\";
    
    @Autowired
    SolicitacaoR solicitacaoR;
    
    Util util = new Util();
    
    @PostMapping("/cadastrarSolicitacao")
    public String cadastrarSolicitacao(Solicitacao solicitacao, @RequestParam("file") MultipartFile doc){
        try {
            solicitacao.setData(util.getDataActual());
            if(!doc.isEmpty()){
                byte[] tamanho = doc.getBytes();
                Path caminho = Paths.get(directorio + doc.getOriginalFilename());
                Files.write(caminho, tamanho);
            }
        }catch(Exception e){
            System.out.println("erro");
            //return "redirect:/erro";
        }
        solicitacao.setStatus("pendente");
        solicitacao.setDocumento(doc.getOriginalFilename());
        solicitacaoR.save(solicitacao);
        return "redirect:/solicitacao";
    }
    
    @GetMapping("/deferirUgea/{id}")
    public String deferirUgea(@PathVariable("id") Integer id){
        solicitacaoR.getById(id);
        Solicitacao updateSol = new Solicitacao();
        for(Solicitacao s : solicitacaoR.findAll()){
            if (s.getCod_solicitacao() == id){
                updateSol.setCod_solicitacao(id);
                updateSol.setCod_sector(s.getCod_sector());
                updateSol.setAssunto(s.getAssunto());
                updateSol.setComentario(s.getComentario());
                updateSol.setData(s.getData());
                updateSol.setDescricao(s.getDescricao());
                updateSol.setDocumento(s.getDocumento());
                updateSol.setStatus("true");
                solicitacaoR.save(updateSol);
            }
        }
        return "redirect:/solicitacoesRecebidas";
    }
    
    @GetMapping("/indeferirUgea/{id}")
    public ModelAndView indeferirUgea(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("sol", solicitacaoR.getById(id));
        mv.setViewName("ugea/indeferirUgea");
        return mv;
    }
    
    @PostMapping("/indeferir")
    public String indeferir(Solicitacao sol){
        sol.setStatus("false");
        solicitacaoR.save(sol);
        return "redirect:/solicitacoesRecebidas";
    }
}
