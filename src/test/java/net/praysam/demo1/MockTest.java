package net.praysam.demo1;

import net.praysam.demo1.pojo.User;
import net.praysam.demo1.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class MockTest {
    @Autowired private MockMvc mockMvc;

    @Test
    public void simpleVerifyTest(){
        //模拟jdk类的对象
//        List mocklist = Mockito.mock(List .class);//模拟出来一个List对象
//        mocklist.add("123");//对模拟对象，执行其add("123")的方法
//        Mockito.verify(mocklist).add("123");//验证是否模拟对象是否调用过add("123");
        //模拟自定义类的对象
        UserService mockUserService = Mockito.mock(UserService.class);//模拟处一个自定义的UserService对象
        mockUserService.getUser(1);//被调用第一次
        mockUserService.getUser(2);//被调用第二次
        Mockito.verify(mockUserService,Mockito.times(2)).getUser(Mockito.anyInt());
    }
    @Test
    public void when_thenReturnTest(){
        UserService mockUserService = Mockito.mock(UserService.class);
        Mockito.when(mockUserService.getUser(Mockito.anyInt())).
                thenReturn(new User("peter","m","18")).//第一次调用返回值
                thenReturn(new User("sarah","f","17"));//第n次调用但绘制
        System.out.println("第一次调用模拟对象返回值="+mockUserService.getUser(1));
        System.out.println("第二次调用模拟对象返回值="+mockUserService.getUser(2));
        System.out.println("第三次调用模拟对象返回值="+mockUserService.getUser(3));


    }

    @Test
    public void hashTest(){
        SimpleHash md5 =
                new SimpleHash("md5","peter"+"123","xyz");
        System.out.println(md5);
    }
}
