package edu.diaz.rockpapersicssors;

import java.util.Scanner;
/**
 * 程序主入口
 * @author Diaz
 *
 */
public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("******************");
		System.out.println("**猜拳，开始**");
		System.out.println("******************");
		System.out.println();
		System.out.println("出拳规则：1.剪刀  2.石头 3。布");
		System.out.print("请选择对方角色(1.刘备 2.曹操 3.孙权):");
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
			System.out.println("输入有误");
			return;
		}
		GameProcess gameProcess = new GameProcess(npc);

	}

}
