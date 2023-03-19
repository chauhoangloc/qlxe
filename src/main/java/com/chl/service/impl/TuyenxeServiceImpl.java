/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.service.impl;

import com.chl.pojo.Tuyenxe;
import com.chl.repository.TuyenxeRepository;
import com.chl.service.TuyenxeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NC
 */
@Service
public class TuyenxeServiceImpl implements TuyenxeService {

    @Autowired
    private TuyenxeRepository tuyenxeRepository;

    @Override
    public List<Tuyenxe> getTuyenxes() {
         return this.tuyenxeRepository.getTuyenxes();
    }

}
