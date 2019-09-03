package util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5ToolsTest {

    public static String md5Hex(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(str.getBytes());
            return new String(new Hex().encode(digest));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return "";
        }
    }

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

    /**
     * 得到字符串的MD5倄17
     *
     * @param str 字符丄17
     * @return 加密后的字符丄17
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5Str(String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] in = str.getBytes();
        byte[] out = md5.digest(in);

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < out.length; i++) {
            String tempHexString = Integer.toHexString(0xFF & out[i]);
            if (tempHexString.length() == 1) {
                hexString.append("0");
            }
            hexString.append(tempHexString);

        }
        return hexString.toString();

    }

    // 测试主函数
    public static void main(String args[]) throws NoSuchAlgorithmException {
        System.out.println(getMD5Str("888888mlgb"));
        //d1ae5d00c4122289fb861d51e4fbd0ee
    }

}
