package demo.zhangxu.zhangxudemo.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * 基础的Activity，该类细化了原始类的生命周期，
 *
 * @author 张旭
 * @version 1.0
 * @date 2016/4/8
 * @since 1.0
 */
abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置横屏或竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //为所有按钮设置点击事件
        View rootView = findViewById(android.R.id.content);// android.R.id.content这个id可以获取到Activity的根View
        //寻找按钮组件，并设置点击事件
        findButtonAndSetOnClickListener(rootView);
        initView();
        initListeners();
        initData();
    }

    /**
     * 初始化Listener,需要实现是覆盖
     */
    public void initListeners() {

    }

    /**
     * 初始化view,必须实现
     */
    public abstract void initView();

//    /**
//     * 设置布局文件
//     * @return 布局文件ID
//     */
//    public abstract int setLayoutResID();

    /**
     * 初始化数据
     */
    public void initData() {}

    /**
     * 寻找按钮组件，并设置点击事件，子类如果需要响应按钮点击事件直接实现本类中的onClick(View v, int id)方法
     * @param rootView
     */
    private void findButtonAndSetOnClickListener(View rootView) {
        if(rootView instanceof ViewGroup){
            ViewGroup viewGroup = (ViewGroup) rootView;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                if(child instanceof Button || child instanceof ImageButton){
                    child.setOnClickListener(this);
                }else if(child instanceof ViewGroup){
                    findButtonAndSetOnClickListener(child);
                }
            }
        }
    }

    /**
     * 子类实现此方法处理点击事件
     * @param v
     */
    public void onClick(View v, int id){}

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //因为项目中都会返回的这个按钮，在ids.xml中创建返回按钮的id,项目中用到直接引用，点击返回功能此处已经完成
//            case R.id.btn_back://点击id为btn_back的按钮统一处理
//                finish();
//                break;

            default://其他的情况下让子类自己处理

                onClick(v, v.getId());

                break;
        }
    }

    /**
     * 显示Toast提示信息
     * @param msg 消息文本
     */
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
