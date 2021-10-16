package chess.Board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board {
	
	
	public static Image[] divideImages() throws IOException {
		LinkedList<ChessCoins> cc=new LinkedList<>(); 
		BufferedImage all=ImageIO.read(new File("D:\\Pieces\\Heads.png"));
		Image images[]=new Image[12]; // To get list of subImages
		int inc=0;
		
		System.out.println(all.getWidth());
		System.out.println(all.getHeight());
		
		
		for (int j = 0; j <=all.getHeight(); j+=all.getHeight()/6) {
		
			for (int i = 0; i <= all.getWidth(); i+=all.getWidth()/2) {
				
				images[inc] = all.getSubimage(i, j, all.getWidth()/2,all.getHeight()/6).getScaledInstance(70,70, BufferedImage.SCALE_SMOOTH);
						//all.getSubimage((int)all.getWidth()/6, (int)all.getHeight()/2, all.getWidth(),all.getHeight());
				//ImageIO.write(images[inc], "png", new File(System.getProperty("user.dir")+"\\Pieces\\subimages\\"+inc+".png"));
				inc++;
			}
		}
		return images;
	}
	
	public static void createBoard() throws IOException {

		
		LinkedList<ChessCoins> cc=new LinkedList<>(); 
		BufferedImage all=ImageIO.read(new File("D:\\Pieces\\Heads.png"));
		Image images[]=new Image[12]; // To get list of subImages
		int inc=0;
		
		for (int j = 0; j < all.getHeight(); j+=all.getHeight()/6) {
		
			for (int i = 0; i < all.getWidth(); i+=all.getWidth()/2) {
				
				images[inc] = all.getSubimage(i, j,all.getWidth()/2,all.getHeight()/6).getScaledInstance(70,70, BufferedImage.SCALE_SMOOTH);
						//all.getSubimage((int)all.getWidth()/6, (int)all.getHeight()/2, all.getWidth(),all.getHeight());
				//ImageIO.write(images[inc], "png", new File(System.getProperty("user.dir")+"\\Pieces\\subimages\\"+inc+".png"));
				inc++;
			}
		}
		
		//Coins Arrangement
		ChessCoins wk = new ChessCoins(0, 1, false, cc, "King");
		ChessCoins wC = new ChessCoins(0, 2, false, cc, "Camel");
		ChessCoins wM = new ChessCoins(0, 3, false, cc, "Minister");
		ChessCoins wH = new ChessCoins(0, 7, false, cc, "Horse");
		ChessCoins wC1 = new ChessCoins(0, 5, false, cc, "Camel");
		ChessCoins wH1 = new ChessCoins(0, 6, false, cc, "Horse");
		ChessCoins wE = new ChessCoins(0, 7, false, cc, "Elephant");
		ChessCoins wE1 = new ChessCoins(0, 4, false, cc, "Elephant");

		ChessCoins bk = new ChessCoins(0, 1, true, cc, "King");
		ChessCoins bC = new ChessCoins(0, 2, true, cc, "Camel");
		ChessCoins bM = new ChessCoins(0, 3, true, cc, "Minister");
		ChessCoins bH = new ChessCoins(0, 7, true, cc, "Horse");
		ChessCoins bC1 = new ChessCoins(0, 5, true, cc, "Camel");
		ChessCoins bH1 = new ChessCoins(0, 6, true, cc, "Horse");
		ChessCoins bE = new ChessCoins(0, 7, true, cc, "Elephant");
		ChessCoins bE1 = new ChessCoins(0, 4, true, cc, "Elephant");
		
		JFrame jf = new JFrame();
		jf.setBounds(10, 50, 560, 560);
		jf.setUndecorated(true); // To disable frame border -- To avoid cells partial view
		JPanel jp = new JPanel() {
			@Override
			public void paint(Graphics g) {
				boolean cel = false;
				// To Create Cells on Board -- Implemented with Nested for loop
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (cel) {
							g.setColor(Color.WHITE);
						} else {
							g.setColor(Color.BLACK);
						}
						g.fillRect(i * 70, j * 70, 70, 70);
						cel = !cel;
					}
					cel = !cel;
				}
				
				
				//g.drawImage(images[inc], cc.x*70, cc.y*70, this);
				
				for(ChessCoins c:cc) {
					int inc = 0;
					if(c.coinName.equalsIgnoreCase("King")) {
						inc = 0;
					}
					if(c.coinName.equalsIgnoreCase("Minister")) {
						inc = 1;
					}
					if(c.coinName.equalsIgnoreCase("Bishop")) {
						inc = 2;
					}
					if(c.coinName.equalsIgnoreCase("Knight")) {
						inc = 3;
					}
					if(c.coinName.equalsIgnoreCase("Camel")) {
						inc = 4;
					}
					if(c.coinName.equalsIgnoreCase("Pawn")) {
						inc = 5;
					}
					if(!c.isWhite) {
						inc+=6;
					}
					g.drawImage(images[inc], c.x*70, c.y*70, this);
					
				}
			}
		};
		jf.add(jp);
		jf.setDefaultCloseOperation(3);
		/*
		 * 1 -- DO_NOTHING_ON_CLOSE; 2 -- HIDE_ON_CLOSE; 3 -- DISPOSE_ON_CLOSE; 4 --
		 * EXIT_ON_CLOSE
		 */
		jf.setVisible(true);
	}
}