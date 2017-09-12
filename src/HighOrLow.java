import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class HighOrLow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		//int[] number = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		int setNumber = rand.nextInt(13) + 1;
		int highlow = 0;
		int save = 0;
		int winCount = 0;
		
		System.out.println("higi&lowゲームをします。");
		System.out.println("最初の数字は" + setNumber + "です。");
		while(true){
			save = setNumber;
			setNumber = rand.nextInt(13) + 1;
			while(true){
				if(save == setNumber){
					setNumber = rand.nextInt(13) + 1;
					continue;
				}
				break;
			}
				
			System.out.println("次の数字がhighかlowを予想して選択してください。");
			System.out.print("high:0 low:1 :");
			try{
				while(true){
					highlow = sc.nextInt();
					if(highlow == 0 || highlow == 1){
						break;
					}
					System.out.println("0か1を選択してください。");
					System.out.print("high:0 low:1 :");
				}
			}catch(InputMismatchException e){
				System.out.println("数字を選択してください。");
			}
			if(highlow == 0){
				System.out.println("あなたはhighを選択しました。");
				if(setNumber > save){
					System.out.println("選ばれた数字は" + setNumber + "でした。");
					System.out.println("当たりです!!");
					System.out.println("次の数字は" + setNumber + "です。");
					winCount++;
				}else if(setNumber < save){
					System.out.println("選ばれた数字は" + setNumber + "でした。");
					System.out.println("ハズレです...");
					break;
				}
			}else if(highlow == 1){
				System.out.println("あなたはlowを選択しました。");
				if(setNumber > save){
					System.out.println("選ばれた数字は" + setNumber + "でした。");
					System.out.println("ハズレです...");
					break;
				}else if(setNumber < save){
					System.out.println("選ばれた数字は" + setNumber + "でした。");
					System.out.println("当たりです!!");
					System.out.println("次の数字は" + setNumber + "です。");
					winCount++;
				}
			}
		}
		System.out.println("あなたは" + winCount + "回当てることができました。");
		sc.close();
	}
}
