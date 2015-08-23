package com.plantatree.plantatree.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.plantatree.plantatree.R;
import com.plantatree.plantatree.util.SharedPrefHelper;

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
			SharedPrefHelper sharedPrefHelper = new SharedPrefHelper(mContext);
			if(sharedPrefHelper.getRateChange()){
				int newRate = DataType.getRate(mContext, position)+1;
				DataType.setRate(mContext,position,newRate);
				viewHolder.rate.setTextColor(Color.RED);
			}else{
				viewHolder.rate.setTextColor(Color.BLACK);
			}
			String rate = DataType.getRate(mContext,position) + "%";
			viewHolder.rate.setText(rate);
		}
		v.invalidate();
		v.setTag(viewHolder);
		return v;
	}

	public MainAdapter(Context context, int resource) {
		super(context, resource);
		mContext = context;
	}

	public enum DataType{
		TYPE_OF_TREE("Type of tree"),
		TYPE_OF_SPECIES("Type of species"),
		GALLERY("Gallery"),
		CONTRIBUTORS("Contributor");

		private String name;
		DataType(String name){
			this.name = name;
		}


		public String getName(){
			return name;
		}
		public static int getRate(Context context, int id){
			SharedPrefHelper sharedPrefHelper = new SharedPrefHelper(context);
			switch (id){
				case 0:
					return sharedPrefHelper.getTypeOfTree();
				case 1:
					return sharedPrefHelper.getNumberOfSpecies();
				case 2:
					return sharedPrefHelper.getGallery();
				case 3:
					return sharedPrefHelper.getContributor();
			}
			return 0;
		}


		public static void setRate(Context context, int id, int rate){
			SharedPrefHelper sharedPrefHelper = new SharedPrefHelper(context);
			switch (id){
				case 0:
					sharedPrefHelper.setTypeOfTree(rate);
					break;
				case 1:
					sharedPrefHelper.setNumberOfSpecies(rate);
					break;
				case 2:
					sharedPrefHelper.setGallery(rate);
					break;
				case 3:
					sharedPrefHelper.setContributor(rate);
					break;
			}
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
