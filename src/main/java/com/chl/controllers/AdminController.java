/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.controllers;

import com.chl.pojo.Chuyenxe;
import com.chl.service.ChuyenxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author NC
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private ChuyenxeService chuyenxeService;
    
   
    @ModelAttribute
    public void commonAttributes(Model model) {
        model.addAttribute("cx", this.chuyenxeService.getChuyenXes(null,0));

    }
    
    @GetMapping("/chuyenxe")
    public String tuyenxes(Model model){
            model.addAttribute("chuyenxe", new Chuyenxe());
          

    return "QTChuyenXe";
    }
    
    @PostMapping("/chuyenxe")
    public String addCX(Model model,@ModelAttribute(value="chuyenxe") Chuyenxe cx){
        if(this.chuyenxeService.AddOrUpdateCX(cx)==true)
            return "redirect:/";    
        else
            model.addAttribute("errMsg","Đã xảy ra lỗi !!");
        
        return "QTChuyenXe";
    }
    
   
    
    @GetMapping("/chuyenxe/{idchuyenxe}")
    public String update(Model model,@PathVariable(value="idchuyenxe")int id){
        model.addAttribute("chuyenxe", this.chuyenxeService.getChuyenxeId(id));
            
    return "QTChuyenXe";
    }
}
