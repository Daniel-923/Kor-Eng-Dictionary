package com.allfunction.arraylist;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 사전
 * - 단어장과 같은 기능
 * - 검색 기능 (한글 <-> 영어 양방향)
 * - 출력할 때 a, b, c 등 사전 순서대로 출력 (라이브러리)
 *  
 *  # 메뉴
 *  - 단어 입력을 하기 전 1~5번 메뉴를 선택
 *  - 1.단어 등록  2.단어 수정  3.단어 삭제  4.단어 검색  5.단어 출력  
 *  - 메뉴 선택 후 선택한 메뉴로 이동하게 되며 모든 메뉴(함수)에 있는 wordInput(단어 입력)을 이용해 사용자의 입력을 받는다
 *  - 단어 수정인 경우 wordInput()을 호출하기 전 sys.out으로 "새로운 단어를 입력하세요" 라는 문구를 띄우고 wordInput()을 호출한다
 *  
 * # 단어 입력하기
 *  - scanner로 사용자 입력을 받는다
 *  
 * # 단어 등록하기
 *  - scanner 입력 값을 hashmap에 넣어 저장하기
 * 
 * # 단어 수정
 *  - 먼저 바꾸고 싶은 단어가 있는지 조회
 *  - 있으면 새로운 단어를 입력하세요라는 문구를 띄우며 wordInput()을 호출한다
 *  - 이후 입력 값을 hashmap에 넣기 전 새로운 단어가 이미 사전에 조회하기. 있으면 이미 있다고 알림
 *  - 없으면 hashmap에 넣어 수정한 값으로 저장하기 
 * 
 * # 단어 삭제
 *  - 먼저 삭제하고 싶은 단어가 있는지 조회
 *  - 있으면 삭제
 *  - 예) 예를 들어 [사과-apple] 있을 때 사과를 삭제한다면 사과만 없어지는 게 아니라 apple도 없어진다(사과-apple 묶음이 없어짐)
 * 
 * 
 * # 검색 기능
 *  - 예) [사과-apple] 
 *  ## 단어 1개만 검색할 때
 *  	- `사과` 입력 -> 입력한 단어와 그에 해당하는 영단어가 있는지 조회 -> 있으면 출력   
 *  	- 없으면 없다고 알림
 * 	
 * 	## 단어 2개 이상 검색할 때
 * 		- '사과, 바나나, 딸기' 입력 -> 입력한 단어와 해당하는 영단어들이 있는지 조회 -> 있으면 출력
 * 		- 검색 기능으로 '바나나, 딸기, 사과' 순으로 입력 -> 출력할 때 입력한 순으로 출력하기
 * 
 * 
 * # 출력 기능
 * 	## 전체 출력
 *  	- 출력하는 단어가 하나일 때 그냥 출력
 *  	- 2개 이상일 때 a, b, c 등 사전 순서대로 출력 -> 해당 라이브러리 참조하기 (Comparator)
 *  
 *  abc
 *  acd
 *  char a = 'a', b= 'b';
 *  sysout(a < b);
 */

public class WordDictionary {

	HashMap<String, String> hashmap = new HashMap<String, String>();
	//	ArrayList<Word> words; -> 나중에 list로 해보기. 다른 클래스를 만들어 참고
	// 자주 사용하는 함수나 변수를 클래스에 만들어서 그것을 jar파일로 만든 후 bulid path에 add해서 사용해보기

	public String wordInput() {

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		return input;
	}

	public void wordRegister() {

		System.out.print("등록할 단어를 입력하세요: ");
		String wordReg = wordInput();

		String[] inputWordArr = wordReg.split(", ");
		String korean = inputWordArr[0];
		String engilsh = inputWordArr[1];

		hashmap.put(korean, engilsh);

		System.out.println("현재 등록한 단어는 " + korean + "이며 " + korean + "의 뜻은 " + hashmap.get(korean) + "입니다.\n");

	}

	public void wordCorrection() {
		while (true) {
			System.out.print("수정할 단어를 입력하세요: ");
			String wordCor = wordInput();

			if (!hashmap.containsKey(wordCor))
				break;

			hashmap.remove(wordCor);
			wordRegister();
			break;
		}
	}

