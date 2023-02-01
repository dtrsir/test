package com.main;

import com.tanchishe.TanChiShe;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TanChiShe tanChiShe = new TanChiShe();
        tanChiShe.setTitle("我的第一个游戏程序");
        tanChiShe.setSize(600,400);
        tanChiShe.setResizable(Boolean.TRUE);
        tanChiShe.setLocationRelativeTo(null);
        tanChiShe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tanChiShe.setVisible(Boolean.TRUE);


    }
}
