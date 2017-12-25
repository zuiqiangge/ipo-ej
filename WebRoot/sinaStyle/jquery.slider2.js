/**
 * Created by sky on 2015/6/18.
 */
(function($){
    // our plugin constructor
    var Slider = function(elem,option){
        this.elem = elem,
        this.$elem = $(elem),
        this.$sliderGroup = $(elem).find(".my-slider-group"),
        this.$sliderItem =  $(elem).find(".my-slider-item"),
        this.$sliderLeft = $(".my-slider-left"),
        this.$sliderRight = $(".my-slider-right"),
        this.spike = 3,
        this.sumSpike = 0,
        this.w = 0,
        this.leftId,
        this.rightId;
        $.extend(this,option);
    };
    // the plugin prototype
    Slider.prototype = {
        init:function(){
            var tg = this;
                tg.$sliderGroup.css("width",tg.getWidth()+"px"),
                tg.$sliderLeft.on("mouseover",  $.proxy(tg.handleClickLeft,tg)),
                tg.$sliderRight.on("mouseover", $.proxy(tg.handleClickRight,tg));
                tg.$sliderLeft.on("mouseout", $.proxy(tg.handleOutLeft,tg));
                tg.$sliderRight.on("mouseout", $.proxy(tg.handleOutRight,tg));
                if(tg.$sliderGroup.width()<tg.$elem.width()){
                    tg.$sliderLeft.hide();
                    tg.$sliderRight.hide();
                }
        },
        handleClickLeft:function(){
            var tg = this;
            this.leftId = setInterval(function(){
                tg.sumSpike -= tg.spike;
                if(tg.sumSpike<tg.$elem.width()-tg.$sliderGroup.width()){
                    tg.sumSpike = tg.$elem.width()-tg.$sliderGroup.width();
                }
                if(tg.sumSpike>=0){
                    tg.sumSpike = 0;
                }
                tg.$sliderGroup.css("marginLeft",tg.sumSpike+"px");
            },10);
        },
        handleClickRight:function(){
            var tg = this;
            this.rightId = setInterval(function(){
                tg.sumSpike += tg.spike;
                if(tg.sumSpike>0){
                    tg.sumSpike = 0;
                }
                tg.$sliderGroup.css("marginLeft",tg.sumSpike+"px");
            },10);
        },
        handleOutLeft:function(){
            clearInterval(this.leftId);
        },
        handleOutRight:function(){
            clearInterval(this.rightId);
        },
        getWidth:function(){
            var w= 10;
            this.$sliderItem.each(function(i,item){
                w += (item.offsetWidth+parseInt($(item).css("marginRight"))+parseInt($(item).css("marginLeft")));
            });
            return w;
        }
    }

    $.fn.slider = function(option){
        return this.each(function(){
            new Slider(this,option).init();
        })
    }
}($))