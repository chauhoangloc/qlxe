/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chl.repository;

import com.chl.pojo.Chuyenxe;
import java.util.List;
import java.util.Map;

/**
 *
 * @author NC
 */
public interface ChuyenxeReposity {
    List<Chuyenxe> getChuyenXes(Map<String , String > params,int page);
}
