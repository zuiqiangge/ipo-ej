package com.pengyue.ipo.action;

import java.util.ArrayList;
import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.suggest.Suggester;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// // TODO Auto-generated method stub
		// String month = "2017-11-05".substring(5, 7);
		// String day = "2017-01-05".substring(8, 10);
		// if (month.startsWith("0")) {
		// month = month.substring(1, 2) + "月";
		// } else {
		// month = month + "月";
		// }
		//		
		// if (day.startsWith("0")) {
		// day = day.substring(1, 2) + "日";
		// } else {
		// day = day + "日";
		// }
		// System.out.println(month+day);
		String document = "　　3月24日，众议院对美国新医保案的投票在30个小时内被两度推迟后，媒体确认美国总统特朗普已表态撤回医保议案，原定当天下午开始的投票被取消，这意味着特朗普新医保案将在一段时间内被束之高阁。 　　今年是“奥巴马医改”方案签署七周年。特朗普上任后接连签署了各类总统行政令和备忘录，其签署的第一条总统行政令就是要抛弃美国前总统奥巴马努力多年促成的“奥巴马医改”方案。此前特朗普多次表明，废除“奥巴马医改”方案并以新方案取而代之，是他所领导的政府的首要工作。不过，24日的结果显示，他的尝试在上任两个多月后就以失败告终。 　　据报道，众议院议长保罗·瑞恩24日表示，由于没有争取到足够的支持票，他向特朗普总统提议撤回议案，总统表示了同意。过去几天，瑞恩和特朗普一直在竭力争取共和党内部的支持。众议院原计划在3月23日就此进行表决，但因票数不够被推迟至24日。白宫行政机构管理与预算局局长米克·马尔瓦尼在与党内保守派“自由党团”会晤期间，代表总统特朗普发出最后通牒：若新医保案没有获得投票通过，白宫的重心将转移到其他优先工作事项上，如税改政策。 　　总统的强硬表态，促使共和党众议员们加班赶制出对20日提交的最后一版新医保案的修正案。新版本的改动包括：废除“奥巴马医改”方案的“核心健康福利”条款，规定各州政府从2018年1月1日起，可以自行定义适当的“核心健康福利”加到新医保设计中；保留对个人年薪超过20万美元、家庭年薪超过25万美元的富裕人群加征0.9%的联邦养老保险税的条款直到2023年，此前一版修正案要求仅保留到2017年底，并从2018年起再免除上述富裕人群缴纳3.8%的投资所得税；此外，在以1000亿美元联邦补贴州政府帮助低收入人群取得医保的基础上，再增加150亿美元用于生育、新生儿、精神健康和药物滥用的治疗基金。 　　分析认为，修正案的目的很明显，希望能够迎合共和党保守派对废除“奥巴马医改”方案中“核心健康福利”的要求，缓解联邦对州政府补贴及对富人减税可能造成的财政赤字扩大，同时变相支持“核心健康福利”中的部分医保项目，以期弥合与共和党中间派的矛盾。但在最后关头，共和党领导层仍然无法争取到足够的支持票。 　　24日，特朗普发出推文，批评党内主要反对派“自由党团”组织反对新医保案的立场。美国副总统迈克·彭斯取消出行计划，为新医保案投票而留在华盛顿。众议院议长瑞恩非正式会见了“自由党团”主席Mark　Meadows。但众议院拨款委员会主席福瑞林汉森表示反对新医保案，使得瑞恩在党内推动新医保案的努力遭到重大挫折。 　　NBC新闻报道称，在离预定的投票时间前一个半小时，仍有34名共和党议员反对新医保案，而为了赢得215票，共和党只能允许22人投反对票。有报道称，下午3点31分，《华盛顿邮报》记者科斯塔接到电话，特朗普简明扼要地表示：“我们决定撤回新医保案。这全怪众议院民主党一票都不肯给我们，而共和党只差几票就能通过了，真的，只差几票，我们只好选择撤回议案。”《纽约时报》记者Maggie　Haberman称，其接到特朗普电话，称短期内不会再讨论新医保案，将在今年稍晚再重新提议讨论。 　　面对新医保案投票的风云变幻，美股市场也呈现跌宕起伏的走势。早盘时高开高走，午盘后掉头下跌，并在投票取消的消息前纷纷触及日内低位，随后又在投票取消的消息确定后跌幅收窄，纳指继而收高。 　　事实上，围绕新医保案，不仅民主党人全力反对，共和党内部也严重分裂。23日公布的一项民调结果显示，支持新医保案的选民仅占17%。分析认为，共和党前参议院领袖John　Boehner最近一语道破天机，称共和党对医改从来没有共识，根本无法推翻“奥巴马医改”方案。也有分析认为，之所以特朗普新医保案难以获得支持　，一些原来的支持者倒戈，是因为“奥巴马医改”开始实施后，一些支持者认为很难面对有民众失去医保的现实，因而出现退缩。 　　新医保案替代“奥巴马医改”方案的这一挫折，被一些美国媒体称为“惊人失败”。据媒体报道，特朗普表示，我们无须着急，“奥巴马医改”方案会在不久后“爆炸”。当“奥巴马医改”无以为继的时候，我们最终会得到真正伟大的医保法案。特朗普称，现在要进行税务改革，这是他一直喜欢的领域。特朗普还说，最后我们就差了10票，差距也许更少。";
		int len1=0;
		if(document.split(",")!=null){
			len1=document.split(",").length;
		}
		int len2=0;
		if(document.split("，")!=null){
			len1=document.split("，").length;
		}
		int len=10;
		if(len2>len1){
			len=len2;
		}else if(len2<len1){
			len=len1;	
		}
		 
		List<String> sentenceList = HanLP.extractSummary(document, len);
		System.out.println(sentenceList);
		System.out.println(sentenceList.get(0) + "    " + sentenceList.size()
				+ "       " + document.split("，").length+"         document=="+document.length());
		 List<Integer> sorderHanp=new ArrayList<Integer>();
		 for(int i=0;i<sentenceList.size();i++){
			 sorderHanp.add(document.indexOf(sentenceList.get(i)));
//			 if(document.indexOf(sentenceList.get(i))==-1){
//				 System.out.println("xxxxxxxxxxxxxxxxxxx");
//			 }
		 }
		 List<String> res = new ArrayList<String>();
		  
		 for(int i=0;i<sorderHanp.size()-1;i++){
			 int minsorder=sorderHanp.get(i);
			 for(int j=i+1;j<sorderHanp.size();j++){
				 if(sorderHanp.get(j)<=minsorder){
					 int tran=sorderHanp.get(i);
					 sorderHanp.set(i, sorderHanp.get(j));
					 sorderHanp.set(j, tran);
					 minsorder=sorderHanp.get(i);
					 
					 String transec=sentenceList.get(i);
					 sentenceList.set(i, sentenceList.get(j));
					 sentenceList.set(j, transec);
				 }
			 }
		 }
		 
		 System.out.println(sentenceList);
		String text = "路透3月27日 - 周一公布的日本央行3月15-16日会议意见摘要显示，政策委员会委员称宽松货币政策将维持一段时间，因消费者物价涨幅距离2%的央行目标水平依然较远。 有人认为，由于海外债券收益率上升，日本央行将不得不提高10年期公债收益率目标。对此审议委员们未予理会，而表示只侧重于关注国内经济。 但是，一些委员确实表达了对日本央行未来控制10年期公债收益率的能力的关切。 “一些市场人士称，央行需要改变货币政策，以因应海外长期收益率上升，”一位委员说。 “但是，日本货币政策应基于日本的经济活动和物价来进行决定。还要过相当长时间，日本央行才需要改变货币政策。” 日本央行在3月会议上维持政策不变，市场猜测该央行可能将于今年稍后提高公债收益率目标，但日本央行总裁黑田东彦对这种市场臆测不屑一顾。 日本央行维持对金融机构存放在央行的部分超额准备金利率在负0.1%不变，承诺引导10年期公债收益率>在零附近。 该央行还维持每年购买80万亿日圆(7,239.8亿美元)公债的宽泛承诺不变。 得益于出口和工业生产增强，经济在近期显示复苏迹象，但对内需活力的担忧挥之不去，因1月核心消费者物价较上年同期仅上升0.1%。 会议意见摘要显示，一位委员对物价趋势持有疑虑，因始于4月的下个财年的薪资增幅可能不及当前财年。 另一位委员称，日本央行上月大幅增加购债以抑制收益率上升，这透露了日本央行控制收益率曲线形态政策的弱点。 该委员称，这表明日本央行今后可能会被迫购买大量公债，以实现其收益率目标。(完) (编译 张若琪/杜明霞/侯雪苹；审校 龚芳/陈宗琦/汪红英)";
		List<String> phraseList = HanLP.extractPhrase(text, 10);
		System.out.println(phraseList);

		String content = "中国工厂当";
		List<String> keywordList = HanLP.extractKeyword(content, 1000);
		System.out.println(keywordList);

		// Suggester suggester = new Suggester();
		// String[] titleArray =
		// (
		// "威廉王子发表演说 呼吁保护野生动物\n" +
		// "《时代》年度人物最终入围名单出炉 普京马云入选\n" +
		// "“黑格比”横扫菲：菲吸取“海燕”经验及早疏散\n" +
		// "日本保密法将正式生效 日媒指其损害国民知情权\n" +
		// "英报告说空气污染带来“公共健康危机”"
		// ).split("\\n");
		// for (String title : titleArray)
		// {
		// suggester.addSentence(title);
		// }
		//
		// System.out.println(suggester.suggest("pujing", 1)); // 语义
		// System.out.println(suggester.suggest("危机公共", 1)); // 字符
		// System.out.println(suggester.suggest("mayun", 1)); // 拼音
	}

}
