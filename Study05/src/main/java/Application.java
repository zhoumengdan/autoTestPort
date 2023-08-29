
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Leslie H C Wang
 * @date 2023/8/23 12:17
 */


@SpringBootApplication
@ComponentScan("com.course")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
