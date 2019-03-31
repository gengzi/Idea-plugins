package club.gsjblog.soulsoother.action;

import club.gsjblog.soulsoother.wrapper.SoulSoothWrapper;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;

/**
 *  @des 心灵鸡汤Action
 *  @date 2019年3月31日09:28:19
 *  @author  gengshuaijia
 */
public class SoulSoothAction extends AnAction {

    /**
     * 当idea启动，触发该插件
     * @param e
     */
    @Override
    public void update(AnActionEvent e) {
        super.update(e);
    }

    /**
     * 动作触发
     * @param e
     */
    @Override
    public void actionPerformed(AnActionEvent e) {

        //定时触发
        //展示内容

        Project project = e.getProject();
        SoulSoothWrapper soulSoothWrapper = new SoulSoothWrapper(project);
        soulSoothWrapper.show();



    }
}
