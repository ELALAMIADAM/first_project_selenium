package logwire.creed;

public class operationArithemetic {
    int a, b;
    public operationArithemetic(int a , int b){
        this.a = a;
        this.b = b;
    }
    public int subPos(){
        if(a >= 0 && b >= 0) {
            if(a < b) return 0;
            return a-b;
        }
        else {
            throw new RuntimeException();
        }
    } 
    
}
