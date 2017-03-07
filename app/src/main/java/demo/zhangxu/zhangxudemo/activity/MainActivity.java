package demo.zhangxu.zhangxudemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import demo.zhangxu.zhangxudemo.R;
import demo.zhangxu.zhangxudemo.adapter.MainAdapter;
import demo.zhangxu.zhangxudemo.entity.CarFailCode;

public class MainActivity extends AppCompatActivity {
    //列表
    private ListView listViewFail;
    //自定义BaseAdapter
    private MainAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.main_title);
        setSupportActionBar(toolbar);
        initView();
    }


    public void initView() {
        listViewFail = (ListView) findViewById(R.id.listViewFail);
        List<CarFailCode> failList=new ArrayList<>();
        for(int i=0;i<10;i++){
            CarFailCode carFailCode=new CarFailCode();
            carFailCode.setCode("code"+i);
            carFailCode.setContent("content:"+i);

            failList.add(carFailCode);
        }

        adapter=new MainAdapter(MainActivity.this,failList);
        listViewFail.setAdapter(adapter);

        listViewFail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(MainActivity.this,CarFailInfoActivity.class));

            }
        });
    }

}