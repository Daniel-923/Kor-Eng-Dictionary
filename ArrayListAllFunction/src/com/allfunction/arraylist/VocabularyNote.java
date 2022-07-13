package com.allfunction.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/*
메뉴

1. 데이터 추가
2. 데이터 수정
3. 데이터 출력


//입력하는 함수
input()
- 입력하면 바로 ArrayList에 add한다.(add함수 호출)

//출력하는 함수
print()
- 1. 배열리스트에 있는 문자열들을 다 출력
- 2. 원하는 문자열만 출력


//ArrayList에 데이터 넣는 함수
add()
- 데이터를 입력하면 배열 뒤에 add한다


//ArrayList에 데이터 삭제 함수
remove()
- 입력한 단어를 arraylist에서 찾아 다른 변수에 옮긴다.
- 빈 공간은 당겨든 밀어서 빈공간을 채운다
- 다른 변수에 옮긴 단어는 삭제한다



//ArrayList에 데이터 수정 함수
correction(a, b)
- 입력한 단어 a를 arraylist에서 찾아 다른 변수에 옮긴다.
- 그리고 a가 있었던 arraylist자리에 b를 할당한다. 
- 다른 변수에 옮긴 단어 a는 삭제한다*/

public class VocabularyNote {

	ArrayList<String> arraylist = new ArrayList<String>(100);

	public void run() {
		while (true) {
			// 메뉴
			int choiceNum = menu();

			switch (choiceNum) {
			case 1:
				// 입력
				save();
				break;
			case 2:
				// 출력
				print();
				break;
			case 3:
				// 삭제
				remove();
				break;
			case 4:
				// 수정
				correction();
				break;

			case 5:
				break;

			default:
				break;
			}

			if (choiceNum == 5)
				break;
		}
	}

	public String input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n" + "수정 예시) 수정하는 단어, 대체할 단어 ");
		System.out.print("단어나 문장을 입력하세요: ");
		String word = scanner.nextLine();
		//scanner.close();

		return word;
	}

	public void save() {
		String wordToSave = input();
		add(wordToSave);
	}

	public void add(String str) {
		arraylist.add(str);
	}

	public void print() {
		//		System.out.print("[");
		//		for (int i = 0; i < arraylist.size(); i++) {
		//			System.out.print(arraylist.get(i));
		//			if (i < arraylist.size() - 1)
		//				System.out.print(", ");
		//		}
		//		System.out.println("]");

		System.out.println(this.arraylist.toString());
	}

	public void remove() {
		String wordToRemove = input();
		arraylist.remove(wordToRemove);
	}

	public void correction() {
		String inputedWords = input();
		String[] inputWordArr = inputedWords.split(", ");
		String wordToCorrection = inputWordArr[0];
		String wordToReplace = inputWordArr[1];

		for (int i = 0; i < arraylist.size(); i++) {
			if (arraylist.get(i).equals(wordToCorrection))
				arraylist.set(i, wordToReplace);
		}
	}

	public int menu() {
		System.out.println("\n" + "번호를 눌러 원하는 기능을 선택하세요");
		System.out.print("1.입력 2.출력 3.삭제 4.수정 5.종료 ---> ");

		Scanner scanner = new Scanner(System.in);
		int choiceNum = scanner.nextInt();
		//scanner.close();

		return choiceNum;
	}

}
