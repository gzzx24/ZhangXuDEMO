package demo.zhangxu.zhangxudemo.activity;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import demo.zhangxu.zhangxudemo.R;
import demo.zhangxu.zhangxudemo.utils.BitmapUtil;
import demo.zhangxu.zhangxudemo.utils.DragImageView;

public class ImageViewActivity extends AppCompatActivity{

    private int window_width, window_height;// �ؼ����
    private DragImageView dragImageView;// �Զ���ؼ�
    private int state_height;// ״̬���ĸ߶�

    private ViewTreeObserver viewTreeObserver;

    private static final String TAG = "DisplayImage";
    private static final int FLING_MIN_DISTANCE = 100;
    private static final int FLING_MIN_VELOCITY = 200;

//    private Button btn_back;
    /* 相关变量声明 */
    private ImageView iv_zoom;
    private Button btn_big;
    private Button btn_small;
//    private FrameLayout layout1;
    private RelativeLayout rl_image_view;
    private LinearLayout layoutImage;
    private Bitmap bmp;
    private int id=0;
    private int displayWidth;
    private int displayHeight;
    private float scaleWidth=1;
    private float scaleHeight=1;
    private GestureDetector mGestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        String title = this.getIntent().getStringExtra("title");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("进气压力温度传感器电压过高");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        btn_back = (Button)findViewById(R.id.btn_back_image);
//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /* 取得屏幕分辨率大小 */
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        window_width = dm.widthPixels;
        window_height = dm.heightPixels;

        dragImageView = (DragImageView) findViewById(R.id.iv_zoom);
        Bitmap bmp = BitmapUtil.ReadBitmapById(this, R.mipmap.zhishi,
                window_width, window_height);
        // ����ͼƬ
        dragImageView.setImageBitmap(bmp);
        dragImageView.setmActivity(this);//ע��Activity.
        /** ����״̬���߶� **/
        viewTreeObserver = dragImageView.getViewTreeObserver();
        viewTreeObserver
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
                        if (state_height == 0) {
                            // ��ȡ״�����߶�
                            Rect frame = new Rect();
                            getWindow().getDecorView()
                                    .getWindowVisibleDisplayFrame(frame);
                            state_height = frame.top;
                            dragImageView.setScreen_H(window_height-state_height);
                            dragImageView.setScreen_W(window_width);
                        }

                    }
                });
    }



}
