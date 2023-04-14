/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chl.service;

import com.chl.pojo.Cart;
import com.chl.pojo.Chuyenxe;
import java.util.List;
import java.util.Map;

/**
 *
 * @author NC
 */
public interface ChuyenxeService {
   List<Chuyenxe> getChuyenXes(Map<String , String > params,int page);
   int count();
   boolean AddOrUpdateCX(Chuyenxe cx);
   Chuyenxe getChuyenxeId(int id);
    boolean delCX(int id);
   boolean Receipt(Map<String, Cart> cart);
}
 