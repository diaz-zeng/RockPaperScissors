package edu.diaz.rockpapersicssors;

import java.util.Scanner;
/**
 * ���������
 * @author Diaz
 *
 */
public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("******************");
		System.out.println("**��ȭ����ʼ**");
		System.out.println("******************");
		System.out.println();
		System.out.println("��ȭ����1.����  2.ʯͷ 3����");
		System.out.print("��ѡ��Է���ɫ(1.���� 2.�ܲ� 3.��Ȩ):");
		NPC npc = null;
		switch (new Scanner(System.in).nextInt())
		{
		case 1:
		{
			npc = npc.LiuXuande;
			break;
		}

		case 2:
		{
			npc = npc.CaoXuande;
			break;
		}
		case 3:
		{
			npc = npc.SunZhongmou;
			break;
		}
		default:
			System.out.println("��������");
			return;
		}
		GameProcess gameProcess = new GameProcess(npc);

	}

}
