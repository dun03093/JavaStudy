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
		System.out.println("�����ν��� ���� ���� ȯ���մϴ�.");

		while (player.name == null) {
			System.out.print("ĳ������ �̸��� �Է��Ͻʽÿ�(����,8�� �̳�)");
			System.out.print("�Է� : ");
			String tmp = scan.nextLine();
			if (tmp.length() > 8)
				System.out.println("�̸��� �ʹ� ��ϴ�. �ٽ� �Է��� �ֽʽÿ�.");
			else
				player.name = tmp;
		}
		System.out.println("�̸��� �����Ǿ����ϴ�. : " + player.name);
		while (player.tribe == null) {
			System.out.println("ĳ������ ������ ��� �ֽʽÿ�.");
			System.out.println("1.Human 2.Orc 3.Blood elf");
			System.out.print("���� : ");
			int tmp;
			try {
				tmp = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("�߸��� �Է��Դϴ�.");
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
				System.out.println("�߸��� �����Դϴ�.");
				break;
			}
		}
		System.out.println("������ ���õǾ����ϴ�. : " + player.tribe);
		while (player.union == null) {
			System.out.println("ĳ������ ������ ��� �ֽʽÿ�.");
			System.out.println("1.Aliance 2.Horde");
			System.out.print("���� : ");
			int tmp;
			try {
				tmp = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("�߸��� �Է��Դϴ�.");
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
				System.out.println("�߸��� �����Դϴ�.");
				break;
			}
		}
		System.out.println("������ ���õǾ����ϴ�. : " + player.union);
		scan.close();
	}

	public static void ShowPlayerStat(Character_PC player) {
		System.out.println("[player]");
		System.out.println("[�̸�] : " + player.name);
		System.out.println("[����] : " + player.tribe);
	}
}