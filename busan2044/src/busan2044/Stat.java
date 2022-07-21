package busan2044;

import java.util.Random;
import java.util.Scanner;

public class Stat {

	// 스탯(상태이상, 컨디션 등)

	private int str = 100, hp = 100, agi = 100, mental = 100; // 스탯: 힘, 체력, 민첩, 정신력
	private int hunger, warter; // 배고픔 정도, 수분 정도
	private String stun = "기절", h_ger = "굶주림", w_ter = "탈수", fracture = "골절", scare = "공포", drain = "탈진", die = "사망";
	// 상태이상: 기절, 굶주림, 탈수, 골절, 공포, 탈진, 사망

	public void toBeAilment(String ailment) { // 감소 시킬 stat에 받은 minus(데미지, 적으로부터 받은 영향(좀비를 마주치니 mental 감소, 골절 상태이상으로 인한 agi 감소 등))
		
		Random rand = new Random();
		
		switch (ailment) {
		case "기절": {
			System.out.println("기절하였습니다.");
			break;
		}
		case "굶주림": {
			int ran = rand.nextInt(15) + 1;
			System.out.println("굶주림으로 인해 체력과 정신력이 "+ran+"만큼 감소하였습니다.");
			hp -= ran;
			mental -= ran;
			break;
		}
		case "탈수": {
			int ran = rand.nextInt(20) + 5;
			System.out.println("탈수로 인해 체력과 정신력이 "+ran+"만큼 감소하였습니다.");
			hp -= ran;
			mental -= ran;
			break;
		}
		case "골절": {
			int ran = rand.nextInt(20) + 5;
			System.out.println("골절로 인해 민첩이 "+ran+"만큼 감소하였습니다.");
			agi -= ran;
			break;
		}
		case "공포": {
			System.out.println("공포에 걸렸습니다.");
			break;
		}
		case "탈진": {
			int ran = rand.nextInt(50) + 20;
			System.out.println("탈진으로 인해 정신력이 "+ran+"만큼 감소하였습니다.");
			mental -= ran;
			break;
		}
		case "사망": {
			System.out.println("당신은 사망하였습니다.");
		}
		}
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		Stat st = new Stat();

		
		
		int a;
		String ailment;
		
		System.out.println("전투 진입");
		
		do {
			int num = rand.nextInt(7) + 1;

			switch (num) {
			case 1: {
				ailment = "기절";
				break;
			}
			case 2: {
				ailment = "굶주림";
				break;
			}
			case 3: {
				ailment = "탈수";
				break;
			}
			case 4: {
				ailment = "골절";
				break;
			}
			case 5: {
				ailment = "공포";
			}
			case 6: {
				ailment = "탈진";
			}
			default:
				ailment = "사망";
				break;
			}
			
			st.toBeAilment(ailment);
			
			System.out.println(st.toString());
			
			System.out.println("*0 입력 시 전투 진행*");
			a = sc.nextInt();

		} while (a == 0);

	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAgi() {
		return agi;
	}

	public void setAgi(int agi) {
		this.agi = agi;
	}

	public int getMental() {
		return mental;
	}

	public void setMental(int mantal) {
		this.mental = mantal;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getWarter() {
		return warter;
	}

	public void setWarter(int warter) {
		this.warter = warter;
	}

	public String getStun() {
		return stun;
	}

	public void setStun(String stun) {
		this.stun = stun;
	}

	public String getH_ger() {
		return h_ger;
	}

	public void setH_ger(String h_ger) {
		this.h_ger = h_ger;
	}

	public String getW_ter() {
		return w_ter;
	}

	public void setW_ter(String w_ter) {
		this.w_ter = w_ter;
	}

	public String getFracture() {
		return fracture;
	}

	public void setFracture(String fracture) {
		this.fracture = fracture;
	}

	public String getScare() {
		return scare;
	}

	public void setScare(String scare) {
		this.scare = scare;
	}

	public String getDrain() {
		return drain;
	}

	public void setDrain(String drain) {
		this.drain = drain;
	}

	public String getDie() {
		return die;
	}

	public void setDie(String die) {
		this.die = die;
	}


	@Override
	public String toString() {
		return "Stat [str=" + str + ", hp=" + hp + ", agi=" + agi + ", mental=" + mental + ", hunger=" + hunger
				+ ", warter=" + warter + "]";
	}

}
