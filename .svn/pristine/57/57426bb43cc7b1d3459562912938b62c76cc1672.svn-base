function getOs(){ 
    var OsObject = ""; 
   if(navigator.userAgent.indexOf("MSIE")>0) { 
        return "MSIE"; 
   } 
   if(navigator.userAgent.indexOf("Firefox")>0){ 
        return "Firefox"; 
   } 
   if(navigator.userAgent.indexOf("Chrome")>0){ 
        return "Chrome"; 
   } 
   if(navigator.userAgent.indexOf("Safari")>0) { 
        return "Safari"; 
   }   
} 
function SetCwinHeight(){
	var navType= getOs();
	var b_height=0;
	if (navType=="Chrome"||navType=="Safari"){
		b_height = document.documentElement.scrollHeight;
	} 
	else{
		b_height = document.body.scrollHeight;
	}
	b_height = b_height + 100;
	if (b_height < 900){
		b_height = 900;
	}
	var c_iframe1 = parent.document.getElementById('ifrmview');
 
	if(c_iframe1){
		c_iframe1.height = b_height ;
	}
}

/*function subForm(){
	var c_iframe = parent.document.getElementById('ifrmview');
	c_iframe.height=0;
	var listD = document.getElementById('listDiv'); 
	listD.style.display='none'; 
	listD.style.visibility='hidden';
	parent.minisecond=0;
	parent.second=0;
	parent.display_loading();
 
	document.frmPopWin.target="";
	document.frmPopWin.submit();
}*/

//点击的不是显示操作时将他隐藏
/* document.onclick = function (event) {
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
    parent.document.getElementById("other_time").style.display = "none";
};
 */

//批量操作 id,类型(-1表示不弹出遮罩),位置(0表示导航,1表示内容)
function operateACommonOne(id, type,postion) {
	parent.operateACommon(id, type,postion,'${admin.userId}');
}

/* $(function(){
	$(".operateLiClass").mouseover(function(){
		$(this).css({"backgroundColor":"#2a8bdb","color":"#ffffff"});
	});
	
	$(".operateLiClass").mouseout(function(){
		$(this).css({"backgroundColor":"#def6fc","color":"#000000"});
	});
}); */

function operateUlOver(opearte, id) {
	$("#selectedId").val(id);
	$("#"+opearte+"operateLi_UL_" + id).css( {
		"display" : "block"
	}).html($("#operateUl_" + id).html());
}

function operateUlOut(opearte, id) {
	$("#"+opearte+"operateLi_UL_" + id).css( {
		"display" : "none"
	}).html($("#operateUl_" + opearte).html());
}
function setWinHeight(){
	var c_iframe1 = parent.document.getElementById('ifrmview');
	if(c_iframe1){
		c_iframe1.height = 600;
	}
	
}
//到指定页
function GotoPage(i)
{	
	if (document.frmPopWin.page||document.frmPopWin.page1)
	{
		document.frmPopWin.page.value = i;
		subForm();
	}
	else{
		subForm();
	}
}
function goView(title,id,titleHs,province,customFlag1,repeatNum){
	var starttime = document.getElementById("starttime").value;
	var endtime = document.getElementById("endtime").value;
	var otherAttribute = document.getElementById("otherAttribute").value;
	var filterOrigina = document.getElementById("filterOrigina").value;
//	province = encodeURIComponent(encodeURIComponent(province));
	var searchKeyword = document.getElementById("searchKeyword").value;
//	if(searchKeyword && searchKeyword!=""){
//		searchKeyword = encodeURIComponent(encodeURIComponent(searchKeyword));
//	}
	var secondSearchWord = document.getElementById("secondSearchWord").value;
//	if(secondSearchWord && secondSearchWord!="" && secondSearchWord !="在结果中搜索"){
//		secondSearchWord = encodeURIComponent(encodeURIComponent(secondSearchWord));
//	}
	var searchPipeiType = document.getElementById("searchPipeiType").value;
//	window.open("content_view.action?con.id="+id+"&titleHs="+titleHs+"&start_time="+starttime+
//			"&end_time="+endtime+"&otherAttribute="+otherAttribute+"&filterOrigina="+filterOrigina+"&province="+province+"&searchKeyword="+searchKeyword+"&secondSearchWord="+secondSearchWord+"&searchPipeiType="+searchPipeiType+"&con.customFlag1="+customFlag1+"&con.repeatNum="+repeatNum,'_blank');
	
	var params = {'con.id':id, 'titleHs':titleHs, 'start_time':starttime, 'end_time':endtime, 'otherAttribute':otherAttribute, 'filterOrigina':filterOrigina, 'province':province, 'searchKeyword':searchKeyword, 'secondSearchWord':secondSearchWord, 'searchPipeiType':searchPipeiType, 'con.customFlag1':customFlag1, 'con.repeatNum':repeatNum};
	
	var temp = document.createElement("form");
	temp.action = njxImgSrc + '/content/detail.shtml';
	temp.method = 'POST';
	temp.target = '_blank';
	for(var x in params) {
		var opt = document.createElement('input');
		opt.type = 'hidden';
		opt.name = x;
		opt.value = params[x];
		temp.appendChild(opt);
	}
	document.body.appendChild(temp);
	temp.submit();
}
function GetRandom(n){
	GetRandomn=Math.floor(Math.random()*n+1);
	return GetRandomn;
}
