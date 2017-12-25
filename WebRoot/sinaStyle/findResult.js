/**
 * 
 * 批量操作
 * 
 */
function GetRandom(n){
	GetRandomn=Math.floor(Math.random()*n+1);
	return GetRandomn;
}
function setSelectIdVal(ev) {
	$("#selectedId").val(ev);
}

function aMouseImg(id,imgSrc){
	//$("#"+id).attr({"src":imgSrc});
}

function getCheckIDs() {
	var elements = document.getElementsByTagName("input");
	var checkedIds = "";
	for ( var i = 0; i < elements.length; i++) {
		var e = elements[i];
		if (e.id == "menuCheckId") {
			if (e.checked == true) {
				// checkedMenu = checkedMenu + 1;
				checkedIds = checkedIds + e.value + ",";
			}
		}
	}
	return checkedIds;
}

function getCheckIDsNum() {
	var elements = document.getElementsByTagName("input");
	var checkedMenu = 0;
	for ( var i = 0; i < elements.length; i++) {
		var e = elements[i];
		if (e.id == "menuCheckId") {
			if (e.checked == true) {
				checkedMenu = checkedMenu + 1;
			}
		}
	}
	return checkedMenu;
}

function checkAllMenuIE(el_name, parent) {
	var elements = document.getElementsByTagName("input");
	var parentChecked = parent.checked;
	for ( var i = 0; i < elements.length; i++) {
		var e = elements[i];
		if (e.id == el_name) {
			e.checked = parentChecked;
		}
	}
}


var importType = 0;
var importToName = "";

// 内容单条导入收藏夹或素材库
function importNewsSingle(importNewType, folderId, account) {
		if (importNewType == 2) {
			importToName = "简报素材";
			importType = 2;
		} else if (importNewType == 1) {
			importToName = "收藏夹";
			importType = 1;
		}
		var checkedId = document.getElementById("selectedId").value;
		
		
		var repeatNum = document.getElementById("repeatNum_"+checkedId).value;
		
		var checkedIds = checkedId + "_" +repeatNum +",";
		var timeDomain = 0;
		var starttime = "";
		var endtime = "";
		if(document.getElementById("timeDomain")!=null){
			timeDomain = document.getElementById("timeDomain").value;
		}
		if(document.getElementById("starttime")!=null){
			starttime = document.getElementById("starttime").value;
		}
		if(document.getElementById("endtime")!=null){
			endtime = document.getElementById("endtime").value;
		}
		var keywordId=null;
		var keyword=null;
		if(document.getElementById("kw.keywordId")){
			var keywordId = document.getElementById("kw.keywordId").value;
		}
		if(keywordId==null||keywordId==""){
			if(document.getElementById("searchKeyword")){
				keyword=document.getElementById("searchKeyword").value;
			}
		}
		//tagNewsDisplay(checkedIds, importType);
		operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime,keywordId,keyword);
		//CallBack(1);
}

// 内容多条导入收藏夹或素材库
function importNews(importNewType, folderId, account) {
	if (importNewType == 2) {
		importToName = "简报素材";
		importType = 2;

	} else if (importNewType == 1) {
		importToName = "收藏夹";
		importType = 1;
	}
	var checkedMenu = getCheckIDsNum();
	var checkedIds = getCheckIDs();
	var timeDomain = document.getElementById("timeDomain").value;
	var starttime = document.getElementById("starttime").value;
	var endtime = document.getElementById("endtime").value;
	if (checkedMenu == "0") {
		alert("请选择需要加入到" + importToName + "的新闻!");
		return;
	}
	if (confirm("您已选择" + checkedMenu + "个新闻，确认加入" + importToName + "?")) {
		//tagNewsDisplay(checkedIds, importType);
		NewsOperate.operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime,
				CallBack);
	}
}




