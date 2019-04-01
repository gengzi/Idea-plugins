package club.gsjblog.soulsoother.wrapper;

import club.gsjblog.soulsoother.utils.PropertiesUtils;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;


/**
 * @des  弹出窗口
 * @date 2019年3月31日09:37:54
 */
public class SoulSoothWrapper  extends DialogWrapper {

    public SoulSoothWrapper(@Nullable Project project) {
        super(true); // use current window as parent
        // 初始化
        init();
        // 设置对话框的标题
        setTitle("毒鸡汤996");
    }


    /**
     * 返回包含对话框主要内容
     * @return
     */
    @Nullable
    @Override
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
        label.setPreferredSize(new Dimension(600, 350));
        dialogPanel.add(label, BorderLayout.CENTER);
        return dialogPanel;
    }
}
// JLabel 换行 https://blog.csdn.net/lianchao668/article/details/7937541