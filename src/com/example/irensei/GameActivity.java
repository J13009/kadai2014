package com.example.irensei;

import java.util.Calendar;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {
	
	private Drawable img;
	private int player = 1;
	private ImageButton[][] imgbtn;
	private EditText xPoint; 
	private EditText yPoint; 
	private Button pointInputBtn; 
	private Toast toast_e;
	private Intent intent;
	private TextView playerName;
	private Board bd;
	private GameControl gc;
	private Bundle extras;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		imgbtn  = new ImageButton[15][15];
		xPoint = new EditText(this);
		yPoint = new EditText(this);
		pointInputBtn = new Button(this);

		gameInit();



	}
	//イベントリスナーを定義
	public View.OnClickListener btnOnClickListener = new View.OnClickListener() {
		//イベント処理
		@Override
		public void onClick(View v) {
			Resources rsc = v.getResources();
			switch (v.getId()) {
				case R.id.pointInputBtn:
				int y;
				int x;
				try {
					y = Integer.parseInt(yPoint.getText().toString());
					x = Integer.parseInt(xPoint.getText().toString());

					if((y>0 && y<16) && (x>0 && x<16)){
						gameUpdate(--y, --x, rsc);
					}else{
						toast_e.show();
						yPoint.setText("");
						xPoint.setText("");						
					}
				} catch (NumberFormatException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
					toast_e.show();
					yPoint.setText("");
					xPoint.setText("");
				}
					break;
				//1行目
				case R.id.imgBtn1:
					gameUpdate(0, 0, rsc);
					break;
				
				case R.id.imgBtn2:
					gameUpdate(0, 1, rsc);
					break;
				
				case R.id.imgBtn3:
					gameUpdate(0, 2, rsc);
					break;
				
				case R.id.imgBtn4:
					gameUpdate(0, 3, rsc);
					break;
				
				case R.id.imgBtn5:
					gameUpdate(0, 4, rsc);
					break;
				
				case R.id.imgBtn6:
					gameUpdate(0, 5, rsc);
					break;
				
				case R.id.imgBtn7:
					gameUpdate(0, 6, rsc);
					break;
				
				case R.id.imgBtn8:
					gameUpdate(0, 7, rsc);
					break;
				
				case R.id.imgBtn9:
					gameUpdate(0, 8, rsc);
					break;
				
				case R.id.imgBtn10:
					gameUpdate(0, 9, rsc);
					break;
				
				case R.id.imgBtn11:
					gameUpdate(0, 10, rsc);
					break;
				
				case R.id.imgBtn12:
					gameUpdate(0, 11, rsc);
					break;
				
				case R.id.imgBtn13:
					gameUpdate(0, 12, rsc);
					break;
				
				case R.id.imgBtn14:
					gameUpdate(0, 13, rsc);
					break;
				
				case R.id.imgBtn15:
					gameUpdate(0, 14, rsc);
					break;
				
				//2行目
				case R.id.imgBtn16:
					gameUpdate(1, 0, rsc);
					break;
				
				case R.id.imgBtn17:
					gameUpdate(1, 1, rsc);
					break;
				
				case R.id.imgBtn18:
					gameUpdate(1, 2, rsc);
					break;
				
				case R.id.imgBtn19:
					gameUpdate(1, 3, rsc);
					break;
				
				case R.id.imgBtn20:
					gameUpdate(1, 4, rsc);
					break;
				
				case R.id.imgBtn21:
					gameUpdate(1, 5, rsc);
					break;
				
				case R.id.imgBtn22:
					gameUpdate(1, 6, rsc);
					break;
				
				case R.id.imgBtn23:
					gameUpdate(1, 7, rsc);
					break;
				
				case R.id.imgBtn24:
					gameUpdate(1, 8, rsc);
					break;
				
				case R.id.imgBtn25:
					gameUpdate(1, 9, rsc);
					break;
				
				case R.id.imgBtn26:
					gameUpdate(1, 10, rsc);
					break;
				
				case R.id.imgBtn27:
					gameUpdate(1, 11, rsc);
					break;
				
				case R.id.imgBtn28:
					gameUpdate(1, 12, rsc);
					break;
				
				case R.id.imgBtn29:
					gameUpdate(1, 13, rsc);
					break;
				
				case R.id.imgBtn30:
					gameUpdate(1, 14, rsc);
					break;
				//3行目
				case R.id.imgBtn31:
					gameUpdate(2, 0, rsc);
					break;
				
				case R.id.imgBtn32:
					gameUpdate(2, 1, rsc);
					break;
				
				case R.id.imgBtn33:
					gameUpdate(2, 2, rsc);
					break;
				
				case R.id.imgBtn34:
					gameUpdate(2, 3, rsc);
					break;
				
				case R.id.imgBtn35:
					gameUpdate(2, 4, rsc);
					break;
				
				case R.id.imgBtn36:
					gameUpdate(2, 5, rsc);
					break;
				
				case R.id.imgBtn37:
					gameUpdate(2, 6, rsc);
					break;
				
				case R.id.imgBtn38:
					gameUpdate(2, 7, rsc);
					break;
				
				case R.id.imgBtn39:
					gameUpdate(2, 8, rsc);
					break;
				
				case R.id.imgBtn40:
					gameUpdate(2, 9, rsc);
					break;
				
				case R.id.imgBtn41:
					gameUpdate(2, 10, rsc);
					break;
				
				case R.id.imgBtn42:
					gameUpdate(2, 11, rsc);
					break;
				
				case R.id.imgBtn43:
					gameUpdate(2, 12, rsc);
					break;
				
				case R.id.imgBtn44:
					gameUpdate(2, 13, rsc);
					break;
				
				case R.id.imgBtn45:
					gameUpdate(2, 14, rsc);
					break;					
				//4行目
				case R.id.imgBtn46:
					gameUpdate(3, 0, rsc);
					break;
				
				case R.id.imgBtn47:
					gameUpdate(3, 1, rsc);
					break;
				
				case R.id.imgBtn48:
					gameUpdate(3, 2, rsc);
					break;
				
				case R.id.imgBtn49:
					gameUpdate(3, 3, rsc);
					break;
				
				case R.id.imgBtn50:
					gameUpdate(3, 4, rsc);
					break;
				
				case R.id.imgBtn51:
					gameUpdate(3, 5, rsc);
					break;
				
				case R.id.imgBtn52:
					gameUpdate(3, 6, rsc);
					break;
				
				case R.id.imgBtn53:
					gameUpdate(3, 7, rsc);
					break;
				
				case R.id.imgBtn54:
					gameUpdate(3, 8, rsc);
					break;
				
				case R.id.imgBtn55:
					gameUpdate(3, 9, rsc);
					break;
				
				case R.id.imgBtn56:
					gameUpdate(3, 10, rsc);
					break;
				
				case R.id.imgBtn57:
					gameUpdate(3, 11, rsc);
					break;
				
				case R.id.imgBtn58:
					gameUpdate(3, 12, rsc);
					break;
				
				case R.id.imgBtn59:
					gameUpdate(3, 13, rsc);
					break;
				
				case R.id.imgBtn60:
					gameUpdate(3, 14, rsc);
					break;					
				//5行目
				case R.id.imgBtn61:
					gameUpdate(4, 0, rsc);
					break;
				
				case R.id.imgBtn62:
					gameUpdate(4, 1, rsc);
					break;
				
				case R.id.imgBtn63:
					gameUpdate(4, 2, rsc);
					break;
				
				case R.id.imgBtn64:
					gameUpdate(4, 3, rsc);
					break;
				
				case R.id.imgBtn65:
					gameUpdate(4, 4, rsc);
					break;
				
				case R.id.imgBtn66:
					gameUpdate(4, 5, rsc);
					break;
				
				case R.id.imgBtn67:
					gameUpdate(4, 6, rsc);
					break;
				
				case R.id.imgBtn68:
					gameUpdate(4, 7, rsc);
					break;
				
				case R.id.imgBtn69:
					gameUpdate(4, 8, rsc);
					break;
				
				case R.id.imgBtn70:
					gameUpdate(4, 9, rsc);
					break;
				
				case R.id.imgBtn71:
					gameUpdate(4, 10, rsc);
					break;
				
				case R.id.imgBtn72:
					gameUpdate(4, 11, rsc);
					break;
				
				case R.id.imgBtn73:
					gameUpdate(4, 12, rsc);
					break;
				
				case R.id.imgBtn74:
					gameUpdate(4, 13, rsc);
					break;
				
				case R.id.imgBtn75:
					gameUpdate(4, 14, rsc);
					break;					
				//6行目
				case R.id.imgBtn76:
					gameUpdate(5, 0, rsc);
					break;
				
				case R.id.imgBtn77:
					gameUpdate(5, 1, rsc);
					break;
				
				case R.id.imgBtn78:
					gameUpdate(5, 2, rsc);
					break;
				
				case R.id.imgBtn79:
					gameUpdate(5, 3, rsc);
					break;
				
				case R.id.imgBtn80:
					gameUpdate(5, 4, rsc);
					break;
				
				case R.id.imgBtn81:
					gameUpdate(5, 5, rsc);
					break;
				
				case R.id.imgBtn82:
					gameUpdate(5, 6, rsc);
					break;
				
				case R.id.imgBtn83:
					gameUpdate(5, 7, rsc);
					break;
				
				case R.id.imgBtn84:
					gameUpdate(5, 8, rsc);
					break;
				
				case R.id.imgBtn85:
					gameUpdate(5, 9, rsc);
					break;
				
				case R.id.imgBtn86:
					gameUpdate(5, 10, rsc);
					break;
				
				case R.id.imgBtn87:
					gameUpdate(5, 11, rsc);
					break;
				
				case R.id.imgBtn88:
					gameUpdate(5, 12, rsc);
					break;
				
				case R.id.imgBtn89:
					gameUpdate(5, 13, rsc);
					break;
				
				case R.id.imgBtn90:
					gameUpdate(5, 14, rsc);
					break;					
				//7行目
				case R.id.imgBtn91:
					gameUpdate(6, 0, rsc);
					break;
				
				case R.id.imgBtn92:
					gameUpdate(6, 1, rsc);
					break;
				
				case R.id.imgBtn93:
					gameUpdate(6, 2, rsc);
					break;
				
				case R.id.imgBtn94:
					gameUpdate(6, 3, rsc);
					break;
				
				case R.id.imgBtn95:
					gameUpdate(6, 4, rsc);
					break;
				
				case R.id.imgBtn96:
					gameUpdate(6, 5, rsc);
					break;
				
				case R.id.imgBtn97:
					gameUpdate(6, 6, rsc);
					break;
				
				case R.id.imgBtn98:
					gameUpdate(6, 7, rsc);
					break;
				
				case R.id.imgBtn99:
					gameUpdate(6, 8, rsc);
					break;
				
				case R.id.imgBtn100:
					gameUpdate(6, 9, rsc);
					break;
				
				case R.id.imgBtn101:
					gameUpdate(6, 10, rsc);
					break;
				
				case R.id.imgBtn102:
					gameUpdate(6, 11, rsc);
					break;
				
				case R.id.imgBtn103:
					gameUpdate(6, 12, rsc);
					break;
				
				case R.id.imgBtn104:
					gameUpdate(6, 13, rsc);
					break;
				
				case R.id.imgBtn105:
					gameUpdate(6, 14, rsc);
					break;
					
				//8行目
				case R.id.imgBtn106:
					gameUpdate(7, 0, rsc);
					break;
				
				case R.id.imgBtn107:
					gameUpdate(7, 1, rsc);
					break;
				
				case R.id.imgBtn108:
					gameUpdate(7, 2, rsc);
					break;
				
				case R.id.imgBtn109:
					gameUpdate(7, 3, rsc);
					break;
				
				case R.id.imgBtn110:
					gameUpdate(7, 4, rsc);
					break;
				
				case R.id.imgBtn111:
					gameUpdate(7, 5, rsc);
					break;
				
				case R.id.imgBtn112:
					gameUpdate(7, 6, rsc);
					break;
				
				case R.id.imgBtn113:
					gameUpdate(7, 7, rsc);
					break;
				
				case R.id.imgBtn114:
					gameUpdate(7, 8, rsc);
					break;
				
				case R.id.imgBtn115:
					gameUpdate(7, 9, rsc);
					break;
				
				case R.id.imgBtn116:
					gameUpdate(7, 10, rsc);
					break;
				
				case R.id.imgBtn117:
					gameUpdate(7, 11, rsc);
					break;
				
				case R.id.imgBtn118:
					gameUpdate(7, 12, rsc);
					break;
				
				case R.id.imgBtn119:
					gameUpdate(7, 13, rsc);
					break;
				
				case R.id.imgBtn120:
					gameUpdate(7, 14, rsc);
					break;
					
				//9行目
				case R.id.imgBtn121:
					gameUpdate(8, 0, rsc);
					break;
				
				case R.id.imgBtn122:
					gameUpdate(8, 1, rsc);
					break;
				
				case R.id.imgBtn123:
					gameUpdate(8, 2, rsc);
					break;
				
				case R.id.imgBtn124:
					gameUpdate(8, 3, rsc);
					break;
				
				case R.id.imgBtn125:
					gameUpdate(8, 4, rsc);
					break;
				
				case R.id.imgBtn126:
					gameUpdate(8, 5, rsc);
					break;
				
				case R.id.imgBtn127:
					gameUpdate(8, 6, rsc);
					break;
				
				case R.id.imgBtn128:
					gameUpdate(8, 7, rsc);
					break;
				
				case R.id.imgBtn129:
					gameUpdate(8, 8, rsc);
					break;
				
				case R.id.imgBtn130:
					gameUpdate(8, 9, rsc);
					break;
				
				case R.id.imgBtn131:
					gameUpdate(8, 10, rsc);
					break;
				
				case R.id.imgBtn132:
					gameUpdate(8, 11, rsc);
					break;
				
				case R.id.imgBtn133:
					gameUpdate(8, 12, rsc);
					break;
				
				case R.id.imgBtn134:
					gameUpdate(8, 13, rsc);
					break;
				
				case R.id.imgBtn135:
					gameUpdate(8, 14, rsc);
					break;		
					
				//10行目
					
				case R.id.imgBtn136:
					gameUpdate(9, 0, rsc);
					break;
				
				case R.id.imgBtn137:
					gameUpdate(9, 1, rsc);
					break;
				
				case R.id.imgBtn138:
					gameUpdate(9, 2, rsc);
					break;
				
				case R.id.imgBtn139:
					gameUpdate(9, 3, rsc);
					break;
				
				case R.id.imgBtn140:
					gameUpdate(9, 4, rsc);
					break;
				
				case R.id.imgBtn141:
					gameUpdate(9, 5, rsc);
					break;
				
				case R.id.imgBtn142:
					gameUpdate(9, 6, rsc);
					break;
				
				case R.id.imgBtn143:
					gameUpdate(9, 7, rsc);
					break;
				
				case R.id.imgBtn144:
					gameUpdate(9, 8, rsc);
					break;
				
				case R.id.imgBtn145:
					gameUpdate(9, 9, rsc);
					break;
				
				case R.id.imgBtn146:
					gameUpdate(9, 10, rsc);
					break;
				
				case R.id.imgBtn147:
					gameUpdate(9, 11, rsc);
					break;
				
				case R.id.imgBtn148:
					gameUpdate(9, 12, rsc);
					break;
				
				case R.id.imgBtn149:
					gameUpdate(9, 13, rsc);
					break;
				
				case R.id.imgBtn150:
					gameUpdate(9, 14, rsc);
					break;	
					
				//11行目
				case R.id.imgBtn151:
					gameUpdate(10, 0, rsc);
					break;
				
				case R.id.imgBtn152:
					gameUpdate(10, 1, rsc);
					break;
				
				case R.id.imgBtn153:
					gameUpdate(10, 2, rsc);
					break;
				
				case R.id.imgBtn154:
					gameUpdate(10, 3, rsc);
					break;
				
				case R.id.imgBtn155:
					gameUpdate(10, 4, rsc);
					break;
				
				case R.id.imgBtn156:
					gameUpdate(10, 5, rsc);
					break;
				
				case R.id.imgBtn157:
					gameUpdate(10, 6, rsc);
					break;
				
				case R.id.imgBtn158:
					gameUpdate(10, 7, rsc);
					break;
				
				case R.id.imgBtn159:
					gameUpdate(10, 8, rsc);
					break;
				
				case R.id.imgBtn160:
					gameUpdate(10, 9, rsc);
					break;
				
				case R.id.imgBtn161:
					gameUpdate(10, 10, rsc);
					break;
				
				case R.id.imgBtn162:
					gameUpdate(10, 11, rsc);
					break;
				
				case R.id.imgBtn163:
					gameUpdate(10, 12, rsc);
					break;
				
				case R.id.imgBtn164:
					gameUpdate(10, 13, rsc);
					break;
				
				case R.id.imgBtn165:
					gameUpdate(10, 14, rsc);
					break;					
				//12行目
				case R.id.imgBtn166:
					gameUpdate(11, 0, rsc);
					break;
				
				case R.id.imgBtn167:
					gameUpdate(11, 1, rsc);
					break;
				
				case R.id.imgBtn168:
					gameUpdate(11, 2, rsc);
					break;
				
				case R.id.imgBtn169:
					gameUpdate(11, 3, rsc);
					break;
				
				case R.id.imgBtn170:
					gameUpdate(11, 4, rsc);
					break;
				
				case R.id.imgBtn171:
					gameUpdate(11, 5, rsc);
					break;
				
				case R.id.imgBtn172:
					gameUpdate(11, 6, rsc);
					break;
				
				case R.id.imgBtn173:
					gameUpdate(11, 7, rsc);
					break;
				
				case R.id.imgBtn174:
					gameUpdate(11, 8, rsc);
					break;
				
				case R.id.imgBtn175:
					gameUpdate(11, 9, rsc);
					break;
				
				case R.id.imgBtn176:
					gameUpdate(11, 10, rsc);
					break;
				
				case R.id.imgBtn177:
					gameUpdate(11, 11, rsc);
					break;
				
				case R.id.imgBtn178:
					gameUpdate(11, 12, rsc);
					break;
				
				case R.id.imgBtn179:
					gameUpdate(11, 13, rsc);
					break;
				
				case R.id.imgBtn180:
					gameUpdate(11, 14, rsc);
					break;
					
				//13行目
				case R.id.imgBtn181:
					gameUpdate(12, 0, rsc);
					break;
				
				case R.id.imgBtn182:
					gameUpdate(12, 1, rsc);
					break;
				
				case R.id.imgBtn183:
					gameUpdate(12, 2, rsc);
					break;
				
				case R.id.imgBtn184:
					gameUpdate(12, 3, rsc);
					break;
				
				case R.id.imgBtn185:
					gameUpdate(12, 4, rsc);
					break;
				
				case R.id.imgBtn186:
					gameUpdate(12, 5, rsc);
					break;
				
				case R.id.imgBtn187:
					gameUpdate(12, 6, rsc);
					break;
				
				case R.id.imgBtn188:
					gameUpdate(12, 7, rsc);
					break;
				
				case R.id.imgBtn189:
					gameUpdate(12, 8, rsc);
					break;
				
				case R.id.imgBtn190:
					gameUpdate(12, 9, rsc);
					break;
				
				case R.id.imgBtn191:
					gameUpdate(12, 10, rsc);
					break;
				
				case R.id.imgBtn192:
					gameUpdate(12, 11, rsc);
					break;
				
				case R.id.imgBtn193:
					gameUpdate(12, 12, rsc);
					break;
				
				case R.id.imgBtn194:
					gameUpdate(12, 13, rsc);
					break;
				
				case R.id.imgBtn195:
					gameUpdate(12, 14, rsc);
					
					break;					
				//14行目
				case R.id.imgBtn196:
					gameUpdate(13, 0, rsc);
					break;
				
				case R.id.imgBtn197:
					gameUpdate(13, 1, rsc);
					break;
				
				case R.id.imgBtn198:
					gameUpdate(13, 2, rsc);
					break;
				
				case R.id.imgBtn199:
					gameUpdate(13, 3, rsc);
					break;
				
				case R.id.imgBtn200:
					gameUpdate(13, 4, rsc);
					break;
				
				case R.id.imgBtn201:
					gameUpdate(13, 5, rsc);
					break;
				
				case R.id.imgBtn202:
					gameUpdate(13, 6, rsc);
					break;
				
				case R.id.imgBtn203:
					gameUpdate(13, 7, rsc);
					break;
				
				case R.id.imgBtn204:
					gameUpdate(13, 8, rsc);
					break;
				
				case R.id.imgBtn205:
					gameUpdate(13, 9, rsc);
					break;
				
				case R.id.imgBtn206:
					gameUpdate(13, 10, rsc);
					break;
				
				case R.id.imgBtn207:
					gameUpdate(13, 11, rsc);
					break;
				
				case R.id.imgBtn208:
					gameUpdate(13, 12, rsc);
					break;
				
				case R.id.imgBtn209:
					gameUpdate(13, 13, rsc);
					break;
				
				case R.id.imgBtn210:
					gameUpdate(13, 14, rsc);
					break;
					
				//15行目
				case R.id.imgBtn211:
					gameUpdate(14, 0, rsc);
					break;
				
				case R.id.imgBtn212:
					gameUpdate(14, 1, rsc);
					break;
				
				case R.id.imgBtn213:
					gameUpdate(14, 2, rsc);
					break;
				
				case R.id.imgBtn214:
					gameUpdate(14, 3, rsc);
					break;
				
				case R.id.imgBtn215:
					gameUpdate(14, 4, rsc);
					break;
				
				case R.id.imgBtn216:
					gameUpdate(14, 5, rsc);
					break;
				
				case R.id.imgBtn217:
					gameUpdate(14, 6, rsc);
					break;
				
				case R.id.imgBtn218:
					gameUpdate(14, 7, rsc);
					break;
				
				case R.id.imgBtn219:
					gameUpdate(14, 8, rsc);
					break;
				
				case R.id.imgBtn220:
					gameUpdate(14, 9, rsc);
					break;
				
				case R.id.imgBtn221:
					gameUpdate(14, 10, rsc);
					break;
				
				case R.id.imgBtn222:
					gameUpdate(14, 11, rsc);
					break;
				
				case R.id.imgBtn223:
					gameUpdate(14, 12, rsc);
					break;
				
				case R.id.imgBtn224:
					gameUpdate(14, 13, rsc);
					break;
				
				case R.id.imgBtn225:
					gameUpdate(14, 14, rsc);
					break;					
			default:
				break;
			}
	
		}
	};
	//更新メソッド
	private void gameUpdate(int y,int x,Resources rsc){
		String win[]=new String[2];
		int point[] = new int[2];
		if(imgbtn[y][x].isEnabled() == true){
			bd.setBoard(y, x, player);	//ボード配列の要素を更新
			if(gc.drawChk(bd.getBoard())){
				intent.putExtra("winnerName", "引き分け");
				startActivity(intent);
				
			}
			if(player == 1){
				img = rsc.getDrawable(R.drawable.black);
				playerName.setText(gc.getP2Name()+"(白)");
				win = gc.winChk(bd.getBoard(),player);
				point = gc.srround(bd.getBoard(), y, x, player,player+1);
				player++;
			}else {
				img = rsc.getDrawable(R.drawable.white);
				playerName.setText(gc.getP1Name()+"(黒)");
				win = gc.winChk(bd.getBoard(),player);
				point = gc.srround(bd.getBoard(), y, x, player,player-1);
				player--;
			}

			imgbtn[y][x].setBackground(img);
			imgbtn[y][x].setEnabled(false);	

			if(!win[0].equals("")){
				dbInsert(win[0], win[1]);
				intent.putExtra("winnerName", win[0]);
				intent.putExtra("loserName", win[1]);
				startActivity(intent);

			}

			
			if(!(point[0] == -1 && point[0] == -1)){
				img = rsc.getDrawable(R.drawable.square);
				imgbtn[point[0]][point[1]].setBackground(img);
				bd.setBoard(point[0], point[1], 0);
			}
			
		}

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	//初期化メソッド
	private void gameInit(){
		Resources res = getResources();
		int id;
		for(int y=0;y<15;y++){
			for(int x=0;x<15;x++){
				id = res.getIdentifier("imgBtn" + String.valueOf(x+15*y+1), "id", getBaseContext().getPackageName());
				imgbtn[y][x] = (ImageButton)findViewById(id);
				imgbtn[y][x].setOnClickListener(btnOnClickListener);
			}
		}
		xPoint = (EditText)findViewById(R.id.editText1);
		yPoint = (EditText)findViewById(R.id.editText2);
		pointInputBtn = (Button)findViewById(R.id.pointInputBtn);
		playerName = (TextView)findViewById(R.id.playerName);
		pointInputBtn.setOnClickListener(btnOnClickListener);
		toast_e = 	Toast.makeText(this,
					"1～15の数字を入力してください",
					Toast.LENGTH_LONG);
		
		intent = new Intent(GameActivity.this,ResultActivity.class);
		extras = getIntent().getExtras();
		bd = new Board();
		gc = new GameControl(extras.getString("player1"), extras.getString("player2"));
		playerName.setText(gc.getP1Name()+"(黒)");
		
	}
	
	private void dbInsert(String winnerName,String loserName){
		DatabaseHelper dbHelper = new DatabaseHelper(this);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Calendar cal = Calendar.getInstance();
		String year = cal.get(Calendar.YEAR)+"年";
		int wmonth = cal.get(Calendar.MONTH);
		String month = wmonth+1+"月";
		String day = cal.get(Calendar.DATE)+"日";
		String date = year+month+day;
		ContentValues values = new ContentValues();
		values.put("winner", winnerName);
		values.put("loser", loserName);
		values.put("date", date);
		//Insert
		db.insert("result", null, values);
		db.close();
	}
}