/* 批量导入 */
function records(account,lmid) {
	var obj = document.getElementById('record_' + lmid);
	var objName = "";
	if (document.all) {
		objName = obj.innerText;
	} else {
		objName = obj.textContent;
	}
	var checkedMenu = getCheckIDsNum();
	var checkedIds = getCheckIDs();
	
	if (checkedMenu < 1) {
		alert("请选择需要收录到->[" + objName + "] 的新闻!");
		return false;
	}
	if (confirm("您已选择" + checkedMenu + "个新闻，确认收录 -> " + objName + "?")) {
		FunctionDwr.record(account,lmid, checkedIds, function(data) {
			alert("收录" + data);
		});
	}
}

// 发送短信
//function showSmsSendFrame(postion) {
//		var checkedIds = "";
//		if (postion == 1) {// 内容
//			checkedIds = $("#selectedId").val() + ",";
//		} else { // 导航
//			checkedIds = getCheckIDs();
//		}
//		if (checkedIds == "") {
//			//alert("请选择要发送短信的内容!");
//			showMsgInfo(0,"请选择要发送短信的内容!",0);
//			return ;
//		} else {
//			parent.showSmsSendFrame(checkedIds);
//		}
//}

// 回调JS
function CallBack(result) {
	if (null != result && result == 2) {
		alert("已成功加入简报素材!");
	}
	if (null != result && result == 1) {
		alert("已成功加入收藏夹!");
		//
		//var screenWidth = parent.parent.$(document).width(), screenHeight = parent.parent.$(document).height(); 
		/*
		var screenWidth = parent.parent.document.body.scrollWidth;
		var screenHeight = parent.parent.document.body.scrollHeight;
		var objWidth = parent.parent.$("#infoDiv").width();
		var left = (screenWidth - objWidth)/2;
		var scrollLeft = $(document).scrollLeft();
		
		parent.parent.$("#BgDiv").css({
				display:"block",
				height:screenHeight,
		});
		parent.parent.$("#infoDiv").css({
				left:left+scrollLeft+"px",
				display:"block",
				top:"100px"
		});
		*/
	}
	if (null != result && result == 3) {
		alert("已成功标签为负面!");
	}
	if (null != result && result == 4) {
		alert("已成功标签为非负面!");
	}
}

/**
 * lb
 * 
 * 其他操作
 * 
 */
//摘要：显示（摘要），不显示（简要）
function changeZhaiyaoType(v,init){
	if(init==1){
		//不需要重新查询
		//subForm();
		//将列表页上的摘要隐藏
		if(v==1){
			//显示摘要
			$(".summaryDiv").css("display","");
			//$(".summaryDivTemp").css("display","");
			//$(".zhaiyao_tr").css("height","60px");
			
			
		}else if(v==2){
			//隐藏摘要
			$(".summaryDiv").css("display","none");
			//$(".summaryDivTemp").css("display","none");
			//$(".zhaiyao_tr").css("height","30px");
		}
		/*
		var clickZhaoyaoShow = document.getElementById("clickZhaoyaoShow").value;
		if(clickZhaoyaoShow!=-1 && clickZhaoyaoShow==1){
			$(".summaryDivTemp").css({
				"display":"",
				"height":"60px"
			});
		}
		if(clickZhaoyaoShow!=-1 && clickZhaoyaoShow==2){
			$(".summaryDivTemp").css({
				"display":"none",
				"height":"30px"
			});
		}*/
		//SetCwinHeight();
		var ifrmview = parent.document.getElementById('ifrmview');
		var top_ifrmview = parent.parent.document.getElementById('top_ifrmview');
		var xx_set_h = $(".xx_set",window.parent.document).height();
		var xx_table_h = $(".xx_table").height();
		
		xx_set_h = xx_set_h + 80;
		
		if(ifrmview){
			ifrmview.height =  parseInt(xx_table_h) + 60;
		}
		if(top_ifrmview){
			top_ifrmview.height = parseInt(ifrmview.height) + parseInt(xx_set_h);
		}
	}
}
//摘要：显示（摘要），不显示（简要）
function changeZhaiyaoTypeNew(v,init){
	if(init==1){
		//不需要重新查询
		//subForm();
		//将列表页上的摘要隐藏
		if(v==1){
			//显示摘要
			/*$(".c3").css("display","");
			$(".c2").css("display","");
			$(".c5").css("display","none");
			$(".c4").css({
				display:"",
				marginBottom:"23px",
			});
			$(".c6").css({
				display:"",
				marginBottom:"23px",
			});
			$(".sub_span").css("display","none");
			$(".xx_list ul li").css({
				paddingBottom:"23px",
			});*/
			
			//$(".c3").css("display","");
			
		}else if(v==2){
			//隐藏摘要
			/*$(".c3").css("display","none");
			$(".c2").css("display","none");
			$(".c5").css("display","");
			$(".c4").css({
				display:"",
				marginBottom:"12px",
			});
			$(".c6").css({
				display:"",
				marginBottom:"10px",
			});
			$(".sub_span").css("display","")
			$(".xx_list ul li").css({
				paddingBottom:"0px",
			});*/
			//$(".c3").css("display","none");
		}
		//SetCwinHeight();
	}
}

