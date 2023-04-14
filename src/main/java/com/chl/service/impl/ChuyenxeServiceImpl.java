/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.service.impl;

import com.chl.pojo.Cart;
import com.chl.pojo.Chuyenxe;
import com.chl.repository.ChuyenxeReposity;
import com.chl.service.ChuyenxeService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NC
 */
@Service
public class ChuyenxeServiceImpl implements ChuyenxeService{
    @Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private ChuyenxeReposity chuyenxerepository;
    

    @Override
    public List<Chuyenxe> getChuyenXes(Map<String, String> params,int page) {
        return this.chuyenxerepository.getChuyenXes(params,page);
    }

    @Override
    public int count() {
        return this.chuyenxerepository.count();
    }

    @Override
    public boolean AddOrUpdateCX(Chuyenxe cx) {
        if(!cx.getFile().isEmpty()){
         try {
                Map res = this.cloudinary.uploader().upload(cx.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                cx.setHinhanh(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ChuyenxeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    return this.chuyenxerepository.AddOrUpdateCX(cx);
    }

    @Override
    public Chuyenxe getChuyenxeId(int id) {
       return this.chuyenxerepository.getChuyenxeId(id);
    }

    @Override
    public boolean delCX(int id) {
       return this.chuyenxerepository.delCX(id);
    }

    @Override
    public boolean Receipt(Map<String, Cart> cart) {
        if(cart!=null)
          return this.chuyenxerepository.Receipt(cart);
        return false;
    }
}
