/**
 * lb
 * 
 * 功能块
 * 
 */
function GetRandom(n){
	GetRandomn=Math.floor(Math.random()*n+1);
	return GetRandomn;
}
function changeZhaiyaoType1(v,id){
 
	/*$("#clickZhaiyaoShow",window.parent.document).val(v);
	$("#zhaiyaoShow",window.parent.document).val(v);*/
	$("#clickZhaiyaoShow").val(v);
	$("#zhaiyaoShow").val(v);
	var zhaiyaoCount = 2;
	for ( var i = 1; i <= zhaiyaoCount; i++) {
		if (i != id) {
			document.getElementById("zhaiyao_type_"+i).className="";
		} else {
			document.getElementById("zhaiyao_type_"+i).className="cur";
		}
	}

	subForm();
	//ifrmview.changeZhaiyaoType(v, 1);
}

function changeComblineFlag(v,id){
	
	var flgCount=2;

	/*$("#clickComblineflg",window.parent.document).val(v);
	$("#comblineflg",window.parent.document).val(v);*/
	$("#clickComblineflg").val(v);
	$("#comblineflg").val(v);
	for ( var i = 1; i <= flgCount; i++) {
		if (i != id) {
			 

			document.getElementById("combline_flg_"+i).className="";
		} else {
			document.getElementById("combline_flg_"+i).className="cur";
		}
	}
	subForm();
	//ifrmview.changeComblineFlg(v, 1);
}

//字体大小设置
function changeFontSize(v,id){
	var count=2;
	ifrmview.$("#fontSizeType").val(v);
	ifrmview.$("#clickFontSizeType").val(v);
/*	$("#clickFontSizeType",window.parent.document).val(v);
	$("#fontSizeType",window.parent.document).val(v);*/
	$("#clickFontSizeType").val(v);
	("#fontSizeType").val(v);
	for ( var i = 1; i <= count; i++) {
		if (i != id) {
			$("#font_size_" + i).css( {
				"color":"#a1a1a1",
				"background-color":"#FFFFFF"
			});
		} else {
			$("#font_size_" + i).css( {
				/*"background-color" : "#93c92b",
				"color":"#FFFFFF"*/
				"background-color" : "#FFFFFF",
				"color":"#93c92b"
			});
		}
	}
	ifrmview.changeFontSizeType(v, 1);
}
//信息列表页切换
function changeList(id,v){
	
	var listLen=2;

	/*$("#clickNewlstSelect",window.parent.document).val(v);
	$("#newlstSelect",window.parent.document).val(v);*/
	$("#newlstSelect").val(v);
	$("#clickNewlstSelect").val(v);
	for(var i=1;i<=listLen;i++){
		if (i != id) {
			document.getElementById("info_list_"+i).className="";
		} else {
			document.getElementById("info_list_"+i).className="cur";
		}
	}
	subForm();
	//ifrmview.changeNewlstSelect(1);
}
 
// 排序
function parXuCommon(id, v) {
	
	var paixuLen = 4;
	//ifrmview.$("#paixu").val(v);
	//ifrmview.$("#clickPaixu").val(v);
	/*$("#clickPaixu",window.parent.document).val(v);
	$("#paixu",window.parent.document).val(v);*/
	$("#clickPaixu").val(v);
	$("#paixu").val(v);
	for ( var i = 1; i <= paixuLen; i++) {
		if (i != id) {
			if (document.getElementById("dateTimeA_"+i))
				document.getElementById("dateTimeA_"+i).className= "";
		} else {
			if (document.getElementById("dateTimeA_"+i))
				document.getElementById("dateTimeA_"+i).className= "cur";
		}
	}
	subForm();
	//ifrmview.changeSort(1);
}

function piPeiTypeCommon(id) {
	for ( var i = 1; i <= 2; i++) {
		if (i != id) {
			$("#pipeiTypeA_" + i).css( {
				"color":"#a1a1a1",
				"background-color":"#FFFFFF"
			});
		} else {
			$("#pipeiTypeA_" + i).css( {
				/*"background-color" : "#93c92b",
				"color":"#FFFFFF"*/
				"background-color" : "#FFFFFF",
				"color":"#93c92b"
			});
		}
	}
	ifrmview.changePipeiType(id);
}




// 来源网站
function cptWebSiteCommon(id, v) {
	var cptWebSiteLen = $("#cptWebSiteLen").val();
	ifrmview.$("#duplicateShow").val(v);
	ifrmview.$("#clickDuplicateShow").val(v);
	/*$("#clickDuplicateShow",window.parent.document).val(v);
	$("#duplicateShow",window.parent.document).val(v);*/
	$("#duplicateShow").val(v);
	$("#clickDuplicateShow").val(v);
	for ( var i = 1; i <= cptWebSiteLen; i++) {
		if (i != id) {
			$("#cptWebSiteA_" + i).css( {
				"color":"#a1a1a1",
				"background-color":"#FFFFFF"
			});
		} else {
			$("#cptWebSiteA_" + i).css( {
				/*"background-color" : "#93c92b",
				"color":"#FFFFFF"*/
				"background-color" : "#FFFFFF",
				"color":"#93c92b"
			});
		}
	}
	ifrmview.changeDuplicate(v, 1);
}