//相同合并、不合并
function changeComblineFlg(v,init){
	if(init == 1){
		subForm();
	}
}
//二次搜索
function secondSearch(){
	//var secondSearchWord=$("#secondSearchWord").val();
	//if(secondSearchWord==''||secondSearchWord=='在结果中搜索'){
	//		alert("请输入搜索关键字");
	//	return;
	//}
	subForm();
}
//字体设置 1- 默认小字体 12px，2-大字体 14px
var font_size=12;
function changeFontSizeType(fontType,init){
	var fontType=$("#fontSizeType").val();
	//默认12px
	if(fontType=="2"){
		//大字号
		font_size=14;
	
	}else if(fontType=="1"){
		font_size=12;
	}
	//改变分页信息字体
	$(".page_info").css("font-size",font_size+"px");
	$("a").css("font-size",font_size+"px");
	//改变列表信息字体
	$(".td_l_t_b").css("font-size",font_size+"px");
	$(".td_l_t_r_b").css("font-size",font_size+"px");
	$(".tagFont").css("font-size",font_size+"px");
	$(".author").css("font-size",font_size+"px");
	$(".td_l_b").css("font-size",font_size+"px");
	$(".td_l_r_b").css("font-size",font_size+"px");
	$(".summaryDiv").css("font-size",font_size+"px");
	if(fontType=="2"){
		$(".summaryDiv").css("font-size",(font_size-1)+"px");
	}
}
//模糊信息列表与精确信息列表切换
function changeNewlstSelect(init){
	if (init == 1) {
		subForm();
	}
}
// 排序 1 - 相关性 2 - 降序 ; 3 - 升序
function changeSort(init) {
	if (init == 1) {
		subForm();
	}
}

function changeOrigina(dateType, init) {
    $("#page").val(1);//修改条件重置页码
	document.getElementById("filterOrigina").value = dateType;
	var divNa = document.getElementById("na" + dateType);
	document.getElementById("clickFilterOrigina").value = dateType;
	if (divNa) {
		divNa.className = "nas";
	}
	if (init == 1) {
		subForm();
	}
}

function changeOriginaNew(dateType, init) {
	document.getElementById("filterOrigina").value = dateType;
	var divNa = parent.document.getElementById("na" + dateType);
	document.getElementById("clickFilterOrigina").value = dateType;
	if (divNa) {
		divNa.className = "nasDiv";
	}
	if (init == 1) {
		subForm();
	}
}
function changeHot(dateType, init) {
	document.getElementById("customHot").value = dateType;
	var dateId = document.getElementById("customHots");
	dateId.innerHTML = document.getElementById("customHots" + dateType).innerHTML;
	if (dateType > 0) {
		document.getElementById("nav4_0").style.display = "";
	} else {
		document.getElementById("nav4_0").style.display = "none";
	}

	if (init == 1) {
		subForm();
	}
}

