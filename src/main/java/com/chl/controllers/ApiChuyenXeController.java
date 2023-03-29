/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.controllers;

import com.chl.service.ChuyenxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NC
 */
@RestController
public class ApiChuyenXeController {
    @Autowired
    private ChuyenxeService chuyenxeService;
    
    @DeleteMapping("/api/chuyenxe/{idchuyenxe}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable(value = "idchuyenxe") int id) {
        this.chuyenxeService.delCX(id);
    }
}
