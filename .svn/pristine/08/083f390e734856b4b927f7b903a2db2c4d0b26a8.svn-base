package com.pengyue.ipo.util;
import sun.misc.BASE64Decoder;  
import sun.misc.BASE64Encoder;  
//有时候也使用apache组织的base64类：org.apache.commons.codec.binary.Base64;   
import javax.crypto.Cipher;  
import javax.crypto.KeyGenerator;  
import java.security.Key;  
import java.security.SecureRandom;  
/**  
 *   
 * DES对称加密算法  
 *   
 * @author wzj  
 *   
 * @see 使用3DES加密与解密,可对byte[],String类型进行加密与解密 密文可使用String,byte[]存储.  
 *   
 * @see 对称加密算法就是能将数据加解密。加密的时候使用密钥对数据进行加密，解密的时候使用同样的密钥对数据进行解密  
 * @see DES是美国国家标准研究所提出的算法。由于加解密的数据安全性和密钥长度成正比，故DES的56位密钥已经形成安全隐患  
 * @see 后来针对DES算法进行了改进，有了三重DES算法（也称DESede或Triple-DES）。全名是TDEA：Triple Data  
 *      Encryption Algorithm  
 * @see DESede针对DES算法的密钥长度较短以及迭代次数偏少问题做了相应改进，提高了安全强度  
 * @see 不过DESede算法处理速度较慢，密钥计算时间较长，加密效率不高  
 */  
  
public class ThreeDes {  
    private Key key; // 密钥  
    public static String generateKeyStr="abcdefghigklmnopqrstuvwxyz123456";  
    private String encryptAlgorithm="DES";  
  
    /**  
     * 根据参数生成KEY  
     *   
     * @param strKey  
     *            密钥字符串  
     */  
    public void getKey(String strKey) {  
        try {  
            KeyGenerator _generator = KeyGenerator.getInstance(encryptAlgorithm);  
            _generator.init(new SecureRandom(strKey.getBytes()));  
            this.key = _generator.generateKey();  
            _generator = null;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    /**  
     * 加密String明文输入,String密文输出  
     *   
     * @param strMing  
     *            String明文  
     * @return String密文  
     */  
    public String getEncString(String strMing) {  
        byte[] byteMi = null;  
        byte[] byteMing = null;  
        String strMi = "";  
        BASE64Encoder base64en = new BASE64Encoder();  
        try {  
            byteMing = strMing.getBytes("UTF8");  
            byteMi = this.getEncCode(byteMing);  
            strMi = base64en.encode(byteMi);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            base64en = null;  
            byteMing = null;  
            byteMi = null;  
        }  
        return strMi;  
    }  
  
    /**  
     * 解密 以String密文输入,String明文输出  
     *   
     * @param strMi  
     *            String密文  
     * @return String明文  
     */  
    public String getDesString(String strMi) {  
        BASE64Decoder base64De = new BASE64Decoder();  
        byte[] byteMing = null;  
        byte[] byteMi = null;  
        String strMing = "";  
        try {  
            byteMi = base64De.decodeBuffer(strMi);  
            byteMing = this.getDesCode(byteMi);  
            strMing = new String(byteMing, "UTF8");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            base64De = null;  
            byteMing = null;  
            byteMi = null;  
        }  
        return strMing;  
    }  
  
    /**  
     *  为getEncString方法提供服务  
     *    
     * 加密以byte[]明文输入,byte[]密文输出  
     *   
     * @param byteS  
     *            byte[]明文  
     * @return byte[]密文  
     */  
    private byte[] getEncCode(byte[] byteS) {  
        byte[] byteFina = null;  
        Cipher cipher;  
        try {  
            cipher = Cipher.getInstance(encryptAlgorithm);  
            cipher.init(Cipher.ENCRYPT_MODE, key);  
            byteFina = cipher.doFinal(byteS);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            cipher = null;  
        }  
        return byteFina;  
    }  
  
    /**  
     * 为getDesString方法提供服务  
     *   
     * 解密以byte[]密文输入,以byte[]明文输出  
     *   
     * @param byteD  
     *            byte[]密文  
     * @return byte[]明文  
     */  
    private byte[] getDesCode(byte[] byteD) {  
        Cipher cipher;  
        byte[] byteFina = null;  
        try {  
            cipher = Cipher.getInstance(encryptAlgorithm);  
            cipher.init(Cipher.DECRYPT_MODE, key);  
            byteFina = cipher.doFinal(byteD);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            cipher = null;  
        }  
        return byteFina;  
    }  
  
    public static void main(String[] args) {  
        String encryStr="123456";  
        ThreeDes des = new ThreeDes(); // 实例化一个对像  
        des.getKey(generateKeyStr);  
        String strEnc = des.getEncString(encryStr);// 加密字符串,返回String的密文  
        System.out.println(strEnc);  
        String strDes = des.getDesString("TOWStKcivDnyT/Ea9vPQjg==");// 把String 类型的密文解密  
        System.out.println(strDes);
                  System.out.println("\"");
    }  
}  