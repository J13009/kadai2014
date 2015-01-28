package com.example.irensei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class TitleActivity extends Activity {
	private ImageButton startBtn;
	private EditText player1Name;
	private EditText player2Name;
	private String p1Name;
	private String p2Name;
	private Intent intent;
	private Toast toast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_title);
		titleInit();
		startBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				p1Name = player1Name.getText().toString();
				p2Name = player2Name.getText().toString();
				if(p1Name.length() >0 || p2Name.length() > 0){
					intent.putExtra("player1", p1Name);
					intent.putExtra("player2", p2Name);
					startActivity(intent);
				}else{
					toast.show();
				}
			}
		});
	}
	
	private void titleInit(){
		startBtn = (ImageButton)findViewById(R.id.start);
		player1Name = (EditText)findViewById(R.id.player1);
		player2Name = (EditText)findViewById(R.id.player2);
		p1Name = null;
		p2Name = null;
		intent = new Intent(TitleActivity.this, GameActivity.class);
		toast = 	Toast.makeText(this,
				"プレイヤー名を入力してください",
				Toast.LENGTH_LONG);
	}
}
