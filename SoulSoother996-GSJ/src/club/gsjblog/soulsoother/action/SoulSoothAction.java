package club.gsjblog.soulsoother.action;

import club.gsjblog.soulsoother.utils.PropertiesUtils;
import club.gsjblog.soulsoother.wrapper.SoulSoothWrapper;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.ComponentPopupBuilder;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

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

        JBPopupFactory instance = JBPopupFactory.getInstance();
        ComponentPopupBuilder componentPopupBuilder = instance.createComponentPopupBuilder(createCenterPanel(),null);
        componentPopupBuilder.setTitle("标题");


    }


    protected JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new BorderLayout());
        String path = this.getClass().getClassLoader().getResource("/").getPath();

        Random random = new Random();
        int size = 1;
        try {
            size = PropertiesUtils.getTotalLines(path + "base.properties");

        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = random.nextInt(size);
        String des = PropertiesUtils.getPropertieByKey(path+"base.properties", "jitang"+i);

        JLabel label = new JLabel(des);
        label.setPreferredSize(new Dimension(300, 50));
        dialogPanel.add(label, BorderLayout.CENTER);
        return dialogPanel;

    }
}
