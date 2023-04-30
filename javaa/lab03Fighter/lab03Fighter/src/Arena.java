import java.util.Scanner;

public class Arena {
    public static void listFighters(Fighter[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println((i+1)+"-   " + array[i].toString());

        }
    }

    public static void main(String[] args) {
        Fighter[] array = new Fighter[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter a name: ");
            String name = scanner.next();
            System.out.println("Enter a damage: ");
            int damage = scanner.nextInt();
            //Fighter person = new Fighter(name,damage);
            array[i] =  new Fighter(name,damage);;
        }

        listFighters(array);
        System.out.println("Choose an enemy: ");
        for (int i=0 ;i<array.length ;i++ )
        {
            int enemy = scanner.nextInt();
            System.out.println(array[i].getName()+ array[enemy]+" ye saldırdı");
            array[i].attack(array[enemy-1]);
            System.out.println(" Damage: "+array[i].getDamage());
            System.out.println("  Updated health: "+array[enemy-1].getHealth());
            System.out.println("\n");


        }

    }

}

