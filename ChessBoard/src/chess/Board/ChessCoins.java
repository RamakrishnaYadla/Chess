package chess.Board;

import java.util.LinkedList;

public class ChessCoins {
	int x; int y;
	boolean isWhite;
	LinkedList<ChessCoins> cc;
	String coinName;
	
	public ChessCoins(int x,int y, boolean isWhite, LinkedList<ChessCoins> cc,String cn) {
		this.x = x;
		this.y = y;
		this.isWhite = isWhite;
		this.cc = cc;
		cc.add(this);
		this.coinName = cn;
	}
	
	public void move(int x, int y) {
		for(ChessCoins c:cc) {
			if(c.x == x && c.y == y) {
				c.kill();
			}
		}
		this.x=x;
		this.y=y;
	}
	
	public void kill() {
		cc.remove(this);
	}
}