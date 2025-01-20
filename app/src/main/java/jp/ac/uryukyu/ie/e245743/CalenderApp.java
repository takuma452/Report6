package jp.ac.uryukyu.ie.e245743;
import java.util.Scanner;

/**
 * カレンダーアプリのUIを作成するクラス。
 */
public class CalenderApp {
  Scanner scanner = new Scanner(System.in);
  Calender calender = new Calender();
  EventManager eventManager = new EventManager(scanner);

  /**
   * カレンダーアプリのUIを表示する。ユーザーには1-5の選択肢がある。
   */
  public void calenderUI(){
    while(true){
      System.out.println("---カレンダーアプリ---");
      System.out.println("[1] カレンダーを表示");
      System.out.println("[2] 予定を表示");
      System.out.println("[3] 予定を作成");
      System.out.println("[4] 予定を削除");
      System.out.println("[5] アプリを終了");
      System.out.println("選択してください (1-5)");

      int choice = scanner.nextInt();
      scanner.nextLine();//改行バッファを削除

      switch(choice){
        case 1:
          //指定した年月のカレンダーを表示する
          calender.showCalender();
          break;

        case 2:
          //予定を表示する。
          eventManager.showEvent();
          break;

        case 3:
          //予定を作成する。
          eventManager.addEvent();
          break;

        case 4:
          //予定を削除する。
          eventManager.removeEvent();
          break;

        case 5:
          //アプリを終了する。
          System.out.println("アプリを終了します。");
          scanner.close();
          return;

        //上記の番号以外の場合は以下の処理を行う。
        default:
          System.out.println("無効な選択です。1から5までの数字を入力してください。");
      }
    }
  }
}
