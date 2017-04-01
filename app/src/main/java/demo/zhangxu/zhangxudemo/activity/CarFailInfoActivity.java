package demo.zhangxu.zhangxudemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import demo.zhangxu.zhangxudemo.R;

public class CarFailInfoActivity extends AppCompatActivity {

    private TextView tv_fail_info;
    private TextView tv_fail_tips;
    private TextView tv_fail_notice;
//    private Button btn_back;
    private Button btn_line;
    private Button btn_plug;
    private Button btn_component;
    private Button btn_help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_fail_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("进气压力温度传感器电压过高");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initView();
    }

    public void initView() {
        tv_fail_info = (TextView)findViewById(R.id.tv_fail_info);
        tv_fail_tips = (TextView)findViewById(R.id.tv_fail_tips);
        tv_fail_notice = (TextView)findViewById(R.id.tv_fail_notice);

//        btn_back = (Button)findViewById(btn_back);
        btn_line = (Button)findViewById(R.id.btn_line);
        btn_plug = (Button)findViewById(R.id.btn_plug);
        btn_component = (Button)findViewById(R.id.btn_component);
        btn_help = (Button)findViewById(R.id.btn_help);

        tv_fail_info.setText("—检查进气压力温度传感器插头是否松动、脱落或损坏；线束是否损坏。");
        tv_fail_tips.setText("—拔下传感器插头，检查传感器管脚是否损坏/腐蚀，重新连接传感器插头。");
        tv_fail_notice.setText("—检查故障是否消失。");

//        // 返回点击事件
//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

        // 束线按钮点击事件
        btn_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title", getString(R.string.info_btn_line));
                Intent intent = new Intent(CarFailInfoActivity.this,ImageViewActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        // 插座按钮点击事件
        btn_plug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title", getString(R.string.info_btn_plug));
                Intent intent = new Intent(CarFailInfoActivity.this,ImageViewActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        // 零件按钮点击事件
        btn_component.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title", getString(R.string.info_btn_component));
                Intent intent = new Intent(CarFailInfoActivity.this,ImageViewActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        // 服务救援按钮点击事件
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("title", getString(R.string.info_btn_component));
                Intent intent = new Intent(CarFailInfoActivity.this,HelpActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
