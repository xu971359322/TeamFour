$(function () {
    $(".give").click(function () {
        var uid=$(this).parent().prev().val();
        var scid =$(this).parent().next().val();
        var time =$("#myDate").val();
        alert(uid);
        if(uid==-1){
            alert("请选择分配的主管");
        }else {
            $.ajax({
                url:"serv_giveUser.action",
                type:"post",
                data:{"sa.scId":scid,"sa.uid":uid,"sa.saTime":time,"status":1},
                dataType:"json",
                success:function (data) {
                    location.reload();
                },
                error:function () {
                    alert("ajax出错");
                }

            });
        }

    });
});

function load(data) {
    $("#status").find('option').eq(data).attr("selected",true);
    // $.ajax({
    //     url:"serv_giveUser.action",
    //     type:"post",
    //     data:{"status":data},
    //     dataType:"json",
    //     success:callback,
    //     error:function () {
    //         alert("ajax出错");
    //     }
    // });
}

function callback(data) {
    var main ="<table class=\"table table-striped\" align=\"center\">";
    main+=" <thead align=\"center\">\n" +
        "            <tr align=\"center\">\n" +
        "                <th>编号</th>\n" +
        "                <th>客户</th>\n" +
        "                <th>概要</th>\n" +
        "                <th>服务类型</th>\n" +
        "                <th>创建人</th>\n" +
        "                <th>创建日期</th>\n" +
        "                <th>分配</th>\n" +
        "                <th>操作</th>\n" +
        "            </tr>\n" +
        "        </thead>";
    main+="<tbody>";
    $.each(data.giveService,function (k,v) {
        main+="<tr align=center>";
        main+="<td>"+v.scid+"</td>";
        main+="<td>"+v.companyname+"</td>";
        main+="<td>"+v.scdescribe+"</td>";
        main+="<td>"+v.sdname+"</td>";
        main+="<td>"+v.uname+"</td>";
        main+="<td>"+v.time+"</td>";
        main+="<td><select name=\"uid\">"
        main+=" <option value=\"-1\">请选择</option>"
            $.each(data.userList,function(key,value) {
                //alert(value.uid+" "+value.uname);
                 main+="<option value="+value.uid+">"+value.uname+"</option>";
            })
            main+= "</select>";
        main+="<button><span class='give'>分配</span></button></td>";
        main+="<td>";
        main+="<button class=\"btn btn-danger\">删除</button>";
        main+="</td>";
        main+="</tr>";
    })
    main +="</tbody></table>";
   $("#mydiv").html(main);
}
