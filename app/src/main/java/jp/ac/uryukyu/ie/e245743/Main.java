package jp.ac.uryukyu.ie.e245743;

import java.util.Scanner;

/**
 * Mainクラス。CalenderAppクラスを通じてカレンダーアプリを起動する。
 */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    EventManager eventManager = new EventManager(scanner);
    Calender calender = new Calender();
    //EventManagerクラスのメソッドのテスト

    calender.showCalender(2025, 1);
    System.out.println();
    calender.showCalender(2025,2);
    eventManager.addEvent();
    eventManager.addEvent();
    eventManager.addEvent();

    eventManager.removeEvent();
    eventManager.removeEvent();
    eventManager.removeEvent();

    eventManager.addEvent();
    eventManager.addEvent();
    
    eventManager.showEvent();

  }
}