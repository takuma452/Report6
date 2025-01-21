package jp.ac.uryukyu.ie.e245743;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.DateTimeException;
import java.time.DayOfWeek;

/**
 * 指定した年月のカレンダーをするクラス。
 */
public class Calender {
  Scanner scanner = new Scanner(System.in);

  /**
   * ユーザーが指定した年月のカレンダーを表示するメソッド。
   */
  public void showCalender(){
      try{System.out.print("指定した年月のカレンダーを表示します。\n西暦を入力してください。:");
          int year = scanner.nextInt();
          scanner.nextLine(); //改行バッファを削除
          System.out.print("月を入力してください。:");
          int month = scanner.nextInt();
          scanner.nextLine();
          YearMonth yearMonth = YearMonth.of(year, month);
        
          //月の初日を取得
          LocalDate firstDay = yearMonth.atDay(1);

          //初日の曜日を取得。MONDAY,SUNDAY等の定数を取得できる。
          DayOfWeek firstDayWeek = firstDay.getDayOfWeek(); 
          //指定した月の日数を取得
          int totalDays = yearMonth.lengthOfMonth();
          //カレンダーの曜日を保存
          String[] Weeks= {"Sun", "Mon", "The", "Wed", "Thu", "Fri", "Sta"};

          //カレンダーの年月を表示
          System.out.println(yearMonth);
          //カレンダーの曜日を表示
          for(String Week : Weeks){
            System.out.print(Week + " ");
          }
          System.out.println();
          //初日の曜日を値として取得。日曜日から土曜日まで0~6の値になるように設定
          int firstDayWeekValue = firstDayWeek.getValue() % 7;
          //1行目の初日の曜日までを空白で埋める
          for(int i=0; i<firstDayWeekValue; i++){
            System.out.print("    ");
          }

          //カレンダーの日付を表示
          for(int day=1; day<=totalDays; day++){
            //一つの日付を三桁の幅で表示するように書式設定し、出力。
            System.out.printf("%3d", day);
            System.out.print(" ");
            if((firstDayWeekValue + day) % 7 == 0){
              System.out.println(); //改行し、カレンダーの下部と他の文字が重ならないようにする。
            }
          }
          System.out.println();
      }catch(DateTimeException e){
      System.out.println("無効な日付です。再度お試しください。");
      scanner.nextLine();//バッファを削除
      } catch(InputMismatchException e){
      System.out.println("無効な値です。数値を入力してください");
      scanner.nextLine();//バッファを削除
      }
  } 
}
