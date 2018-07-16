$(function () {
    $(".give").click(function () {
        var uid=$(this).parent().prev().val();
        var scid =$(this).parent().next().val();
        var time =$("#myDate").val();
        $.ajax({
            url:"serv_giveUser.action",
            type:"post",
            data:{"sa.scId":scid,"sa.uid":uid,"sa.saTime":time,"status":1},
            //dataType:"json",
            success:function (data) {
                location.reload();
            },
            error:function () {
                alert("ajax出错");
            }

        });
    });
});

function load(data) {
    $("[name=scstatus]").find('option').eq(data).attr("selected",true);
}

function callback(data) {
    alert("123");
   //  var main ="<tbody>";
   //  $.each(data.userList,function (k,v) {
   //      main+="<tr align=center>";
   //      main+="<td>"+v.uid+"</td>";
   //      main+="<td>"+v.uid+"</td>";
   //      main+="<td>"+v.uid+"</td>";
   //      main+="<td>"+v.uid+"</td>";
   //      main+="<td>"+v.uid+"</td>";
   //      main+="<td>"+v.uid+"</td>";
   //
   //      main+="</tr>";
   //  })
   //  main +="</tbody>";
   //  alert(main);
   // $("#mydiv").html(main);
}
