public class Main {

    public Main(){
        Node<Integer> testIntegerNode = new Node<>(0, 1234);
        System.out.println(testIntegerNode.getKey());
        Node<String> testStringNode = new Node<>(1,"Hello world");
        System.out.println(testStringNode.getKey());
    }

    public static void main(String[] args){
        new Main();
    }

}
