package Student;

// 학생 성적 계산기
// 1. 학생 입력은 동적으로 증가
// 2. 성적에 따라 내림차순으로 정렬

import java.util.*;

public class Student {
	public static void main(String [] args) {
		
		Input_Delete_Print std;
		Vector item = new Vector();
		
		while(true) {
			System.out.println("학생성적계산기!!");
			System.out.println("[메뉴]---------------");
			System.out.println("1.입력   2.삭제   3.출력   4.종료");
			
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt(); 
			
			if( input == 1 ) {
				std = new Input_Delete_Print(input);
				item.add(std);
				item.sort(null);
			}
			
			else if( input == 2 ) {
				Scanner scan_01 = new Scanner(System.in);
				System.out.println("이름을 입력해주세요");
				String name_check = scan_01.nextLine();
				
				
				for(int i = 0; i < item.size(); i++ ){
					int check = 0;
					Input_Delete_Print mm = (Input_Delete_Print)item.get(i);
					if(name_check.equals(mm.getName())){
						item.remove(mm); 
						System.out.println("성공적으로 삭제되었습니다.");
						check++;
						if(check == 0) {
							System.out.println("잘 못 입력하였거나 없는 이름입니다.");
						}
					}
				}
			}
			
			else if( input == 3 ) {
				System.out.println("순위\t이름\t국어\t영어\t수학\t총합\t평균" );
				for(int i = 0; i < item.size(); i++ ){
					Input_Delete_Print mm = (Input_Delete_Print)item.get(i);
					  System.out.println((i + 1) + "\t" + mm.getName() + "\t" + mm.getKorean() + "\t" + mm.getEnglish() + "\t" + mm.getMath() + 
							  "\t" + mm.getSum() + "\t" + mm.getAvg() + "\t");
				}
			}
			else if( input == 4 ) {
				break;
			}
		}
	}
}



class Input_Delete_Print implements Comparable<Input_Delete_Print>{
	private String 	name;
	private int    	korean, math, english;
	private int		sum; 
	private double  avg;
	int rank;
	
	Input_Delete_Print(int input) {
		if(input == 1) {
			input();
		}
	}



	// 학생 정보(성적 등) 입력
	private void input() {
		Scanner scan_01 = new Scanner(System.in);
		System.out.print("이름 : ");
		name = scan_01.nextLine();
		
		Scanner scan_02 = new Scanner(System.in);
		System.out.print("국어: ");
		korean = scan_02.nextInt();
		
		Scanner scan_03 = new Scanner(System.in);
		System.out.print("영어: ");
		english = scan_03.nextInt();
	
		Scanner scan_04 = new Scanner(System.in);
		System.out.print("수학: ");
		math = scan_04.nextInt();
		
		calc(korean, english, math);
		calc(sum);
	}
	// 총 합을 구하는 메소드
	private void calc(int korean, int english, int math) {
		sum = korean + english + math;
	}
	
	// 평균을 구하는 메소드 
	private void calc(int sum) {
		avg = sum/3;
	}
	
	// 학생 정보를 가져오는 메소드(이름)
	public String getName() {
		return name = this.name;
	}
	// 학생 정보를 가져오는 메소드(국어)
	public int getKorean() {
		return korean = this.korean;
	}
	// 학생 정보를 가져오는 메소드(영어)
	public int getEnglish() {
		return english = this.english;
	}
	// 학생 정보를 가져오는 메소드(수학)
	public int getMath() {
		return math = this.math;
	}
	// 학생 정보를 가져오는 메소드(총합)
	public int getSum() {
		return sum = this.sum;
	}
	// 학생 정보를 가져오는 메소드(평균)
	public double getAvg() {
		return avg = this.avg;
	}

	@Override
	public int compareTo(Input_Delete_Print arg0) {
		// TODO Auto-generated method stub
		if(this.sum < arg0.sum) {
			return 1;
		}
		else if(this.sum == arg0.sum){
			return 0;
		}
		
		else
			return -1;
	}
	
	
}
