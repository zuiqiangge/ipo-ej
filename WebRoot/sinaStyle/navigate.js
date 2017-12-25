<!--
//导航条的搜索功能
	function ajaxClickEvl(ev) {
		$("#searchKeyword").val(ev.innerHTML);
		$("#keyWordLogs_div").css( {
			"display" : "none"
		});
		subSearchForm();
	}

	function ajaxOverBG(ev) {
		ev.style.backgroundColor = "#e4e4e4";
		ev.style.color = "#2680b4";
	}

	function ajaxOutBG(ev) {
		ev.style.backgroundColor = "#ffffff";
		ev.style.color = "#2680b4";
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
		$("#keyWordLogs_div").hide();

	/*	$("#searchKeyword").css( {
				
				"background": "url(images/search.png) 180px 2px no-repeat"
			});*/
		/*$(".search_btn_span_right").css({
			float:"left",
			display:"inline-block",
			height:"32px",
			lineHeight:"32px",
			border:"solid 1px #CCC",
			margin:"1px 0px",
			verticalAlign: "middle",
			width:"38px",
			borderLeft:0,
			cursor: "pointer",
			background: "url(images/search.png)",
			backgroundPosition: "center",
			backgroundRepeat: "no-repeat",
		});*/
	};


	function deleteUserSearch() {
		$.ajax( {
			url : njxBasePath+"/keyWordLogs_deleteAll.action?" + new Date(),
			type : "get",
			success : function(data) {
                $("#keyWordLogs_ul").hide();
			},
			error : function(data) {
				alert("删除失败!");
			}
		});
	}
	function goNext(obj) {
		 
		var objName = "";
		var objId = "";
		if (event.keyCode == 13) {
		 
			subSearchForm();
			return false;
		}

	}

	function subSearchForm(){
			var kv = document.getElementById("searchKeyword").value;

		
		if($.trim(kv)==""){
			document.getElementById("searchKeyword").value = "";
			document.getElementById("searchKeyword").focus();
			//alert("请输入搜索关键字!");
			showMsgInfo(0,"请输入搜索关键字!",0);
			
			return ;
		}

		 
		var keyTitleV = kv;
		kv =  kv.replace(/\%/g, "%25");

		searchForm.action = njxBasePath + "/search.shtml";
	    searchForm.target = "_self";
	    searchForm.submit();

	}

	$(function(){
 
 		 
		 
		$("#dingdan_icon").mouseover(function() {
			
			 $(this).attr( {
				"src" : "images/icon_dingdan_hover.png"
				});
			 
		 });
		
		$("#dingdan_icon").mouseout(function() {
			 $(this).attr( {
				"src" : "images/icon_dingdan.png"
				});
		 });
		$("#user_icon").mouseover(function() {
			
			 $(this).attr( {
				"src" : "images/icon_user_hover.png"
				});
			 
		 });
		
		$("#user_icon").mouseout(function() {
			 $(this).attr( {
				"src" : "images/icon_user.png"
				});
		 });
	});

function goShouye(init){
	if(init==1){
		window.location.href = njxBasePath + "/home.shtml";
	}
}
function goYQList(init){
	if(init==1){
		window.location.href = njxBasePath + "/keyword.shtml";
	}
}
function goCollectNewsList(init){
	if(init==1){
		window.location.href="collectNewsList.action";
	}
}	
function goWarning(init){
	window.location.href=njxBasePath+"/warning.shtml";
}
function goUserCenter(init){

	window.location.href= njxBasePath + "/usercenter/account.shtml";
}
function goDingdan(init){
	window.location.href= njxBasePath + "/pay/cart.shtml";
}
function goJianbao(init){
	window.location.href="briefListSearch.action";
}
function logout(){
	window.location.href="logout.action";
}

function goDev(){
	window.location.href="goDev.action";
}


function goFindResult(kid,isGoSet){

 	// $(".submitBtn").html("续费");
	// showMsgInfo(0,"你的监测方案已到期，为享有更好的服务，请您及时续费！",1);

	$.ajax( {
				url : njxBasePath + "/isKeywordExpired.action?kw.keywordId="+kid,
				type : 'POST',
				 
				dataType : 'json',
				success : function(retMsg) {
					 
					if (retMsg.msg==false) {
					 //已过期
                        console.log(111);
						 $(".submitBtn").html("续费");
                        $(".cancelBtn").html("删除");
						 showMsgInfo(0,"您的监测方案已过期，您可以直接续费或者删除！",1);
						 $(".submitBtn").one("click",function(){
								/*var temp = document.createElement("form");
								temp.action = njxBasePath + "/continue/keyword.shtml";
								temp.method = 'POST';
								var opt = document.createElement('input');
								opt.type = 'hidden';
								opt.name = 'selectIds';
								opt.value = kid;
								temp.appendChild(opt);
								document.body.appendChild(temp);
								temp.submit();*/
							 	var params = {keywordIds : kid};
                                openBuyCommon(1, params);
						 });
						 $(".cancelBtn").one("click",function(){
                             /*$(".submitBtn").html("确定");*/
                             $.ajax({
                                 url:njxBasePath + "/deleteKeyword.action?kw.keywordId="+kid,
                                 type : 'GET',
                                 dataType : 'json',
                                 success : function(retMsg) {
                                     if(retMsg.msg==true){
                                         location.href= njxBasePath +"/keyword.shtml";
                                     }
                                 }
                             })
						 });
						  $(".info_close").one("click",function(){
								$(".submitBtn").html("确定");
						 });
							
					}
					else{
					 
						 
						if (isGoSet==1){
							self.location.href = njxBasePath + "/keywordSearch.action?targetTab=kset&kw.keywordId="+kid;
						}
						else{
							/*var params = {'kw.keywordId':kid};
							sendPostForm(njxBasePath + "/keyword.shtml", '_self', params);*/
                            getSearchBody(kid);
						}
					}
				 
				} 
					
			});

	/*
	
	*/
}

function deleteKeyword(kid){
    showMsgInfo(0,"该监测方案匹配的预警和自动报表将同时清除，确认删除？",1);
    $(".submitBtn").one("click",function(){
        $.ajax({
            url:njxBasePath + "/deleteKeyword.action?kw.keywordId="+kid,
            type : 'GET',
            dataType : 'json',
            success : function(retMsg) {
                if(retMsg.msg==true){
                    window.location.href= njxBasePath +"/keyword.shtml";
                }
            }
        })
    });
}

function  goKeySet(kid){

	var params = {'kw.keywordId':kid};
	sendPostForm(njxBasePath + "/keyword/set.shtml", '_self', params);


}

function sendPostForm(url, target, params) {
	var temp = document.createElement("form");
	temp.action = url;
	temp.method = 'POST';
	temp.target = target;
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