
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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import kr.co.green.BusanUtil;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Chapter2_Screen_YS extends JFrame {
	public JPanel pnlTxt2;
	private JPanel choicePnl;
	
//	대수Screen 사용을 위해 public으로 변경 
	private JPanel startPnl;
	private JScrollPane jsp2;

	private JButton[] btnChoice = new JButton[4];
	private JButton rest;
	private JButton shop;
	private JButton search;


	private JTextArea textArea;

//	현재 있는 코드 랜덤으로 나오게 하기 위해서 list 제작
	
	// 다음 화면으로 넘길 때 필요한 int
	private int ok = 0;

// ------------------------------------------------------------------------ //	
	// ev10 밤 이벤트(41, 42, 43) 배열로 받아서 조건걸기
	// 스탯 변화 있음
	// 영빈 인하한테.. 물어바야겠다.......
	public void nigntEv10() {
		Chapter2StoryDao dao = new Chapter2StoryDaoImpl();
		Chapter2ChoiceDao Cdao = new Chapter2ChoiceDaoImpl();
		List<String> ev10 = new ArrayList<String>();
		// 조건(StoryPath) 가지고 오기 위한 객체
		Pathget p = new Pathget();
//		MultiEndingJudge j = new MultiEndingJudge();
		// UserInfo(플레이어 정보) 가지고 오기 위한 객체

		try {

			ev10.add(dao.read(41).getStoryMain());
			ev10.add(dao.read(42).getStoryMain());
			ev10.add(dao.read(43).getStoryMain());
			// 새로 추가해서 뒷번호
			ev10.add(dao.read(72).getStoryMain());
			ev10.add(dao.read(73).getStoryMain());
			ev10.add(dao.read(74).getStoryMain());
			ev10.add(dao.read(75).getStoryMain());

//			// 아직 둘 다 널이라서...
//			if(p.getPath2("id").equals("user_Id") && 4-1을 가지고 있을 때) {
//				
//				textArea.setText(ev10.get(0));
//				// 정신력 -2
//				System.out.println("정신력 -2");
//			}

//			if(4-2-2-1을 가지고 있을 때) {
//				textArea.setText(ev10.get(1));
//				// 체력-2
//				System.out.println("체력 -2");
//			}

//			if(4-2-2를 가지고 있을 때) {
//				textArea.setText(ev10.get(2));
//				// 권총 +1
//				System.out.println("권총+1");
//			}

//			if(4-2-2를 가지고 있을 때) {
//				// 식량 -3, 식량 없으면 체력 -1
//				System.out.println("식량 -3, 식량 없으면 체력 -1");
//				
//				choicePnl.setVisible(true);
//				textArea.setText(dao.read(75).getStoryMain());
//				
//				btnChoice[0].setText(Cdao.read(39).getChoiceMain());
//				btnChoice[1].setText(Cdao.read(40).getChoiceMain()); // 정신력 -2
//				btnChoice[2].setText(Cdao.read(41).getChoiceMain());
//				btnChoice[3].setVisible(false);
//				
//				btnChoice[0].addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						try {
//							textArea.setText(dao.read(72).getStoryMain());
//							choicePnl.setVisible(false);
//							// "식량 -3 없으면 체력 -1"
//							System.out.println("식량 -3 없으면 체력 -1");
//						} catch (SQLException e1) {
//							e1.printStackTrace();
//						}
//					}
//				});
//				
//				btnChoice[1].addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						try {
//							textArea.setText(dao.read(73).getStoryMain());
//							choicePnl.setVisible(false);
//							// 스탯 증감 없음
//						} catch (SQLException e1) {
//							e1.printStackTrace();
//						}
//					}
//				});
//				
//				btnChoice[2].addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						try {
//							textArea.setText(dao.read(74).getStoryMain());
//							choicePnl.setVisible(false);
//							// 스탯 증감 없음
//						} catch (SQLException e1) {
//							e1.printStackTrace();
//						}
//					}
//				});
//				
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

// ------------------------------------------------------------------------ //	
	// ev11 낮 GM 이벤트 (StoryId = 46, 47, 49, 51, 52) 배열로 받아서 랜덤 출력
	// 스탯 변화 있음
	public void GmEvDay() {
		Random random = new Random();

		Chapter2StoryDao dao = new Chapter2StoryDaoImpl();
		List<String> gmDay = new ArrayList<String>();

		try {
			gmDay.add(dao.read(46).getStoryMain()); // 정신력 -2
			gmDay.add(dao.read(47).getStoryMain()); // 체력 +1
			gmDay.add(dao.read(49).getStoryMain()); // 정신력 -1
			gmDay.add(dao.read(51).getStoryMain()); // 아이템 효자손 +1
			gmDay.add(dao.read(52).getStoryMain()); // 체력 +1 정신력 +1

		} catch (SQLException e) {
			e.printStackTrace();
		}

		int a = random.nextInt(gmDay.size());
		textArea.setText(gmDay.get(a));

		// 아이템과 스탯 반영하는 부분
		if (a == 0) {
			// 정신력 -2
			System.out.println("정신력 -2");
		}

		if (a == 1) {
			// 체력 +1
			System.out.println("체력 + 1");
		}

		if (a == 2) {
			// 정신력 -1
			System.out.println("정신력 -1");
		}

		if (a == 3) {
			// 아이템 효자손 +
			System.out.println("아이템 효자손 +1");
		}

		if (a == 4) {
			// 체력 +1 정신력 +1
			System.out.println("체력 +1 정신력 +1");
		}
	}

// ------------------------------------------------------------------------ //
	// ev11 밤 GM 이벤트 (StoryId = 45, 48, 50) 배열로 받아서 랜덤 출력
	// 스탯 변화 있음
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

// ------------------------------------------------------------------------ //
	// ev12 밤 (StoryId = 53, 54, 55, 57, 58 )
	// 스탯 변화 있음
	public void nightEv12() {
		Chapter2StoryDao dao = new Chapter2StoryDaoImpl();
		Chapter2ChoiceDao Cdao = new Chapter2ChoiceDaoImpl();

		try {
			textArea.setText(dao.read(53).getStoryMain());
			choicePnl.setVisible(true);

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

// ------------------------------------------------------------------------ //	
	// ev14 밤 (StoryId = 64, 65, 66)
	// 스탯 증감 있음
	// 나오는 확률 조정이 필요할지 테스트 해보기
	public void nightEv14() {

		Chapter2StoryDao dao = new Chapter2StoryDaoImpl();
		Chapter2ChoiceDao Cdao = new Chapter2ChoiceDaoImpl();

		try {
			textArea.setText(dao.read(64).getStoryMain());
			choicePnl.setVisible(true);

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
			}
		});
	}

// ------------------------------------------------------------------------ //	
	// ev15 낮 (StoryId = 68, 69, 70, 71)
	// 정보를 주는 이벤트라서 스탯 증감 없음!!!
	public void nightEv15() {

		Chapter2StoryDao dao = new Chapter2StoryDaoImpl();
		Chapter2ChoiceDao Cdao = new Chapter2ChoiceDaoImpl();

		try {
			textArea.setText(dao.read(67).getStoryMain());
			choicePnl.setVisible(true);

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
			}
		});
	}

// ------------------------------------------------------------------------ //	
	public Chapter2_Screen_YS() {
		// 오타나있어서 고쳤움
		super("Chapter2");

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

//		선택지 시작
		choicePnl = new JPanel();
		choicePnl.setBounds(12, 579, 800, 252);
		pnlTxt2.add(choicePnl);
		choicePnl.setLayout(null);
		choicePnl.setVisible(false);

		int a = 10;
		for (int i = 0; i < btnChoice.length; i++) {
			btnChoice[i] = new JButton("선택지1");
			btnChoice[i].setBounds(12, a, 776, 52);
			a += 62;
			choicePnl.add(btnChoice[i]);
		}
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
//				for (int i = 0; i < 20; i++) {
//					System.out.println(getAstory2(i).getStoryMain());
//					System.out.println("===============================================");
//					System.out.println(getAchoice2(i).getChoiceMain());
//				}
				// 테스트 해본거 그냥 안 지움!

//				GmEvDay(); // 낮은 대수Screen에서 처리하여서 안써도 됨
//				nigntEv10(); // 안나오는 게 맞음

//				GmEvNight();
				nightEv12();
//				nightEv14();
//				nightEv15();

//				대수 Screen에서 사용을 위해 위 메소드 public으로 변경
				startPnl.setVisible(false);
				jsp2.setVisible(true);
			}
		});

		shop = new JButton("상점");
		shop.setBounds(44, 156, 300, 64);
		startPnl.add(shop);

		rest = new JButton("휴식");
		rest.setBounds(44, 230, 300, 64);
		startPnl.add(rest);

		setSize(830, 870);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

	}

	public static void main(String[] args) {
		new Chapter2_Screen_YS().setVisible(true);

	}
}
