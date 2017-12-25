/**
 * Created by 罗朝州 on 2016/9/2.
 */
//0:股票 1：明星 2：汽车 3：手机 4：美妆 5：景区 6：金融 7：电脑 8：家电 9：食品 10：教育
/*var categoryParams = ['','演员,歌手','汽车用品','手机数码/手机','化妆美容','','金融','电脑用品','家用电器','食品饮料','教育培训'];
var smallClassArr = ['深市A股、沪市A股、沪市B股、深市B股、中小板、创业板','男演员、女演员、男歌手、女歌手、组合','跑车、微型车、轿车、越野车',
    '','香水、彩妆、护肤','','银行、证券公司、保险公司','台式机、笔记本','电视、冰箱、洗衣机、烟机灶具','葡萄酒、巧克力、牛奶、饮料','英语培训机构'];*/
function toggleCategory(type,rankId,obj,paramName){
    var currentPage = $("#currentPageCode").val();
    if(currentPage&&currentPage==1){
        var txt = "榜"
        if(type==9||type==10||type==11||type==13||type==14||type==15){
            txt = "品牌榜";
        }
        $("#rankingName").text($.trim($(obj).text())+txt);
    }
    $("#type").val(type);
    $(obj).parent().find("li").removeClass("active");
    $(obj).addClass("active");
    $("#middleClass").val("");
    $("#smallClass").val("");
    $("#stockType").val("");
    $("#starProfession").val("");
    $("#starSex").val("");
    $("#carTag").val("");
    $("#computerTag").val("");
    $("#celebrityTag").val("");
    $("#appliancesTag").val("");
    $("#searchName").val("");
    $("#page").val(1);
    $("#sort").val(3);
    $("#order").val(1);
    $("#paramName").val(paramName);
    $("#paramValue").val("");
    /*var params = categoryParams[type];
    if(params!=""){
        var paramsArr = params.split("/");
        $("#category").val(paramsArr[0]);
        if(paramsArr[1]&&paramsArr[1]!=""){
            $("#smallClass").val(paramsArr[1]);
        }
    }
    var middleClass = middleClassArr[type];
    if(middleClass!=""){
        $("#middleClass").val(middleClass);
    }*/
    var smallClass = smallClassArr[rankId];
    var paramClass=paramValueStr[rankId];
    if(smallClass!=""){
        var classArr = smallClass.split("、");
        var paramArr= paramClass.split(",");
        $("#paramValue").val(paramArr[0]);        
        var classHtml = '';
        var param="'"+paramArr[0]+"'";
        if(currentPage&&currentPage==1){//排行榜
            classHtml += '<label class="btn active" onclick="allClick('+type+','+param+')"><input type="radio" name="options1" id="option11"> 全部</label>';
            $.each(classArr,function(n){
                classHtml+= '<label class="btn" onclick="smallCalssClick('+type+','+paramArr[n+1]+',this)"><input type="radio" name="options1" id="option12">'+this+'</label>';
            });
        }else{
            classHtml += '<li class="active" onclick="allClick('+type+','+param+')">全部</li>';
            $.each(classArr,function(n){
                classHtml+= '<li onclick="smallCalssClick('+type+','+paramArr[n+1]+',this)">'+this+'</li>';
            });
        }

        $("#smallClassUl").html(classHtml);
        if(paramArr[0]==paramArr[1]){
            $("#smallClassUl label:eq(1),#smallClassUl li:eq(1)").addClass("active");
            $("#smallClassUl label:first,#smallClassUl li:first").remove();
        }
    }else{
        $("#smallClassUl").html("");
    }
    getRank();
}

function smallCalssClick(type,i,obj){
    $("#searchName").val("");
    $("#page").val(1);
    $("#sort").val(3);
    $("#order").val(1);
    $("#smallClassUl li").removeClass("active");
    obj = $(obj);
    obj.addClass("active");
    var txt = obj.text();
   /* if(type==2){
        $("#stockType").val(i);
    }else if(type==3){
        $("#celebrityTag").val(i);
    }else if(type==9){
        $("#carTag").val(i+1);
    }else if(type==13){
        if(txt.indexOf("台式")!=-1){
            $("#computerTag").val(3);
        }
        if(txt.indexOf("笔记")!=-1){
            $("#computerTag").val(2);
        }
        if(txt.indexOf("一体")!=-1){
            $("#computerTag").val(4);
        }
    }else if(type==14){
        $("#appliancesTag").val(i);
    }*/
    $("#paramValue").val(i);
    
    getRank();
}

