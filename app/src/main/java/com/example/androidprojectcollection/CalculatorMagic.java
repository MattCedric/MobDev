package com.example.androidprojectcollection;


import java.util.Stack;

public class CalculatorMagic {

    public String forSequence(Stack s) {
        String output = "";

        Stack<String> stackF = new Stack<>();
        while (!s.isEmpty()) {
            stackF.push(s.pop().toString());
        }

        while(!(stackF.size() == 1)) {
            float first = Float.parseFloat(stackF.pop());
            float second, total;
            switch(stackF.pop()) {
                case "+":
                    second = Float.parseFloat(stackF.pop());
                    total = first + second;
                    stackF.push(String.valueOf(total));
                    break;
                case "-":
                    second = Float.parseFloat(stackF.pop());
                    total = first - second;
                    stackF.push(String.valueOf(total));
                    break;
                case "*":
                    second = Float.parseFloat(stackF.pop());
                    total = first * second;
                    stackF.push(String.valueOf(total));
                    break;
                case "/":
                    second = Float.parseFloat(stackF.pop());
                    if(second==0){
                        stackF.push(String.valueOf(0));
                        break;
                    }
                    total = first / second;
                    stackF.push(String.valueOf(total));
                    break;

            }
        }
        output = stackF.pop();
        return output;
    }

    public String forMDAS(Stack s) {
        String output = "";

        Stack<String> stackM = new Stack<>();

        while (!s.isEmpty()) {
            float first;
            float second, total;
            switch (s.peek().toString()){
                case "*":
                    s.pop();
                    first = Float.parseFloat(s.pop().toString());
                    second = Float.parseFloat(stackM.pop());
                    total = first * second;
                    stackM.push(String.valueOf(total));
                    break;
                default:
                    stackM.push(s.pop().toString());
            }
        }

        s = toReverse(((Stack<String>) stackM.clone()));
        stackM = new Stack<>();

        while (!s.isEmpty()) {
            float first_num;
            float second_num, res;
            switch (s.peek().toString()){
                case "/":
                    s.pop();
                    first_num = Float.parseFloat(s.pop().toString());
                    second_num = Float.parseFloat(stackM.pop());
                    if(second_num == 0 ){
                        stackM.push(String.valueOf(0));
                        break;
                    }
                    res = first_num / second_num;
                    stackM.push(String.valueOf(res));
                    break;
                default:
                    stackM.push(s.pop().toString());
            }
        }

        s = toReverse(((Stack<String>) stackM.clone()));
        stackM = new Stack<>();

        while (!s.isEmpty()) {
            float first_num;
            float second_num, res;
            switch (s.peek().toString()){
                case "+":
                    s.pop();
                    first_num = Float.parseFloat(s.pop().toString());
                    second_num = Float.parseFloat(stackM.pop());
                    res = first_num + second_num;
                    stackM.push(String.valueOf(res));
                    break;
                default:
                    stackM.push(s.pop().toString());
            }
        }

        s = toReverse(((Stack<String>) stackM.clone()));
        stackM = new Stack<>();

        while (!s.isEmpty()) {
            float first_num;
            float second_num, res;
            switch (s.peek().toString()){
                case "-":
                    s.pop();
                    first_num = Float.parseFloat(s.pop().toString());
                    second_num = Float.parseFloat(stackM.pop());
                    res = first_num - second_num;
                    stackM.push(String.valueOf(res));
                    break;
                default:
                    stackM.push(s.pop().toString());
            }
        }

        output = stackM.pop();
        return output;
    }

    public boolean isFloat(String s) {
        float num = Float.parseFloat(s);

        return num - Math.floor(num) > 0;
    }

    public Stack toReverse(Stack s) {
        Stack<String> stackReverse = new Stack<>();

        while (!s.isEmpty()) {
            stackReverse.push(s.pop().toString());
        }
        return stackReverse;
    }
}