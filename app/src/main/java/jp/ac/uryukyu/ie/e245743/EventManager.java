package jp.ac.uryukyu.ie.e245743;

import java.util.ArrayList;
import java.util.Scanner;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * 日付を指定して予定を作成したり、削除したりなど予定の管理をするクラス。
 */

public class EventManager {
  ArrayList<String> Events;
  Scanner scanner;

  EventManager(Scanner scanner){
    this.scanner = scanner;
    this.Events = new ArrayList<>();
  }

  /**
   * addEventメソッド。
   * 日付(西暦,月,日)とイベントを入力させ、Eventsリストに予定として追加する。
   */

  public void addEvent(){
    try{
      System.out.print("西暦を入力してください:");
      int year = scanner.nextInt();
      System.out.print("月を入力してください:");
      int month = scanner.nextInt();
      System.out.print("日を入力してください:");
      int day = scanner.nextInt();
      LocalDate date = LocalDate.of(year,month,day);
      System.out.print("予定を入力してください:");
      scanner.nextLine(); //改行文字バッファを削除
      String inputEvent = scanner.nextLine();
      //Eventsリストに予定を追加する。
      this.Events.add(date + "---" + inputEvent);
      System.out.println("下記の予定を追加しました\n" + "---" + date + "---" + "\n"
        +inputEvent + "\n");
      System.out.println("現在の予定一覧を表示します");
      int count = 0;
      for(String event : Events){
        count += 1;
        System.out.print(count + ":" + event + "\n");
      }
    } catch(DateTimeException e){
      System.out.println("無効な日付です。再度お試しください。");
      } catch(Exception e){
      System.out.println("エラーが発生しました:" + e.getMessage());
      }
  }

  /**
   * removeEventメソッド。
   * Eventsリストの追加済みの予定を指定し、削除する。
   */
  public void removeEvent(){
    try{
      if(Events.size() == 0){
        System.out.println("現在、予定がありません。");
        return;
      }
      System.out.print("削除する予定の番号を選択してください。");
      int count = 0;
      for(String event : Events){
        count += 1;
        System.out.println(count + ":" + event + "\n");
      }
      int number = scanner.nextInt();
      String removedEvent = Events.get(number - 1);
      //Eventsリストから指定の予定を削除する。
      Events.remove(number - 1);
      System.out.println(removedEvent + "の予定を削除しました。");
      } catch(IndexOutOfBoundsException e){
        System.out.println("無効な値です。再度お試しください。");
        } catch(Exception e){
        System.out.println("エラーが発生しました。" + e.getMessage());
        }
  }

  /**
   * showEventメソッド。Eventsリストの予定一覧を表示する。
   */
  public void showEvent(){
    if(Events.size() == 0){
      System.out.println("現在、予定がありません。");
      return;
    }
    System.out.println("現在の予定一覧を表示します。");
    int count = 0;
    for(String event : Events){
      count += 1;
      System.out.println(count + ":" + event);
    }
  }
}
