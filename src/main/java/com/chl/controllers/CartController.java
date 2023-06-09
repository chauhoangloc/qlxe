    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.controllers;
import com.chl.Utils.Utils;
import com.chl.pojo.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;
/**
 *
 * @author NC
 */
@Controller
public class CartController {
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session){
        Map<Integer,Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart != null)
            model.addAttribute("carts1",cart.values());
        else
            model.addAttribute("carts1",null);
        model.addAttribute("cartStats", Utils.cartStats(cart));
        return "Cart";
    }

}