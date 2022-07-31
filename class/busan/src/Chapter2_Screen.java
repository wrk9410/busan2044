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
//	int ok = 0;
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

	private void storyUpdate(int btn) {
		// random = 랜덤으로 가져오는 이벤트 처리를 위해 입력받음(파라미터없이 그냥 random 입력해도 될 것 같음)
		// btn = 몇 번째 버튼인지 입력
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
//					night = false;
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
