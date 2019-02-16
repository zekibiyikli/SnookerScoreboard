import java.util.Scanner;

public class Main {

	static Scanner input;
	static String player1,player2;
	static int p1Score=0,p2Score=0,p1Ball=0,p2Ball=0;
	static int turn=1;
	static int value;
	
	public static void main(String[] args) {
		input=new Scanner(System.in);
		
		System.out.print("1. Player Name: ");
		player1=input.next();
		System.out.print("2. Player Name: ");
		player2=input.next();
		
		System.out.println();
		System.out.println("1 => Got it");
		System.out.println("2 => Don't Got it");
		
		writeScoreBoard();
	}
	
	public static void writeScoreBoard() {
		System.out.println();
		System.out.println(player1+"     "+p1Score+" | "+p1Ball);
		System.out.println(player2+"     "+p2Score+" | "+p2Ball);
		
		try {
			if(turn==1) {
				System.out.println();
				System.out.println("Is "+player1+" got the Score?");
				value=input.nextInt();
				score(value);
			}else if(turn==2) {
				System.out.println();
				System.out.println("Is "+player2+" got the Score?");
				value=input.nextInt();
				score(value);
			}
		}catch(Exception e) {
			System.out.println("Wrong Key");
		}		
	}
	
	public static void score(int i) {
		if(i==1) {
			if(turn==1) {
				p1Ball++;
				checkResult();
			}else if(turn==2) {
				p2Ball++;
				checkResult();
			}
		}else if(i==2) {
			if(turn==1) {
				p1Score=p1Score+p1Ball;
				p1Ball=0;
				turn=2;
				writeScoreBoard();
			}else if(turn==2) {
				p2Score=p2Score+p2Ball;
				p2Ball=0;
				turn=1;
				writeScoreBoard();
			}
		}else {
			System.out.println();
			System.out.println("Wrong Key");
			writeScoreBoard();
		}
	}
	
	public static void checkResult() {
		if(p1Score+p1Ball==40) {
			System.out.println();
			System.out.println(player1+"    "+(p1Score+p1Ball));
			System.out.println(player2+"    "+(p2Score+p2Ball));
			System.out.println();
			System.out.println(player1+" WIN");
		}else if(p2Score+p2Ball==40) {
			System.out.println();
			System.out.println(player1+"    "+(p1Score+p1Ball));
			System.out.println(player2+"    "+(p2Score+p2Ball));
			System.out.println();
			System.out.println(player2+" WIN");
		}else {
			writeScoreBoard();
		}
	}

}
