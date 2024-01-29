package entity;

import org.example.exercice1.GradingCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GradindCalculatorTest {

    private GradingCalculator gradingCalculator;

    private void initGradingCalculator(int score, int attendance){
        gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(score);
        gradingCalculator.setAttendancePercentage(attendance);
    }

    @Test
    void givenAttendance90AndScore95WhenGetGradeThenGradeIsA() {
        /*GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(90);*/

        //Arrange
        initGradingCalculator(95,90);

        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('A', grade);
    }

    @Test
    void givenAttendance90AndScore85WhenGetGradeThenGradeIsB() {
        /*GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(85);
        gradingCalculator.setAttendancePercentage(90);*/

        initGradingCalculator(85,90);

        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('B', grade);
    }

    @Test
    void givenAttendance90AndScore65WhenGetGradeThenGradeIsC() {
        /*GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(90);*/

        initGradingCalculator(65,90);

        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('C', grade);
    }

    @Test
    void givenAttendance65AndScore95WhenGetGradeThenGradeIsB() {
        /*GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(65);*/

        initGradingCalculator(95,65);
        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('B', grade);
    }

    @Test
    void givenAttendance55AndScore95WhenGetGradeThenGradeIsF() {
        /*GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(55);*/

        initGradingCalculator(95,55);

        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('F', grade);
    }

    @Test
    void givenAttendance55AndScore65WhenGetGradeThenGradeIsF() {
        /*GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(55);*/

        initGradingCalculator(65,55);

        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('F', grade);
    }

    @Test
    void givenAttendance90AndScore50WhenGetGradeThenGradeIsA() {
        /*GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(50);
        gradingCalculator.setAttendancePercentage(90);*/


        initGradingCalculator(50,90);

        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('F', grade);
    }


}
