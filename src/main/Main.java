package main;

import entities.*;
import gui.StartWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Result> results = new ArrayList<>();
        results = ResultLoader.load("results.dat");
        StartWindow startWindow = new StartWindow();
        /*Result result = new Result("1", 1000);
        Result result1 = new Result("2", 13000);
        Result result2 = new Result("3", 2110);
        Result result3 = new Result("4", 12000);
        Collections.addAll(results, result1, result3, result2, result);
        ResultSaver.save(results, "results.dat");*/
    }
}