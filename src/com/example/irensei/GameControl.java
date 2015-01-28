package com.example.irensei;

public class GameControl {
	String p1Name;
	String p2Name;
	
	public GameControl(String p1Name,String p2Name){
		this.p1Name = p1Name;
		this.p2Name = p2Name;
	}
	
	public String getP1Name() {
		return p1Name;
	}
	public String getP2Name() {
		return p2Name;
	}
	
	
	public String[] winChk(int[][] bd,int player){
		String[] name = new String[2];
		if(player == 1){
			name[0] = p1Name;
			name[1] = p2Name;
		}else if(player == 2){
			name[0] = p2Name;
			name[1] = p1Name;
		}
	
		//横方向の勝利チェック
		for(int y=0;y<15;y++ ){
			for(int x=0;x<9;x++){
				if(bd[y][x] == player && bd[y][x+1] == player && bd[y][x+2] == player &&
						bd[y][x+3] == player && bd[y][x+4] == player && bd[y][x+5] == player &&
						bd[y][x+6] == player){
					return name;
				}
			}
		}
		//縦方向の勝利チェック
		for(int y=0;y<9;y++ ){
			for(int x=0;x<15;x++){

				if(bd[y][x] == 1 && bd[y+1][x] == player && bd[y+2][x] == player &&
						bd[y+3][x] == player && bd[y+4][x] == player && bd[y+5][x] == player &&
						bd[y+6][x] == player){

					return name;
				}
			}
		}
		
		//左斜め方向の勝利チェック
		for(int y=0;y<9;y++ ){
			for(int x=0;x<9;x++){

				if(bd[y][x] == player && bd[y+1][x+1] == player && bd[y+2][x+2] == player &&
						bd[y+3][x+3] == player && bd[y+4][x+4] == player && bd[y+5][x+5] == player &&
						bd[y+6][x+6] == player){

					return name;
				}
			}
		}		

		//右斜め方向の勝利チェック
		for(int y=0;y<9;y++ ){
			for(int x=14;x>5;x--){

				if(bd[y][x] == player && bd[y+1][x-1] == player && bd[y+2][x-2] == player &&
						bd[y+3][x-3] == player && bd[y+4][x-4] == player && bd[y+5][x-5] == player &&
						bd[y+6][x-6] == player){

					return name;
				}
			}
		}
		name[0] = "";
		name[1] = "";
		return  name;
	}
	
	//引き分け判定
	public boolean drawChk(int[][] bd){
		for(int y=0;y<15;y++){
			for(int x=0;x<15;x++){
				if(bd[y][x] == 0){
					return false;
				}
			}
		}
		return true;
	}
	
