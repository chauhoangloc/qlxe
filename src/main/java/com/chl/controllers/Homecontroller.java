/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.controllers;

import com.chl.pojo.Chuyenxe;
import com.chl.service.ChuyenxeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author NC
 */
@Controller
public class Homecontroller {
    @Autowired
    private ChuyenxeService chuyenxeService;
    
    @RequestMapping(value = "/")
    public String index(Model model) {
        List<Chuyenxe> chuyenxe= this.chuyenxeService.getChuyenXes();
        model.addAttribute("cx",chuyenxe);
        
        return "index";
    }
}