// 跟帖
var genTieLen = 2;
function genTieCommon(id, isShow) {
	for ( var i = 1; i <= genTieLen; i++) {
		if (i != id) {
			$("#genTieA_" + i).css( {
				"color":"#a1a1a1",
				"background-color":"#FFFFFF"
			});
		} else {
			$("#genTieA_" + i).css( {
			/*	"background-color" : "#93c92b",
				"color":"#FFFFFF"*/
				"background-color" : "#FFFFFF",
				"color":"#93c92b"
			});
		}
	}
	ifrmview.changeGengtie(isShow);
}

// 批量操作 id,类型(-1表示不弹出遮罩),位置(0表示导航,1表示内容)
function operateACommon(id, type, postion, account) {
	if (id == 4) {// 非负面
		if (postion == 0) {// 导航
			ifrmview.TagNews(4, 0, account);
		} else {// 内容
			ifrmview.TagNewsSingle(4, 0, account);
		}
	} else if (id == 5) {// 短信
		ifrmview.showSmsSendFrame(postion);
	}
}
function showSmsSend(ids){
	$("#send_sms_frame").attr("src","pre_send_sms.action?checkedIds="+ids);
	$("#BgDiv").css({display:"block", height:$(document).height()});
	var yscroll = document.documentElement.scrollTop;
	parent.$("#DialogDiv").css("display", "block");
	parent.document.documentElement.scrollTop = 0;
	parent.document.body.scrollTop =0;

 
}
function aMouseImg(id, imgSrc) {
	// $("#"+id).attr({"src":imgSrc});
}

//搜索方式
var solrType = 3;
function solrTypeCommon(id, v) {
	
	 
	$("#solrType").val(v);
	for ( var i = 1; i <= solrType; i++) {
		if (i != id) {
			 document.getElementById("solrType_"+i).className="";
			 
		} else {
			  document.getElementById("solrType_"+i).className="cur";
			 
		}
	}
	subForm();
}


// 属性
var attributeALen = 3;
function attributeACommon(id, v) {
	
	 
	$("#otherAttribute").val(v);
	$("#clickOtherAttribute").val(v);
	for ( var i = 1; i <= attributeALen; i++) {
		if (i != id) {
			 document.getElementById("attributeA_"+i).className="";
			 
		} else {
			  document.getElementById("attributeA_"+i).className="cur";
			 
		}
	}
	subForm();
	//ifrmview.changeDuplicate(1);
}

//系统优选


var isRecommendedLen = 3;
function isRecommendedCommon(id, v) {
	
	 
	$("#isRecommended").val(v);
	for ( var i = 1; i <= isRecommendedLen; i++) {
		if (i != id) {
			 document.getElementById("isRecommended_"+i).className="";
			 
		} else {
			  document.getElementById("isRecommended_"+i).className="cur";
			 
		}
	}
	subForm();
}


// 计算默认时间
function setDefaultLenLoadCommon() {
	// 默认时间
	var defaultDaytime = 1;
	var defaultTime = '${search_default_time}';
	var date = new Date().getTime();
	if (defaultTime == 'today') {
		var today = new Date();
		var todayTime = new Date((today.getFullYear() + "-" + today.getMonth()
				+ "-" + today.getDate() + " 00:00:00").replace(/-/g, "/"))
				.getTime();
		date = date - todayTime;
	} else {
		if (defaultTime == '24h') {
			defaultDaytime = 1;
		} else if (defaultTime == 'week') {
			defaultDaytime = 6;
		} else if (defaultTime == '10days') {
			defaultDaytime = 9;
		} else if (defaultTime == '15days') {
			defaultDaytime = 14;
		} else if (defaultTime == 'month') {
			defaultDaytime = 30;
		}
		date = date - defaultDaytime * 24 * 3600 * 1000;
	}

	if ($.trim($("#starttime").val()) == '') {

		$("#starttime").val(new Date(date).format("yyyy-MM-dd hh:mm:ss"));
		$("#endtime").val(
				new Date(new Date().getTime()).format("yyyy-MM-dd hh:mm:ss"));

		$("#showStarttime").val(new Date(date).format("yyyy-MM-dd hh:mm:ss"));
		$("#showEndtime").val(
				new Date(new Date().getTime()).format("yyyy-MM-dd hh:mm:ss"));
	} else {
		var showStarttime = $("#starttime").val();
		var showEndtime = $("#endtime").val();
		//$("#showStarttime").val(showStarttime.substring(0, 10));
		//$("#showEndtime").val(showEndtime.substring(0, 10));
	}
}

Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1,
		"d+" : this.getDate(),
		"h+" : this.getHours(),
		"m+" : this.getMinutes(),
		"s+" : this.getSeconds(),
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		"S" : this.getMilliseconds()
	}
	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}