function changeOrder(dateType, init) {
	document.getElementById("orderby").value = dateType;
	var dateId = document.getElementById("orderbys");
	dateId.innerHTML = document.getElementById("orderbys" + dateType).innerHTML;
	if (dateType > 0) {
		document.getElementById("nav5_0").style.display = "";
	} else {
		document.getElementById("nav5_0").style.display = "none";
	}
	if (init == 1) {
		subForm();
	}
}
function changeShow(init) {
	var show = document.getElementById("pinglunShow").value;
	var dateId = document.getElementById("pinglunshows");
	if (show == 1) {
		dateId.innerHTML = "隐藏评论";
		document.getElementById("pinglunShow").value = 0;
	} else {
		dateId.innerHTML = "显示评论";
		document.getElementById("pinglunShow").value = 1;
	}
	if (init == 1) {
		subForm();
	}
}

function zhaiyaoChangeShow(init) {
	var show = document.getElementById("zhaiyaoShow").value;
	var dateId = document.getElementById("zhaiyaoShows");
	if (show == 1) {
		dateId.innerHTML = "隐藏摘要";
		document.getElementById("zhaiyaoShow").value = 0;
	} else if (show == 0) {
		dateId.innerHTML = "显示摘要";
		document.getElementById("zhaiyaoShow").value = 1;
	}
	if (init == 1) {
		subForm();
	}
}

function changeDate(dateType, init) {
	document.getElementById("filterDate").value = dateType;
	var dateId = document.getElementById("dates");
	if (init == 1) {
		subForm();
	}
}

function duplicateChangeShow(init) {
	var show = document.getElementById("duplicateShow").value;
	var stext = document.getElementById("duplicateShowsText");
	if (show == 1) {
		stext.innerHTML = "不显示重复项";
		document.getElementById("duplicateShow").value = 0;
	} else if (show == 0) {
		stext.innerHTML = "显示重复项";
		document.getElementById("duplicateShow").value = 1;
	}
	if (init == 1) {
		subForm();
	}
}

// 属性 0 - 全部 1 - 疑似负面 2 - 负面
function changeDuplicate(init) {
	if (init == 1) {
		subForm();
	}
}

// 跟帖 0 - 不显示 1 - 显示
function changeGengtie(show) {
	if (show == 0) {
		document.getElementById("pinglunShow").value = 1; // 不显示跟帖
		document.getElementById("pxgt").value = 0;
		document.getElementById("clickPxgt").value = 0;
	} else {
		document.getElementById("pxgt").value = 1;
		document.getElementById("clickPxgt").value = 1;
		document.getElementById("pinglunShow").value = 2;
	}
	subForm();
}

function ExportExcel(){
	
	ExportExcelCommon(window.parent.parent.parent, 'goResultList.action');

}
function ExportAllExcel(){
	var checkedMenu = getCheckIDsNum();
	var checkedIds = getCheckIDs();
	
	if (checkedMenu < 1) {
		alert("请选择需要导出的新闻!");
		return ;
	}
		if($("#checkIdAll").attr("checked")){
			if(confirm("确定导出以下新闻吗？(限制2000条内容)")){
				//$("#checkedIdsXls").val(checkedIds);
				document.frmPopWin.action="exportExcel.action";
				document.frmPopWin.target="";
				document.frmPopWin.submit();
				document.frmPopWin.action="goResultList.action";
			}
		}else{
			if (confirm("您已选择" + checkedMenu + "个新闻，确认导出?")) {
				$("#checkedIdsXls").val(checkedIds);
				//document.exportExcelFRM.submit();
				document.frmPopWin.action="exportExcel.action";
				document.frmPopWin.target="";
				document.frmPopWin.submit();
				document.frmPopWin.action="goResultList.action";
				$("#checkedIdsXls").val("");
			}
		}
}
function ExportShouyeExcel(){
var checkedMenu = getCheckIDsNum();
var checkedIds = getCheckIDs();

if (checkedMenu < 1) {
	alert("请选择需要导出的新闻!");
	return ;
}
	if($("#checkIdAll").attr("checked")){
		if(confirm("确定导出以下新闻吗？(限制2000条内容)")){
			document.frmPopWin.action="exportExcel.action";
			document.frmPopWin.target="";
			document.frmPopWin.submit();
			document.frmPopWin.action="list.action";
		}
	}else{
		if (confirm("您已选择" + checkedMenu + "个新闻，确认导出?")) {
			$("#checkedIdsXls").val(checkedIds);
			document.frmPopWin.action="exportExcel.action";
			document.frmPopWin.target="";
			document.frmPopWin.submit();
			document.frmPopWin.action="list.action";
			$("#checkedIdsXls").val("");
		}
	}
}
//新提示弹出层
/*
 *msg_type = 0 普通消息
 *msg_type > 0 回调消息
 *
 *stype = 1 ;确定、取消
 *
 *stype = 0 ;确定
 *
 *importType =1 素材库
 *importType =2 收藏夹
 */