function allClick(type,pv){
    $("#searchName").val("");
    $("#page").val(1);
    $("#sort").val(3);
    $("#order").val(1);
    $("#smallClassUl li").removeClass("active");
    var obj = $("#smallClassUl li:eq(0)");
    obj.addClass("active");
    $("#smallClass").val("");
    $("#stockType").val("");
    $("#starProfession").val("");
    $("#starSex").val("");
    $("#carTag").val("");
    $("#computerTag").val("");
    $("#celebrityTag").val("");
    $("#appliancesTag").val("");
    $("#paramValue").val(pv);
    getRank();
}

function getRank(){//1:地域关键词 2:股票关键词 3:明星关键词 4:行业关键词 5:品牌关键词 6:人物关键词 7:景区关键词 8:地域关键词(iis后台) 9:汽车关键词 10:手机关键词 11:美妆关键词 12:金融关键词 13:电脑关键词 14:家电关键词 15:食品关键词 16:教育关键词
	chartLoading("rankList");
    var type = $("#type").val();
    var category = $("#category").val();
    var middleClass = $("#middleClass").val();
    var smallClass = $("#smallClass").val();
    var paramName=$("#paramName").val();
    var paramValue=$("#paramValue").val();
    
    var data = {};
    var url = basePath+"/view/hotSearch/rankList.action";
   
    /*if(type==2){
        if($("#stockType").val()!=""){
            data.stockType=$("#stockType").val();
        }
    }else if(type==3){
        if($("#celebrityTag").val()!=""){
            data.celebrityTag=$("#celebrityTag").val();
        }
    }else if(type==9){
        if($("#carTag").val()==""){
            $("#carTag").val(1);
        }
        data.carTag = $("#carTag").val();
    }else if(type==13){
        if($("#computerTag").val()==""){
            $("#computerTag").val(1);
        }
        data.computerTag = $("#computerTag").val();
    }else if(type==14){
        if($("#appliancesTag").val()==""){
            $("#appliancesTag").val(1);
        }
        data.appliancesTag = $("#appliancesTag").val();
    }*/
    if(paramName!=""){
    	data.paramName=paramName;
    }
    if(paramValue!=""){
    	data.paramValue=paramValue;
    }
    
    
    data.type = type;
    data.page = $("#page").val();
    data.pagesize = $("#pagesize").val();
    data.currentPageCode = $("#currentPageCode").val();
    data.searchName = $("#searchName").val();
    data.sort = $("#sort").val();
    data.order = $("#order").val();
    $.ajax({
        url : url,
        type : "post",
        data:data,
        success : function(data){

            $("#rankList").html(data);

        }
    })
    var desc = "排行榜_"+ $.trim($("#categoryUl .active").text());
    if($("#smallClassUl:visible").length==1){
        desc += "_"+$.trim($("#smallClassUl .active:last").text());
    }
    recordUserLog(operateLogPageCode,desc);
}

function rankToSearch(n){
    var title = $("#name_"+n).val();
    var keyword = $("#keyword_"+n).val();
    var filterKeyword = $("#filterKeyword_"+n).val();
    var categoryIds=$("#categoryIds_"+n).val();
    var types=$("#types_"+n).val();
    if('undefined'==keyword){
        keyword = "";
    }else{
        keyword = keyword.replace(/\r\n/g,"");
    }
    if('undefined'==filterKeyword){
        filterKeyword = "";
    }else{
        filterKeyword = filterKeyword.replace(/\r\n/g,"");
    }
    $("#title").val(title);
    $("#keyword").val(keyword);
    $("#filterKeyword").val(filterKeyword);
    $("#categoryId").val(categoryIds);
    $("#categoryType").val(types);
    $("#secondCategory").val($("#paramValue").val());
    $("#num").val(1);
    goSearch(2);
}

