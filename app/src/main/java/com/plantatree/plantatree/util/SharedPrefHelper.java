package com.plantatree.plantatree.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by robertzhang on 2015-08-23.
 */
public class SharedPrefHelper {
	SharedPreferences sharedPreferences;
	private static final String RATE_CHANGE = "rate_change";
	private static final String AVERAGE_HEIGHT = "average_height";
	private static final String TYPE_OF_TREE = "type_of_tree";
	private static final String NUMBER_OF_SPECIES = "number_of_species";
	private static final String NUMBER_OF_TREE = "number_of_tree";
	private static final String GALLERY = "gallery";
	private static final String CONTRIBUTOR = "contributor";
	private static final String DONATED = "donated";


	public SharedPrefHelper(Context context){
		sharedPreferences = context.getSharedPreferences("forest", Context.MODE_PRIVATE);
	}

	public void setRateChange(boolean change){
		sharedPreferences.edit().putBoolean(RATE_CHANGE, change).commit();
	}
	public boolean getRateChange(){
		return sharedPreferences.getBoolean(RATE_CHANGE, false);
	}

	public void setAverageHeight(int averageHeight){
		sharedPreferences.edit().putInt(AVERAGE_HEIGHT, averageHeight).commit();
	}
	public int getAverageHeight(){
		return sharedPreferences.getInt(AVERAGE_HEIGHT, 8);
	}

	public void setTypeOfTree(int typeOfTree){
		sharedPreferences.edit().putInt(TYPE_OF_TREE, typeOfTree).commit();
	}
	public int getTypeOfTree(){
		return sharedPreferences.getInt(TYPE_OF_TREE, 1);
	}

	public void setNumberOfSpecies(int numberOfSpecies){
		sharedPreferences.edit().putInt(NUMBER_OF_SPECIES, numberOfSpecies).commit();
	}
	public int getNumberOfSpecies(){
		return sharedPreferences.getInt(NUMBER_OF_SPECIES,3);
	}
	public void setNumberOfTree(int numberOfTree){
		sharedPreferences.edit().putInt(NUMBER_OF_TREE, numberOfTree).commit();
	}
	public int getNumberOfTree(){
		return sharedPreferences.getInt(NUMBER_OF_TREE,4);
	}
	public void setGallery(int gallery){
		sharedPreferences.edit().putInt(GALLERY, gallery).commit();

	}

	public int getGallery(){
		return sharedPreferences.getInt(GALLERY,1);

	}

	public void setContributor(int contributor){
		sharedPreferences.edit().putInt(CONTRIBUTOR, contributor).commit();

	}
	public int getContributor(){
		return sharedPreferences.getInt(CONTRIBUTOR, 4);
	}

	public void setDonated(boolean donated){
		sharedPreferences.edit().putBoolean(DONATED, donated).commit();
	}
	public boolean getDonated(){
		return sharedPreferences.getBoolean(DONATED, false);
	}
}
