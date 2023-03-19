/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.service.impl;

import com.chl.pojo.Chuyenxe;
import com.chl.repository.ChuyenxeReposity;
import com.chl.service.ChuyenxeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NC
 */
@Service
public class ChuyenxeServiceImpl implements ChuyenxeService{
    @Autowired
    private ChuyenxeReposity chuyenxerepository;
    

    @Override
    public List<Chuyenxe> getChuyenXes(Map<String, String> params) {
        return this.chuyenxerepository.getChuyenXes(params);
    }
    
    
}
