package club.gsjblog.soulsoother;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.ServiceManager;
import org.jetbrains.annotations.NotNull;

public class SoulSootherApplicationService implements ApplicationComponent {
    public SoulSootherApplicationService() {
    }

    @Override
    public void initComponent() {
        // TODO: insert component initialization logic here
        applictionOpened();
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "SoulSootherApplicationService";
    }


    public void applictionOpened() {
        // called when project is opened
//        ApplicationManager.getApplication().runWriteAction(new ShowTimeTask());
//        Application application = ApplicationManager.getApplication();
//        ApplicationFactory applicationFactory = new ApplicationFactory(application);
//        ShowTimeTask service = ServiceManager.getService(ShowTimeTask.class);
//        service.show();

    }

}
