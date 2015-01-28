package com.example.irensei;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ResultActivity extends Activity {

	private TextView winnerName;
	private Button resultViewBtn;
	private Button titleBtn;
	private ListView resultListView;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		resultInit();
		Bundle extras = getIntent().getExtras();
		winnerName.setText("勝者:"+extras.getString("winnerName"));
	}
	
	public View.OnClickListener btnOnClickLisntener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			switch (v.getId()) {
			case R.id.resultviewbtn:
				resultView();
				break;
			case R.id.titlebtn:
				startActivity(intent);
				break;

			default:
				break;
			}

		}
	};
	
	private void resultInit(){
		winnerName = (TextView)findViewById(R.id.winnerName);
		resultViewBtn = (Button)findViewById(R.id.resultviewbtn);
		titleBtn = (Button)findViewById(R.id.titlebtn);
		resultListView = (ListView)findViewById(R.id.resulltlistView);
		intent = new Intent(ResultActivity.this, TitleActivity.class);
		resultViewBtn.setOnClickListener(btnOnClickLisntener);
		titleBtn.setOnClickListener(btnOnClickLisntener);
	}
	
	private void resultView(){
		DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
		SQLiteDatabase mydb = helper.getReadableDatabase();
		try{
			Cursor cr = mydb.rawQuery("Select * From result Order By id desc", null);
			cr.moveToFirst();
			if(cr.getCount()>0){
				Integer[] data = new Integer[cr.getCount()];//ID array
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
				for(int cnt=0;cnt<cr.getCount();cnt++){
					data[cnt] = cr.getInt(0);
					adapter.add("勝者:"+cr.getString(1)+" 敗者:"+cr.getString(2)+" 対戦日"+cr.getString(3));
					cr.moveToNext();
					resultListView.setAdapter(adapter);
				}
			}else{
				resultListView.setAdapter(null);
			}
		}finally{
			mydb.close();
		}
	}

}
