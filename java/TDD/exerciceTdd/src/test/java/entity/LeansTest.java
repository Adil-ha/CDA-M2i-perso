package entity;

import org.example.exercice3.Bissextile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeansTest {

    @Test
    void yearIsDivisibleBy400(){
        Bissextile bissextile = new Bissextile();
        boolean res = bissextile.isBessectile(400);
        Assertions.assertTrue(res);
    }
    @Test
    void yearIsDivisibleBy4(){
        Bissextile bissextile = new Bissextile();
        boolean res = bissextile.isBessectile(4);
        Assertions.assertTrue(res);
    }

    @Test
    void yearIsNotDivisibleBy100(){
        Bissextile bissextile = new Bissextile();
        boolean res = bissextile.isBessectile(100);
        Assertions.assertFalse(res);
    }
    @Test
    void yearIsDivisibleBy4000(){
        Bissextile bissextile = new Bissextile();
        boolean res = bissextile.isBessectile(4000);
        Assertions.assertTrue(res);
    }


}
