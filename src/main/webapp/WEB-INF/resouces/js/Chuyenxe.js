    /* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function delCX(endpoint, idchuyenxe) {
    if (confirm("Bạn chắc chắn xóa? Việc xóa này có thể ảnh hưởng đến các dữ liệu khác !") === true) {
        let s = document.getElementById(`spinner${idchuyenxe}`);
        s.style.display = "block";
        
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            s.style.display = "none";
            console.info(res);
            if (res.status === 204) {
               document.getElementById(`chuyenxe${idchuyenxe}`).style.display = "none";
            } else
                alert("Có điều gì đó bất thường ở đây!");
        });
    }
}