function showMsgInfo(msg_type,msg,style){
	if(msg_type==0){
		window.parent.parent.parent.showInfoDiv(msg,style);
	}
}
//内容多条导入收藏夹或素材库（新）
function importNewsSenior(importNewType, folderId, account) {
	if (importNewType == 2) {
		importToName = "简报素材";
		importType = 2;

	} else if (importNewType == 1) {
		importToName = "收藏夹";
		importType = 1;
	}
	var checkedMenu = getCheckIDsNum();
	//var checkedIds = getCheckIDs();
	
	var elements = document.getElementsByTagName("input");
	var checkedIds = "";
	var repeatNum = "";
	for ( var i = 0; i < elements.length; i++) {
		var e = elements[i];
		if (e.id == "menuCheckId") {
			if (e.checked == true) {
				// checkedMenu = checkedMenu + 1;
				repeatNum = $("#repeatNum_"+e.value).val();
				checkedIds = checkedIds + e.value + "_"+repeatNum+",";
			}
		}
	}
	
	var timeDomain = document.getElementById("timeDomain").value;
	var starttime = document.getElementById("starttime").value;
	var endtime = document.getElementById("endtime").value;
	var silderRightDiv = $("#izl_rmenu",parent.window.document);
	if(parent.document.getElementById("izl_rmenu")==null){
		silderRightDiv = $("#izl_rmenu",parent.parent.window.document);
	}
	var countSucaiObj = $(silderRightDiv).find("a").eq(0).find("div").find("span");  //获取右侧素材 对象
	var countCollectObj = $(silderRightDiv).find("div[class='btn btn-scj rel']").find("span");  //获取右侧收藏 对象
	 var bottomSucaiCount =  $("#bottomSucaiCount",parent.window.document); //获取底部的素材数量
	 if(parent.document.getElementById("bottomSucaiCount")==null){
		 bottomSucaiCount=$("#bottomSucaiCount",parent.parent.window.document);
	 }
	if (checkedMenu == "0") {
		showMsgInfo(0,"请选择需要加入到" + importToName + "的新闻!",0);
		return;
	}
    var collectNum = $(countCollectObj).text()==""?0:$(countCollectObj).text();
    var checkNum = checkedIds.split(",").length;
  //  alert(collectNum);
   // alert(checkNum);
    if(importNewType==1&&(parseInt(collectNum)+checkNum)>1001){
        $("#cancelBtn").html("确认");
        $("#submitBtn").html("去收藏夹");
        showMsgInfo(0,"失败啦，收藏夹只提供1000条信息加入哦！",1);
        $("#submitBtn").click(function(){
            location.href = njxBasePath+"/collect.shtml";
        });
        return;
    }
	/*if (confirm("您已选择" + checkedMenu + "个新闻，确认加入" + importToName + "?")) {
		//tagNewsDisplay(checkedIds, importType);
		NewsOperate.operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime,
				CallBack);
	}*/
	//showMsgInfo(0,"您已选择" + checkedMenu + "个新闻，确认加入" + importToName + "?",1);
	//window.parent.parent.operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime);
	//$("#submitBtn",window.parent.parent.document).attr("onclick","javascript:operateNews('insert','"+checkedIds+
	//		"','"+importType+"','"+account+"','"+timeDomain+"','"+starttime+"','"+endtime+"')");
	/*$(".submitBtn",window.parent.parent.document).click(function(){
		alert("子页面")
		window.parent.parent.operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime);
	})*/;
	var keywordId=null;
	var keyword=null;
	if(document.getElementById("kw.keywordId")){
		var keywordId = document.getElementById("kw.keywordId").value;
	}
	if(keywordId==null||keywordId==""){
		if(document.getElementById("searchKeyword")){
			keyword=document.getElementById("searchKeyword").value;
		}
	}
	if($(".submitBtn",window.parent.parent.parent.document)){
		
		//4层
		//$(".submitBtn",window.parent.parent.parent.document).one("click",function(){
			window.parent.parent.parent.operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime,keywordId,keyword);
			/**if(importType==1){
				$(countCollectObj).html(parseInt($(countCollectObj).html())+parseInt(checkedMenu));
			}else if(importType==2){
				$(countSucaiObj).html(parseInt($(countSucaiObj).html())+parseInt(checkedMenu));
				 $(bottomSucaiCount).html(parseInt($(bottomSucaiCount).html())+parseInt(checkedMenu));
			}
			*/
		//})
	}else if($(".submitBtn",window.parent.document)){
			//2层
			window.parent.operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime,keywordId,keyword);
	}else if($(".submitBtn")){
			//1层
			operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime,keywordId,keyword);
	}
	
	
}
//内容单条导入收藏夹或素材库(新)
function importNewsSingleSenior(importNewType, folderId, account) {
		if (importNewType == 2) {
			importToName = "简报素材";
			importType = 2;
		} else if (importNewType == 1) {
			importToName = "收藏夹";
			importType = 1;
		}
	var checkedId = document.getElementById("selectedId").value;
	
	
	var repeatNum = document.getElementById("repeatNum_"+checkedId).value;
	
	var checkedIds = checkedId + "_" +repeatNum +",";
		var timeDomain = document.getElementById("timeDomain").value;
		var starttime = document.getElementById("starttime").value;
		var endtime = document.getElementById("endtime").value;
        var silderRightDiv = $("#izl_rmenu",parent.window.document);
        if(parent.document.getElementById("izl_rmenu")==null){
            silderRightDiv = $("#izl_rmenu",parent.parent.window.document);
        }
        var countCollectObj = $(silderRightDiv).find("div[class='btn btn-scj rel']").find("span");  //获取右侧收藏 对象
        var collectNum = $(countCollectObj).text()==""?0:$(countCollectObj).text();
        var checkNum = checkedIds.split(",").length;
        if(importNewType==1&&(parseInt(collectNum)+checkNum)>1001){
            $("#cancelBtn").html("确认");
            $("#submitBtn").html("去收藏夹");
            showMsgInfo(0,"失败啦，收藏夹只提供1000条信息加入哦！",1);
            $("#submitBtn").click(function(){
                location.href = njxBasePath+"/collect.shtml";
            });
            return;
        }
		//showMsgInfo(0,"您确定要加入"+importToName+"吗?",1);
		/*$(".submitBtn",window.parent.parent.document).one("click",function(){
			window.parent.parent.operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime);
		})*/
        var keywordId=null;
        var keyword=null;
        if(document.getElementById("kw.keywordId")){
        	keywordId = document.getElementById("kw.keywordId").value;
        }
    	if(keywordId==""||keywordId==null){
    		if(document.getElementById("searchKeyword")){    			
    			var searchKeyword=document.getElementById("searchKeyword").value;
    			if(searchKeyword!=""||searchKeyword!=null){
    				keyword = searchKeyword;
    			}
    		}
    	}
		if($(".submitBtn",window.parent.parent.parent.document)){
			//$(".submitBtn",window.parent.parent.parent.document).one("click",function(){
			
				window.parent.parent.parent.operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime,keywordId,keyword);
			//})
		}else if($(".submitBtn",window.parent.document)){
				window.parent.operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime,keywordId,keyword);
		}else if($(".submitBtn")){
				operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime,keywordId,keyword);
		}
}
//导出新闻(新)
function ExportAllExcelSenior(){
	
	ExportExcelCommon(this, 'gozzNews.action');
	
//	var checkedMenu = getCheckIDsNum();
//	var checkedIds = getCheckIDs();
//	
//	if (checkedMenu < 1) {
//		showMsgInfo(0,"请选择需要导出的新闻!",0);
//		return ;
//	}
//		if($("#checkIdAll").attr("checked")){
//			showMsgInfo(0,"确定导出以下新闻吗？(限制2000条内容)",1);
//			$(".submitBtn",window.parent.parent.parent.document).one("click",function(){
//				document.frmPopWin.action="exportExcel.action";
//				document.frmPopWin.target="";
//				document.frmPopWin.submit();
//				document.frmPopWin.action="goResultList.action";
//				window.parent.parent.parent.hideInfoDiv();
//			});
//		}else{
//			showMsgInfo(0,"您已选择" + checkedMenu + "个新闻，确认导出?",1);
//			$(".submitBtn",window.parent.parent.parent.document).one("click",function(){
//				$("#checkedIdsXls").val(checkedIds);
//				document.frmPopWin.action="exportExcel.action";
//				document.frmPopWin.target="";
//				document.frmPopWin.submit();
//				document.frmPopWin.action="goResultList.action";
//				$("#checkedIdsXls").val("");
//				window.parent.parent.parent.hideInfoDiv();
//			});
//		}
}
//导出首页列表新闻(新)
function ExportShouyeExcelSenior(){
	
	ExportExcelCommon(window.parent, 'listLoading.action');
	
//	var checkedMenu = getCheckIDsNum();
//	var checkedIds = getCheckIDs();
//
//	if (checkedMenu < 1) {
//		showMsgInfo(0,"请选择需要导出的新闻!",0);
//		return ;
//	}
//		if($("#checkIdAll").attr("checked")){
//			    showMsgInfo(0,"确定导出以下新闻吗？(限制2000条内容)",1);
//			    $(".submitBtn",window.parent.document).one("click",function(){
//					document.frmPopWin.action="exportExcel.action";
//					document.frmPopWin.target="";
//					document.frmPopWin.submit();
//					document.frmPopWin.action="list.action";
//					window.parent.hideInfoDiv();
//		    });
//		}else{
//			showMsgInfo(0,"您已选择" + checkedMenu + "个新闻，确认导出?",1);
//			 $(".submitBtn",window.parent.document).one("click",function(){
//				 	$("#checkedIdsXls").val(checkedIds);
//					document.frmPopWin.action="exportExcel.action";
//					document.frmPopWin.target="";
//					document.frmPopWin.submit();
//					document.frmPopWin.action="list.action";
//					$("#checkedIdsXls").val("");
//					window.parent.hideInfoDiv();
//			});
//		}
}
//首页内容多条导入收藏夹或素材库（新）
function importShouyeNewsSenior(importNewType, folderId, account) {
	if (importNewType == 2) {
		importToName = "简报素材";
		importType = 2;

	} else if (importNewType == 1) {
		importToName = "收藏夹";
		importType = 1;
	}
	var checkedMenu = getCheckIDsNum();
	var checkedIds = getCheckIDs();
	var timeDomain = document.getElementById("timeDomain").value;
	var starttime = document.getElementById("starttime").value;
	var endtime = document.getElementById("endtime").value;
	if (checkedMenu == "0") {
		showMsgInfo(0,"请选择需要加入到" + importToName + "的新闻!",0);
		return;
	}
	//showMsgInfo(0,"您已选择" + checkedMenu + "个新闻，确认加入" + importToName + "?",1);
	$(".submitBtn",window.parent.document).one("click",function(){
		var keywordId=null;
        var keyword=null;
        if(document.getElementById("kw.keywordId")){
        	keywordId = document.getElementById("kw.keywordId").value;
        }
    	if(keywordId==""||keywordId==null){
    		if(document.getElementById("searchKeyword")){    			
    			var searchKeyword=document.getElementById("searchKeyword").value;
    			if(searchKeyword!=""||searchKeyword!=null){
    				keyword = searchKeyword;
    			}
    		}
    	}
		window.parent.operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime,keywordId,keyword);
	})
}
//内容单条导入收藏夹或素材库(新)
function importShouyeNewsSingleSenior(importNewType, folderId, account) {
		if (importNewType == 2) {
			importToName = "简报素材";
			importType = 2;
		} else if (importNewType == 1) {
			importToName = "收藏夹";
			importType = 1;
		}
		var checkedIds = document.getElementById("selectedId").value + ",";
		var timeDomain = document.getElementById("timeDomain").value;
		var starttime = document.getElementById("starttime").value;
		var endtime = document.getElementById("endtime").value;
		showMsgInfo(0,"您确定要加入"+importToName+"吗?",1);
		var keywordId=null;
        var keyword=null;
        if(document.getElementById("kw.keywordId")){
        	keywordId = document.getElementById("kw.keywordId").value;
        }
    	if(keywordId==""||keywordId==null){
    		if(document.getElementById("searchKeyword")){    			
    			var searchKeyword=document.getElementById("searchKeyword").value;
    			if(searchKeyword!=""||searchKeyword!=null){
    				keyword = searchKeyword;
    			}
    		}
    	}
		$(".submitBtn",window.parent.document).one("click",function(){
			window.parent.operateNews("insert",checkedIds, importType, account,timeDomain,starttime,endtime,keywordId,keyword);
		})
}

