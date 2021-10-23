package chess.Board;

import java.util.LinkedList;

import com.designPatterns.Container;
import com.designPatterns.Iterator;

public class CoinsDetailsImpl implements Container {
	public static LinkedList<ChessCoins> cc=new LinkedList<>();
	
	public CoinsDetailsImpl(LinkedList<ChessCoins> ccoins) {
		ccoins = this.cc;
	}
	
	public Iterator createIterator() {
		CCDetailsIterator Iter = new CCDetailsIterator();
		return Iter;
	}
	
	private class CCDetailsIterator implements Iterator{

		int i = 0;
		
		@Override
		public boolean hasNext() {
			if(cc.size()>0) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if(this.hasNext()) {
				ChessCoins ccdetails = cc.get(i);
				cc.remove(i);
				return ccdetails;
			}
			return null;
		}
	}
}