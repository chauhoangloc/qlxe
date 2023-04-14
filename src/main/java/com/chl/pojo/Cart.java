/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.pojo;

import java.math.BigDecimal;

/**
 *
 * @author NC
 */
public class Cart {

    private int idchuyenxe;
    private String tenchuyenxe;
    private BigDecimal giave;
    private int count;
    /**
     * @return the icchuyenxe
     */

    /**
     * @return the tenchuyenxe
     */
    public String getTenchuyenxe() {
        return tenchuyenxe;
    }

    /**
     * @param tenchuyenxe the tenchuyenxe to set
     */
    public void setTenchuyenxe(String tenchuyenxe) {
        this.tenchuyenxe = tenchuyenxe;
    }

    /**
     * @return the giave
     */
    public BigDecimal getGiave() {
        return giave;
    }

    /**
     * @param giave the giave to set
     */
    public void setGiave(BigDecimal giave) {
        this.giave = giave;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the idchuyenxe
     */
    public int getIdchuyenxe() {
        return idchuyenxe;
    }

    /**
     * @param idchuyenxe the idchuyenxe to set
     */
    public void setIdchuyenxe(int idchuyenxe) {
        this.idchuyenxe = idchuyenxe;
    }

   
}