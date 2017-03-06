package demo.zhangxu.zhangxudemo.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import demo.zhangxu.zhangxudemo.R;
import demo.zhangxu.zhangxudemo.entity.CarFailCode;
public class MainAdapter extends BaseAdapter {
	private List<CarFailCode> data;
	private LayoutInflater layoutInflater;
	private Context context;
	private String saveStr;
	public MainAdapter(Context context, List<CarFailCode> data) {
		this.context 		= context;
		this.data 			= data;
		this.layoutInflater = LayoutInflater.from(context);
	}
	/**
	 * 获取列数
	 */
	public int getCount() {
		return data.size();
	}
	/**
	 * 获取某一位置的数据
	 */
	public Object getItem(int position) {
		return data.get(position);
	}
	/**
	 * 获取唯一标识
	 */
	public long getItemId(int position) {
		return position;
	}

	public void setListData(List<CarFailCode> data){
		this.data = data;
		this.notifyDataSetChanged();
	}
	/**
	 * android绘制每一列的时候，都会调用这个方法
	 */
	public View getView(final int position, View convertView, ViewGroup parent) {
		final Holder holder;
		if (convertView == null) {
			holder = new Holder();
			// 获取组件布局
			convertView 		= layoutInflater.inflate(R.layout.item_main, null);
			holder.tv_code 		= (TextView) convertView.findViewById(R.id.tv_code);
			holder.tv_content 	= (TextView) convertView.findViewById(R.id.tv_content);
			// 这里要注意，是使用的tag来存储数据的。
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		holder.tv_code.setText("id1992");
		holder.tv_content.setText("电压过高");

		return convertView;
	}

	public final class Holder {
		// 错误码
		public TextView tv_code;
		// 错误内容
		public TextView tv_content;
	}
}