$(function(){
	var sucaiTotal = $("#sucaiTotal").val();
	var collectTotal = $("#collectTotal").val();
    collectTotal = collectTotal==0?"":collectTotal;
	var cartTotal = $("#cartTotal").val();
	var tophtml="<div id=\"izl_rmenu\" class=\"izl-rmenu\">";
	tophtml += "	<a href=\'javascript:;'\>";
	tophtml += "		<div style='display:none;' id=\"commonShare\" class=\"btn btn-fx\">";
	tophtml += "			<div class=\"pic\">";
	tophtml += "				<div class=\"fenxiang\">";
	tophtml += "					<div class=\"arrow\"></div>";
	tophtml += "					<a href=\"javascript:;\" class=\"icon icon_wb\" title=\"分享到微博\"></a>";
	tophtml += "					<a href=\"javascript:;\" class=\"icon icon_wx\" title=\"分享到微信\"></a>";
	tophtml += "					<a href=\"javascript:;\" class=\"icon icon_pyq\" title=\"分享到朋友圈\"></a>";
	tophtml += "					<a href=\"javascript:;\" class=\"icon icon_qq\" title=\"分享到QQ\"></a>";
	tophtml += "					<a href=\"javascript:;\" class=\"icon icon_qqkj\" title=\"分享到QQ空间\"></a>";
	tophtml += "				</div>";
	tophtml += "			</div>";
	tophtml += "		</div>";
	tophtml += "	</a>";
	tophtml += "	<a style='display:none;' href=\'"+actionBase+"/pay/buy.shtml'\>";
	tophtml += "		<div class=\"btn btn-gwc\"></div>";
	tophtml += "	</a>";
	tophtml += "	<a style='display:none;' href=\'"+actionBase+"/briefListSearch.action?flag=3'\>";
	tophtml += "		<div class=\"btn btn-sucai rel\">";
	tophtml += "			<span id='sucai_num' class=\"numBox abs\">"+sucaiTotal+"</span>";
	tophtml += "		</div>";
	tophtml += "	</a>";
	tophtml += "	<a href=\'"+actionBase+"/collect.shtml'\>";
	tophtml += "		<div class=\"btn btn-scj rel\">";
	tophtml += "			<span id='collect_num' class=\"numBox abs\">"+collectTotal+"</span>";
	tophtml += "		</div>";
	tophtml += "	</a>";
   /* tophtml += "    <a href=\'"+actionBase+"/exportInfortmation.shtml'\>";
    tophtml +="         <div class=\"btn btn-export rel\"></div>";
    tophtml +="     </a>";*/
	tophtml += "	<a href=\'"+actionBase+"/downLoad.shtml'\>";
	tophtml += "		<div class=\"btn btn-app\">";
	tophtml += "			<img class=\"pic\" src=\"" + qrCodeImg + "\" onclick=\"window.location.href=\'javascript:;'\"/>";
	tophtml += "		</div>";
	tophtml += "	</a>";
	tophtml += "	<a href=\'"+actionBase+"/help.shtml'\>";
	tophtml += "		<div class=\"btn btn-question\"></div>";
	tophtml += "	</a>";
	tophtml += "	<div class=\"btn btn-qq\" title=\QQ客服\>";
	tophtml += "		<div class=\"pic\">";
	tophtml += "			<a class=\qq_btn\ href=\http://wpa.qq.com/msgrd?v=3&uin=2597444526&site=qq&menu=yes\ target=\blank\ title=\客服小微\>客服小微</a>";
	tophtml += "			<a class=\qq_btn\ href=\http://wpa.qq.com/msgrd?v=3&uin=2840307223&site=qq&menu=yes\ target=\blank\ title=\客服小舆\>客服小舆</a>";
	tophtml += "		</div>";
	tophtml += "	</div>";
	tophtml += "	<a href=\'" + actionBase + "/QAndA/list.shtml'\>";
	tophtml += "		<div class=\"btn btn-questions\"></div>";
	tophtml += "	</a>";
	tophtml += "	<div class=\"btn btn-top\"></div>";
	tophtml += "</div>";
	$("#top").html(tophtml);
	$("#izl_rmenu").each(function(){
		$(this).find(".btn-fx").mouseenter(function(){
			$(this).find(".pic").fadeIn("fast");
		});
		$(this).find(".btn-fx").mouseleave(function(){
			$(this).find(".pic").fadeOut("fast");
		});
		$(this).find(".btn-qq").mouseenter(function(){
			$(this).find(".pic").fadeIn("fast");
		});
		$(this).find(".btn-qq").mouseleave(function(){
			$(this).find(".pic").fadeOut("fast");
		});
		$(this).find(".btn-app").mouseenter(function(){
			$(this).find(".pic").fadeIn("fast");
		});
		$(this).find(".btn-app").mouseleave(function(){
			$(this).find(".pic").fadeOut("fast");
		});
		$(this).find(".btn-phone").mouseenter(function(){
			$(this).find(".phone").fadeIn("fast");
		});
		$(this).find(".btn-phone").mouseleave(function(){
			$(this).find(".phone").fadeOut("fast");
		});
		$(this).find(".btn-top").click(function(){
			$("html, body").animate({
				"scroll-top":0
			},"fast");
		});
	});
	var lastRmenuStatus=false;
	$(window).scroll(function(){//bug
		var _top=$(window).scrollTop();
		if(_top>200){
			$("#izl_rmenu").data("expanded",true);
		}else{
			$("#izl_rmenu").data("expanded",false);
		}
		if($("#izl_rmenu").data("expanded")!=lastRmenuStatus){
			lastRmenuStatus=$("#izl_rmenu").data("expanded");
			if(lastRmenuStatus){
				$("#izl_rmenu .btn-top").slideDown();
			}else{
				$("#izl_rmenu .btn-top").slideUp();
			}
		}
	});
});


$(function(){

	var tophtml="<div id=\"izl_rmenu\" class=\"izl-rmenu\"><a href=\'#'\><div class=\"btn btn-fx\"><div class=\"pic\"><div class=\"fenxiang\"><div class=\"arrow\"></div><a href=\"#\" class=\"icon icon_wb\" title=\"分享到微博\"></a><a href=\"#\" class=\"icon icon_wx\" title=\"分享到微信\"></a><a href=\"#\" class=\"icon icon_pyq\" title=\"分享到朋友圈\"></a><a href=\"#\" class=\"icon icon_qq\" title=\"分享到QQ\"></a><a href=\"#\" class=\"icon icon_qqkj\" title=\"分享到QQ空间\"></a></div></div></div></a><div class=\"btn btn-top\"></div></div>";
	$("#top2").html(tophtml);
	$("#izl_rmenu").each(function(){
		$(this).find(".btn-fx").mouseenter(function(){
			$(this).find(".pic").fadeIn("fast");
		});
		$(this).find(".btn-fx").mouseleave(function(){
			$(this).find(".pic").fadeOut("fast");
		});
		$(this).find(".btn-top").click(function(){
			$("html, body").animate({
				"scroll-top":0
			},"fast");
		});
	});
	var lastRmenuStatus=false;
	$(window).scroll(function(){//bug
		var _top=$(window).scrollTop();
		if(_top>200){
			$("#izl_rmenu").data("expanded",true);
		}else{
			$("#izl_rmenu").data("expanded",false);
		}
		if($("#izl_rmenu").data("expanded")!=lastRmenuStatus){
			lastRmenuStatus=$("#izl_rmenu").data("expanded");
			if(lastRmenuStatus){
				$("#izl_rmenu .btn-top").slideDown();
			}else{
				$("#izl_rmenu .btn-top").slideUp();
			}
		}
	});
});