import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import kr.co.green.BusanUtil;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Chapter2_Screen extends JFrame {
	int ok = 0;
	int random;

	public JPanel pnlTxt2;
	private JPanel choicePnl;

	private JButton[] btnChoice = new JButton[4];
	private JPanel startPnl;
	private JButton rest;
	private JButton shop;
	private JButton search;
	private JScrollPane jsp2;
	private JTextArea textArea;

	private List<Story> list2;
	private List<ChoiceSum> choiceOnly2;
	private List<ChoiceSum> choiceSum2;
	private boolean twoCc = false, threeCc = false;
	// twoCc: 삼중 선택지 + 선택지 열려있을 경우 textArea 닫혀짐 방지 | false일 시 startPnl 활성화, jsp2 비활

	// 임시 조건 필드
	private int day = 0;
	private boolean night = false;

	// 합치지 위해 예슬누나 Screen 가져옴
	Chapter2_Screen_YS ys = new Chapter2_Screen_YS();

// YS 예슬누나 Screen 메소드 전체 복붙
	public void GmEvNight() {
		Random random = new Random();

		Chapter2StoryDao dao = new Chapter2StoryDaoImpl();
		List<String> gmNight = new ArrayList<String>();

		try {
			gmNight.add(dao.read(45).getStoryMain()); // 체력 +1
			gmNight.add(dao.read(48).getStoryMain()); // 체력 -1
			gmNight.add(dao.read(50).getStoryMain()); // 체력 +1

		} catch (SQLException e) {
			e.printStackTrace();
		}

		int b = random.nextInt(gmNight.size());
		textArea.setText(gmNight.get(b));

		// 아이템과 스탯 반영하는 부분
		if (b == 0) {
			// 정신력 -2
			System.out.println("체력+1");
		}

		if (b == 1) {
			// 체력 +1
			System.out.println("체력-1");
		}

		if (b == 2) {
			// 정신력 -1
			System.out.println("체력+1");
		}
	}

	public void nightEv12() {
		Chapter2StoryDao dao = new Chapter2StoryDaoImpl();
		Chapter2ChoiceDao Cdao = new Chapter2ChoiceDaoImpl();

		try {
			textArea.setText(dao.read(53).getStoryMain());
			choicePnl.setVisible(true);

			for (int i = 0; i < 3; i++) {
				btnChoice[i].setVisible(true);
			}

			btnChoice[0].setText(Cdao.read(23).getChoiceMain());
			btnChoice[1].setText(Cdao.read(24).getChoiceMain()); // 정신력 -2
			btnChoice[2].setText(Cdao.read(25).getChoiceMain());
			btnChoice[3].setVisible(false);

		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		UserInfo user = new UserInfo();
		// 테스트 하려고 임의로 쿠키와 한은둔을 넣은 것
//			user.setParty(Arrays.asList(9, 8));
		if (user.getParty().contains(9) == false) {
			btnChoice[0].setEnabled(false);
		}

		if (user.getParty().contains(8) == false) {
			btnChoice[1].setEnabled(false);
		}

		// 선택지 눌렀을 때 화면 넘기기
		btnChoice[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(dao.read(54).getStoryMain());
					choicePnl.setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				night = false;
			}
		});

		btnChoice[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(dao.read(55).getStoryMain());
					choicePnl.setVisible(false);
					// 정신력 -1
					System.out.println("정신력-1");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				night = false;
			}
		});

		btnChoice[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(dao.read(57).getStoryMain());
					choicePnl.setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				night = false;
			}
		});

		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					if (ok == 0) {
						ok++;
					}

					if (ok == 1 && textArea.getText().equals(dao.read(57).getStoryMain())) {
						textArea.setText(dao.read(58).getStoryMain());
						choicePnl.setVisible(false);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
	}

	public void nightEv14() {

		Chapter2StoryDao dao = new Chapter2StoryDaoImpl();
		Chapter2ChoiceDao Cdao = new Chapter2ChoiceDaoImpl();

		try {
			textArea.setText(dao.read(64).getStoryMain());
			choicePnl.setVisible(true);

			for (int i = 0; i < 2; i++) {
				btnChoice[i].setVisible(true);
			}

			btnChoice[0].setText(Cdao.read(37).getChoiceMain()); // 체력 -2, 정신력 -2, 감기+
			btnChoice[1].setText(Cdao.read(38).getChoiceMain()); // 체력 -1
			btnChoice[2].setVisible(false);
			btnChoice[3].setVisible(false);

		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		btnChoice[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(dao.read(65).getStoryMain());
					choicePnl.setVisible(false);
					// 체력 -2 정신력 -2 감기+
					System.out.println("체력-2 정신력-2 걍 죽어라 이말이에용");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				night = false;
			}
		});

		btnChoice[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(dao.read(66).getStoryMain());
					choicePnl.setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				night = false;
			}
		});
	}

	public void nightEv15() {

		Chapter2StoryDao dao = new Chapter2StoryDaoImpl();
		Chapter2ChoiceDao Cdao = new Chapter2ChoiceDaoImpl();

		try {
			textArea.setText(dao.read(67).getStoryMain());
			choicePnl.setVisible(true);

			for (int i = 0; i < 3; i++) {
				btnChoice[i].setVisible(true);
			}

			btnChoice[0].setText(Cdao.read(34).getChoiceMain());
			btnChoice[1].setText(Cdao.read(35).getChoiceMain());
			btnChoice[2].setText(Cdao.read(36).getChoiceMain());
			btnChoice[3].setVisible(false);

		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		btnChoice[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(dao.read(68).getStoryMain());
					choicePnl.setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				night = false;
			}
		});

		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {

					if (ok == 0) {
						ok++;
					}
					if (ok == 1 && textArea.getText().equals(dao.read(68).getStoryMain())) {
						textArea.setText(dao.read(69).getStoryMain());
						choicePnl.setVisible(false);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnChoice[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(dao.read(70).getStoryMain());
					choicePnl.setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				night = false;
			}
		});

		btnChoice[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(dao.read(71).getStoryMain());
					choicePnl.setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				night = false;
			}
		});
	}