function getToDay() {
	var now = new Date();
	var nowYear = now.getFullYear();
	var nowMonth = (now.getMonth() + 1);
	var nowDate = now.getDate();
	if (nowMonth < 10) {
		nowMonth = "0" + nowMonth;
	}
	if (nowDate < 10) {
		nowDate = "0" + nowDate;
	}
	return nowYear + "-" + nowMonth + "-" + nowDate + " 00:00:00";
}
//op 0 - 图表 , 1 - 搜索
function selectTimeSubmit(ev, id,op) {
	
	var lenA = 7;
//	ifrmview.$("#clickTimeDomain").val(ev);
//	ifrmview.$("#timeDomain").val(ev);
	
	var start_time = $("#start_time").val();
	var end_time = $("#end_time").val();
	if(op == 1){
		//document.getElementById("defaultLen").value= ev;
	}
	
	for ( var i = 1; i <= lenA; i++) {
		if (i != id) {

			//document.getElementById("selectTimeA_"+i).className="";
            $("#selectTimeA_"+i).removeClass("cur");
			//$("#selectTimeA_" + i).attr({className: ''});
		} else {
			 document.getElementById("selectTimeA_"+i).className="cur";
			//$("#selectTimeA_" + i).attr({className: 'cur'});
		}
	}
	//其他
	if ('0' == ev) {
        $("#selectOtherTime").val(1);
		$("#clickTimeDomain").val(ev);
		$("#other_time").show();
		$("#timeDomain").val(ev);
		if(!start_time && typeof(start_time)!="undefined" && start_time!=0){
			$("#starttime").val(start_time);
		}else{
			$("#start_time").val($("#starttime").val());
		}
		if(!end_time && typeof(end_time)!="undefined" && end_time!=0){
			$("#endtime").val(end_time);
		}else{
			$("#end_time").val($("#endtime").val());
		}
	} else {
        $("#selectOtherTime").val(0);
        $("#combline_flg_1").show();
		if(op == 1){
			//ifrmview.$("#selectOtherTime").val(0);
			//$("#dataParam").val(id);
			//$("#defaultLen").val(ev);
			$("#timeDomain").val(ev);
		}else if(op == 0){
			//$("#selectOtherTime").val(0);
			//$("#dataParam").val(id);
			//$("#defaultLen").val(ev);
			$("#timeDomain").val(ev);
		}
		var now = new Date().getTime();
		var end = 0;
		var isHourSeach = false;
		if ('24' == ev || '1' == ev) {// 24小时 或者今天
			if ('1' == ev) {// 今天
				end = getToDay();
			} else {
				end = now - 1 * 24 * 3600 * 1000;
			}
			isHourSeach = true;
			$("#isHourSeach").val(true);
		} else {
			$("#isHourSeach").val(false);
			if ('7' == ev) {// 1周
				end = now - 6 * 24 * 3600 * 1000;
			} else if ('10' == ev) {// 10天
				end = now - 9 * 24 * 3600 * 1000;
			} else if ('15' == ev) {// 半月
				end = now - 14 * 24 * 3600 * 1000;
			} else if ('30' == ev) {// 1月
				end = now - 29 * 24 * 3600 * 1000;
			}  else if ('60' == ev) {// 2月
				end = now - 59 * 24 * 3600 * 1000;
			} else if ('90' == ev) {// 3月
				end = now - 89 * 24 * 3600 * 1000;
			}else if ('365' == ev) {// 年
				end = now - 364 * 24 * 3600 * 1000;
			}else if ('3' == ev){//3天
                end = now - 2 * 24 * 3600 * 1000;
            }else if ('2' == ev){//2天
                end = now - 1 * 24 * 3600 * 1000;
            }
		}
		$("#starttime").val(new Date(end).format("yyyy-MM-dd 00:00:00"));
		$("#endtime").val(new Date(now).format("yyyy-MM-dd hh:mm:ss"));
		if (ev == '1') {
			$("#starttime").val(end);
		} else if(ev=='24'){
			$("#starttime").val(new Date(end).format("yyyy-MM-dd hh:mm:ss"));
			$("#endtime").val(new Date(now).format("yyyy-MM-dd hh:mm:ss"));
		}
		if (end >= now) {
			alert("开始时间不能大于或等于结束时间");
			return;
		}
		
		 
		$("#clickTimeDomain").val(ev);
		$("#timeDomain").val(ev);
		//$("#starttime").val(starttime);
		//$("#endtime").val(endtime);
	  	subForm();
	}
}

