/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.controllers;


import com.chl.Utils.Utils;
import com.chl.pojo.Cart;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author NC
 */
@RestController
public class CartAPIController  {
    @PostMapping("/api/cart")
    public int addToCart(@RequestBody Cart params, HttpSession session){
        Map<Integer,Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart ==null)
            cart = new HashMap<>();
        int idChuyenXe=params.getIdchuyenxe();
        if(cart.containsKey(idChuyenXe)==true){
            Cart c= cart.get(idChuyenXe);
            c.setCount(c.getCount()+1);
        }
        else{
            cart.put(idChuyenXe,params);
        }
        session.setAttribute("cart",cart);
        return Utils.countCart(cart);
    }
}

