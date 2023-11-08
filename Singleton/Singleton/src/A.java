public class A {

    private Rector rector;

    public A(Rector rector) {this.rector = rector;}


    public String getMyBoss(){
        return rector.getRectorName();
    }
}

