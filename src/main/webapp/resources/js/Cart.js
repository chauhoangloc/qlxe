/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function addToCart(endpoint,idchuyenxe,tenchuyenxe,giave){
    event.preventDefault();
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
        return res.json();
    }).then(function(data){
        let counter = document.getElementsByClassName("cartCouter");
        counter.innerText = data.counter;
    })
    location.reload();

}

function updateCart(update,obj,idchuyenxe){
    fetch(update,{
        method : 'put',
        body : JSON.stringify({
            "idchuyenxe":idchuyenxe,
            "tenchuyenxe":"",
            "giave":0,
            "count":obj.value
        }),
        headers:{
            "Content-Type":"application/json"
        }
    }).then(function(res){
        return res.json();
    }).then(function(data){ 
        let counter = document.document.getElementsByClassName("cartCouter");
        counter.innerText = data.counter;                          //.counter gọi từ Utils
        let amount = document.getElementById("amountCart");
        amount.innerText = data.amount;

    })
     location.reload();
}
function deleteCart(del,idchuyenxe,tenchuyenxe){
    if(confirm(`Bạn có muốn xóa ${tenchuyenxe} hay không ! `)==true){
    fetch(del,{
        method : 'delete'
    }).then(function(res){
        return res.json();
    }).then(function(data){
        let counter = document.getElementById("cartCouter");
         counter.innerText = data.couter;                          //.counter gọi từ Utils
        let amount = document.getElementById("amountCart");
        amount.innerText = data.amount ;
      
    })
    }
     location.reload();
}

function payment(endpoint) {
    if(confirm(`Bạn có muốn đặt vé này không ! `)==true){
    fetch(endpoint, {
        method: "post"
    }).then(res => {
        console.info(res);
        if (res.status === 200) {
            let e = document.getElementById("content");
            e.innerText = "Đơn hàng đã được ghi nhận";
            let counters = document.document.getElementsByClassName("cartCouter");
            for (let d of counters)
                d.innerText = 0;
        } 
    })
}
}
