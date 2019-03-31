package club.gsjblog.soulsoother;

import club.gsjblog.soulsoother.wrapper.SoulSoothWrapper;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.ComponentManager;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.util.ActionCallback;
import org.jetbrains.annotations.NotNull;
import  com.intellij.openapi.application.Application;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Future;

public class ShowTimeTask extends TimerTask {
    SoulSoothWrapper soulSoothWrapper;
    static int count = 0;
    public void show(){
        //创建定时器对象
        Timer t=new Timer();
        //在3秒后执行MyTask类中的run方法
        t.schedule(new ShowTimeTask(), 5000,10000);
    }

    /**
     * The action to be performed by this timer task.
     * 触发对话框
     */
    @Override
    public void run() {
//        Application application = ApplicationFactory.getApplication();
        if(count == 0){
//            Application application1 = ApplicationManager.getApplication();
//            boolean active = application1.isActive();
//            application.runWriteAction(new ShowTimeTask());
            ApplicationManager.getApplication().invokeLater(new ShowTimeTask());
            count ++;
        }else{
            soulSoothWrapper = new SoulSoothWrapper(null);
            soulSoothWrapper.show();
            count =0;
            Timer t=new Timer();
            t.schedule(new ShowTimeTask(), 5000);
        }
    }

}