function addKeyword(n){
    if($("#userId").length!=0){
        $("#recordName").val($("#name_"+n).val());
        $("#recordKeyword").val($("#keyword_"+n).val());
        $("#recordFilterKeyword").val($("#filterKeyword_"+n).val());
        $("#recordType").val(1);
        $("#loginRecordForm").submit();
    }else{
        var data = {"notLoginOperateRecord.operateType":1,"notLoginOperateRecord.name":$("#name_"+n).val(),"notLoginOperateRecord.keyword":$("#keyword_"+n).val(),"notLoginOperateRecord.filterKeyword":$("#filterKeyword_"+n).val()}
        $.ajax({
            url : basePath+"/view/hotSearch/recordOperateInfo.action",
            type : "post",
            data : data,
            success : function(){$("#login").click()}
        })
    }

}

/*function addProductAnalysis(){

    var checkID = [];
    $.each($("#sharesList li"),function(n){
        if($(this).hasClass("active")){
            checkID.push(n);
        }
    });
    if(checkID.length<2){
        //alert("最少选择2个！");
        return;
    }
    if(checkID.length>6){
        alert("最多选择6个！");
        return;
    }
    var jsonData = {};
    var title = "";
    var i = 1;
    $.each(checkID,function(n){
        var key = "keyword"+i;
        var fkey = "filterKeyword"+i;
        var nkey = "name"+i;
        jsonData[key] = $("#keyword_"+this).val();
        //jsonData[fkey] = $("#filterKeyword_"+n).val();
        jsonData[nkey] = $("#name_"+this).val();
        title += $("#name_"+this).val()+"、";
        i++;
    });
    title = title.substr(0,title.length-1);
    jsonData = JSON.stringify(jsonData);
    if($("#userId").length!=0){
        $("#recordName").val(title);
        $("#recordData").val(jsonData);
        $("#recordType").val(3);
        $("#loginRecordForm").submit();
    }else{
        var data = {"notLoginOperateRecord.operateType":3,"notLoginOperateRecord.name":title,"notLoginOperateRecord.jsonData":jsonData};

        $.ajax({
            url : basePath+"/view/hotSearch/recordOperateInfo.action",
            type : "post",
            data : data,
            success : function(){
                $("#sharesModal .close").click();
                $("#login").click();
            }
        })
    }

}*/

function addProductAnalysis(){
    var checkID = [];
    $.each($("#sharesList li"),function(n){
       /* n+=1;*/
        if($(this).hasClass("active")){
            checkID.push(n);
        }
    });
    if(checkID.length>3){
        alert("最多选择3个！");
        return;
    }
    var title = "";
    var keyword="";
    var filterKeyword="";
    var categoryId="";
    var categoryType="";
    $.each(checkID,function(n){
        keyword += $("#keywords_"+this).val()+",";
        filterKeyword+=$("#filterKeywords_"+this).val()+",";
        title += $("#names_"+this).val()+",";
        categoryId+=$("#categoryId_"+this).val()+",";
        categoryType+=$("#type_"+this).val()+",";
    });
    title = title.replace(/,$/,"");
    keyword = keyword.replace(/,$/,"");
    filterKeyword = filterKeyword.replace(/,$/,"");
    categoryId=categoryId.replace(/,$/,"");
    categoryType=categoryType.replace(/,$/,"");
    if($("#userId").length!=0){
        $("#title").val(title);
        $("#keyword").val(keyword);
        $("#filterKeyword").val(filterKeyword);
        $("#categoryId").val(categoryId);
        $("#categoryType").val(categoryType);
        $("#num").val(checkID.length);
        $("#secondCategory").val($("#paramValue").val());
        var form = document.getElementById("searchForm");
        form.action = basePath+"/view/hotSearch/goSearch.action";
        form.submit();
    }else{
        var data = {"notLoginOperateRecord.operateType":15,"notLoginOperateRecord.name":title,"notLoginOperateRecord.keyword":keyword,"notLoginOperateRecord.filterKeyword":filterKeyword,"notLoginOperateRecord.categoryId":categoryId,"notLoginOperateRecord.categoryType":categoryType,"notLoginOperateRecord.num":checkID.length};

        $.ajax({
            url : basePath+"/view/hotSearch/recordOperateInfo.action",
            type : "post",
            data : data,
            success : function(){
                $("#sharesModal .close").click();
                $("#login").click();
            }
        })
    }
}
function goSearch(n){
    var kv = $("#keyword").val();
    if($.trim(kv)==""||$.trim(kv)=="请输入您想查询的关键字"){
        showMsgInfo(0,"请输入你想搜索的词语",0);
        return ;
    }
    if($.trim(kv).length==1){
        showMsgInfo(0,"请至少输入2个字符",0)
        return ;
    }
    if($("#title").val()==""){
        $("#title").val(kv);
    }
    if(n&&n>1){
        var form = document.getElementById("searchForm");
        form.action = basePath+"/view/hotSearch/goSearch.action";
        form.submit();
    }else{
        var submitFlag = false;
        $.ajax({
            url:basePath+"/view/hotSearch/hotCheck.action",
            type:"post",
            async:false,
            data:{keyword:kv},
            success:function(data){
                if(data&&data.code=="0000"){
                    submitFlag = true;
                }else if(data){
                    showMsgInfo(0,data.message,0);
                    return;
                }
            }
        });
        if(submitFlag){
            var form = document.getElementById("searchForm");
            form.action = basePath+"/view/hotSearch/goSearch.action";
            form.submit();
        }
    }


}

