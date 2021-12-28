//I worked on the homework assignment alone, using only course materials.
import java.util.Random;

enum SchoolDataType {
STUDENTS, CLASSES, HOUSING, DINING;
}
public class DataLeakSimulator {
    public static SchoolDataType leakData(int a) {
        a = Math.abs(a) % 4;
        switch (a) {
        case 0: return SchoolDataType.STUDENTS;
        case 1: return SchoolDataType.CLASSES;
        case 2: return SchoolDataType.HOUSING;
        case 3: return SchoolDataType.DINING;
        default: return SchoolDataType.DINING;
        }
    }
    public static void main(String[] args) {
        Random  myRandom = new Random();
        int a = myRandom.nextInt(26);
        int sqRandom = (int) Math.sqrt(a);
        System.out.println(leakData(sqRandom) + " data was leaked");
        System.out.println(leakData((int) (Math.random() * (((10) - (-10)) + 1) + (-10))) + " data was leaked");
    }
}
