package demo.zhangxu.zhangxudemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.zhangxu.zhangxudemo.R;
import demo.zhangxu.zhangxudemo.adapter.HelpAdapter;
import demo.zhangxu.zhangxudemo.adapter.AddressAdapter;
import demo.zhangxu.zhangxudemo.entity.CarFailCode;

public class HelpActivity extends AppCompatActivity {

    //列表
    private ListView listViewFail;
    private ListView listViewAdrress;
    //自定义BaseAdapter
    private HelpAdapter adapter;
    private AddressAdapter addressAdapter;
    private Spinner spinner_province;
    private Spinner spinner_city;
    private Spinner spinner_area;
    private ArrayAdapter<String> provinceAdapter = null;  //省级适配器
    private ArrayAdapter<String> cityAdapter = null;    //地级适配器
    private ArrayAdapter<String> countyAdapter = null;    //县级适配器
    private TextView tv_adrress;
    static int provincePosition = 3;
    private Button btn_map;

    //省级选项值
    private String[] province = new String[] {"北京","上海","天津","广东"};//,"重庆","黑龙江","江苏","山东","浙江","香港","澳门"};
    //地级选项值
    private String[][] city = new String[][]
            {
                    { "东城区", "西城区", "崇文区", "宣武区", "朝阳区", "海淀区", "丰台区", "石景山区", "门头沟区",
                            "房山区", "通州区", "顺义区", "大兴区", "昌平区", "平谷区", "怀柔区", "密云县",
                            "延庆县" },
                    { "长宁区", "静安区", "普陀区", "闸北区", "虹口区" },
                    { "和平区", "河东区", "河西区", "南开区", "河北区", "红桥区", "塘沽区", "汉沽区", "大港区",
                            "东丽区" },
                    { "广州", "深圳", "韶关" // ,"珠海","汕头","佛山","湛江","肇庆","江门","茂名","惠州","梅州",
                            // "汕尾","河源","阳江","清远","东莞","中山","潮州","揭阳","云浮"
                    }
            };

    //县级选项值
    private String[][][] county = new String[][][]
            {
                    {   //北京
                            {"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},
                            {"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"}
                    },
                    {    //上海
                            {"无"},{"无"},{"无"},{"无"},{"无"}
                    },
                    {    //天津
                            {"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"}
                    },
                    {    //广东
                            {"海珠区","荔湾区","越秀区","白云区","萝岗区","天河区","黄埔区","花都区","从化市","增城市","番禺区","南沙区"}, //广州
                            {"宝安区","福田区","龙岗区","罗湖区","南山区","盐田区"}, //深圳
                            {"武江区","浈江区","曲江区","乐昌市","南雄市","始兴县","仁化县","翁源县","新丰县","乳源县"}  //韶关
                    }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.info_btn_title);
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
//        tv_adrress = (TextView) findViewById(R.id.tv_adrress);
        btn_map = (Button) findViewById(R.id.btn_map);
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("title", getString(R.string.info_btn_line));
                Intent intent = new Intent(HelpActivity.this,MapActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        spinner_province = (Spinner) findViewById(R.id.spinner_province);
        spinner_city = (Spinner) findViewById(R.id.spinner_city);
        spinner_area = (Spinner) findViewById(R.id.spinner_area);

        //绑定适配器和值
        provinceAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, province);
        // 将adapter 添加到spinner中
        spinner_province.setAdapter(provinceAdapter);
        // 添加事件Spinner事件监听
        spinner_province.setOnItemSelectedListener(new FirsthanddlbhSpinnerSelectedListener());


        // 定义原始排队编号下拉菜单
        spinner_city = (Spinner) findViewById(R.id.spinner_city);
        // 将可选内容与ArrayAdapter连接起来
        cityAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, city[3]);
        // 将adapter 添加到spinner中
        spinner_city.setAdapter(cityAdapter);
        // 添加事件Spinner事件监听
        spinner_city.setOnItemSelectedListener(new FirsthandpdbhSpinnerSelectedListener());

        // 定义目标队列下拉菜单
        spinner_area = (Spinner) findViewById(R.id.spinner_area);
        // 将可选内容与ArrayAdapter连接起来
        countyAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, county[3][0]);
        // 将adapter 添加到spinner中
        spinner_area.setAdapter(countyAdapter);
        // 添加事件Spinner事件监听
        spinner_area.setOnItemSelectedListener(new TargetdlbhpinnerSelectedListener());

        listViewFail = (ListView) findViewById(R.id.listViewFail);
        List<CarFailCode> failList=new ArrayList<>();
        for(int i=0;i<2;i++){
            CarFailCode carFailCode=new CarFailCode();
            carFailCode.setCode("code"+i);
            carFailCode.setContent("content:"+i);

            failList.add(carFailCode);
        }
        adapter = new HelpAdapter(HelpActivity.this,failList);
        listViewFail.setAdapter(adapter);



        listViewAdrress = (ListView) findViewById(R.id.listViewAdrress);
        List<CarFailCode> addressList=new ArrayList<>();
        for(int i=0;i<1;i++){
            CarFailCode carFailCode=new CarFailCode();
            carFailCode.setCode("code"+i);
            carFailCode.setContent("content:"+i);

            addressList.add(carFailCode);
        }
        addressAdapter = new AddressAdapter(HelpActivity.this,addressList);
        listViewAdrress.setAdapter(addressAdapter);
    }

    // 选择 目标排队编号 事件 监听器
    class FirsthanddlbhSpinnerSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            //position为当前省级选中的值的序号

            //将地级适配器的值改变为city[position]中的值
            cityAdapter = new ArrayAdapter<String>(HelpActivity.this, android.R.layout.simple_spinner_item, city[arg2]);

            // 设置二级下拉列表的选项内容适配器
            spinner_city.setAdapter(cityAdapter);
            provincePosition = arg2;    //记录当前省级序号，留给下面修改县级适配器时用

        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
    // 选择 目标排队编号 事件 监听器
    class FirsthandpdbhSpinnerSelectedListener implements
            AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            countyAdapter = new ArrayAdapter<String>(HelpActivity.this,android.R.layout.simple_spinner_item, county[provincePosition][arg2]);
            spinner_area.setAdapter(countyAdapter);

        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    // //选择 参照排队编号 事件 监听器
    class TargetdlbhpinnerSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
//            target_dlbh = queuilist[arg2];
//            tv_adrress.setText("广东省 广州市 服务站客服联系方式：\n 0131－31182100 \n 0131－31182100 ");
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
}
