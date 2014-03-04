package com.example.listview;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.photocheckin.ActivityRoomla;
import com.example.photocheckin.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;
import android.view.View.OnClickListener;

public class LazyAdapter extends BaseAdapter {

	private String activity_id;
	private Activity activity;
	private Context context;
	private ArrayList<HashMap<String, String>> data;
//	HashMap<String, String> resultp = new HashMap<String, String>();
	private static LayoutInflater inflater = null;
	//public ImageLoader imageLoader;
	HashMap<String, String> song = new HashMap<String, String>();

	public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> arraylist) {
		data = arraylist;
		this.activity = a;
	}

	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		TextView title;
		TextView detail;
		TextView time;
		
		
		song = data.get(position);
		inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		
		View itemView = inflater.inflate(R.layout.list_box, parent, false);
		title = (TextView) itemView.findViewById(R.id.Title);
		detail = (TextView) itemView.findViewById(R.id.Detail);
		time = (TextView) itemView.findViewById(R.id.Time);
		
		TextView addactivity = (TextView) itemView.findViewById(R.id.Add_Activity);
		
		
		title.setText(song.get(WallPage.TAG_ACTIVITYNAME));
		detail.setText(song.get(WallPage.TAG_ACTIVITYDETAIL));
		time.setText(song.get(WallPage.TAG_LASTTIME));
		
		addactivity.setClickable(true);
		
		addactivity.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// Get the position
				song = data.get(position);
				Intent intent = new Intent(activity, ActivityRoomla.class);

				intent.putExtra("id", song.get(WallPage.TAG_ID));
				intent.putExtra("lasttime", song.get(WallPage.TAG_LASTTIME));
				intent.putExtra("activityname", song.get(WallPage.TAG_ACTIVITYNAME));
				intent.putExtra("activitydetail", song.get(WallPage.TAG_ACTIVITYDETAIL));
				intent.putExtra("createby", song.get(WallPage.TAG_CREATEBY));
				intent.putExtra("condition", song.get(WallPage.TAG_CONDITION));
				intent.putExtra("usertype", song.get(WallPage.TAG_USERTYPE));
				intent.putExtra("block", song.get(WallPage.TAG_BLOCK));
				intent.putExtra("registerdate", song.get(WallPage.TAG_REGISTERDATE));
				intent.putExtra("startdate", song.get(WallPage.TAG_STARTDATE));
				intent.putExtra("enddate", song.get(WallPage.TAG_ENDDATE));
				intent.putExtra("picture", song.get(WallPage.TAG_PICTURE));
				intent.putExtra("latitude", song.get(WallPage.TAG_LATITUDE));
				intent.putExtra("longitude", song.get(WallPage.TAG_LONGITUDE));
				intent.putExtra("qrcode", song.get(WallPage.TAG_QRCODE));
				
			
				activity.startActivity(intent);
				
				
				CheckTextNull();
			}

			private void CheckTextNull() {
				String activity_id = song.get(WallPage.TAG_ID);
				RequestHTTP(activity_id);
				
			}
			
			private void RequestHTTP(String activity_id){
				try{
				JSONArray jsonArray = new JSONArray(activity_id);
				JSONObject jsonObject = new JSONObject(jsonArray.getString(Integer.parseInt(activity_id)));
				Log.d("NewComment", "id"+ activity_id);
				}catch(JSONException e){
					
				}
			}
		});

		return itemView;
	}
}