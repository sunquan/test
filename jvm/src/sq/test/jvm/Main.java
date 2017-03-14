package sq.test.jvm;

public class Main {


    public static void main(String[] args) {
	    System.out.println("11111111111");
        for(;;){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
