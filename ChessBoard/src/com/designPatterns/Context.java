package com.designPatterns;

import chess.Board.ChessCoins;

public class Context {
	private CoinState State;
     
    public Context(CoinState cState) 
    {
        super();
        this.State = cState;
         
        if(cState == null) {
            this.State = ChessCoins.inst();
        }
    }
 
    public CoinState getCurrentState() {
        return State;
    }
 
    public void setCurrentState(ChessCoins currentState) {
        this.State = currentState;
    }
     
    public void update() {
    	State.updateState(this);
    }
}