//发送短信
function showSmsFrame(postion){
	var checkedIds = "";
	if (postion == 1) {// 内容
		checkedIds = $("#selectedId").val() + ",";
	} else { // 导航
		checkedIds = getCheckIDs();
	}
	if (checkedIds == "") {
		showMsgInfo(0,"请选择要发送短信的内容!",0);
		return ;
	} else {
		/*parent.showSmsSendFrame(checkedIds);*/
		var src = "pre_send_sms.action?checkedIds="+checkedIds;
		window.parent.parent.parent.showSmsDiv(src);
	}
}
//发送短信
function showShouyeSmsFrame(postion){
	var checkedIds = "";
	if (postion == 1) {// 内容
		checkedIds = $("#selectedId").val() + ",";
	} else { // 导航
		checkedIds = getCheckIDs();
	}
	if (checkedIds == "") {
		showMsgInfo(0,"请选择要发送短信的内容!",0);
		return ;
	} else {
		/*parent.showSmsSendFrame(checkedIds);*/
		var src = "pre_send_sms.action?checkedIds="+checkedIds;
		window.parent.showSmsDiv(src);
	}
}

// 导出列表新闻(共用)
function ExportExcelCommon(obj, action){
//	alert('ExportExcelCommon() -- >' + obj + ' ---> ' + action);
	var checkedMenu = getCheckIDsNum();
	var checkedIds = getCheckIDs();

	if (checkedMenu < 1) {
		showMsgInfo(0,"请选择需要导出的新闻!",0);
		return ;
	}
		if($("#checkIdAll").prop("checked")){
			    showMsgInfo(0,"确定导出以下新闻吗？(限制2000条内容)",1);
			    $(".submitBtn",obj.document).one("click",function(){
			    	if(getCheckIDsNum() >= 1) {
						document.frmPopWin.action="exportExcel.action";
						document.frmPopWin.target="";
						document.frmPopWin.submit();
						document.frmPopWin.action=action;
						obj.hideInfoDiv();
			    	}
		    });
		}else{
			showMsgInfo(0,"您已选择" + checkedMenu + "个新闻，确认导出?",1);
			 $(".submitBtn",obj.document).one("click",function(){
				 if(getCheckIDsNum() >= 1) {
				 	$("#checkedIdsXls").val(checkedIds);
				 	$("#checkedIds").val(checkedIds);
					document.frmPopWin.action="exportExcel.action";
					document.frmPopWin.target="";
					document.frmPopWin.submit();
					document.frmPopWin.action=action;
					$("#checkedIdsXls").val("");
					$("#checkedIds").val("");
					obj.hideInfoDiv();
				 }
			});
		}
}