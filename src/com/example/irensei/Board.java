package com.example.irensei;


public class Board {
	
	private int board[][];
	
	public Board(){
		board = new int[15][15];
		for(int y=0;y<15;y++){
			for(int x=0;x<15;x++){
				board[y][x] = 0;
			}
		}
	}
	
	public void setBoard(int y,int x,int state){
		//stateが1なら黒石、2なら白石、3なら取った石
		board[y][x] = state;
	}
	public int[][] getBoard(){
		return board;
	}
}