function mtSearch(){
    var kv = $("#title").val();
    if($.trim(kv)=="人名、企业名、品牌名或事件关键词"){
        showMsgInfo(0,"请输入搜索词!",0);
        return;
    }

    if($.trim(kv).length>20){
        showMsgInfo(0,"搜索词不得大于20个字!",0);
        return;
    }

    kv = $.trim(kv).replace(/\s+/g,"+");

    $("#keyword").val(kv);
    $("#filterKeyword").val("");
    goSearch();
}
function enterClick(event){
    event = event || window.event;
    if(event.keyCode==13){
        mtSearch();
    }
}

function hotSearch(title,keyword,filterKeyword){
    if('undefined'==keyword){
        keyword = "";
    }else{
        keyword = keyword.replace(/\r\n/g,"");
    }
    if('undefined'==filterKeyword){
        filterKeyword = "";
    }else{
        filterKeyword = filterKeyword.replace(/\r\n/g,"");
    }
    $("#title").val(title);
    $("#keyword").val(keyword);
    $("#filterKeyword").val(filterKeyword);
    goSearch(3);
}

function getHotKeywords(){
    $.ajax({
        url : basePath+"/view/hotSearch/hotKeywords.action",
        type : "get",
        success : function(data){
            if(data&&data instanceof Array){
                data = data[0];
                var html = '';//<div><a href="javascript:refreshHotKeywords()"><i class="icon-repeat"></i> 换一换</a></div>
                $.each(data,function(){
                    html += '<a href="javascript:hotSearch(\''+this.incidentTitle+'\',\''+this.keyword+'\',\''+this.filterKeyword+'\')">'+this.incidentTitle;
                    if(this.type==1){
                        html += '<em class="newLabel">热</em>';
                    }else if(this.type==2){
                        html += '<em class="newLabel red">新</em>';
                    }else if(this.type==3){
                        html += '<em class="newLabel blue">荐</em>';
                    }
                    html += '</a>';
                });
                $("#hotKeyword").html(html);
            }
        }
    })
}

function refreshHotKeywords(){
    window.clearInterval(intervalId);
    getHotKeywords();
    intervalId = setInterval(function(){getHotKeywords()},1000*60*10);
}


