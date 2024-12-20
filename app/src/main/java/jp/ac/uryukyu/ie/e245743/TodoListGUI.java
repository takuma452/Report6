package jp.ac.uryukyu.ie.e245743;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.*;

public class TodoListGUI{
  /**
   * TodoListのGUIを作成するクラス。
   * 
   */
  public void makeWindow(){
    /**
     * TodoListを起動した際に表示されるウィンドウの作成とTodoListを終了させる際の処理を行う。
     */

    JFrame frame = new JFrame("TODOリスト"); //ウィンドウの作成
    frame.setSize(1366,768); //ウィンドウサイズを設定

    //ウィンドウに追加する部品を作成していく
    JTextField writeTask = new JTextField(40);//タスクを入力する欄
    JButton addTask = new JButton("タスク追加"); //タスク追加ボタン
    JButton removeTask = new JButton("タスク削除");
    DefaultListModel<String> todoListData = new DefaultListModel<>();  //リストの内部データの管理
    JPanel panel = new JPanel(); //部品をまとめるもの

    //panelに作成した部品を追加していく
    panel.add(new JList<>(todoListData));//リストを表示する部品
    panel.add(new JLabel("\nタスクを入力し、タスク追加ボタンを押してください"));
    panel.add(writeTask); 
    panel.add(addTask);
    panel.add(removeTask);
    panel.setLayout(new FlowLayout()); 
    frame.add(panel); //ウィンドウに部品をまとめたpanelを追加することで部品が表示されるようになる
    
    //Todoリストの終了処理
    frame.addWindowListener(new WindowAdapter(){
      @Override
      public void windowClosing(WindowEvent e){
        int result = JOptionPane.showConfirmDialog(frame, "アプリを終了しますか？", "終了確認", JOptionPane.YES_NO_OPTION);

        if(result == JOptionPane.YES_OPTION){
          frame.dispose(); //ウィンドウを破棄
          System.exit(0);//アプリを終了
        }
      }
    });

    //タスクが実際にリストとして表示されるか確認するテスト
    todoListData.addElement("早起きする");
    todoListData.addElement("運動する");
    frame.setVisible(true); //ウィンドウを表示
      }
  };
