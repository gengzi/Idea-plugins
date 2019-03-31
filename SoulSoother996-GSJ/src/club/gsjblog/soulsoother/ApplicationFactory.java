package club.gsjblog.soulsoother;

import com.intellij.openapi.application.Application;

public class ApplicationFactory {

    static Application application = null;
    public ApplicationFactory(Application app) {
        application = app;
    }
    public static Application getApplication() {
        return application;
    }
}
