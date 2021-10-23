package chess.Board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.designPatterns.Iterator;

public class Board {
	
	public static LinkedList<ChessCoins> cc=new LinkedList<>();
	public static ChessCoins selectedCoin = null;
	
	public static void createBoard() throws IOException {

		BufferedImage all=ImageIO.read(new File("C:\\Users\\ramakrishna\\Downloads\\Image.png"));
		Image images[]=new Image[12]; // To get list of subImages
		int inc=0;

		for (int j = 0; j <all.getHeight(); j+=all.getHeight()/2) {
			for (int i = 0; i <all.getWidth(); i+=all.getWidth()/6) {
				images[inc] = all.getSubimage(i, j,all.getHeight()/2,all.getWidth()/6).getScaledInstance(70,70, BufferedImage.SCALE_SMOOTH);
						//all.getSubimage((int)all.getWidth()/6, (int)all.getHeight()/2, all.getWidth(),all.getHeight());
				//ImageIO.write(images[inc], "png", new File(System.getProperty("user.dir")+"\\Pieces\\subimages\\"+inc+".png"));
				inc++;
			}
		}
		
		PlayersImpl pi = new PlayersImpl();
		CoinsDetailsImpl cdi = new CoinsDetailsImpl(cc);
		Iterator i = pi.getIterator();
		Iterator j = cdi.createIterator();
		while (i.hasNext()) {
			Object object = i.next();
			String type =(String)object;
			while (j.hasNext()) {
				Object obj = j.next();
				String desc =(String)obj;
				System.out.println("MousePad : "+type +" : "+desc);
				break;
			}
		}
		
		new ChessCoins.Builder().PlayerName1("Test1").PlayerName2("Test2").StartDate(new Date()).build();
		//Coins Arrangement
		ChessCoins bk = new ChessCoins(4, 0, false, cc, "King");
		ChessCoins bM = new ChessCoins(3, 0, false, cc, "Minister");
		ChessCoins bC = new ChessCoins(2, 0, false, cc, "Camel");
		ChessCoins bH = new ChessCoins(1, 0, false, cc, "Horse");
		ChessCoins bE = new ChessCoins(0, 0, false, cc, "Elephant");
		ChessCoins bC1 = new ChessCoins(5, 0, false, cc, "Camel");
		ChessCoins bH1 = new ChessCoins(6, 0, false, cc, "Horse");
		ChessCoins bE1 = new ChessCoins(7, 0, false, cc, "Elephant");
		ChessCoins bP1 = new ChessCoins(0, 1, false, cc, "Pawn");
		ChessCoins bP2 = new ChessCoins(1, 1, false, cc, "Pawn");
		ChessCoins bP3 = new ChessCoins(2, 1, false, cc, "Pawn");
		ChessCoins bP4 = new ChessCoins(3, 1, false, cc, "Pawn");
		ChessCoins bP5 = new ChessCoins(4, 1, false, cc, "Pawn");
		ChessCoins bP6 = new ChessCoins(5, 1, false, cc, "Pawn");
		ChessCoins bP7 = new ChessCoins(6, 1, false, cc, "Pawn");
		ChessCoins bP8 = new ChessCoins(7, 1, false, cc, "Pawn");

		ChessCoins wk = new ChessCoins(4, 7, true, cc, "King");
		ChessCoins wM = new ChessCoins(3, 7, true, cc, "Minister");
		ChessCoins wC = new ChessCoins(2, 7, true, cc, "Camel");
		ChessCoins wH = new ChessCoins(1, 7, true, cc, "Horse");
		ChessCoins wE = new ChessCoins(0, 7, true, cc, "Elephant");
		ChessCoins wC1 = new ChessCoins(5, 7, true, cc, "Camel");
		ChessCoins wH1 = new ChessCoins(6, 7, true, cc, "Horse");
		ChessCoins wE1 = new ChessCoins(7, 7, true, cc, "Elephant");
		ChessCoins wP1 = new ChessCoins(0, 6, true, cc, "Pawn");
		ChessCoins wP2 = new ChessCoins(1, 6, true, cc, "Pawn");
		ChessCoins wP3 = new ChessCoins(2, 6, true, cc, "Pawn");
		ChessCoins wP4 = new ChessCoins(3, 6, true, cc, "Pawn");
		ChessCoins wP5 = new ChessCoins(4, 6, true, cc, "Pawn");
		ChessCoins wP6 = new ChessCoins(5, 6, true, cc, "Pawn");
		ChessCoins wP7 = new ChessCoins(6, 6, true, cc, "Pawn");
		ChessCoins wP8 = new ChessCoins(7, 6, true, cc, "Pawn");
		
		JFrame jf = new JFrame();
		jf.setBounds(10, 50, 560, 560);
		jf.setUndecorated(true); // To disable frame border -- To avoid partial view
		JPanel jp = new JPanel() {
			@Override
			public void paint(Graphics g) {
				boolean cel = true;
				// To Create Cells on Board -- Implemented with Nested for loop
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (cel) {
							g.setColor(Color.WHITE);
						} else {
							//g.setColor(Color.BLACK);
							g.setColor(new Color(50, 150, 60));
						}
						g.fillRect(i * 70, j * 70, 70, 70);
						cel = !cel;
					}
					cel = !cel;
				}
				
				for(ChessCoins c:cc) {
					int inc = 0;
					if(c.coinName.equalsIgnoreCase("King")) {
						inc = 0;
					}
					if(c.coinName.equalsIgnoreCase("Minister")) {
						inc = 1;
					}
					if(c.coinName.equalsIgnoreCase("Camel")) {
						inc = 2;
					}
					if(c.coinName.equalsIgnoreCase("Horse")) {
						inc = 3;
					}
					if(c.coinName.equalsIgnoreCase("Elephant")) {
						inc = 4;
					}
					if(c.coinName.equalsIgnoreCase("Pawn")) {
						inc = 5;
					}
					if(!c.isWhite) {
						inc+=6;
					}
					g.drawImage(images[inc], c.i, c.j, this);
					
				}
			}
		};
		jf.add(jp);
		jf.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				selectedCoin.move(e.getX()/70,e.getY()/70);
				jf.repaint();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				//System.out.println(getCoin(e.getX(), e.getY()).isWhite?"White ":"Black "+getCoin(e.getX(), e.getY()).coinName);
				selectedCoin = getCoin(e.getX(), e.getY());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		jf.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(selectedCoin!=null) {
					selectedCoin.x = e.getX()-35;
					selectedCoin.y = e.getY()-35;
					jf.repaint();
				}
			}
		});
		
		jf.setDefaultCloseOperation(3);
		/*
		 * 1 -- DO_NOTHING_ON_CLOSE; 2 -- HIDE_ON_CLOSE; 3 -- DISPOSE_ON_CLOSE; 4 --
		 * EXIT_ON_CLOSE
		 */
		jf.setVisible(true);
	}
	
	public static ChessCoins getCoin(int i, int j) {
		int x=i/64;
		int y=j/64;
		for(ChessCoins c:cc) {
			if(c.x ==x && c.y ==y) {
				return c;
			}
		}
		return null;
	}
}
