package chess.Board;

import com.designPatterns.Iterator;

public class PlayersImpl implements ChessCollection {

	String Players[] = {"White","Black"};
	
	@Override
	public Iterator getIterator() {
		return new Iter();
	}
	
	private class Iter implements Iterator{

		int i = 0;
		
		@Override
		public boolean hasNext() {
			if(i<Players.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if(this.hasNext()) {
				return Players[i++];
			}
			return null;
		}
	}
}