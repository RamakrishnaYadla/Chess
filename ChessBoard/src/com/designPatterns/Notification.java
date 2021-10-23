package com.designPatterns;

import java.util.ArrayList;
import java.util.LinkedList;

import chess.Board.ChessCoins;

public class Notification implements CoinState{

	private LinkedList<ChessCoins> coins;
	private ArrayList<Observer> Obs;
	
	public Notification() {
		coins = new LinkedList<ChessCoins>();
		Obs = new ArrayList();
	}
	
	@Override
	public void updateState(Context ctx) {
		for(int i=0; i<Obs.size();i++) {
			Obs.get(i).update(this);
		}
	}
}