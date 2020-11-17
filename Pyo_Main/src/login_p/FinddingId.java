package login_p;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import jdbc_p.GameUserDAO;
import jdbc_p.GameUserDTO;
import login_p.Login;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FinddingId extends JFrame{

	String id, pw, name, birth, email;
	GameUserDAO dao = new GameUserDAO();
	GameUserDTO dto = new GameUserDTO();
	ArrayList<String> fId = new ArrayList<String>();



	//LoginTest jt = new LoginTest();
	JTextField nameText;
	JTextField idText;
	JTextField birthText;
	JTextField emailText;
	JButton closeBtn;
	JButton findBtn;
	String birthday="";
	
	int monthL = 1;
	int dayL = 1;
	int yearL = 2020;
	int days=1;
	int lastday;
	   
	
	
	
	
	
	
	public FinddingId() {
		getContentPane().setLayout(null);
		setTitle("계정 찾기");
		setIconImage(new ImageIcon("./img/logo.png").getImage());
		setSize(600, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		

		JLabel lbJoinId_1_1_1 = new JLabel("이메일");
		lbJoinId_1_1_1.setBounds(138, 291, 74, 27);
		getContentPane().add(lbJoinId_1_1_1);

		
		
	      Calendar calders = Calendar.getInstance();
	      
	      JComboBox year= new JComboBox();  //년
	      year.setBounds(245, 250, 74, 23);
	      for (int i = 1920; i <= 2020; i++) {
	    	  year.addItem(i);
	      }
	      
	      JComboBox month = new JComboBox(); //월
	      month.setBounds(340, 250, 52, 23);
	      for (int i = 1; i <=12; i++) {
	    	  month.addItem(i);
	      }      
	      
	      JComboBox<Integer> day = new JComboBox(); // 일
	      day.setBounds(410, 250, 46, 23);
	      
	      for (int i = 1; i <=31; i++) {
	    	  day.addItem(i);
	      }      
	      
	      
	      JLabel lblNewLabel_2 = new JLabel("년");
	      lblNewLabel_2.setBounds(325, 250, 21, 27);
	      getContentPane().add(lblNewLabel_2);
	      
	      JLabel lblNewLabel_2_1 = new JLabel("월");
	      lblNewLabel_2_1.setBounds(395, 250, 21, 27);
	      getContentPane().add(lblNewLabel_2_1);
	      
	      JLabel lblNewLabel_2_1_1 = new JLabel("일");
	      lblNewLabel_2_1_1.setBounds(465, 250, 21, 27);
	      getContentPane().add(lblNewLabel_2_1_1);
	      
		  year.setSelectedItem(2020);
	      getContentPane().add(year);
	      getContentPane().add(month);
	      getContentPane().add(day);
	      
	      
	      year.addActionListener(new  ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					yearL = (int) year.getItemAt(year.getSelectedIndex());
				}
			});
	      
	      
	      
	  	month.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			

				if(day.getItemCount()>1) {
					day.removeAllItems();
				}
				
				monthL = (int) month.getItemAt(month.getSelectedIndex());
				calders.set(yearL, monthL - 1, days);
				lastday = calders.getActualMaximum(Calendar.DAY_OF_MONTH);
				
				for (int j = 1; j <= lastday; j++) {
					day.addItem(j);
				}

			}
		});
		
	
		day.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(day.getSelectedItem()!=null) {
					dayL = (int) day.getItemAt(day.getSelectedIndex());
					System.out.println(dayL);
				}
			}
		});
		

		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(245, 206, 209, 27);
		getContentPane().add(nameText);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(245, 291, 209, 27);
		getContentPane().add(emailText);

		closeBtn = new JButton("종료");
		closeBtn.setBackground(Color.LIGHT_GRAY);
		closeBtn.setBounds(305, 416, 129, 29);
		getContentPane().add(closeBtn);
		closeBtn.addActionListener(actBtn);

		findBtn = new JButton("찾기");
		findBtn.setBackground(Color.LIGHT_GRAY);
		findBtn.setBounds(159, 416, 129, 29);
		getContentPane().add(findBtn);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(138, 212, 57, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_1.setBounds(138, 254, 57, 15);
		getContentPane().add(lblNewLabel_1);
		findBtn.addActionListener(actBtn);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	ActionListener actBtn = new ActionListener() {
		ArrayList<GameUserDTO> pwF = new ArrayList<GameUserDTO>();

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == closeBtn) {
				dispose();
				new Login();
			}

			if (e.getSource() == findBtn) {
				String name = nameText.getText().trim();
				String birth = yearL + "년" + monthL + "월" + dayL + "일";
				String mail = emailText.getText().trim();
				System.out.println(birth+"벌스벌스");
				while (true) {
					GameUserDTO dto = new GameUserDTO();

					if (name.equals("")) {
						JOptionPane.showMessageDialog(null, "이름을 입력해 주세요");
						break;
					} else {
						dto.setName(name);
					}
					
					if (yearL==0 || monthL==0 || monthL==0) {
						JOptionPane.showMessageDialog(null, "생일을 입력해 주세요");
						break;
					} else {
						dto.setBirth(birth);
		
					}

					if (mail.equals("")) {
						JOptionPane.showMessageDialog(null, "메일을 입력해 주세요");
						break;
					} else {
						dto.setEmail(mail);
					}

					pwF.add(new GameUserDAO().find(name, birth, mail));
					String findname = pwF.get(0).getName();
					String findId = pwF.get(0).getId();
					String findPw = pwF.get(0).getPw();

					if (findname != null && findId != null && findPw != null ) {
						JOptionPane.showMessageDialog(null,
								findname + "님의 아이디 : " + findId + " 비밀번호 : " + findPw + " 입니다.");
						pwF.clear();
						dispose();
						new Login();
					}else{
						JOptionPane.showMessageDialog(null, "유효하지 않은 정보 입니다.");
						pwF.clear();
					}

					break;

				}

			}

		}

	};
	public static void main(String[] args) {
		new FinddingId();
	}

}