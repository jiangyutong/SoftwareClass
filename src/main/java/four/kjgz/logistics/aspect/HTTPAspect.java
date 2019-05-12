package four.kjgz.logistics.aspect;


import com.alibaba.fastjson.JSON;
import four.kjgz.logistics.bean.ActionLog;
import four.kjgz.logistics.bean.MyLog;
import four.kjgz.logistics.bean.Mycheck;
import four.kjgz.logistics.bean.loginInfo;
import four.kjgz.logistics.repository.ActionLogReposity;
import javassist.bytecode.SignatureAttribute;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class HTTPAspect {
    private final static Logger logger = LoggerFactory.getLogger(HTTPAspect.class);
    @Autowired
    ActionLogReposity actionLogReposity;

    //权限的管理
    @Autowired
    loginInfo nowloginInfo;
    //匹配所有contorll包下面的子包和包下面的所有方法
    //@Pointcut("within( four.kjgz.logistics.contorll..*)")
    //匹配所有DistributionpointControll下面的方法
   /* @Pointcut("within( four.kjgz.logistics.contorll.DistributionpointControll)")
    public  void adminOnly() { }
    @Before("adminOnly()")
    public void check()
    {
        Mycheck mycheck = new Mycheck();
        nowloginInfo.setResult(mycheck.checkaccess(nowloginInfo.getMyusernum()));
    }*/
    @Pointcut("within( four.kjgz.logistics.contorll..*)")
    public void  log()
    {
        System.out.println("jyt");
    }
    @Before("log()")//不管里面传上面参数都会被拦截
    public void  dobefore(JoinPoint joinPoint)
    {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
        System.out.println("jyt");
    }
    @After("log()")
    public void  logTwo(JoinPoint joinPoint)
    {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        ActionLog actionLog=new ActionLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            actionLog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        actionLog.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);
        actionLog.setParams(params);

        actionLog.setCreateDate(new Date());
        //获取用户名
        actionLog.setUsernum(nowloginInfo.getMyusernum());
        actionLog.setUsername(nowloginInfo.getMyusername());
        //获取用户ip地址
        actionLog.setIp(request.getRequestURI());

        //调用service保存SysLog实体类到数据库
        actionLogReposity.save(actionLog);
        System.out.println("jytafter");
    }

    /**
     * 环绕通知：
     *   环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     *   环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    //four.kjgz.logistics下的所有包和所有的类和任意的参数
  /*  @Around(value = "execution(* four.kjgz.logistics.*.*(..))")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName());
        try {
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }*/

//    private final static Logger logger = LoggerFactory.getLogger(HTTPAspect.class);

//    @Before("execution(public * yutong.jiang.mybatisjpa.contorll.Dept.getDepartment(..))")//不管里面传上面参数都会被拦截
//    public void  log()
//    {
//        logger.info("jyt");
//        System.out.println("jyt");
//    }
//    @After("execution(public * yutong.jiang.mybatisjpa.contorll.Dept.getDepartment(..))")
//    public void  logTwo()
//    {
//        logger.info("jytafter");
//        System.out.println("jytafter");
//    }
}
