package com.spring5.demoreactor.reactor8;

import java.util.Observable;

/**
 * @author lichuang
 * @create 2021-08-26 21:29
 * @project_name spring5
 */
public class ObserverDemo extends Observable {

    public static void main(String[] args) {
        ObserverDemo observer = new ObserverDemo();
        // 添加观察者
        observer.addObserver((o,arg) -> {
            System.out.println("发生了变化");
        });
        observer.addObserver((o,arg) -> {
            System.out.println("收到了被观察者通知，准备改变");
        });
        observer.setChanged(); // 数据变化
        observer.notifyObservers(); // 通知
    }
}