	//囲み判定
	public int[] srround(int bd[][],int y,int x,int player,int player2){
		int[]point ={-1,-1};
		if(x==0&&y==0){
			//右方向
			if(bd[y][x+1]==player2 && bd[y][x+2]==player &&bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+2][x]==player &&  bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;
			}
		}else if(x==0 &&y==14){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-2][x]==player && bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//右方向
			}else if(bd[y][x+1]==player2 && bd[y][x+2]==player &&bd[y-1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			}
		}else if(x==14&&y==0){
			//左方向
			if(bd[y][x-1]==player2 && bd[y][x-2]==player &&bd[y+1][x-1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+2][x]==player &&  bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;
			}			
		}else if(x==14&&y==14){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-2][x]==player && bd[y-1][x-1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//左方向
			}else	if(bd[y][x-1]==player2 && bd[y][x-2]==player &&bd[y-1][x-1]==player){
					point[0] = y;
					point[1] = x+1;
					return point;
			}
		}else if(x==0&&y==1){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			
			}
			//右方向
			if(bd[y][x+1]==player2 && bd[y-1][x+1]==player && bd[y][x+2]==player &&bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			
			}
			//下方向
			if(bd[y+1][x]==player2 && bd[y+2][x]==player &&  bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;
			}			
		}else if(x==1&&y==0){
			//右方向
			if(bd[y][x+1]==player2 && bd[y][x+2]==player &&bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y+1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+2][x]==player && bd[y+1][x-1]==player && bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;		
			}			
		}else if(x==13&&y==0){
			//右方向
			if(bd[y][x+1]==player2 && bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y][x-2]==player && bd[y+1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+2][x]==player && bd[y+1][x-1]==player && bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;		
			}			
		}else if(x==14&&y==1){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-1][x-1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y-1][x-1]==player && bd[y][x-2]==player &&bd[y+1][x-1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+2][x]==player &&  bd[y+1][x-1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;
			}			
		}else if(x==0&&y==13){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-2][x]==player && bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			
			}
			//右方向
			if(bd[y][x+1]==player2 && bd[y-1][x+1]==player && bd[y][x+2]==player &&bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			
			}
			//下方向
			if(bd[y+1][x]==player2 && bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;
			}			
		}else if(x==1&&y==14){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-2][x]==player && bd[y-1][x-1]==player && bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
				//右方向
			}else if(bd[y][x+1]==player2 && bd[y][x+2]==player &&bd[y-1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y-1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			}			
		}else if(x==13&&y==14){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-2][x]==player && bd[y-1][x-1]==player && bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
				//右方向
			}else if(bd[y][x+1]==player2 && bd[y-1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y][x-2]==player && bd[y-1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			}			
		}else if(x==14&&y==13){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-2][x]==player && bd[y-1][x-1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y-1][x+1]==player && bd[y][x-2]==player &&bd[y+1][x-1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//下方向
			}else if(bd[y+1][x]==player2 &&  bd[y+1][x-1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;
			}
		}else if(x==1 && y==1){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-1][x-1]==player && bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//右方向
			}else if(bd[y][x+1]==player2 && bd[y-1][x+1]==player && bd[y][x+2]==player &&bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y-1][x-1]==player && bd[y+1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+1][x-1]==player && bd[y+2][x]==player &&bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;			
			}
		}else if(x==13 && y==1){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-1][x-1]==player && bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//右方向
			}else if(bd[y][x+1]==player2 && bd[y-1][x+1]==player && bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y-1][x-1]==player && bd[y][x-2]==player && bd[y-1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+1][x-1]==player && bd[y+2][x]==player &&bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;			
			}
		}else if(x==1 && y==13){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-1][x-1]==player && bd[y-2][x]==player &&bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//右方向
			}else if(bd[y][x+1]==player2 && bd[y-1][x+1]==player && bd[y][x+2]==player &&bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y-1][x-1]==player && bd[y+1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+1][x-1]==player && bd [y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;			
			}
		}else if(x==13 && y==13){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-1][x-1]==player && bd[y-2][x]==player &&bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//右方向
			}else if(bd[y][x+1]==player2 && bd[y-1][x+1]==player && bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y-1][x-1]==player && bd[y][x-2]==player && bd[y-1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+1][x-1]==player && bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;			
			}						
		}else if(x==0){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-2][x]==player && bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			
			}
			//右方向
			if(bd[y][x+1]==player2 && bd[y-1][x+1]==player && bd[y][x+2]==player &&bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			
			}
			//下方向
			if(bd[y+1][x]==player2 && bd[y+2][x]==player &&  bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;
			}
		}else if(x==14){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-2][x]==player && bd[y-1][x-1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y-1][x-1]==player && bd[y][x-2]==player &&bd[y+1][x-1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+2][x]==player &&  bd[y+1][x-1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;
			}
		}else if(y==0){
			//右方向
			if(bd[y][x+1]==player2 && bd[y][x+2]==player &&bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y][x-2]==player && bd[y+1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+2][x]==player && bd[y+1][x-1]==player && bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;		
			}
		}else if(y==14){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-2][x]==player && bd[y-1][x-1]==player && bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
				//右方向
			}else if(bd[y][x+1]==player2 && bd[y][x+2]==player &&bd[y-1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y][x-2]==player && bd[y-1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			}
		}else if(x==1){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-1][x-1]==player && bd[y-2][x]==player &&bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//右方向
			}else if(bd[y][x+1]==player2 && bd[y-1][x+1]==player && bd[y][x+2]==player &&bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y-1][x-1]==player && bd[y+1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+1][x-1]==player && bd[y+2][x]==player &&bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;			
			}			
		}else if(x==13){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-1][x-1]==player && bd[y-2][x]==player &&bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//右方向
			}else if(bd[y][x+1]==player2 && bd[y-1][x+1]==player && bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y-1][x-1]==player && bd[y][x-2]==player && bd[y-1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+1][x-1]==player && bd[y+2][x]==player &&bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;			
			}			
		}else if(y==1){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-1][x-1]==player && bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//右方向
			}else if(bd[y][x+1]==player2 && bd[y-1][x+1]==player && bd[y][x+2]==1 &&bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y-1][x+1]==player && bd[y][x-2]==player && bd[y-1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+1][x-1]==player && bd[y+2][x]==player &&bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;			
			}			
		}else if(y==13){
			//上方向
			if(bd[y-1][x]==player2 && bd[y-1][x-1]==player && bd[y-2][x]==player &&bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//右方向
			}else if(bd[y][x+1]==player2 && bd[y-1][x+1]==player && bd[y][x+2]==player &&bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y-1][x-1]==player && bd[y][x-2]==player && bd[y-1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+1][x-1]==player && bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;			
			}			

		}else{

			//上方向
			if(bd[y-1][x]==player2 && bd[y-1][x-1]==player && bd[y-2][x]==player &&bd[y-1][x+1]==player){
				point[0] = y-1;
				point[1] = x;
				return point;
			//右方向
			}else if(bd[y][x+1]==player2 && bd[y-1][x+1]==player && bd[y][x+2]==player &&bd[y+1][x+1]==player){
				point[0] = y;
				point[1] = x+1;
				return point;
			//左方向
			}else if(bd[y][x-1]==player2 && bd[y+1][x-1]==player && bd[y][x-2]==player && bd[y-1][x-1]==player){
				point[0] = y;
				point[1] = x-1;
				return point;	
			//下方向
			}else if(bd[y+1][x]==player2 && bd[y+1][x-1]==player && bd[y+2][x]==player &&bd[y+1][x+1]==player){
				point[0] = y+1;
				point[1] = x;
				return point;			
			}
		}
		

		return point;
	}

}
