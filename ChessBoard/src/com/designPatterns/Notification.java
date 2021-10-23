package com.designPatterns;

import java.util.ArrayList;

import chess.Board.ChessCoins;

public class Notification implements CoinState{

	private ArrayList<ChessCoins> coins;
	private ArrayList<Observer> Obs;
	
	public Notification() {
		coins = new ArrayList();
		Obs = new ArrayList();
	}
	
	@Override
	public void updateState(Context ctx) {
		for(int i=0; i<Obs.size();i++) {
			Obs.get(i).update(this);
		}
	}
}