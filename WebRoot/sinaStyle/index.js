// JavaScript Document
// JavaScript Document
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}
function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->

document.execCommand("BackgroundImageCache",false,true);var timerID;
function Ali_Showtable(obj, index) {
	var arry=new Array("cz","tf","ta");
	for(i=0;i<3;i++)
	{
		if(index==arry[i])
		{
			document.getElementById(arry[i]+"_Content").style.display="block";
			document.getElementById("image_"+arry[i]).className="image_"+arry[i]+"_2";
		}
		else
		{
			document.getElementById(arry[i]+"_Content").style.display="none";
			document.getElementById("image_"+arry[i]).className="image_"+arry[i]+"_1";
		}
	}
}
//
function senfe(o,a,b,c,d){ 
 var t=document.getElementById(o).getElementsByTagName("tr");
 //alert(t.length);
 for(var i=0;i<t.length;i++){
  t[i].style.backgroundColor=(t[i].sectionRowIndex%2==0)?a:b;
  t[i].onclick=function(){
   if(this.x!="1"){
    this.x="1";
    this.style.backgroundColor=d;
   }else{
    this.x="0";
    this.style.backgroundColor=(this.sectionRowIndex%2==0)?a:b;
   }
  }
  t[i].onmouseover=function(){
   if(this.x!="1")this.style.backgroundColor=c;
  }
  t[i].onmouseout=function(){
   if(this.x!="1")this.style.backgroundColor=(this.sectionRowIndex%2==0)?a:b;
  }
 }
}
//
//tab function
function TabSelect(tab,con,addClass,obj) {
    var jQuery_self = obj;
    var jQuery_nav = jQuery(tab);

    jQuery_nav.removeClass(addClass),
	jQuery_self.addClass(addClass);

    var jQuery_index = jQuery_nav.index(jQuery_self);
    var jQuery_con = jQuery(con);
    jQuery_con.hide(),
	jQuery_con.eq(jQuery_index).show();
}

//----------------------------------------------------------
// Set Cookie
//----------------------------------------------------------
function setCookie(sName, sValue){
   //document.cookie = escape(sName) + "=" + escape(sValue) + "; domain=alicall.com";  
	var argv=setCookie.arguments;
	var argc=setCookie.arguments.length;
	var expires=(2<argc)?argv[2]:null;
	var path=(3<argc)?argv[3]:null;
	var domain=(4<argc)?argv[4]:null;
	var secure=(5<argc)?argv[5]:false;
	document.cookie=escape(sName)+"="+escape(sValue)+((expires==null)?"":("; expires="+expires.toGMTString()))+((path==null)?"":("; path="+path))+((domain==null)?"":("; domain="+domain))+((secure==true)?"; secure":"");
}

//----------------------------------------------------------
// Get Cookie
//----------------------------------------------------------
function getCookie(name) {
    var arg = name + "=";
    var alen = arg.length;
    var clen = document.cookie.length;
    var i = 0;
    while (i < clen) {
        var j = i + alen;
        if (document.cookie.substring(i, j) == arg) {
		    var endstr = document.cookie.indexOf(";", j);
		    if (endstr == -1) {
		        endstr = document.cookie.length;
		    }
		    return unescape(document.cookie.substring(j, endstr));
        }
        i = document.cookie.indexOf(" ", i) + 1;
        if (i == 0) {
            break;
        }
    }
    return null;
}

//----------------------------------------------------------
// del cookies
//----------------------------------------------------------
function delCookie(name)//删除cookie
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}
function clearCookie(){
    var keys=document.cookie.match(/[^ =;]+(?=\=)/g);
    if (keys) {
        for (var i =  keys.length; i--;)
            document.cookie=keys[i]+'=0;expires=' + new Date( 0).toUTCString()
    }    
}

//----------------------------------------------------------
// Date Format
//----------------------------------------------------------


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

//----------------------------------------------------------
// Base AjaxRequest
//----------------------------------------------------------
function AjaxRequest(){
    var oThis = this; 
    var text = null;
    var xml = null;
    var object = null;
    var xmlhttp = null;
    var parameters = [];
    try {
        xmlhttp = new XMLHttpRequest();
    }catch (e1) {
        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e2) {
            try{
                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
            }catch(e3){
            }
        }
    }
    if(xmlhttp==null){
        alert("Can't create XMLHttpRequest object");
        return null;
    }

    this.onreadystatechange = function(){
        if(xmlhttp.readyState==4){
            if(xmlhttp.status==200 ||xmlhttp.status==0){
                oThis.onBack();
            }else{
                if (xmlhttp.status==404){
                    // alert("URL: (" + oThis.url + ") doesn't exist!");
                }else{
                    // alert("Status is " + xmlhttp.status);
                }
            }
        }
    }
    
    this.open = function(_method,_url,_async){
        xml = null;
        text = null;
        object = null;
        oThis.clearParameters();
        oThis.async = _async;
        oThis.url = _url;
        xmlhttp.open(_method,_url,_async);
        xmlhttp.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
        oThis.setParameter("_isAjaxRequest",'true');    
        if(_async==true) {xmlhttp.onreadystatechange=oThis.onreadystatechange;}
    }

    this.setParameter = function(name,value) {
        parameters.push({'name':name,'value':value});
    }

    this.clearParameters = function(){
        parameters = new Array();
    }

    this.getParametersStr = function(){
        var info = [];
        var pvalue = null;
        for(var i=0;i<parameters.length;i++){
            var p = parameters[i];
            if(p==null) continue;
            pvalue = encodeURIComponent(p.value);
            info.push(p.name + "=" + pvalue);
        }
        var str = info.join("&");
        return str;
    }
    
    this.send = function(){
        var str =oThis.getParametersStr();
        xmlhttp.send(str);
        // if async is false, run function by synchronous
        if(oThis.async==false) {oThis.onreadystatechange();}
        oThis.clearParameters();
    }
    
    // return value of object
    this.getObject = function(){
        if(object==null){
            try{
                object = eval("obj=" + oThis.getText());
            }catch(e){
                object = null;
            }
        }
        return object;
    }
    
    // return value of text
    this.getText = function(){
        if(text==null) {text = xmlhttp.responseText;}
        return text;
    }

    // return value of xmlDoc
    this.getXml = function(){
        if(xml==null) {xml = xmlhttp.responseXML;}
        return xml;
    }
      
    this.onBack = function(){}
}

function intro_float(i)
{
	document.getElementById(i).style.display = "block";
}
function shutup(i)
{
	document.getElementById(i).style.display = "none";
}
jQuery(function(){
	setTimeout('jQuery("#uc").hide();',100);
})
