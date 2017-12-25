/**
 * Created by 罗朝州 on 2016/4/6.
 */

function toggleTab(type,obj,url){
    if($(obj).hasClass("current"))
        return;
     
        location.href = url;
    
}

//创建事件分析弹框
function showEventFrame(type,taskId,url){
    
 
    $("#event_frame").attr("src",url);
    $("#BgDiv").fadeIn("slow");
    //$("body").css({overflow:"hidden"});    //禁用滚动条
    $("#eventDiv").fadeIn("slow");
}

//创建微博事件分析弹窗
function showWeiBoEventFrame(type,taskId){
	 var url = "createWeiBoAnalysis.action?createType="+type;
    if(taskId!=""){
        url += "&analysisTask.taskId="+taskId;
    }else if( $("#heatNameWB").length!=0&& $("#heatNameWB").val()!=null){
        url +="&analysisTask.incidentTitle="+encodeURIComponent(encodeURIComponent($("#heatNameWB").val()));
    }
	$("#event_frame").attr("src",url);
    $("#BgDiv").fadeIn("slow");
   // $("body").css({overflow:"hidden"});    //禁用滚动条
    $("#eventDiv").fadeIn("slow");
}

function hideEventDiv(){
    $("#heatNameWB").val("");
    $("#heatName").val("");
    $("#recordName").val("");
    $("#BgDiv").fadeOut("slow");
    //$("body").css({overflow:"auto"});
    $("#eventDiv").fadeOut("slow");
}

//购买
function showBuy(){
    $('.zhezhao').fadeIn('slow');
    $('#buyPrompt_sj').css('display', 'block');
}


// 购买事件分析次数
function buyAnalysis() {
    var packageNum = $('#packageNum').val();
    if (packageNum > 0) {
        var analysisForm = $('form[name="analysisForm"]')[0];
        if (analysisForm)
            analysisForm.submit();
    }
}

function count(){
    console.log(1);
    var packageNum = $('#packageNum').val();
    if (!isNaN(packageNum)) {
        $('input[name="myProducts[\'product\'].keywordPackageNum"]').val(packageNum);
        var price = $('input[name="myProducts[\'product\'].keywordPackagePrice"]').val();
        var totalPrice = price * packageNum;
        var youhuiPrice = 0;
        if (totalPrice >= 5000)
            youhuiPrice = totalPrice * 0.6;
        else if (totalPrice >= 4000)
            youhuiPrice = totalPrice - 1500;
        else if (totalPrice >= 3000)
            youhuiPrice = totalPrice - 1000;
        else if (totalPrice >= 2000)
            youhuiPrice = totalPrice - 500;
        else if (totalPrice >= 1000)
            youhuiPrice = totalPrice - 100;
        else
            youhuiPrice = totalPrice;

        $('#yuanjiaFont').text('￥' + youhuiPrice.toFixed(2));
        if (youhuiPrice != totalPrice) {
            $('#jieshengSpan').text('为您节省：' + (totalPrice - youhuiPrice).toFixed(2) + '元');
            $('#jieshengSpan').css('display', '');
        } else {
            $('#jieshengSpan').css('display', 'none');
        }
    }
}
