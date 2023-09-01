/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugea.controller;

import com.ugea.model.Proposta;
import com.ugea.model.Sector;
import com.ugea.model.Solicitacao;
import com.ugea.model.TipoSector;
import com.ugea.repositories.PropostaR;
import com.ugea.repositories.SectorR;
import com.ugea.repositories.SolicitacaoR;
import com.ugea.repositories.TiposectorR;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Eugenio
 */
@Controller
public class Routas {

    @Autowired
    SolicitacaoR solicitacaoR;

    @Autowired
    SectorR sectorR;

    @Autowired
    PropostaR propostaR;

    @Autowired
    TiposectorR tiposector;

    //Routas Relacionadas a cadastro
    @GetMapping("/cadastro")
    public ModelAndView cadastro(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("admin") != null) {
            mv.setViewName("cadastro/cadastro");
        } else {
            mv.setViewName("login/login");
        }
        return mv;
    }

    //Routas Relacionadas a login
    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("secttor", new Sector());
        mv.setViewName("login/login");
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView loginU() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("secttor", new Sector());
        mv.setViewName("login/login");
        return mv;
    }

    //Routas Relacionadas a UGEA
    @GetMapping("/ugea")
    public ModelAndView homeUgea(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("ugea") != null) {
            mv.setViewName("ugea/ugea");
        } else {
            mv.setViewName("login/login");
        }
        return mv;
    }

    @GetMapping("/solicitacoesRecebidas")
    public ModelAndView solicitacoesRecebidas(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("ugea") != null) {
            mv.addObject("sol", solicitacaoR.findAll());
            mv.setViewName("ugea/solicitacoesRecebidas");
        } else {
            mv.setViewName("login/login");
        }
        return mv;
    }

    @GetMapping("/novaPropost")
    public ModelAndView novaPropost(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        List<Solicitacao> sol = solicitacaoR.findAll();
        List<Proposta> prop = propostaR.findAll();
        List<Solicitacao> solsempro = new ArrayList<>();
        List<Solicitacao> solsempro1 = new ArrayList<>();
        List<Integer> soliciP = new ArrayList<>();

        for (Proposta p : prop) {
            soliciP.add(p.getCod_solicitacao());
        }
        for (Solicitacao s : sol) {
            if (s.getStatus().equals("true")) {
                solsempro.add(s);
            }
        }
        for (Solicitacao s : solsempro) {
            if (!soliciP.contains(s.getCod_solicitacao())) {
                solsempro1.add(s);
            }
        }

        if (session.getAttribute("ugea") != null) {
            mv.addObject("sol", solsempro1);
            mv.setViewName("ugea/novaPropost");
        } else {
            mv.setViewName("login/login");
        }
        return mv;
    }

    @GetMapping("/propostas")
    public ModelAndView propostas(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        List<Solicitacao> sol = solicitacaoR.findAll();

        List<Proposta> prop = propostaR.findAll();

        List<Solicitacao> solsempro = new ArrayList<Solicitacao>();

        for (Solicitacao s : sol) {
            for (Proposta p : prop) {
                if (s.getCod_solicitacao() != p.getCod_solicitacao()) {
                    solsempro.add(s);
                }
            }
        }

        if (session.getAttribute("ugea") != null) {
            if (propostaR.findAll().isEmpty()) {
                mv.addObject("sol", solicitacaoR.findAll());
            } else if (!propostaR.findAll().isEmpty()) {
                mv.addObject("prop", propostaR.findAll());
                mv.addObject("sol", solsempro);
                mv.setViewName("ugea/propostas");
            }
        } else {
            mv.setViewName("login/login");
        }
        return mv;
    }

    @GetMapping("/enviarProposta")
    public ModelAndView enviarProposta(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("ugea") != null) {
            mv.setViewName("ugea/enviarProposta");
        } else {
            mv.setViewName("login/login");
        }
        return mv;
    }

    @GetMapping("/indeferirUgea")
    public ModelAndView indeferirUgea(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("ugea") != null) {
            mv.setViewName("ugea/indeferirUgea");
        } else {
            mv.setViewName("login/login");
        }
        return mv;
    }
    //Routas Relacionadas ao Admin

    @GetMapping("/adminHome")
    public ModelAndView adminHome(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("admin") != null) {
            mv.setViewName("admin/adminHome");
            mv.addObject("tipo_sector", new TipoSector());
            mv.addObject("lista_sectores", tiposector.findAll());
            mv.addObject("sector", new Sector());
        } else {
            mv.setViewName("login/login");
        }
        return mv;
    }

    //Routas Relacionadas a cada Departamento
    @GetMapping("/sector")
    public ModelAndView sector(HttpSession session) {

        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("sector") != null) {
            mv.addObject("sol", solicitacaoR.findAll());
            mv.addObject("tipo", tiposector.findAll());
            mv.addObject("sector", sectorR.findAll());
            mv.setViewName("sector/sector");
        } else {
            mv.setViewName("login/login");
        }
        return mv;
    }

    @GetMapping("/solicitacao")
    public ModelAndView solicitacao(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("sector") != null) {
            mv.setViewName("sector/solicitacao");
            mv.addObject("solicitacao", new Solicitacao());
        } else {
            mv.setViewName("login/login");
        }
        return mv;
    }
    //Routas Relacionadas a Daf

    @GetMapping("/daf")
    public ModelAndView daf(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("daf") != null) {
            mv.addObject("sol", solicitacaoR.findAll());
            mv.addObject("prop", propostaR.findAll());
            mv.setViewName("daf/daf");
        } else {
            mv.setViewName("login/login");
        }
        return mv;
    }

    @GetMapping("/indeferirDaf")
    public ModelAndView indeferirDaf(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("daf") != null) {
            mv.setViewName("daf/indeferirDaf");
        } else {
            mv.setViewName("login/login");
        }
        return mv;

    }

    //Routas Relacionadas aos Erros
    @GetMapping("/erro")
    public ModelAndView erro() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("erro/erro");
        return mv;

    }
}
