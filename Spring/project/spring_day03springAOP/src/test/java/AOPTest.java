import com.jiadong.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        // 1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
        // 2. 获取对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        // 3. 执行方法
        as.saveAccount();
    }

}
