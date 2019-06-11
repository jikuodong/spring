package net.jikuodong.spring.communication.handler;

import net.jikuodong.spring.utils.SSM_Constents;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ServiceHandler.java
 * @createTime 2019年06月11日 13:27:00
 */
public class ServiceHandler {

    public static ServiceHandler getInstance()
    {
        return ServiceHandlerHolder.INSTANCE;
    }

    public static final class ServiceHandlerHolder
    {
        private static final ServiceHandler INSTANCE = new ServiceHandler();
    }

    protected ServiceHandler()
    {
        //初始化系统参数
        init();
    }

    private void init()
    {
        new Thread()
        {
            public void run()
            {
                try
                {
                    SSM_Constents.initProperties();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

}
