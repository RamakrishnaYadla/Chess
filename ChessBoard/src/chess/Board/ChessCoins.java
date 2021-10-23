package chess.Board;

import java.util.Date;
import java.util.LinkedList;

import com.designPatterns.CoinState;
import com.designPatterns.Context;

public class ChessCoins implements CoinState{
	int x; int y;int i; int j;
	boolean isWhite;
	LinkedList<ChessCoins> cc;
	String coinName;
	private String PlayerName1;
	private String PlayerName2;
	private Date StartDate;
	private Date EndDate;
	
	public ChessCoins(int x,int y, boolean isWhite, LinkedList<ChessCoins> cc,String cn) {
		this.x = x;
		this.y = y;
		i = x*70; j = y*70;
		this.isWhite = isWhite;
		this.cc = cc;
		cc.add(this);
		this.coinName = cn;
	}
	
	public ChessCoins(Builder builder) {
	}

	public void kill() {
		cc.remove(this);
	}

	public void move(int x, int y) {
			//for(ChessCoins c:cc) 
			//if(c.x == x && c.y == y) {
			//}
		if(Board.getCoin(x*70, y*70)!=null) {
			if(Board.getCoin(x*70, y*70).isWhite!=isWhite) {
				Board.getCoin(x*70, y*70).kill();
			}else {
				i = this.x*70;
				j = this.y*70;
				return;
			}
		}
		
		this.x=x;
		this.y=y;
		i = x*70; j = y*70;
	}
	
	public static class Builder {
		private String PlayerName1;
		private String PlayerName2;
		private Date StartDate;
		private Date EndDate;
		
		public Builder PlayerName1(String PlayerName1) {
			this.PlayerName1 = PlayerName1;
			return this;
		}
		
		public Builder PlayerName2(String PlayerName2) {
			this.PlayerName2 = PlayerName2;
			return this;
		}
		
		public Builder StartDate(Date StartDate) {
			this.StartDate = StartDate;
			return this;
		}
		
		public Builder EndDate(Date EndDate) {
			this.EndDate = EndDate;
			return this;
		}
		
		public ChessCoins build() {
			return new ChessCoins(this);
		}
	}
	
	public String toString() {
		return PlayerName1+" "+PlayerName2+" "+StartDate+" "+EndDate;
	}

	 private static ChessCoins inst = new ChessCoins();
	 
	 private ChessCoins() {}
	 
	    public static ChessCoins inst() {
	        return inst;
	    }
	     
		@Override
		public void updateState(Context ctx) {
			System.out.println("\nCoin Killed");
	        ctx.setCurrentState(ChessCoins.inst());
		}
}