package com.pengyue.ipo.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cosine {  
    
    public static double getSimilarity(String doc1, String doc2) {  
        if (doc1 != null && doc1.trim().length() > 0 && doc2 != null&& doc2.trim().length() > 0) {  
              
            Map<Integer, int[]> AlgorithmMap = new HashMap<Integer, int[]>();  
              
            //将两个字符串中的中文字符以及出现的总数封装到，AlgorithmMap中  
            for (int i = 0; i < doc1.length(); i++) {  
                char d1 = doc1.charAt(i);  
                if(isHanZi(d1)){//标点和数字不处理  
                    int charIndex = getGB2312Id(d1);//保存字符对应的GB2312编码  
                    if(charIndex != -1){  
                        int[] fq = AlgorithmMap.get(charIndex);  
                        if(fq != null && fq.length == 2){  
                            fq[0]++;//已有该字符，加1  
                        }else {  
                            fq = new int[2];  
                            fq[0] = 1;  
                            fq[1] = 0;  
                            AlgorithmMap.put(charIndex, fq);//新增字符入map  
                        }  
                    }  
                }  
            }  
  
            for (int i = 0; i < doc2.length(); i++) {  
                char d2 = doc2.charAt(i);  
                if(isHanZi(d2)){  
                    int charIndex = getGB2312Id(d2);  
                    if(charIndex != -1){  
                        int[] fq = AlgorithmMap.get(charIndex);  
                        if(fq != null && fq.length == 2){  
                            fq[1]++;  
                        }else {  
                            fq = new int[2];  
                            fq[0] = 0;  
                            fq[1] = 1;  
                            AlgorithmMap.put(charIndex, fq);  
                        }  
                    }  
                }  
            }  
              
            Iterator<Integer> iterator = AlgorithmMap.keySet().iterator();  
            double sqdoc1 = 0;  
            double sqdoc2 = 0;  
            double denominator = 0;   
            while(iterator.hasNext()){  
                int[] c = AlgorithmMap.get(iterator.next());  
                denominator += c[0]*c[1];  
                sqdoc1 += c[0]*c[0];  
                sqdoc2 += c[1]*c[1];  
            }  
              
            return denominator / Math.sqrt(sqdoc1*sqdoc2);//余弦计算  
        } else {  
            throw new NullPointerException(" the Document is null or have not cahrs!!");  
        }  
    }  
  
    public static boolean isHanZi(char ch) {  
        // 判断是否汉字  
        return (ch >= 0x4E00 && ch <= 0x9FA5);  
        /*if (ch >= 0x4E00 && ch <= 0x9FA5) {//汉字 
            return true; 
        }else{ 
            String str = "" + ch; 
            boolean isNum = str.matches("[0-9]+");  
            return isNum; 
        }*/  
        /*if(Character.isLetterOrDigit(ch)){ 
            String str = "" + ch; 
            if (str.matches("[0-9a-zA-Z\\u4e00-\\u9fa5]+")){//非乱码 
                return true; 
            }else return false; 
        }else return false;*/  
    }  
  
    /** 
     * 根据输入的Unicode字符，获取它的GB2312编码或者ascii编码， 
     *  
     * @param ch 输入的GB2312中文字符或者ASCII字符(128个) 
     * @return ch在GB2312中的位置，-1表示该字符不认识 
     */  
    public static short getGB2312Id(char ch) {  
        try {  
            byte[] buffer = Character.toString(ch).getBytes("GB2312");  
            if (buffer.length != 2) {  
                // 正常情况下buffer应该是两个字节，否则说明ch不属于GB2312编码，故返回'?'，此时说明不认识该字符  
                return -1;  
            }  
            int b0 = (int) (buffer[0] & 0x0FF) - 161; // 编码从A1开始，因此减去0xA1=161  
            int b1 = (int) (buffer[1] & 0x0FF) - 161;   
            return (short) (b0 * 94 + b1);// 第一个字符和最后一个字符没有汉字，因此每个区只收16*6-2=94个汉字  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return -1;  
    }  
      
    public static void main(String[] args) {  
        String str1="　　参考消息网3月27日报道 浙江吉利控股集团（以下简称“吉利”）旗下的伦敦出租车公司于当地时间3月22日在考文垂安斯蒂举行新工厂落成仪式。英国商务大臣Greg Clark 、中国驻英公使祝勤、吉利控股集团董事长李书福等出席仪式。 　　安斯蒂工厂的落成，是吉利全球化战略和新能源战略进程中的重要里程碑。新工厂融研发和生产于一体，总占地达100000平方米。其中生产基地位于伦敦出租车现有工厂附近，规划年产达30000辆。而这里的吉利英国前沿研发中心，将汇集全球各地的顶尖工程师，专注打造全新轻量化电动商用车。 　　伦敦出租车安斯蒂工厂从签约、奠基到竣工历时两年。新工厂的建成给当地创造了千余个工作岗位，同时还将通过提高英国和欧盟的零部件供应商比例，为英国带来超过500个其它工作机会。 　　作为十多年来英国新建的首家现代化汽车生产基地，也是英国首个专注电动汽车的工厂，安斯蒂工厂充分发挥吉利控股集团的内部协同效应，采用沃尔沃汽车成熟的电动化动力总成系统，打造全新的轻量化电动车平台。工厂未来将主要研发、生产零排放和超低排放的伦敦出租车，以及一系列零排放的轻量化电动商用车，首批下线的将是全新一代伦敦出租车TX5，专注引领现代城市的绿色出行。 　　安斯蒂工厂不仅研发、生产符合现代城市环保需求的产品，在工厂的建设和生产标准上，也完全以绿色生态为准则。工厂建设了850m?太阳能电池板，为厂区20个电动车充电桩提供动力，符合最高环保标准。同时，工厂获评BREEAM（英国建筑研究院环境评估方法）“杰出建筑”，并在能源绩效方面得到A级评分。 　　浙江吉利控股集团董事长李书福表示：“我们信守对伦敦出租车公司和对英国政府的承诺，不断加大技术研发和生产设施的投入。而伦敦出租车业务的持续发展也证明中英两国拥有巨大的互利共赢的合作空间。吉利控股集团希望在未来能够持续整合全球资源，发挥英国在新能源汽车领域的研发和人才优势，为全球未来的城市交通提供更多样化的解决方案，为中英经贸和技术合作做出应有贡献。” 　　伦敦出租车公司董事长Carl-Peter Foster表示：“安斯蒂工厂的建立将为伦敦出租车公司开启全新未来。新一代伦敦出租车和轻量化新能源商用车的陆续推出，将提升我们在全球高端产业价值链的地位。新工厂的研发中心汇集全球顶尖研发力量，将持续推动新能源汽车在全球的发展。” 　　吉利于2013年2月全资收购伦敦出租车公司，截止目前已投资3亿英镑用于建设安斯蒂新工厂和吉利英国前沿研发中心，未来投资数额已追加至3.25亿英镑。该项目不仅是中国汽车企业在英国的第一笔绿地投资，也是十多年来首个在英国建设的新车生产基地。新工厂于2015年8月破土动工，首批下线的下一代伦敦出租车TX5预计将于2017年年底在英国上市，并将在2018年登陆国际市场。";  
        String str2="　　石油输出国组织(欧佩克)和非欧佩克产油国26日在科威特举行会议，评估原油减产进程，表示将根据原油减产的全球效果决定减产协议是否应延长六个月。 　　欧佩克和非欧佩克产油国联合委员会当天发布声明，对各产油国积极遵守减产协议取得的成果表示满意，并鼓励各国继续努力直至完全实现减产目标。 　　俄罗斯能源部长诺瓦克表示，截至今年2月底，各产油国对减产承诺的履行程度已达94％，尽管完全实现减产目标前景乐观，但现在就决定是否延长原油减产协议仍为时过早。 　　科威特石油大臣埃萨姆·马尔祖克预计，若减产协议完全实现，原油市场有望在今年第三季度恢复平衡。 　　2016年底，欧佩克和俄罗斯等11个非欧佩克产油国达成原油减产协议。按照协议，从2017年1月起的六个月内，欧佩克日均减产120万桶原油，11个非欧佩克产油国日均减产55.8万桶原油。(新华)";  
        long start=System.currentTimeMillis();
        double Similarity=Cosine.getSimilarity(str1, str2);
        System.out.println("用时:"+(System.currentTimeMillis()-start));
        System.out.println(Similarity);
    }
    
} 
