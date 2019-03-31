package club.gsjblog.codedes;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.JBColor;
import org.apache.http.util.TextUtils;

import java.awt.*;
import java.io.*;
import java.util.Properties;


/**
 *  描述：codedes 的动作，AnAction 代表一个动作
 *  时间：2019年3月16日21:18:55
 *
 */
public class CodeDes extends AnAction {
    /**
     * 此方法应包含在调用操作时要执行的代码, 比如ctrl+p
     * @param e
     */
    @Override
    public void actionPerformed(AnActionEvent e) {
        // 获取当前选中的单词
        // 获取编辑器
        final Editor mEditor = e.getData(PlatformDataKeys.EDITOR);
        if (null == mEditor) {
            return;
        }
        // 获取选中的Model
        SelectionModel model = mEditor.getSelectionModel();
        // 获取选中的text
        final String selectedText = model.getSelectedText();
        if (TextUtils.isEmpty(selectedText)) {
            return;
        }
        // 匹配properties 中的单词和汉语意思

        // todo : 修改为从配置中读取 文件的位置


        String des = getPropertieByKey("G://base.properties", selectedText);
        // 通过一个类似于popupwindows 来展示
        showPopupBalloon(mEditor, des);
    }

    /**
     * 此方法用于，在何种情况下，让我们这个插件起作用，可以点击使用
     * @param e
     */
    @Override
    public void update(AnActionEvent e) {
        super.update(e);
    }

    // 通过一个类似于PopupWindow来显示
    private void showPopupBalloon(final Editor editor, final String result) {
        ApplicationManager.getApplication().invokeLater(new Runnable() {
            public void run() {
                JBPopupFactory factory = JBPopupFactory.getInstance();
                factory.createHtmlTextBalloonBuilder(result, null, new JBColor(new Color(186, 238, 186), new Color(73, 117, 73)), null)
                        .setFadeoutTime(2000)
                        .createBalloon()
                        .show(factory.guessBestPopupLocation(editor), Balloon.Position.below);
            }
        });
    }


    /**
     * 获取properties 的配置内容
     * @param filePath
     * @param keyWord
     * @return
     * @throws IOException
     */
    public static String getPropertieByKey(String filePath, String keyWord) {
        Properties properties = new Properties();
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(new File(filePath)), "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            properties.load(bufferedReader);
            String des = properties.getProperty(keyWord);
            if(TextUtils.isEmpty(des)){
                return "des:字段未定义";
            }
            return des;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return  "所peoperties文件未找到，请查看配置的路径，以及文件的权限配置为完全控制";
        } catch (IOException e) {
            e.printStackTrace();
            return "请查看perperties的文件权限";
        } finally {
            if (inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "des:解析失败";
    }
}
