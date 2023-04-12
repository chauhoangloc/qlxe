/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.controllers;

import com.chl.Utils.Utils;
import com.chl.pojo.Chuyenxe;
import com.chl.pojo.Tuyenxe;
import com.chl.pojo.Cart;
import com.chl.service.ChuyenxeService;
import com.chl.service.TuyenxeService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author NC
 */
@Controller
@ControllerAdvice
public class Homecontroller {

    @Autowired
    private TuyenxeService tuyenxeService;
    @Autowired
    private ChuyenxeService chuyenxeService;

    @ModelAttribute
    public void commonAt(Model model, @RequestParam Map<String, String> params, HttpSession sesion){
        List<Tuyenxe> tuyenxe = this.tuyenxeService.getTuyenxes();
        model.addAttribute("tx", tuyenxe);
        
        model.addAttribute("cartCouter", Utils.countCart((Map<Integer, Cart>) sesion.getAttribute("cart")));
    }  
    
    @RequestMapping(value = "/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        int page= Integer.parseInt(params.getOrDefault("page", "1"));
        List<Chuyenxe> chuyenxe = this.chuyenxeService.getChuyenXes(params, page);
       

        model.addAttribute("countCX",this.chuyenxeService.count());
        model.addAttribute("cx",chuyenxe);
        return "index";
    }
    
}
