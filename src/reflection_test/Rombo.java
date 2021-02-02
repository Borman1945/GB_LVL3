package reflection_test;

public class Rombo {

    @BeforeSuite
    void setUp(){
        System.out.println("Do smt before @Test");
    }




    @Test(priority = 1)
    void smthTwo(){
        System.out.println("Do Test Two");
    }

    @Test
    void smthOne(){
        System.out.println("Do Test One");
    }


    @AfterSuite
    void end(){
        System.out.println("Do smt after @Test");
    }
}
