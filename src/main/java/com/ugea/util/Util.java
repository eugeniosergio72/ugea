/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugea.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Eugenio
 */
public class Util {
    
    public String md5(String valor){
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            BigInteger bg = new BigInteger(md.digest(valor.getBytes()));
            return bg.toString(16);
        }catch(Exception e){
            return "Contacte o Admin!";
        }
    }
    
    //public Date getDataActual(){}
    public String getDataActual(){
        Date data = new Date();
        SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataActual = datetime.format(data);
//        Date  dataConvertida = new Date();
//        try {
//            dataConvertida = datetime.parse(dataActual);
//        }catch(Exception e){
//            System.out.println("Contacte o Admin!");
//        }
        return dataActual;
    }
}