function openCompare(n){
    $("#sharesList li").removeClass("active");
    $("#sharesList li:eq("+n+")").addClass("active");
    $("#checkNum").text(1);
    /*if($("#sharesList li").length==1){
        $("#sharesModal .btn").addClass("btn-disabled").removeClass("btn-warning");
    }*/
}
var timeout="";
function thinkKeywords(obj){
    $("#keyWordLogs_ul").hide();
    var txt = $(obj).val();
    if(txt==""){
        return;
    }
    if(timeout!=""){
        window.clearTimeout(timeout);
    }
    timeout = setTimeout(function(){beginThink(txt)},1000);
}
function beginThink(txt){
    var data = {"thinkKeyword":txt};
    $.ajax({
        url : basePath+"/view/hotSearch/thinkKeywords.action",
        type : "post",
        data:data,
        success : function(data){
            if(data&&data instanceof Array){
                data = data[0];
                if(data==null){
                    $("#hotwords").hide();
                }
                var html = '';
                $.each(data,function(){
                    html += '<li style="cursor:pointer;" onclick="hotSearch(\''+this.title+'\',\''+this.keyword+'\',\''+this.filterKeyword+'\')"><a href="javascript:void(0)"><h1>'+this.title+'</h1></a>';
                    if(this.type==1){
                        html += '<em>来自地域';
                    }else if(this.type==2){
                        html += '<em>来自股票';
                    }else if(this.type==3){
                        html += '<em>来自明星';
                    }else if(this.type==4){
                        html += '<em>来自行业';
                    }else if(this.type==5){
                        html += '<em>来自品牌';
                    }else if(this.type==6){
                        html += '<em>来自人物';
                    }else if(this.type==7){
                        html += '<em>来自景区';
                    }else if(this.type==8){
                        html += '<em>来自地域';
                    }else if(this.type==9){
                        html += '<em>来自汽车';
                    }else if(this.type==10){
                        html += '<em>来自手机';
                    }else if(this.type==11){
                        html += '<em>来自美妆';
                    }else if(this.type==12){
                        html += '<em>来自金融';
                    }else if(this.type==13){
                        html += '<em>来自电脑';
                    }else if(this.type==14){
                        html += '<em>来自家电';
                    }else if(this.type==15){
                        html += '<em>来自食品';
                    }else if(this.type==16){
                        html += '<em>来自教育';
                    }
                    if(!this.category||this.category==""||this.category=="undefined"){
                        html += '</em></li>';
                    }else{
                        html += '（'+this.category+'）</em></li>';
                    }

                });
                $("#hotwords").html(html);
                $("#hotwords").show();
            }
        }
    })
}
function chartLoading(id){
    var stat = document.getElementById(id);
    stat.innerHTML = '<div class="spinner" style="display: block;"><div class="bounce1"></div></div>';
}
//点击的不是显示操作时将他隐藏
document.onclick = function(event) {
    var e = event || window.event;
    var elem = e.srcElement || e.target;
    while (elem) {
        var reg = /^search/g;
        if (reg.test(elem.id)) {
            return;
        }
        elem = elem.parentNode;
    }
    //隐藏div的方法
    $("#keyWordLogs_ul").hide();
    $("#hotwords").hide();
};

/*
function checkLi(obj){

    var checkID = [];
    $.each($("#sharesList li"),function(n){
        if($(this).hasClass("active")){
            checkID.push(n);
        }
    });
    var len = checkID.length;
    if($(obj).hasClass("active")){
        len -= 1;
    }else{
        len += 1;
    }
    if(len<2){
        $("#sharesModal .btn").addClass("btn-disabled").removeClass("btn-warning");
    }else{
        $("#sharesModal .btn").addClass("btn-warning").removeClass("btn-disabled");
    }
}*/

function checkLi(obj){

    var checkID = [];
    $.each($("#sharesList li"),function(n){
        if($(this).hasClass("active")){
            checkID.push(n);
        }
    });
    var len = checkID.length;
    if($(obj).hasClass("active")){
        len -= 1;
    }else{
        len += 1;
    }
    if(len<1){
        $("#sharesModal .btn").addClass("btn-disabled").removeClass("btn-warning");
    }else{
        $("#sharesModal .btn").addClass("btn-warning").removeClass("btn-disabled");
    }
}

function recordUserLog(code,name){
    $.ajax({
        url : basePath+"/view/hotSearch/recordUserLog.action",
        type : "post",
        data:{'operateLogObject.productPageCode':code,'operateLogObject.productPageDesc':name},
        success : function(data){

        }
    })
}