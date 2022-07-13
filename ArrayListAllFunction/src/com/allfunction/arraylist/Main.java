package com.allfunction.arraylist;

public class Main {

	//	 [주문]
	//			 * - ArrayList 사용해서 구현
	//			 * - 단어 띄어쓰기 포함해서 저장
	//			 * - 입력, 출력, 삭제, 수정 기능
	//			 * - 레이블 -> 예) ABC: while()  ...  break ABC;
	//			 */

	/*
	 * 사전
	 * - 단어장과 같은 기능
	 * - 검색 기능 (한글 <-> 영어 양방향)
	 * - 출력할 때 a, b, c 등 사전 순서대로 출력 (라이브러리)
	 * 
	 */
	public static void main(String[] args) {

		//	VocabularyNote wordNote = new VocabularyNote();
		WordDictionary wordDic = new WordDictionary();
		wordDic.run();
		//wordNote.run();
	}

}
