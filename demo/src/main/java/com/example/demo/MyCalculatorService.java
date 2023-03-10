package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyCalculatorService {
    // 해당 필드(calculator)에 의존성 주입이 진행될 수 있도록 Autowired 어노테이션을 적용
    // 필드 주입
    // @Autowired
    private  Calculator calculator;

    // 생성자 주입
    // @AutoWired
    public MyCalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    // 세터 주입
    // @Autowired
    public void setCalculator(Calculator calculator) {
        System.out.println("from setCalculator");
        System.out.println(calculator);
        this.calculator = calculator;
    }

    @Autowired
    public void iNeedDependency(MyBean myBean, @Qualifier("myPerson") Person person, Calculator calculator) {
        System.out.println("iNeedDependency");
        System.out.println(person);
        System.out.println(myBean);
        System.out.println(calculator);
    }

    public int calcAdd(int a, int b) {
        return calculator.add(a, b);
    }
}