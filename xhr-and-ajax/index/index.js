"use strict";

// XMLHttpRequest请求，修改页面内容
var xhr = new XMLHttpRequest();
if (window.XMLHttpRequest) {
    xhr = new XMLHttpRequest();
} else {
    xhr = new ActiveXObject('Microsoft.XMLHTTP');
}
xhr.open('GET', 'http://127.0.0.1:8081/api/v1/classroom/getAll');
xhr.send();
xhr.onreadystatechange = function () {
    if (xhr.readyState == 4 && xhr.status == 200) {
        document.getElementById('mydiv').innerHTML = xhr.responseText;
    }
}

// JQuery.load()，然后修改页面内容
$(".mydiv").load("http://127.0.0.1:8081/api/v1/classroom/getAll", null);

// 元素的click()应当只设置一次。
// 解析JSON。请求的返回内容是一个JSON字符串。
// $(".btn").click(() => {
//     $.ajax({
//         url: 'http://127.0.0.1:8081/api/v1/user/login',
//         type: 'POST',
//         data: {
//             username: 'zgy',
//             password: '12345678'
//         },
//         success: function (res) {
//             alert("请求成功。返回信息为：\n"+JSON.stringify(res));
//         },
//         error: function (res) {
//             alert("请求失败。返回信息为：\n"+JSON.stringify(res));
//         }
//     });
// });

// JQuery.get()
// $(".btn").click(() => {
//     $.get('http://127.0.0.1:8081/api/v1/classroom/getAll',(data,status) =>{
//         alert('Data: \n'+JSON.stringify(data)+'\nStatus: '+status);
//     })
// });


// JQuery.post()
// $(".btn").click(() => {
//     $.post(
//         'http://127.0.0.1:8081/api/v1/user/login',
//         {
//             username: 'zgy',
//             password: '12345678'
//         },
//         (data, status) => {
//             alert('Data: \n' + JSON.stringify(data) + '\nStatus: ' + status);
//         }
//     );
// });

// 改用axios
$(".btn").click(() => {
    axios.post('http://127.0.0.1:8081/api/v1/user/login?username=zgy&password=12345678')
        .then(resp => {
            alert('Response: \n' + JSON.stringify(resp['data']));
        });
});