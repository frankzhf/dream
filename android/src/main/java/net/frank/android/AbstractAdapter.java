package net.frank.android;

import java.util.List;

import net.frank.android.entity.BaseEntity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableRow;

public abstract class AbstractAdapter<T extends BaseEntity> extends ArrayAdapter<T> {
	
	int resource;
	
	public AbstractAdapter(Context context, int textViewResourceId,
			List<T> objects) {
		super(context, textViewResourceId, objects);
		resource = textViewResourceId;
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		final BaseEntity currRecord = getItem(position);
		ViewGroup recordView = null;
		if(convertView == null){
			recordView = new TableRow(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater li;
			li = (LayoutInflater) getContext().getSystemService(inflater);
			li.inflate(resource, recordView,true);
		}else{
			recordView = (ViewGroup)convertView;
		}
		processRow(currRecord,recordView,getContext());
		return recordView;
	}
	
	public abstract void processRow(BaseEntity currRecord,ViewGroup recordView,Context context);

}
