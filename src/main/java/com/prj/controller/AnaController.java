package com.prj.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/13
 * @地址 https://github.com/itdebug/
 * @描述
 */
@RestController
@CrossOrigin
public class AnaController {

	public static void main(String[] args) {
		List<Double> correctAnswers = new ArrayList<>();
		correctAnswers.add(1D);
		correctAnswers.add(2D);
		correctAnswers.add(3D);
		List<Double> predictedAnswers = new ArrayList<>();
		predictedAnswers.add(10240D);
		predictedAnswers.add(15000D);
		predictedAnswers.add(18000D);
		System.out.println(meanSquareLoss(correctAnswers, predictedAnswers));
	}

	public static Double meanSquareLoss(List<Double> correctAnswers, List<Double> predictedAnswers) {
		double sumSquare = 0;
		for (int i = 0; i < correctAnswers.size(); i++) {
			double error = correctAnswers.get(i) - predictedAnswers.get(i);
			sumSquare += (error * error);
		}
		return sumSquare / (correctAnswers.size());
	}


}
