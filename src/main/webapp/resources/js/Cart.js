/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function addToCart(endpoint,idchuyenxe,tenchuyenxe,giave){
    fetch(endpoint,{
        method : 'post',
        body : JSON.stringify({
            "idchuyenxe":idchuyenxe,
            "tenchuyenxe":tenchuyenxe,
            "giave":giave,
            "count":1
        }),
        headers:{
            "Content-Type":"application/json"
        }
    }).then(function(res){
        return res.json()
    })

}