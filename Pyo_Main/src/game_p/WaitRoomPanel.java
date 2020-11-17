package game_p;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WaitRoomPanel extends JPanel {

	ImageIcon background;
	String src;
	boolean chk;

	public WaitRoomPanel(String src, boolean chk) {
		// TODO Auto-generated constructor stub
		this.src = src;
		this.chk = chk;
		this.background = new ImageIcon(src);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

	@Override
	public void paint(Graphics g) { // 게임이 끝났을시 투명도를 설정
		super.paint(g);
		if (!this.chk)
			return;
		BufferedImage img = (BufferedImage) createImage(getWidth(), getHeight());
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setComposite(AlphaComposite.SrcOver.derive(0.8f));
		g2.drawImage(img, 0, 0, null);
	}

}