// 设置页面中默认搜索时间
function setStartAndEndTime() {
	var date = new Date($("#starttime").val().replace(/-/g, "/")).getTime();
	var enddate = new Date($("#endtime").val().replace(/-/g, "/")).getTime();
	$("#showStarttime").val(new Date(date).format("yyyy-MM-dd hh:mm:ss"));
	//$("#showEndtime").val(new Date(new Date().getTime()).format("yyyy-MM-dd"));
	$("#showEndtime").val(new Date(enddate).format("yyyy-MM-dd hh:mm:ss"));
}


function selectTimeOver() {
	$("#other_time").show();
}

function selectTimeOut() {
	$("#other_time").hide();
}

function showSubForm() {
	if($("#showStarttime").val()=="undefined" || $("#showStarttime").val()==null || $("#showStarttime").val()==""){
		window.parent.showMsgInfo(0,"请输入搜索开始时间",0);
		return;
	}
	if($("#showEndtime").val()=="undefined" || $("#showEndtime").val()==null || $("#showEndtime").val()==""){
		window.parent.showMsgInfo(0,"请输入搜索结束时间",0);
		return;
	}
    //时间戳
    var end_stamp = Date.parse(new Date($("#showEndtime").val().replace(/-/g, "/")));
    var start_stamp  = Date.parse(new Date($("#showStarttime").val().replace(/-/g, "/")));
    if(start_stamp > end_stamp ){
        //alert("开始时间不能大于结束时间");
        showMsgInfo(0,"开始时间不能大于结束时间",0);
        return ;
    }
    if((end_stamp-start_stamp)/(1000*60*60*24)>30){
        changeComblineFlag(2,2);
        $("#combline_flg_1").hide();
    }else{
        $("#combline_flg_1").show();
    }
	
//	ifrmview.$("#selectOtherTime").val(1);
	//$("#selectOtherTime").val(1);

	$("#starttime").val($("#showStarttime").val());
	$("#endtime").val($("#showEndtime").val());
	$("#showChartStarttime").val($("#showStarttime").val());
	$("#showChartEndtime").val($("#showEndtime").val());
   // $("#start_time").val($("#starttime").val());
   // $("#end_time").val($("#endtime").val());
    
	$("#clickTimeDomain").val(0);
	$("#timeDomain").val(0);
	subForm();
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
    document.getElementById("checkIdAll").checked=parentChecked;
}
function setSelectIdVal(ev) {
	$("#selectedId").val(ev);
}

function changeOrigina(dateType, init) {
    $("#cpage").val(1);//修改条件重置页码
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


// 导出列表新闻(共用)
function ExportExcelCommon(){
//	alert('ExportExcelCommon() -- >' + obj + ' ---> ' + action);
	var checkedMenu = getCheckIDsNum();
	var checkedIds = getCheckIDs();

	if (checkedMenu < 1) {
		showMsgInfo(0,"请选择需要导出的新闻!",0);
		return ;
	}
		/*if($("#checkIdAll").prop("checked")){
			    showMsgInfo(0,"确定导出以下新闻吗？(限制2000条内容)",1);
			    $(".submitBtn",this.document).one("click",function(){
			    	if(getCheckIDsNum() >= 1) {
						document.frmPopWin.action="exportExcel.action";
						document.frmPopWin.target="";
						document.frmPopWin.submit();
						//document.frmPopWin.action=action;
						hideInfoDiv();
			    	}
		    });
		}else{*/
			showMsgInfo(0,"您已选择" + checkedMenu + "个新闻，确认导出?",1);
			 $(".submitBtn",this.document).one("click",function(){
				 if(getCheckIDsNum() >= 1) {
				 	$("#checkedIdsXls").val(checkedIds);
					document.frmPopWin.action="exportExcel.action";
					document.frmPopWin.target="";
					document.frmPopWin.submit();
					//document.frmPopWin.action=action;
					$("#checkedIdsXls").val("");
					 hideInfoDiv();
				 }
			});
		/*}*/
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
function switchToolbar(ev,id){
	var flgLen=2;
	for(var i=1;i<=flgLen;i++){
		if (i != id) {
			document.getElementById("switchToolbar_" + i).className = "";
		} else {
			document.getElementById("switchToolbar_" + i).className = "cur";
		}
	}
	document.getElementById("toolbarSwitch").value = ev;
}

function changeDirectSet(value, id, length) {
	$('#directSet').val(value);
    $("#clickDirectSet").val(value);
	for (var i = 1; i <= length; i++) {
		if (i != id)
			document.getElementById('changeDirectSet_' + i).className = '';
		else
			document.getElementById('changeDirectSet_' + i).className = 'cur';
	}
	/*curKDS = id;*/
	subForm();
}