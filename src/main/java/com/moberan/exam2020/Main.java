package com.moberan.exam2020;

import com.moberan.exam2020.lib.Task;
import com.moberan.exam2020.lib.TestLibrary;

public class Main {

	public static void main(String[] args) {
		String result = tasks();
		System.out.println(result);
	}

	private static String tasks(){

		TestLibrary lib = new TestLibrary();

		final String[] result = new String[1];

		lib.firstTask(new Task() {
			@Override
			public void taskCallback(String s) {
				 result[0] = lib.secondTask(s);
			}
		});

		while(result[0]==null) { //firstTask의 쓰레드가 종료되고 secondTask가 호출될때까지 대기
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// FIXME always null.
		return result[0];
	}
}
