package codeWars;

public class SheepCount {

    public static void main(String[] args) {
        int num = 3;

        System.out.println(countingSheep(num));
    }
    public static String countingSheep(int num) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        while (count <= num){
            sb.append(count).append(" ").append("sheep...");
            count++;
        }
        return sb.toString();
    }
}
