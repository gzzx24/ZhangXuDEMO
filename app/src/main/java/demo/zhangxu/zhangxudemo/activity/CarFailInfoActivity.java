package demo.zhangxu.zhangxudemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.zhangxu.zhangxudemo.R;
import demo.zhangxu.zhangxudemo.entity.CarFailCode;

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
        setTitle("详细内容");
        tv_fail_info = (TextView)findViewById(R.id.tv_fail_info);
        tv_fail_tips = (TextView)findViewById(R.id.tv_fail_tips);
        tv_fail_notice = (TextView)findViewById(R.id.tv_fail_notice);

        tv_fail_info.setText("123\n 456\n789");
        tv_fail_tips.setText("123\n 456\n789");
        tv_fail_notice.setText("123\n 456\n789");
        List<CarFailCode> stuList=new ArrayList<>();
        for(int i=0;i<10;i++){
            CarFailCode carFailCode=new CarFailCode();
            carFailCode.setCode("code"+i);
            carFailCode.setContent("content:"+i);

            stuList.add(carFailCode);
        }


    }
}
