public class Recursive {
    static String output = "";
    public static int russian(int a,int b){
        if(a==0){
            output+= "+" + 0;
            return 0;
        }
        if(a%2 ==0){
            output+= "+" + 2 + "* russian("+ a + "/2," + b+ ")";
            return 2*russian(a/2,b);
        }
        output+= "+" + b + "+ 2* russian(("+ a+ "-1)/2," + b+ ")";
        return b + 2* russian((a-1)/2,b);
    }

    public static void main(String[] args){
        System.out.println(russian(10,2));
        System.out.println(output);
    }
}
