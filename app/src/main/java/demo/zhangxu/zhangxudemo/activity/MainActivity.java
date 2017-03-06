package demo.zhangxu.zhangxudemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import demo.zhangxu.zhangxudemo.R;
import demo.zhangxu.zhangxudemo.adapter.MainAdapter;
import demo.zhangxu.zhangxudemo.entity.CarFailCode;

public class MainActivity extends Activity {
    //列表
    private ListView listViewFail;
    //自定义BaseAdapter
    private MainAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    public void initView() {
        setTitle(R.string.main_title);
        listViewFail = (ListView) findViewById(R.id.listViewFail);
        List<CarFailCode> stuList=new ArrayList<>();
        for(int i=0;i<10;i++){
            CarFailCode carFailCode=new CarFailCode();
            carFailCode.setCode("code"+i);
            carFailCode.setContent("content:"+i);

            stuList.add(carFailCode);
        }

        adapter=new MainAdapter(MainActivity.this,stuList);
        listViewFail.setAdapter(adapter);

        listViewFail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(MainActivity.this,CarFailInfoActivity.class));

            }
        });
    }

}