package jp.ac.uryukyu.ie.e245743;

import org.junit.jupiter.api.Test;
import java.util.Scanner;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * EventManagerの機能をテストするクラス。
 * addEventメソッドとremoveメソッドのテストを行う。
 */

class EventManagerTest {
  @Test
  /**
   * addEventの正常系動作を検証するテスト。
   */
  void addEventTest(){
    //addEventで入力するScannerのモックを作成
    Scanner mockScanner = Mockito.mock (Scanner.class); 
    when(mockScanner.nextInt()).thenReturn(2025).thenReturn(2).thenReturn(15);
    when(mockScanner.nextLine()).thenReturn("").thenReturn("TestEvent");
    
    //EventManagerにScannerのモックを注入する。
    EventManager eventManager = new EventManager(mockScanner); 
    eventManager.addEvent(); 
    String expextedEvents = "2025-02-15---TestEvent";
    assertEquals(expextedEvents, eventManager.Events.get(0));
  }

  @Test
  /**
   * removeEventの正常系動作を検証するテスト。
   */

   void removeEventTest(){
    //removeEventで入力するScannerのモックを作成
    Scanner mockScanner = Mockito.mock(Scanner.class);
    when(mockScanner.nextInt()).thenReturn(1);

    //EventManagerにScannerのモックを注入する。
    EventManager eventManager = new EventManager(mockScanner);

    //Eventsリストに予定を追加する。
    eventManager.Events.add ("TestEvent");
    eventManager.removeEvent();
    int expectEventsSize = 0;

    //Eventsの値がremoveEventによって削除されているかを検証する。
    assertEquals(expectEventsSize, eventManager.Events.size());
   }
}
