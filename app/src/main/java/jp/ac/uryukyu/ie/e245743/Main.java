package jp.ac.uryukyu.ie.e245743;

import java.util.Scanner;

/**
 * Mainクラス。CalenderAppクラスを通じてカレンダーアプリを起動する。
 */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    EventManager eventManager = new EventManager(scanner);
    //EventManagerクラスのメソッドのテスト
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