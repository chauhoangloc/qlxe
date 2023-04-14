/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chl.repository;

import com.chl.pojo.Users;

/**
 *
 * @author NC
 */
public interface UserRepository {
       Users getUserByUsername(String username);
}
