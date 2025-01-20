package jp.ac.uryukyu.ie.e245743;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.DayOfWeek;

/**
 * 指定した年月のカレンダーをするクラス。
 */
public class Calender {

  public void showCalender(int year, int month){
    YearMonth yearMonth = YearMonth.of(year, month);
    
    //月の初日を取得
    LocalDate firstDay = yearMonth.atDay(1);

    //初日の曜日を取得
    DayOfWeek firstDayWeek = firstDay.getDayOfWeek();
    //指定した月の日数を取得
    int totalDays = yearMonth.lengthOfMonth();
    //カレンダーの曜日を保存
    String[] Weeks= {"Sun", "Mon", "The", "Wed", "Thu", "Fri", "Sta"};

    System.out.println(yearMonth);
    //カレンダーの曜日を表示
    for(String Week : Weeks){
      System.out.print(Week + " ");
    }
    System.out.println();
    //初日の曜日を値として取得。
    int firstDayWeekValue = firstDayWeek.getValue() % 7;
    for(int i=0; i<firstDayWeekValue; i++){
      System.out.print("    ");
    }

    //カレンダーの日付を表示
    for(int day=1; day<=totalDays; day++){
      //一つの整数を三桁の幅で表示する。
      System.out.printf("%3d", day);
      System.out.print(" ");
      if((firstDayWeekValue + day) % 7 == 0){
        System.out.println();
      }
    }
  }
}
