import java.util.Scanner;

public class Main {
    public static final int MAX_LIMIT = 100;
    public static final int MIN_LIMIT = 1;

    public static int maxBorder;
    static int minBorder;

    public static int generateRandomValue(){
        int value = (int) (MIN_LIMIT + Math.random()*MAX_LIMIT);
        return value;
    }

    public static int getUserValue(){
        int userValue = 0;
        boolean isInteger = false;
        while (isInteger==false) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ваше число: ");
            if (scanner.hasNextInt()) {
                isInteger=true;
                userValue = scanner.nextInt();
            }
            else{
                System.out.println("Ошибка");
            }
        }
        return userValue;
    }

    public static void playTheGame(int randomizerValue){
        maxBorder = MAX_LIMIT;
        minBorder = MIN_LIMIT;
        System.out.println("Рандомайзер загадал число, попробуйте угадать))");

        boolean userIsWin = false;
        while (userIsWin==false){
            System.out.println("\n*** Ищите в диапазоне от " + minBorder + " до " + maxBorder + " ***");
            int userNum = getUserValue();
            if (userNum>randomizerValue){
                System.out.println("Ваше число больше загаданного. ");
                maxBorder = userNum;
            }else if (userNum<randomizerValue){
                System.out.println("Ваше число меньше загаданного");
                minBorder = userNum;
            }
            else if (userNum==randomizerValue){
                userIsWin=true;
            }
        }
        System.out.println("Поздравляем, вы угадали число: " + randomizerValue);
    }

    public static void main(String[] args) {
        int randomValue = generateRandomValue();
        playTheGame(randomValue);
    }
}
