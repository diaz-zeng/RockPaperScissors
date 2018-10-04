package edu.diaz.rockpapersicssors;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/**
 * ��Ϸ����
 * @author Diaz
 *
 */
public class GameProcess
{
	private NPC competitors = null;//�˻�����
	String npcName = "";//��ɫ����
	int playerPoint = 0, npcPoint = 0, rounds = 0;//���ּ��غ���

	/**
	 * ���캯��
	 * @param competitors Ҫѡ��Ķ�ս��ɫ
	 */
	public GameProcess(NPC competitors)
	{
		// TODO Auto-generated constructor stub
		if (null == this.competitors)
		{
			this.competitors = competitors;
			switch (competitors)
			{
			case LiuXuande:
			{
				npcName = "����";
				break;
			}
			case CaoXuande:
			{
				npcName = "�ܲ�";
				break;
			}
			case SunZhongmou:
			{
				npcName = "��Ȩ";
				break;
			}
			default:
				break;
			}
			System.out.println("��ѡ����" + npcName);
			userOptional(true);

		}

	}

	
	/**
	 * �Ƿ����
	 * @param isFirst �Ƿ��ǵ�һ����Ϸ
	 */
	private void userOptional(boolean isFirst)
	{
		System.out.println((isFirst ? "Ҫ��ʼ��?" : "Ҫ��ʼ��һ����?") + "(y/n)");
		if ("y".equals(new Scanner(System.in).nextLine()))
		{
			gaming();
		} else
		{
			theEnd();
		}
	}

	
	/**
	 * ��Ϸ����
	 */
	private void gaming()
	{
		System.out.print("���ȭ(1.����  2.ʯͷ 3����):");
		try
		{

			int playerOrder = new Scanner(System.in).nextInt();
			if (playerOrder >= 1 && playerOrder <= 3)
			{
//				int npcOrder = (Math.random() * 10 % 2) == 0 ? 1 : (Math.random() * 10 % 2) == 0 ? 2 : 3;
				int r1 = Math.abs(new Random().nextInt());
				int r2 = Math.abs(new Random().nextInt());
				int npcOrder = r1 % 10 > 5 ? 1 : r2 % 10 < 5 ? 2 : 3;
				System.out.println("���ȭ:" + (playerOrder == 1 ? "����" : playerOrder == 2 ? "ʯͷ" : "��"));
				System.out.println(npcName + "��ȭ:" + (npcOrder == 1 ? "����" : npcOrder == 2 ? "ʯͷ" : "��"));
				if (playerOrder == npcOrder)
				{
					npcPoint += 1;
					playerPoint += 1;
					System.out.println("�;���");
				} else if ((1 == npcOrder && 2 == playerOrder) || (2 == npcOrder && 3 == playerOrder)
						|| (3 == npcOrder && 1 == playerOrder))
				{
					System.out.println("��Ӯ��");
					playerPoint += 3;
				} else if ((2 == npcOrder && 1 == playerOrder) || (3 == npcOrder && 2 == playerOrder)
						|| (1 == npcOrder && 3 == playerOrder))
				{
					npcPoint += 3;
					System.out.println("������");
				}
				rounds += 1;
				userOptional(false);
			} else
			{
				throw new InputMismatchException();
			}
		} catch (InputMismatchException e)
		{
			// TODO: handle exception
			System.out.println("������������������");
			this.gaming();
		}
	}
	/**
	 * ������Ϸ
	 */
	private void theEnd()
	{
		System.out.println("���� VS " + npcName);
		System.out.println("��ս�غ�:" + rounds);
		System.out.println("���:" + npcName + "�÷�:" + npcPoint + ",��÷�:" + playerPoint + "\t"
				+ (npcPoint >= playerPoint ? "���´�Ŭ��!" : "��ϲ��ϲ!"));
		return;
	}
}
