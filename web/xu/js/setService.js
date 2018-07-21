$(function () {
    $("#sdid").blur(function () {
        sdId();
    });
    $("#describe").blur(function () {
        describe();
    });
    $("#cid").blur(function () {
        cid();
    });
    $("#request").blur(function () {
        request();
    });
    $("#frm").submit(function () {
        if(!sdId()){
            alert("填写完整的信息")
            return false
        }
        if(!describe()){
            alert("填写完整的信息");
            return false;
        }
        if(!cid()) {
            alert("填写完整的信息");
            return false;
        }
        if(!request()) {
            alert("填写完整的信息");
            return false;
        }
    });
})

function request(){
    var request = $("#request").val();
    if(request==-1){
        $("[name=requestspan]").show();
        return false;
    }
    $("[name=requestspan]").hide();
    return true;
}

function cid(){
    var cid = $("#cid").val();
    if(cid==-1){
        $("[name=clentspan]").show();
        return false;
    }
    $("[name=clentspan]").hide();
    return true;
}

function sdId(){
     var sdid = $("#sdid").val();
     if(sdid==-1){
         $("[name=typespan]").show();
         return false;
     }
     $("[name=typespan]").hide();
     return true;
}

function describe(){
    var describe = $("#describe").val();
    if(describe==""){
        $("[name=describespan]").show();
        return false;
    }
    $("[name=describespan]").hide();
    return true;
}