package demo.zhangxu.zhangxudemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import demo.zhangxu.zhangxudemo.R;

public class CarFailInfoActivity extends AppCompatActivity {

    private TextView tv_fail_info;
    private TextView tv_fail_tips;
    private TextView tv_fail_notice;
    private Button btn_back;
    private Button btn_line;
    private Button btn_plug;
    private Button btn_component;
    private Button btn_help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_fail_info);

        initView();
    }

    public void initView() {
        setTitle(R.string.info_btn_title);
        tv_fail_info = (TextView)findViewById(R.id.tv_fail_info);
        tv_fail_tips = (TextView)findViewById(R.id.tv_fail_tips);
        tv_fail_notice = (TextView)findViewById(R.id.tv_fail_notice);

        btn_back = (Button)findViewById(R.id.btn_back);
        btn_line = (Button)findViewById(R.id.btn_line);
        btn_plug = (Button)findViewById(R.id.btn_plug);
        btn_component = (Button)findViewById(R.id.btn_component);
        btn_help = (Button)findViewById(R.id.btn_help);

        tv_fail_info.setText("—检查进气压力温度传感器插头是否松动、脱落或损坏；线束是否损坏。\n " +
                "—拔下传感器插头，检查传感器管脚是否损坏/腐蚀，重新连接传感器插头。\n" +
                "—检查故障是否消失。");
        tv_fail_tips.setText("检查时需举升驾驶室；并断开电源总开关。");
        tv_fail_notice.setText("正确拔插接插件，避免接插件端子进水和油污，保证插接器插接牢靠。\n" +
                "谨慎操作，必要时请与维修站联系，尽快将车辆送至维修站进行检修。");

        // 返回点击事件
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 束线按钮点击事件
        btn_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CarFailInfoActivity.this, "束线按钮点击事件", Toast.LENGTH_SHORT).show();
            }
        });

        // 插座按钮点击事件
        btn_plug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CarFailInfoActivity.this, "插座按钮点击事件", Toast.LENGTH_SHORT).show();
            }
        });

        // 零件按钮点击事件
        btn_component.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CarFailInfoActivity.this, "零件按钮点击事件", Toast.LENGTH_SHORT).show();
            }
        });

        // 服务救援按钮点击事件
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CarFailInfoActivity.this, "服务救援按钮点击事件", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
