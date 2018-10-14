package edu.diaz.rockpapersicssors;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/**
 * 游戏过程
 * @author Diaz
 *
 */
public class GameProcess
{
	private NPC competitors = null;//人机对象
	String npcName = "";//角色名称
	int playerPoint = 0, npcPoint = 0, rounds = 0;//积分及回合数

	/**
	 * 构造函数
	 * @param competitors 要选择的对战角色
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
				npcName = "刘备";
				break;
			}
			case CaoXuande:
			{
				npcName = "曹操";
				break;
			}
			case SunZhongmou:
			{
				npcName = "孙权";
				break;
			}
			default:
				break;
			}
			System.out.println("你选择了" + npcName);
			userOptional(true);

		}

	}

	
	/**
	 * 是否继续
	 * @param isFirst 是否是第一次游戏
	 */
	private void userOptional(boolean isFirst)
	{
		System.out.println((isFirst ? "要开始吗?" : "要开始下一轮吗?") + "(y/n)");
		if ("y".equals(new Scanner(System.in).nextLine()))
		{
			gaming();
		} else
		{
			theEnd();
		}
	}

	
	/**
	 * 游戏过程
	 */
	private void gaming()
	{
		System.out.print("请出拳(1.剪刀  2.石头 3。布):");
		try
		{

			int playerOrder = new Scanner(System.in).nextInt();
			if (playerOrder >= 1 && playerOrder <= 3)
			{
//				int npcOrder = (Math.random() * 10 % 2) == 0 ? 1 : (Math.random() * 10 % 2) == 0 ? 2 : 3;
				int r1 = Math.abs(new Random().nextInt());
				int r2 = Math.abs(new Random().nextInt());
				int npcOrder = r1 % 10 > 5 ? 1 : r2 % 10 < 5 ? 2 : 3;
				System.out.println("你出拳:" + (playerOrder == 1 ? "剪刀" : playerOrder == 2 ? "石头" : "布"));
				System.out.println(npcName + "出拳:" + (npcOrder == 1 ? "剪刀" : npcOrder == 2 ? "石头" : "布"));
				if (playerOrder == npcOrder)
				{
					npcPoint += 1;
					playerPoint += 1;
					System.out.println("和局了");
				} else if ((1 == npcOrder && 2 == playerOrder) || (2 == npcOrder && 3 == playerOrder)
						|| (3 == npcOrder && 1 == playerOrder))
				{
					System.out.println("你赢了");
					playerPoint += 3;
				} else if ((2 == npcOrder && 1 == playerOrder) || (3 == npcOrder && 2 == playerOrder)
						|| (1 == npcOrder && 3 == playerOrder))
				{
					npcPoint += 3;
					System.out.println("你输了");
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
			System.out.println("输入有误，请重新输入");
			this.gaming();
		}
	}
	/**
	 * 结束游戏
	 */
	private void theEnd()
	{
		System.out.println("匿名 VS " + npcName);
		System.out.println("对战回合:" + rounds);
		System.out.println("结果:" + npcName + "得分:" + npcPoint + ",你得分:" + playerPoint + "\t"
				+ (npcPoint >= playerPoint ? "请下次努力!" : "恭喜恭喜!"));
		return;
	}
}
