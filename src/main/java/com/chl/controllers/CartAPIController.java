/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.controllers;

import com.chl.Utils.Utils;
import com.chl.pojo.Cart;
import com.chl.service.ChuyenxeService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NC
 */
@RestController
public class CartAPIController {

    @Autowired
    private ChuyenxeService chuyenxeService;

    @PostMapping("/api/cart")
    public int addToCart(@RequestBody Cart params, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        int idChuyenXe = params.getIdchuyenxe();
        if (cart.containsKey(idChuyenXe) == true) {
            Cart c = cart.get(idChuyenXe);
            c.setCount(c.getCount() + 1);
        } else {
            cart.put(idChuyenXe, params);
        }
        session.setAttribute("cart", cart);
        return Utils.countCart(cart);
    }

    @PutMapping("/api/cart")
    public ResponseEntity<Map<String, String>> updateCart(@RequestBody Cart params, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        int idchuyenxe = params.getIdchuyenxe();
        if (cart.containsKey(idchuyenxe) == true) {
            Cart c = cart.get(idchuyenxe);
            c.setCount(params.getCount());
        }
        session.setAttribute("cart", cart);
        return new ResponseEntity<>(Utils.cartStats(cart), HttpStatus.OK);
    }

    @DeleteMapping("/api/cart/{idchuyenxe}")
    public ResponseEntity<Map<String, String>> deleteCart(@PathVariable(value = "idchuyenxe") int idchuyenxe, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(idchuyenxe)) {
            cart.remove(idchuyenxe);
            session.setAttribute("cart", cart);
        }
        return new ResponseEntity<>(Utils.cartStats(cart), HttpStatus.OK);
    }

    @PostMapping("/api/payment")
    public ResponseEntity payment(HttpSession session) {
        if (this.chuyenxeService.Receipt((Map<String, Cart>) session.getAttribute("cart")))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
        
        }
}

