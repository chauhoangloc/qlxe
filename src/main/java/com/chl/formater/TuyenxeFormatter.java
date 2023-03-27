/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.formater;


import com.chl.pojo.Tuyenxe;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author NC
 */
public class TuyenxeFormatter  implements Formatter<Tuyenxe> {

    @Override
    public String print(Tuyenxe t, Locale locale) {
        return String.valueOf(t.getIdTX());
    }

    @Override
    public Tuyenxe parse(String id, Locale locale) throws ParseException {
        Tuyenxe t = new Tuyenxe();
        t.setIdTX(Integer.parseInt(id));
        
        return t;
    }
}