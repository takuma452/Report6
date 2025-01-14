package jp.ac.uryukyu.ie.e245743;

import java.time.LocalDate;

/**
 * カレンダーの表示をするクラス。
 */
public class Calender {

  int year;
  int month;

   public void showCalender(){
    LocalDate today = LocalDate.now();
    int year = today.getYear();
    int month = today.getMonthValue();
   }
}
