var textT="<li><div class='text tool tools'><ul class='control'><!--<li><b title='移动' id='moveBtn' class='icon-arrows'></b></li> --><li><b title='编辑' id='editorBtn' class='icon-pencil' style='display: none;'></b></li><li><b title='确定' id='okBtn' class='icon-check'></b></li><li><b title='删除' id='deleteBtn' class='icon-trash-o'></b></li></ul><div contenteditable='true'  class='textCon contenteditable texteditor' id='contentelement' placeholder='文本'></div></div></li>";

/*
var trendF="<li><div class='float_l'><span class='line'></span><span class='round'></span><span class='line'></span></div><div class='sz'></div><div class='text text2'><i class='icon-arrows yb-move' style='display: none;'></i><i class='icon-trash-o yb-delete'></i><i class='icon-control_point yb-add yb-addF'></i><i class='icon-control_point yb-add yb-addT' style='display: none;'></i><div class='contenteditable' contenteditable='false'>[1月1日] 事件内容［来源网站］转载量：0</div></div></li>";
*/

var trendF="<li><div class='float_l'><span class='line'></span><span class='round'></span><span class='line'></span></div><div class='sz'></div><div class='text text2'><i class='icon-arrows yb-move' style='display: none;'></i><i class='icon-trash-o yb-delete'></i><i class='icon-control_point yb-add yb-addF'></i><i class='icon-control_point yb-add yb-addT' style='display: none;'></i><div class='contenteditable' contenteditable='false'>[1月1日] 事件内容［来源网站］转载量：0</div></div></li>";

//var trendT="<li><div class='float_l'><span class='line'></span><span class='round'></span><span class='line'></span></div><div class='sz'></div><div class='text text2'><i class='icon-arrows yb-move'></i><i class='icon-trash-o yb-delete'></i><i class='icon-control_point yb-add yb-addF' style='display: none;'></i><i class='icon-control_point yb-add yb-addT'></i><div class='contenteditable' contenteditable='true'>[1月1日] 事件内容［来源网站］转载量：0</div></div></li>";

var trendT="<li><div class='float_l'><span class='line'></span><span class='round'></span><span class='line'></span></div><div class='sz'></div><div class='text text2'><i class='icon-arrows yb-move'></i><i class='icon-trash-o yb-delete' onclick='del(this);'></i><i class='icon-control_point yb-add yb-addF' onclick='add();'></i><i class='icon-control_point yb-add yb-addT' onclick='add();'></i><div class='contenteditable' contenteditable='true'>[1月1日] 事件内容［来源网站］影响力：0</div></div></li>";

var hotTableF="<tr><td style='text-align: left;'><div contenteditable='false' class='contenteditable'>标题<p class='phone_show time'></p></div></td><td><div contenteditable='false' class='contenteditable'>来源站点</div></td><td class='phone_hide'><div contenteditable='false' class='contenteditable'>时间</div></td><td><div contenteditable='false' class='contenteditable'>转发数</div></td><td><i class='icon-control_point td-add td-addF'></i><i class='icon-control_point td-add td-addT' style='display: none;'></i><i class='icon-trash-o td-delete'></i></td></tr>";

var hotTableT="<tr><td style='text-align: left;'><div contenteditable='true' class='contenteditable'>标题<p class='phone_show time'></p></div></td><td><div contenteditable='true' class='contenteditable'>来源站点</div></td><td class='phone_hide'><div contenteditable='true' class='contenteditable'>时间</div></td><td><div contenteditable='true' class='contenteditable'>转发数</div></td><td><i class='icon-arrows td-move'></i> <i class='icon-control_point td-add td-addF' style='display: none;'></i><i class='icon-control_point td-add td-addT'></i><i class='icon-trash-o td-delete'></i></td></tr>";


//栏目排序效果
$(function() {
    $( ".reportBox" ).sortable({
        connectWith: ".reportBox",
        handle: ".moveBtn",
        placeholder: "portlet-placeholder ui-corner-all"
    });
    $('.reportBox').bind('sortstop', function(event, ui) {
        var $this=ui.item;
        /*var thisId=$this.attr("id");
        var upId=$this.prev().attr("id");*/
        var thisName=$this.attr("name");
        var upName=$this.prev().attr("name");
        var nextName=$this.next().attr("name");
        var curLi=$("#nav2").find("#"+thisName);
        if(upName&&upName!="undefined"){
            var preLi=$("#nav2").find("#"+upName);
            curLi.insertAfter(preLi);
        }else if(nextName&&nextName!="undefined"){
            var nextLi=$("#nav2").find("#"+nextName);
            curLi.insertBefore(nextLi);
        }else{
            $('.reportBox').sortable( 'cancel' );
        }
    });
});

//全局排序效果
$(function() {
    $( ".column" ).sortable({
        connectWith: ".column",
        handle: "#moveBtn",
        placeholder: "portlet-placeholder ui-corner-all"
    });
});

//事件走势排序效果
/*$(function() {
    $( "#trend" ).sortable({
        connectWith: "#trend",
        handle: ".round",
        placeholder: "portlet-placeholder ui-corner-all"
    });
});*/