// YS 예슬누나 Screen 메소드 전체 복사

	private void storyUpdate(int btn) {
		// random = 랜덤으로 가져오는 이벤트 처리를 위해 입력받음(파라미터없이 그냥 random 입력해도 될 것 같음)
		// btn = 몇 번째 버튼인지 입력

		try {

			btn += 1;

			List<String> mainList = new ArrayList<>();
			Random rd = new Random();

			String nowStory = list2.get(random).getStoryNum();
			String choiceNum = (nowStory + "-" + String.valueOf((btn)));
			String storyNum;
			for (int i = 0; i < choiceSum2.size(); i++) {
				storyNum = choiceSum2.get(i).getStoryNum();
				if (choiceNum.equals(storyNum)) {
					mainList.add(choiceSum2.get(i).getStoryMain());
				}
			}
			textArea.setText(mainList.get(rd.nextInt(mainList.size())));

			String threeChoice = "4-2";
			int three = 1;
			String cn = String.valueOf(three);
			if (choiceNum.equals(threeChoice)) {
				twoCc = true;
				threeChoice += ("-" + cn);
				for (int i = 0; i < choiceSum2.size(); i++) {
					if (choiceSum2.get(i).getStoryNum().equals(threeChoice)) {
						btnChoice[three - 1].setText(choiceSum2.get(i).getChoiceMain());
						three++;
						cn = String.valueOf(three);
						threeChoice = "4-2" + "-" + cn;
					}
				}

			} else {
				twoCc = false;
				choicePnl.setVisible(false);
			}
		} catch (IllegalArgumentException e) {
			System.out.println("예슬Screen과 대수Screen 합치다가 버튼이 겹쳐서 생기는 오류, 신경안써도 됨 정상 작동함");
		}
	}

	private void btnSet() {
		List<String> strList = new ArrayList<>();
		int b = 1;

		String nowStory = list2.get(random).getStoryNum();
		String choiceNum;
		String storyNum;
		for (int i = 0; i < choiceOnly2.size(); i++) {
			choiceNum = choiceOnly2.get(i).getChoiceNum();
			storyNum = (nowStory + "-" + String.valueOf((b)));
			if (storyNum.equals(choiceNum)) {
				strList.add(choiceOnly2.get(i).getChoiceMain());
				b++;
			}
		}

		for (int i = 0; i < btnChoice.length; i++) {
			btnChoice[i].setVisible(false);
		}

		for (int i = 0; i < strList.size(); i++) {
			btnChoice[i].setText(strList.get(i));
			btnChoice[i].setEnabled(true);
			btnChoice[i].setVisible(true);
		}

		choicePnl.setVisible(true);
		twoCc = true;
	}

	private void getAchoiceSum2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		choiceSum2 = new ArrayList<>();

		try {
			conn = BusanUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM `busan`.chapter2_choiceSum");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ChoiceSum cic = new ChoiceSum(rs.getInt("storyId"), rs.getString("storyNum"),
						rs.getString("choiceMain"), rs.getString("StoryMain"));
				choiceSum2.add(cic);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BusanUtil.closeRS(rs);
			BusanUtil.closeStmt(pstmt);
			BusanUtil.closeConn(conn);
		}
	}

	private void getAchoiceOnly2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		choiceOnly2 = new ArrayList<>();

		try {
			conn = BusanUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM `busan`.chapter2_choiceOnly");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ChoiceSum cic = new ChoiceSum(rs.getInt("choiceId"), rs.getString("choiceNum"),
						rs.getString("choiceMain"));
				choiceOnly2.add(cic);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BusanUtil.closeRS(rs);
			BusanUtil.closeStmt(pstmt);
			BusanUtil.closeConn(conn);
		}
	}

	private void getAstory2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		list2 = new ArrayList<>();

		try {

			conn = BusanUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM busan.chapter2_storyonly");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Story str = new Story(rs.getInt("storyId"), rs.getString("storyNum"), rs.getString("storyMain"),
						rs.getString("storyTime"), rs.getString("check"));

				list2.add(str);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BusanUtil.closeRS(rs);
			BusanUtil.closeStmt(pstmt);
			BusanUtil.closeConn(conn);
		}
	}

	public Chapter2_Screen() {
		super("Chater2");

		pnlTxt2 = new JPanel();
		pnlTxt2.setBounds(12, 10, 824, 841); // 크기를 정해줘야 다른 class에서 사용 가능
		pnlTxt2.setBorder(new LineBorder(new Color(0, 0, 0)));

		jsp2 = new JScrollPane();
		jsp2.setBounds(12, 10, 800, 569);
		pnlTxt2.add(jsp2);

		textArea = new JTextArea();
		jsp2.setViewportView(textArea);
		textArea.setEditable(false);
		jsp2.setVisible(false);

		getAstory2();
		getAchoiceOnly2();
		getAchoiceSum2();

//		선택지 시작
		choicePnl = new JPanel();
		choicePnl.setBounds(12, 579, 800, 252);
		pnlTxt2.add(choicePnl);
		choicePnl.setLayout(null);
		choicePnl.setVisible(false);

		int a = 10;
		for (int i = 0; i < btnChoice.length; i++) {
			btnChoice[i] = new JButton();
			btnChoice[i].setBounds(12, a, 776, 52);
			a += 62;
			choicePnl.add(btnChoice[i]);
		}

		btnChoice[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (list2.get(random).getStoryNum().equals("4") && twoCc == true) {
					if (threeCc == true) {
						for (int i = 0; i < choiceSum2.size(); i++) {
							if (choiceSum2.get(i).getStoryNum().equals("4-2-2-1")) {
								textArea.setText(choiceSum2.get(i).getStoryMain());
								choicePnl.setVisible(false);
								twoCc = false;
								break;
							}
						}
					} else {
						for (int i = 0; i < choiceSum2.size(); i++) {
							if (choiceSum2.get(i).getStoryNum().equals("4-2-1")) {
								textArea.setText(choiceSum2.get(i).getStoryMain());
								choicePnl.setVisible(false);
								break;
							}
						}
					}
				} else {
					storyUpdate(0);
				}
			}
		});

		btnChoice[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (list2.get(random).getStoryNum().equals("4") && twoCc == true) {
					if (threeCc == true) {
						for (int i = 0; i < choiceSum2.size(); i++) {
							if (choiceSum2.get(i).getStoryNum().equals("4-2-2-2")) {
								textArea.setText(choiceSum2.get(i).getStoryMain());
								twoCc = false;
								choicePnl.setVisible(false);
								break;
							}
						}
					} else {
						int a = 1;
						String cn = String.valueOf(a);
						String choiceMain = "4-2-2-" + cn;
						for (int i = 0; i < choiceSum2.size(); i++) {
							if (choiceSum2.get(i).getStoryNum().equals("4-2-2")) {
								textArea.setText(choiceSum2.get(i).getStoryMain());
							}
							if (choiceSum2.get(i).getStoryNum().equals(choiceMain)) {
								btnChoice[a - 1].setText(choiceSum2.get(i).getChoiceMain());
								a++;
								cn = String.valueOf(a);
								choiceMain = "4-2-2-" + cn;
							}
						}
						threeCc = true;
					}
				} else {
					storyUpdate(1);
				}
			}
		});

		btnChoice[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				storyUpdate(2);
			}
		});

		btnChoice[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				storyUpdate(3);
			}
		});

