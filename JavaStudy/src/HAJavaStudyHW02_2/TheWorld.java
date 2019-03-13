package HAJavaStudyHW02_2;

import java.util.*;

class TheWorld {
	public static void main(String[] args) {

		Character_PC player = new Character_PC(null);

		StartWorld(player);
		ShowPlayerStat(player);
		
		player.WarCry();
		player.Talk("Hello!");
	}

	private static void StartWorld(Character_PC player) {

		Scanner scan = new Scanner(System.in);
		System.out.println("아제로스에 오신 것을 환영합니다.");

		while (player.name == null) {
			System.out.print("캐릭터의 이름을 입력하십시오(영어,8자 이내)");
			System.out.print("입력 : ");
			String tmp = scan.nextLine();
			if (tmp.length() > 8)
				System.out.println("이름이 너무 깁니다. 다시 입력해 주십시오.");
			else
				player.name = tmp;
		}
		System.out.println("이름이 설정되었습니다. : " + player.name);
		while (player.tribe == null) {
			System.out.println("캐릭터의 종족을 골라 주십시오.");
			System.out.println("1.Human 2.Orc 3.Blood elf");
			System.out.print("선택 : ");
			int tmp;
			try {
				tmp = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			switch (tmp) {
			case 1:
				player.tribe = "Human";
				break;
			case 2:
				player.tribe = "Orc";
				break;
			case 3:
				player.tribe = "Blood elf";
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
		System.out.println("종족이 선택되었습니다. : " + player.tribe);
		while (player.union == null) {
			System.out.println("캐릭터의 진영을 골라 주십시오.");
			System.out.println("1.Aliance 2.Horde");
			System.out.print("선택 : ");
			int tmp;
			try {
				tmp = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			switch (tmp) {
			case 1:
				player.union = "Aliance";
				break;
			case 2:
				player.union = "Horde";
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
		System.out.println("진영이 선택되었습니다. : " + player.union);
		scan.close();
	}

	public static void ShowPlayerStat(Character_PC player) {
		System.out.println("[player]");
		System.out.println("[이름] : " + player.name);
		System.out.println("[종족] : " + player.tribe);
	}
}