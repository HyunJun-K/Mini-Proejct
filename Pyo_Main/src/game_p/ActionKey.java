package game_p;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class ActionKey implements KeyListener {

	MePuyoPanel panel;

	int meX;
	int meY;

	int youX;
	int youY;

	boolean retateChk, keyChk;

	public ActionKey(MePuyoPanel panel) { // ������ ���� �г�
		// TODO Auto-generated constructor stub
		this.panel = panel;
		this.retateChk = false;
		this.keyChk = true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) { // Ű �̺�Ʈ
		// TODO Auto-generated method stub

		if (panel.me.stopChk || panel.you.stopChk) // �ѿ䰡 �ϳ��� ��ž�Ǹ� Ű�� ������� ����
			return;

		meX = panel.meLb.getX(); // �������� ���� x���� y���� ����
		meY = panel.meLb.getY();

		youX = panel.youLb.getX();
		youY = panel.youLb.getY();

		int key = e.getKeyCode();

		switch (key) {

		case KeyEvent.VK_LEFT:

			// System.out.println("����");

			if (retateChk) // �����鼭 �������� �͸� ���� ĥ�� ���װ� ����ٰ���...
				return;

			if (meX == 0 || youX == 0)
				return;

			if (inspectLeft())
				return;

			if (keyChk) { // Ű�� ��ħ���� ��Ű�� ������ �ٸ�Ű�� �� ������ ����
				keyChk = false;
				meX -= Puyo.PUYOSIZE;
				youX -= Puyo.PUYOSIZE;
			}

			// fixBug();
			// printNode();
			break;

		case KeyEvent.VK_RIGHT:

			// System.out.println("������");

			if (retateChk) // �����鼭 �������� �͸� ���� ĥ�� ���װ� ����ٰ���...
				return;

			if (meX + Puyo.PUYOSIZE == panel.getSize().width || youX + Puyo.PUYOSIZE == panel.getSize().width)
				return;

			if (inspectRight())
				return;

			if (keyChk) { // Ű�� ��ħ���� ��Ű�� ������ �ٸ�Ű�� �� ������ ����
				keyChk = false;
				meX += Puyo.PUYOSIZE;
				youX += Puyo.PUYOSIZE;

			}
			// printNode();
			// fixBug();
			break;

		case KeyEvent.VK_UP:

			if (fix()) {
				// System.out.println("Ű���� ����");
				return;
			}

			if (keyChk) { // Ű�� ��ħ���� ��Ű�� ������ �ٸ�Ű�� �� ������ ����

				keyChk = false;

				this.retateChk = true;

				rotate();

				this.retateChk = false;
			}
			// fixBug();
			break;

		case KeyEvent.VK_DOWN:

			int speed = 10;
			// �ʹ� ª�� ������ �ٴ��� �հ� ���� ���� �� ���� �˳��ϰ� �ѻѿ��� ũ�� ������ ��� ����
			// ���� ��� �϶�

			if (fix())
				return;

			if (keyChk) { // Ű�� ��ħ���� ��Ű�� ������ �ٸ�Ű�� �� ������ ����
				keyChk = false;
				meY += speed;
				youY += speed;
				// printNode();
				// fixBug();
			}
			break;
		}

		// me�� you �� ���� ���ʿ� �ִ��� �˾ƾ���
		// ������ �� : x ��ǥ�� �� ŭ
		// ���� �� : x ��ǥ�� �� ����

		// ���ι����϶� ���� ������ �������

		panel.meLb.setLocation(meX, meY);
		fixBug();
		panel.youLb.setLocation(youX, youY);
		panel.fixBug(panel.equalsPuyo(panel.meLb), panel.meLb);
		panel.fixBug(panel.equalsPuyo(panel.youLb), panel.youLb);
		keyChk = true;
//		printNode();

	}

	boolean fix() {

		boolean result = false;

		if (meY >= (panel.getSize().height - Puyo.PUYOSIZE * 2) || youY >= (panel.getSize().height - Puyo.PUYOSIZE * 2))
			result = true;

		for (MyLabel puyo : panel.puyoLbs) {
			if (!puyo.equals(panel.meLb) && !puyo.equals(panel.youLb)) {
				if (meX == puyo.getX() || youX == puyo.getX()) {
					if (meY >= (puyo.getY() - Puyo.PUYOSIZE * 2) || youY >= (puyo.getY() - Puyo.PUYOSIZE * 2))
						result = true;
				}
			}
		}

		return result;

	}

	boolean inspectLeft() { // ���� �ɹ��� �������� �����ʰ� ���� ��ҵ鸸 ���� ���� �ϰڱ���...

		boolean result = false;

		// me �� you�� �������� �����̷� �Ҷ� �׿��� ��Ұ� �ֳ� ������ üũ
		// me �� you �� ���ι����϶� �� ���ϳ���� ���� ��Ұ� ������ �� ������
		for (JLabel puyo : panel.puyoLbs) {
			if (!panel.meLb.equals(puyo) && !panel.youLb.equals(puyo)) { // �� ��󿡼� ���� �ʴ� ����
				if (panel.meLb.getX() > puyo.getX() || panel.youLb.getX() > puyo.getX()) {
					if (panel.meLb.getY() >= puyo.getY() || panel.youLb.getY() >= puyo.getY()) {
						// �� �Ǵ� ���� y ���� ���� ����� y���� ���Եɶ� ���� ��Ұ� ������ �� �� ����
						if (panel.meLb.getX() <= puyo.getX() + Puyo.PUYOSIZE
								|| panel.youLb.getX() <= puyo.getX() + Puyo.PUYOSIZE) {
							// me �Ǵ� you�� x���� �� ����� x ���� ħ�� �Ϸ� �Ҷ�....
							result = true; // true�� �Ǹ� ������ ���� ���ϰ� ��
						}
					}
				}
			}

		}

		return result;

	}

	boolean inspectRight() { // ���� �ɹ��� �������� �����ʰ� ���� ��ҵ鸸 ���� ���� �ϰڱ���...

		boolean result = false;

		// me �� you�� �������� �����̷� �Ҷ� �׿��� ��Ұ� �ֳ� ������ üũ
		// me �� you �� ���ι����϶� �� ���ϳ���� ���� ��Ұ� ������ �� ������
		for (JLabel puyo : panel.puyoLbs) {
			if (!panel.meLb.equals(puyo) && !panel.youLb.equals(puyo)) { // �� ��󿡼� ���� �ʴ� ����
				if (panel.meLb.getX() < puyo.getX() || panel.youLb.getX() < puyo.getX()) {
					if (panel.meLb.getY() >= puyo.getY() || panel.youLb.getY() >= puyo.getY()) {
						// �� �Ǵ� ���� y ���� ���� ����� y���� ���Եɶ� ���� ��Ұ� ������ �� �� ����
						if (panel.meLb.getX() + Puyo.PUYOSIZE >= puyo.getX()
								|| panel.youLb.getX() + Puyo.PUYOSIZE >= puyo.getX()) {
							// me �Ǵ� you�� x���� �� ����� x ���� ħ�� �Ϸ� �Ҷ�....
							result = true; // true�� �Ǹ� ������ ���� ���ϰ� ��
						}
					}
				}
			}

		}

		return result;

	}

	void rotate() {

		// ���� ��� ����
		// ���λ��� �϶� �ʹ� �ؿ��� ����Ű�� ȸ�� ��Ű�� �̻��ϰ� ���̴� ���� �ذ�

		if (youX == meX) { // me �� you�� y������ ������ �� ���� ���� �϶�

			if (youY < meY) { // you�� me ���� ���� ���� �Ҷ�
				if (searchRight()) {
					return;
				}
				// you�� x �� me�� ����������...
				// you�� y �� me�� ����...
				youX = meX + Puyo.PUYOSIZE;
				youY = meY;

			} else { // you�� me ���� �Ʒ� ���� �Ҷ�
				if (searchLeft()) {
					return;
				}
				// you�� x �� me�� ��������...
				// you�� y �� me�� ����...
				youX = meX - Puyo.PUYOSIZE;
				youY = meY;

			}

		} else { // me �� you�� x������ ������ �� ���� ���� �϶�
			// y�� ���� x�ุ ���� ���� ���

			// me�� �ؿ� �����ΰ� ���� �ϸ� ȸ�� ����Ű�� ����� �ǰٳ�...
			for (MyLabel puyo : panel.puyoLbs) {
				if (meX == puyo.getX() && meY + (Puyo.PUYOSIZE * 2) == puyo.getY()) {
					// System.out.println("���Ⱑ ���� ������ ?????????????");
					return;
				}
			}

			if (youX < meX) { // you�� me �� ���ʿ� ���� �Ҷ�
				// you �� me �� ���� �̵�
				// you�� x�� me �� ����
				// you�� y�� me�� ���� ����
				youX = meX;
				youY = meY - Puyo.PUYOSIZE;
			} else { // you�� me �� �����ʿ� ���� �Ҷ�
				// you�� me �� �Ʒ��� �̵�
				// you�� x�� me �� ����
				// you�� y�� me�� �Ʒ��� ����
				youX = meX;
				youY = meY + Puyo.PUYOSIZE;
			}

		}

	}

	boolean searchRight() { // (���ι����� �ѿ�) ���������� ȸ���� => �� you�� me�� ���� ������

		// �����ʿ� �� �Ǵ� �ٸ� �ѿ䰡 �ִٸ�...
		// me �� �������� you �� ȸ���� you�� ��ǥ���� �������

		boolean result = false;

		for (JLabel puyo : panel.puyoLbs) {

			if (youX + Puyo.PUYOSIZE == puyo.getX())
				if (youY + Puyo.PUYOSIZE >= puyo.getY())
					result = true;

		}

		if (youX + Puyo.PUYOSIZE == panel.getSize().width)
			result = true;

		return result;

	}

	boolean searchLeft() { // (���ι����� �ѿ�) �������� ����� => �� you�� me�� �Ʒ� ������

		// ���ʿ� �� �Ǵ� �ٸ� �ѿ䰡 �ִٸ�...
		// me �� �������� you �� ȸ���� you�� ��ǥ���� �������

		boolean result = false;

		for (JLabel puyo : panel.puyoLbs) {

			if (youX - Puyo.PUYOSIZE == puyo.getX())
				if (youY + Puyo.PUYOSIZE >= puyo.getY())
					result = true;

		}

		if (youX == 0)
			result = true;

		return result;

	}

	void fixBug() {

		if (meX == youX) { // ���� �����϶� Ʋ ������ �����.... // me �� �������� �ϱ� ���� you�� X �� me �� xe��
			youX = panel.meLb.getX();
		} else {

			if (meX > youX)
				youX = panel.meLb.getX() - Puyo.PUYOSIZE;
			else
				youX = panel.meLb.getX() + Puyo.PUYOSIZE;
		}

	}

	void printNode() {
		System.out.println("me : " + meX + ", " + meY);
		System.out.println("you : " + youX + ", " + youY);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		int key = e.getKeyCode();
		// System.out.println(key == KeyEvent.VK_DOWN);

	}

}