//		선택지 끝

		getContentPane().add(pnlTxt2);
		pnlTxt2.setLayout(null);

		startPnl = new JPanel();
		startPnl.setBounds(413, 76, 383, 374);
		pnlTxt2.add(startPnl);
		startPnl.setLayout(null);

		search = new JButton("탐색");
		search.setBounds(44, 82, 300, 64);
		startPnl.add(search);

		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startPnl.setVisible(false);
				if (day == 3) {
					day = 1;
					night = true;
				}

				jsp2.setVisible(!night);

				if (night == false) {
					Random rd = new Random();
					if (day == 0) {
						textArea.setText(list2.get(8).getStoryMain());
						list2.remove(8);
						day++;
					}
					// 첫째날 스푸키 이벤트 고정
					else {
						list2.remove(random); // 나온 이벤트 삭제된 리스트를 전투 이벤트와 계속 합쳐야됨
						if (list2.size() == 1) { // 이벤트가 1개만 남았을 때 랜덤에 size가 들어가지않아 설정해둠
							textArea.setText(list2.get(0).getStoryMain());
						} else {
							random = rd.nextInt(list2.size());
							btnSet();
							textArea.setText(list2.get(random).getStoryMain());
						}
					}
					day++;
				} else {
					System.out.println("예슬누나 screen 출력 예정");

//					for (int i = 0; i < btnChoice.length; i++) {
//						btnChoice[i].setVisible(false);
//					}
					jsp2.setVisible(night);
					nightEv12();

				}

			}
		});

		shop = new JButton("상점");
		shop.setBounds(44, 156, 300, 64);
		startPnl.add(shop);

		rest = new JButton("휴식");
		rest.setBounds(44, 230, 300, 64);
		startPnl.add(rest);

//		스토리 클릭 시 변화
		textArea.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (list2.get(random).getStoryNum().equals("GM")) {
					twoCc = false;
					list2.remove(random);
				} else if (night == true) {
					startPnl.setVisible(!night);
					jsp2.setVisible(night);
				} else {
					twoCc = false;
				}
				startPnl.setVisible(!twoCc);
				jsp2.setVisible(twoCc);
			}

		});

		setSize(830, 870);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

	}

	public static void main(String[] args) {
		new Chapter2_Screen().setVisible(true);
	}
}