//热门信息排序效果
$(function() {
    $( "tbody" ).sortable({
        connectWith: "tbody",
        handle: ".td-move",
        placeholder: "portlet-placeholder ui-corner-all"
    });
});

$(function() {
    //移除整个栏目
    $(" .btn-group a.removeBtn").on("click",function() {
        var columnId=$(this).parents(".row-fluid").find(".textShow .tit").attr("id");
        if(columnId.length>3){
            columnId=columnId.substr(columnId.length - 3);
        }else{
            columnId=columnId.substr(columnId.length - 2);
        }
        $("#"+columnId).hide();
        $(this).parents(".row-fluid").remove();
    });

    //插入文本
    $(".row-fluid .textShow .tool .btn-group .dropdown-menu").on("click",".addText",function(){
        var $li = $(textT);
        $li.find("#deleteBtn").on("click",function() {
            $(this).parents(".text").remove();
        });

        $li.find("#okBtn").on("click",function() {
            $(this).parents(".control").siblings("[contenteditable=true]").attr("contenteditable","false");
            $(this).parents(".control").find("#editorBtn").css("display","block");
            $(this).parents(".control").find("#okBtn").css("display","none");
        });

        $li.find("#editorBtn").on("click",function() {
            $(this).parents(".control").siblings("[contenteditable=false]").attr("contenteditable","true");
            $(this).parents(".control").find("#editorBtn").css("display","none");
            $(this).parents(".control").find("#okBtn").css("display","block");
        });

        $(this).parents(".row-fluid .textShow").find(".column").prepend($li);

    });

    //编辑文本
    $(".row-fluid .textShow .text").on("click","#editorBtn",function() {
        $(this).parents(".control").siblings("[contenteditable=false]").attr("contenteditable","true");
        $(this).parents(".control").find("#editorBtn").css("display","none");
        $(this).parents(".control").find("#okBtn").css("display","block");
    });

    //确定文本
    $(".row-fluid .textShow .text").on("click","#okBtn",function() {
        $(this).parents(".control").siblings("[contenteditable=true]").attr("contenteditable","false");
        $(this).parents(".control").find("#editorBtn").css("display","block");
        $(this).parents(".control").find("#okBtn").css("display","none");
    });

    //删除文本
    $(".row-fluid .textShow .text .control").on("click","#deleteBtn",function() {
        $(this).parents(".text").remove();
    });

    //删除表格行
    $("table").on("click",".td-delete",function() {
        $(this).parents("tr").remove();
    });





    //添加可编辑表格行
    $(" #hotTable").on("click",".td-add",function() {
        var $li = $(hotTableT);
        $li.find("table").on("click",".td-delete",function() {
            $(this).parents("tr").remove();
        });
        $(hotTableT).clone(true).prependTo("#hotTable");
    });

    //热点网民选择样式
    $(".yqtabs .tool .btn-group").on("click",".listMo",function() {
        $(this).parents(".yqtabs").addClass("circularMWBList");
        $(this).css("display","none");
        $(this).siblings(".cirMo").css("display","block");
    });

    $(".yqtabs .tool .btn-group").on("click",".cirMo",function() {
        $(this).parents(".yqtabs").removeClass("circularMWBList");
        $(this).css("display","none");
        $(this).siblings(".listMo").css("display","block");
    });

//插入统计图表
    $(".row-fluid .textShow .tool .btn-group .dropdown-menu").on("click",".addChart",function(){
        var $this = $(this);
        var $rowMapbox = $this.parents(".row-fluid").find(".textShow .column");
        $(this).parents(".row-fluid .textShow .tool .btn-group .dropdown-menu").find(".addChart").siblings(".chartMapBK").clone(true).prependTo($rowMapbox);
    });


    //统计图样式选中效果
    $(".chartChoice >ul>li").on("click",function(){
        var $this = $(this);
        var $rowMapimg = $this.find("p img").attr("src");
        $this.siblings("li").removeClass("clicked");
        $(this).addClass("clicked");
        $(this).parents(".row-fluid .textShow .column .chartMapBK").find(".picBox img").attr("src",$rowMapimg);
    });

    //确定统计图表
    /*$(".row-fluid .textShow .chartMapBK  .control").on("click","#okBtn",function(){
        $(this).parents(".row-fluid .textShow .chartMapBK .chartMap").find(".chartChoice").css("display","none");
        $(this).parents(".row-fluid .textShow .chartMapBK .chartMap").find(".picBox").css("display","block");
        $(this).parents(".row-fluid .textShow .chartMapBK .chartMap").find(".control #editorBtn").css("display","block");
        $(this).parents(".row-fluid .textShow .chartMapBK .chartMap").find(".control #okBtn").css("display","none");
    });*/

    //确定统计图表
    $(".row-fluid .chartMapBK  .control").on("click","#okBtn",function(){
        $(this).parents(".row-fluid .chartMapBK").find(".chartChoice").css("display","none");
        $(this).parents(".row-fluid .chartMapBK").find(".picBox").css("display","block");
        $(this).parents(".row-fluid .chartMapBK").find(".control #editorBtn").css("display","block");
        $(this).parents(".row-fluid .chartMapBK").find(".control #okBtn").css("display","none");
        $(this).parents(".row-fluid  .chartMapBK ").find(".parameterBox").css("display","block");
    });

    //编辑统计图表
  /*  $(".row-fluid .textShow .chartMapBK .control").on("click","#editorBtn",function(){
        $(this).parents(".row-fluid .textShow .chartMapBK .chartMap").find(".chartChoice").css("display","block");
        $(this).parents(".row-fluid .textShow .chartMapBK .chartMap").find(".picBox").css("display","none");

        $(this).parents(".row-fluid .textShow .chartMapBK .chartMap").find(".control #editorBtn").css("display","none");
        $(this).parents(".row-fluid .textShow .chartMapBK .chartMap").find(".control #okBtn").css("display","block");
    });*/

    //编辑统计图表
    $(".row-fluid .chartMapBK .control").on("click","#editorBtn",function(){
        $(this).parents(".row-fluid  .chartMapBK ").find(".chartChoice").css("display","block");
        $(this).parents(".row-fluid  .chartMapBK ").find(".picBox").css("display","none");
        $(this).parents(".row-fluid  .chartMapBK ").find(".parameterBox").css("display","none");
        $(this).parents(".row-fluid  .chartMapBK ").find(".control #editorBtn").css("display","none");
        $(this).parents(".row-fluid  .chartMapBK ").find(".control #okBtn").css("display","block");

    });

//删除统计图表
    /*$(" .row-fluid .textShow .chartMapBK .control").on("click","#deleteBtn",function() {
        $(this).parents(".chartMapBK").remove();
    });*/
    $(" .row-fluid .chartMapBK .control").on("click","#deleteBtn",function() {
        $(this).parents(".chartMapBK").remove();
    });


//编辑观点
    var num=0;
    $('.chartMap .control #editorGDBtn').click(function(e){
        if(num++ %2 == 0){
            $(this).parents(".row-fluid .textShow").find(".viewpoint [contenteditable=false]").attr("contenteditable","true");
        }else{
            $(this).parents(".row-fluid .textShow").find(".viewpoint [contenteditable=true]").attr("contenteditable","false");
        }
        e.preventDefault(); //阻止元素的默认动作（如果存在）
    });




    $('#hotTable tr').find('td:last-child').hide();
    $('#hotTable tr').find('th:last-child').hide();
    //切换到编辑状态
    $(" .btn-group a.editBtn").on("click",function() {
        $("[contenteditable=true]").attr("contenteditable","false");
        $(".editBtn").css("display","block");
        $(".saveBtn").css("display","none");

        $(this).parents(".row-fluid .textShow .btn-group").find(".editBtn").css("display","none");
        $(this).parents(".row-fluid .textShow .btn-group").find(".saveBtn").css("display","block");
        $(".yb-move").css("display","none");
        $(".yb-delete").css("display","none");
        $(".yb-add").css("display","none");
        $(this).parents(".row-fluid .textShow").find(".yb-move").css("display","block");
        $(this).parents(".row-fluid .textShow").find(".yb-delete").css("display","block");
        $(this).parents(".row-fluid .textShow").find(".yb-add").css("display","block");

        $('#hotTable tr').find('td:last-child').hide();
        $('#hotTable tr').find('th:last-child').hide();

        $(this).parents('.row-fluid .textShow').find('#hotTable tr td:last-child').show();
        $(this).parents('.row-fluid .textShow').find('#hotTable tr th:last-child').show();

        $(this).parents(".row-fluid .textShow").find("[contenteditable=false]").attr("contenteditable","true");
        $(this).parents(".row-fluid .textShow").siblings(".textShow").find("[contenteditable=false]").attr("contenteditable","true");

    });

    //切换到预览状态
    $(" .btn-group a.saveBtn").on("click",function() {
        $(this).parents(".row-fluid .textShow .btn-group").find(".editBtn").css("display","block");
        $(this).parents(".row-fluid .textShow .btn-group").find(".saveBtn").css("display","none");
        $(this).parents(".row-fluid .textShow").find(".yb-move").css("display","none");
        $(this).parents(".row-fluid .textShow").find(".yb-delete").css("display","none");
        $(this).parents(".row-fluid .textShow").find(".yb-add").css("display","none");

        $(this).parents('.row-fluid .textShow').find('#hotTable tr td:last-child').hide();
        $(this).parents('.row-fluid .textShow').find('#hotTable tr th:last-child').hide();

        $(this).parents(".row-fluid .textShow").find("[contenteditable=true]").attr("contenteditable","false");
        $(this).parents(".row-fluid .textShow").siblings(".textShow").find("[contenteditable=true]").attr("contenteditable","false");
    });
});

function add(){
    //插入单条事件走势
    var $li = $(trendT);
    $li.find("#trend").on("click",".yb-delete",function() {
        $(this).parents("li").remove();
    });
    $(trendT).clone(true).prependTo("#trend");

}

function del(obj){
    //删除单条事件走势
    $(obj).parents("#trend li").remove();

}

function delHot(obj){
    $(obj).parents(".mwblist li").hide();
}



 
