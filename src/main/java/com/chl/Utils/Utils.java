/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.Utils;


import com.chl.pojo.Cart;

import java.util.Map;
/**
 *
 * @author NC
 */
public class Utils {
    public static int countCart(Map<Integer, Cart> cart){
        int c=0;
        for (Cart ca: cart.values())
            c += ca.getCount();
        return c;
    }
}