	public void wordRemove() {
		while (true) {
			System.out.print("삭제할 단어를 입력하세요: ");
			String wordRem = wordInput();

			if (!hashmap.containsKey(wordRem)) {
				System.out.println("해당하는 단어는 없습니다\n");
				break;
			}

			System.out.println("현재 삭제한 단어는 " + wordRem + "이며 " + wordRem + "의 뜻은 " + hashmap.get(wordRem) + "였습니다.\n");

			hashmap.remove(wordRem);
			break;
		}
		//		if (hashmap.containsKey(wordRem)) {
		//			System.out.println(
		//					"현재 삭제한 단어는 " + wordRem + "이며 " + wordRem + "의 뜻은 " + hashmap.get(wordRem) + "였습니다.\n");
		//			hashmap.remove(wordRem);
		//			break;
		//		}
		//		System.out.println("해당하는 단어는 없습니다\n");

	}

	public void wordPrint() {

		while (true) {
			if (hashmap.isEmpty()) {
				System.out.println("비어있습니다.\n");
				break;
			} else if (hashmap.size() == 1) {
				System.out.println(hashmap.toString() + "\n");
				System.out.println("1개 단어만 출력합니다\n");
				break;
			} else if (hashmap.size() >= 2) {

			}

		}
	}

	public void wordSearch() {

		System.out.print("검색할 단어를 입력하세요: ");
		String wordSea = wordInput();

		String[] inputWordArr = wordSea.split(", ");

		System.out.print("[");
		for (String s : inputWordArr) {
			System.out.print(hashmap.get(s));
			if (s != inputWordArr[inputWordArr.length - 1]) {
				System.out.print(", ");
			}
		}
		System.out.println("]");

		//		String[] constantName = { "first", "second", "third", "fourth", "fifth" };
		//
		//		for (int i = 0; i < constantName.length; i++) {
		//			if (inputWordArr[i].equals(null)) {
		//				constantName[i] = null;
		//				break;
		//			}
		//			constantName[i] = inputWordArr[i];
		//		}
		//
		//		for (int i = 0; i < constantName.length; i++) {
		//			if (constantName[i].equals(null))
		//				break;
		//			System.out.println(hashmap.get(constantName[i]));
	}

	public void help() {
		System.out.println("이 사전은 한영사전입니다.");
		System.out.println("등록 예시) 1. 등록할 단어 '사과, apple' 입력 ");
		System.out.println("수정 예시) 1. 수정할 단어 '딸기' 입력  2. 새로운 단어 '바나나, banana' 입력");
		System.out.println("삭제 예시) 1. 삭제할 단어 '오렌지' 입력");
		System.out.println("검색 예시) 1. 검색할 단어 '바나나' or '바나나, 딸기, 오렌지' 최대 5개 입력 가능");
		System.out.println("출력: 현재까지 등록된 단어들 알파벳 순서대로 출력");
	}

	public void run() {
		while (true) {
			// 도움말
			help();

			// 메뉴
			int choiceNum = menu();

			switch (choiceNum) {
			case 1:
				// 등록
				wordRegister();
				break;
			case 2:
				// 수정
				wordCorrection();
				break;
			case 3:
				// 삭제
				wordRemove();
				break;
			case 4:
				// 검색
				wordSearch();
				break;

			case 5:
				wordPrint();
				break;

			case 6:
				break;

			default:
				break;
			}

			if (choiceNum == 6)
				break;
		}
	}

	public int menu() {
		System.out.println("\n" + "번호를 눌러 원하는 기능을 선택하세요");
		System.out.print("1.등록 2.수정 3.삭제 4.검색 5.출력 6.종료 ---> ");

		Scanner scanner = new Scanner(System.in);
		int choiceNum = scanner.nextInt();
		System.out.println("\n");
		//scanner.close();

		return choiceNum;
	}

	//	 * # 출력 기능
	//	 * 	## 전체 출력
	//	 *  	- 출력하는 단어가 하나일 때 그냥 출력
	//	 *  	- 2개 이상일 때 a, b, c 등 사전 순서대로 출력 -> 해당 라이브러리 참조하기 (Comparator)
	//	 *  	- 현재까지 등록된 단어들 알파벳 순서대로 출력

}

//class Word {
//	String korean;
//	String english;
//	
//	
//}
