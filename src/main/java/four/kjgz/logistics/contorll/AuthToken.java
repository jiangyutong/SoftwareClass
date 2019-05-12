package four.kjgz.logistics.contorll;


import java.lang.annotation.*;

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthToken {
    /**
     * 访问所需的身份，默认为空，为登录即可访问，可以多个定义
     *
     * @return
     * @data 2018年12月19日
     * @version v1.0.0.0
     */
    String[] role_name() default "未用";
}

//此注解定义一个数组属性，role_name，用于标识访问被此注解修饰的方法需要访问的用户具有什么身份。
