package util;

public class BCryptDemo {

    public static void main(String[] args) {

        String password = "testpassword";

        //第一次哈希密码
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println("hashed："+hashed);
        System.out.println(BCrypt.gensalt());

        // gensalt的log_rounds参数确定复杂性
        //工作因子是2 ** log_rounds，默认值是10
        String hashed2 = BCrypt.hashpw(password, BCrypt.gensalt(14));
        System.out.println("hashed2:"+hashed2);
        System.out.println(BCrypt.gensalt(12));

        //检查未加密的密码是否与已加密的密码匹配
        //之前被哈希过
        String candidate = "testpassword";
        if(BCrypt.checkpw(candidate, hashed2)){
            System.out.println("匹配");
        }else {
            System.out.println("它不匹配");
        }
    }

}
