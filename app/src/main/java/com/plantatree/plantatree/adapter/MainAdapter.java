package com.plantatree.plantatree.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.plantatree.plantatree.R;

/**
 * Created by robertzhang on 2015-08-22.
 */
public class MainAdapter extends ArrayAdapter<MainAdapter.DataType> {
	private Context mContext;
	@Override
	public int getPosition(DataType item) {
		return super.getPosition(item);
	}

	@Override
	public DataType getItem(int position) {
		return DataType.getDataTypeById(position);
	}

	@Override
	public int getCount() {
		return DataType.values().length;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		ViewHolder viewHolder;
		if (v == null) {
			viewHolder = new ViewHolder();
			v = View.inflate(mContext, R.layout.data_item, null);
			viewHolder.name = (TextView) v.findViewById(R.id.item_name);
			viewHolder.rate = (TextView) v.findViewById(R.id.item_rate);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		if(DataType.getDataTypeById(position)!=null){
			viewHolder.name.setText(DataType.getDataTypeById(position).getName());
		}
		v.setTag(viewHolder);
		return v;
	}

	public MainAdapter(Context context, int resource) {
		super(context, resource);
		mContext = context;
	}

	public enum DataType{
		AVERAGE_HEIGHT("Average Height"),
		TYPE_OF_TREE("Type of tree"),
		NUMBER_OF_SPECIES("Type of species"),
		NUMBER_OF_TREE("Number of tree"),
		GALLERY("Gallery"),
		CONTRIBUTORS("Contributor");

		private String name;
		DataType(String name){
			this.name = name;
		}

		public String getName(){
			return name;
		}

		public static DataType getDataTypeById(int id){
			for (DataType dataType: values()){
				if(dataType.ordinal()==id){
					return dataType;
				}
			}
			return null;
		}
	}
	class ViewHolder{
		TextView name;
		TextView rate;
	}
}
