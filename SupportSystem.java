import java.util.HashSet;
import java.util.Random;
/**
 * This class implements a technical support system. It is the top
 * level class in this project. The support system communicates via
 * text input/output in the text terminal.
 * 
 * This class uses an object of class InputReader to read input from
 * the user, and an object of class Responder to generate responses.
 * It contains a loop that repeatedly reads input and generates output
 * until the users wants to leave.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    0.1 (1.Feb.2002)
 */
public class SupportSystem
{
    private InputReader reader;
    private Responder responder;
    private Random rand;
    private int playerHealth;
    private int enemyHealth;
    private int damage;
    private int captin;
    private int recover; 
    private int coins;
    private int enemyPlacement;

    /**
     * Creates a technical support system.
     */
    public SupportSystem()
    {
        reader = new InputReader();
        responder = new Responder();
        rand=new Random();
        playerHealth=100;
        enemyHealth=75;
        damage=0;
        captin=0;
        recover=0;
        coins=0;
        enemyPlacement=0;
    }

    private void randomEnemyAttack()   
    {
        int index=rand.nextInt(5)+1;
        if(index==1){
            enemyPlacement=1;
        }
        else if(index==2){
            enemyPlacement=2;
        }
        else if(index==3){
            enemyPlacement=3;
        }
        else if(index==4){
            enemyPlacement=4;
        }
        else if(index==5){
            enemyPlacement=5;
        }
    }

    private void captinPlacement()
    {
        int index=rand.nextInt(5)+1;
        if(index==1){
            captin=1;
        }
        else if(index==2){
            captin=2;
        }
        else if(index==3){
            captin=3;
        }
        else if(index==4){
            captin=4;
        }
        else if(index==5){
            captin=5;
        }
    }

    private void recoverHealth()
    {
        int index=rand.nextInt(3)+1;
        if(index==1){
            recover=1;
        }
        else if(index==2){
            recover=2;
        }
        else if(index==3){
            recover=3;
        }
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    public void start()
    {
        System.out.println("\u000C");
        printWelcome();
        System.out.println("You will start in place 1");
        playerHealth=100;
        recoverHealth();
        captinPlacement();
        randomEnemyAttack();
        coins=0;
        place1();
    }

    private void place1()
    {
        boolean finished = false;
        System.out.println("You are now in Place 1");
        if(recover==1){
            System.out.println("Would you like to restore your health?");
            System.out.println("If you do, then type 'restore'.");
            System.out.println("If you do not, then type 'stay'.");
        }
        else{
            System.out.println("You missed a chance to restore your health. Next time!");
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }
            else if(input.contains("restore")){
                finished=false;
                playerHealth=100;
                System.out.println("Now type in a different command to go.");
            }
            else if(input.contains("stay")){
                finished=false;
                System.out.println("Ok. That was your choice.");
                System.out.println("Now type in a different command to go.");
            }
            else if(input.contains("p1")) {
                finished = false;
                System.out.println("You are already in Place 1, silly!");
            }
            else if(input.contains("p2")){
                finished = true;
                System.out.println("\u000C");
                place2();
            }
            else if(input.contains("p3")){
                finished=true;
                System.out.println("\u000C");
                place3();
            } 
            else if(input.contains("p4")){
                finished=true;
                System.out.println("\u000C");
                place4();
            } 
            else if(input.contains("p5")){
                finished=true;
                System.out.println("\u000C");
                place5();
            } 
            else if(input.contains("base")){
                finished=true;
                System.out.println("\u000C");
                placebase();
            }
            else if(input.contains("map")){
                map();
            }    
            else if(input.contains("captin")){
                captinInstructions();
            }
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    private void placebase()
    {
        System.out.println("\u000C");
        System.out.println("You made it back safely with Captin Jones!");
        System.out.println("You recieve 1,000,000 (one million) gold coins!!!");
        System.out.println("                 ______________ ");
        System.out.println("    __,.,---'''''              '''''---..._ ");
        System.out.println(" ,-'             .....:::''::.:            '`-. ");
        System.out.println(" '           ...:::.....       ' ");
        System.out.println("             ''':::'''''       .               , ");
        System.out.println(" |'-.._           ''''':::..::':          __,,- ");
        System.out.println(" '-.._''`---.....______________.....---''__,,- ");
        System.out.println("       ''`---.....______________.....---'' ");
        coins+=1000000;
        System.out.println("You are rich!!!");
        System.out.println("AND");
        System.out.println("You WIN!!!!!");
        System.out.println("(And you're a hero.)");
        System.out.println("  .-'''-.  ");
        System.out.println(" / #     \\ ");    
        System.out.println(": #       :   .-'''-. ");
        System.out.println(" \\       /   /  #    \\ ");
        System.out.println("  \\     /    : #      : ");
        System.out.println("    `'q'`     \\      /  ");
        System.out.println("      (        \\    /   ");
        System.out.println("       ) .-'''-.`'q'`    ");
        System.out.println("      ( / #     \\ (  ");
        System.out.println("       ) #      :  )  .-'''-.");
        System.out.println("      ( \\      /  (  / #     \\ ");
        System.out.println("         \\    /    ) #       :");
        System.out.println("          `'q'`    ( \\      / ");
        System.out.println("            (         \\    / ");
        System.out.println("             )         `'q'` ");
        System.out.println("            (             ) ");
        System.out.println("             )           ( ");
        System.out.println("                          ) ");
        System.out.println("You made it 100%");
        System.out.println();
        printGoodbye();
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    private void place2()
    {
        boolean finished = false;
        System.out.println("You are now in Place 2");
        if(captin==1){
            System.out.println("Congratulations! You have reached Captin Jones!");
            System.out.println("Now that you have Captin Jones, you need to return back to our base safely.");
            System.out.println("To do that, you will need to travel back to place 1, and when you get \nthere, you need to type in 'base' to reach your destination.");
            System.out.println("Good luck!");
            System.out.println("If you forget, you can always type 'captin' and you will recieve the directions to finish the game.");
        }
        else{
            System.out.println("The captin is not here. Sorry!");
        }
        if(enemyPlacement==1){
            System.out.println("There are double the enemies around the corner!");
            System.out.println("                                             |______| ");
            System.out.println("                            _                 |    | ");
            System.out.println("                           | `-._             |    | ");
            System.out.println("         __________________|_____`._______    /    /____________________________.-.____________ ");
            System.out.println("     __.`-------------------____----------`--/`._.`-----|                        o|            | ");
            System.out.println("    ||                     (____)            |          | ======================  |____________| ");
            System.out.println("    ||_______________________________________|__________| ======================  | ");
            System.out.println("    '-._o                          o____(_)_____________| ============= ____..o---' ");
            System.out.println("        `.           __0-------''-`          `---..--._(|_o______.-----`      `.O.` ");
            System.out.println("          )     o  .' //       ||                                            __//__ ");
            System.out.println("         /        (   \\       ||                                           `------` ");
            System.out.println("        /         \\___________//                                            |     | ");
            System.out.println("       /         __/-----------`                                             |     | ");
            System.out.println("   _./          (                                                            /     / ");
            System.out.println(" _.-`             )                                                          /     / ");
            System.out.println(" \\              (                                                          /     / ");
            System.out.println("  \\     _ o      )                                                       _/     / ");
            System.out.println("   \\_.-`        ( _                                                  _.-`   _.-` ");
            System.out.println("    (_____________)O)                                             _.-`   _.-` ");
            System.out.println("                 __\\__                                       _.-`   _.-` ");
            System.out.println("                `------`.                                 _.-`   _.-` ");
            System.out.println("                 \\     |                             _.-`   _.-` ");
            System.out.println("                  \\    \\_                       _.-`   _.-` ");
            System.out.println("                   `-._    `-._              __.-`   _.-` ");
            System.out.println("                       `-._    `-.__.--===--`    _.-` ");
            System.out.println("                           `-._     / LGB  \\_.-` ");
            System.out.println("                               `-._.--=====-` ");
            System.out.println("Would you like to fight or run?");
        }
        else{
            System.out.println("There are enemies around the corner!");
            System.out.println("                                             |______| ");
            System.out.println("                            _                 |    | ");
            System.out.println("                           | `-._             |    | ");
            System.out.println("         __________________|_____`._______    /    /____________________________.-.____________ ");
            System.out.println("     __.`-------------------____----------`--/`._.`-----|                        o|            | ");
            System.out.println("    ||                     (____)            |          | ======================  |____________| ");
            System.out.println("    ||_______________________________________|__________| ======================  | ");
            System.out.println("    '-._o                          o____(_)_____________| ============= ____..o---' ");
            System.out.println("        `.           __0-------''-`          `---..--._(|_o______.-----`      `.O.` ");
            System.out.println("          )     o  .' //       ||                                            __//__ ");
            System.out.println("         /        (   \\       ||                                           `------` ");
            System.out.println("        /         \\___________//                                            |     | ");
            System.out.println("       /         __/-----------`                                             |     | ");
            System.out.println("   _./          (                                                            /     / ");
            System.out.println(" _.-`             )                                                         /     / ");
            System.out.println(" \\              (                                                          /     / ");
            System.out.println("  \\     _ o      )                                                       _/     / ");
            System.out.println("   \\_.-`        ( _                                                  _.-`   _.-` ");
            System.out.println("    (_____________)O)                                             _.-`   _.-` ");
            System.out.println("                 __\\__                                       _.-`   _.-` ");
            System.out.println("                `------`.                                 _.-`   _.-` ");
            System.out.println("                 \\     |                             _.-`   _.-` ");
            System.out.println("                  \\    \\_                       _.-`   _.-` ");
            System.out.println("                   `-._    `-._              __.-`   _.-` ");
            System.out.println("                       `-._    `-.__.--===--`    _.-` ");
            System.out.println("                           `-._     / LGB  \\_.-` ");
            System.out.println("                               `-._.--=====-` ");
            System.out.println("Would you like to fight or run?");
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }
            else if(input.contains("fight")){
                finished=true;
                System.out.println("\u000C");
                chooseWeapon();
                if(enemyPlacement==1){
                    enemyHealth=150;
                    fight1();
                }
                else{
                    enemyHealth=75;
                    fight1();
                }
            }
            else if(input.contains("run")){
                int index=rand.nextInt(3);
                if(index==0){
                    finished=true;
                    System.out.println("Running was a bad idea. You tripped on a grain a sand \nand got shot by your enemies.");
                    System.out.println("GAME OVER");
                    System.out.println("You were in Place 2");
                    if(captin==1){
                        System.out.println("You made it 50%");
                    }
                    else if(captin==2){
                        System.out.println("You made it 40%");
                    }
                    else if(captin==3){
                        System.out.println("You made it 30%");
                    }
                    else if(captin==4){
                        System.out.println("You made it 20%");
                    }
                    else if(captin==5){
                        System.out.println("You made it 30%");
                    }
                    printGoodbye();
                }
                else{
                    System.out.println("You escaped from your enemies!");    
                    System.out.println("Go back to place 1 to move out of your \nenemy's territory and try again later.");
                }
            }

            else if(input.contains("p2")) {
                finished = false;
                System.out.println("You are already in Place 2, silly!");
            }
            else if(input.contains("p1")){
                finished = true;
                System.out.println("\u000C");
                place1();
            }
            else if(input.contains("p4")){
                finished=true;
                System.out.println("\u000C");
                place4();
            }
            else if(input.contains("map")){
                map();
            }
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else if(input.contains("captin")){
                captinInstructions();
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    private void place2b()
    {
        boolean finished = false;
        System.out.println("You are now in Place 2");
        if(captin==1){
            System.out.println("Congratulations! You have reached Captin Jones!");
            System.out.println("Now that you have Captin Jones, you need to return back to our base safely.");
            System.out.println("To do that, you will need to travel back to place 1, and when you get \nthere, you need to type in 'base' to reach your destination.");
            System.out.println("Good luck!");
            System.out.println("If you forget, you can always type 'captin' and you will recieve the directions to finish the game.");
        }
        else{
            System.out.println("Continue your journey to find Captin Jones!");
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }

            else if(input.contains("p2")) {
                finished = false;
                System.out.println("You are already in Place 2, silly!");
            }
            else if(input.contains("p1")){
                finished = true;
                System.out.println("\u000C");
                place1();
            }
            else if(input.contains("p4")){
                finished=true;
                System.out.println("\u000C");
                place4();
            }
            else if(input.contains("map")){
                map();
            }   
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else if(input.contains("captin")){
                captinInstructions();
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    private void place3()
    {
        boolean finished = false;
        System.out.println("You are now in Place 3");
        if(recover==2){
            System.out.println("Would you like to restore your health?");
            System.out.println("If you do, then type 'restore'.");
            System.out.println("If you do not, then type 'stay'.");
        }
        else{
            System.out.println("You missed a chance to restore your health. Next time!");
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }
            else if(input.contains("restore")){
                finished=false;
                playerHealth=100;
                System.out.println("Now type in a different command to go.");
            }
            else if(input.contains("stay")){
                finished=false;
                System.out.println("Ok. That was your choice.");
                System.out.println("Now type in a different command to go.");
            }
            else if(input.contains("p3")) {
                finished = false;
                System.out.println("You are already in Place 3, silly!");
            }
            else if(input.contains("p1")){
                finished = true;
                System.out.println("\u000C");
                place1();
            }
            else if(input.contains("p5")){
                finished=true;
                System.out.println("\u000C");
                place5();
            }
            else if(input.contains("map")){
                map();
            }       
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else if(input.contains("captin")){
                captinInstructions();
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    private void place4()
    {
        boolean finished = false;
        System.out.println("You are now in Place 4");
        if(captin==2){
            System.out.println("Congratulations! You have reached Captin Jones!");
            System.out.println("Now that you have Captin Jones, you need to return back to our base safely.");
            System.out.println("To do that, you will need to travel back to place 1, and when you get \nthere, you need to type in 'base' to reach your destination.");
            System.out.println("Good luck!");
            System.out.println("If you forget, you can always type 'captin' and you will recieve the directions to finish the game.");
        }
        else{
            System.out.println("The captin is not here. Sorry!");
        }	
        if(enemyPlacement==2){
            System.out.println("There are double the enemies around the bend!");
            System.out.println("                                             |______| ");
            System.out.println("                            _                 |    | ");
            System.out.println("                           | `-._             |    | ");
            System.out.println("         __________________|_____`._______    /    /____________________________.-.____________ ");
            System.out.println("     __.`-------------------____----------`--/`._.`-----|                        o|            | ");
            System.out.println("    ||                     (____)            |          | ======================  |____________| ");
            System.out.println("    ||_______________________________________|__________| ======================  | ");
            System.out.println("    '-._o                          o____(_)_____________| ============= ____..o---' ");
            System.out.println("        `.           __0-------''-`          `---..--._(|_o______.-----`      `.O.` ");
            System.out.println("          )     o  .' //       ||                                            __//__ ");
            System.out.println("         /        (   \\       ||                                           `------` ");
            System.out.println("        /         \\___________//                                            |     | ");
            System.out.println("       /         __/-----------`                                             |     | ");
            System.out.println("   _./          (                                                            /     / ");
            System.out.println(" _.-`             )                                                         /     / ");
            System.out.println(" \\              (                                                          /     / ");
            System.out.println("  \\     _ o      )                                                       _/     / ");
            System.out.println("   \\_.-`        ( _                                                  _.-`   _.-` ");
            System.out.println("    (_____________)O)                                             _.-`   _.-` ");
            System.out.println("                 __\\__                                       _.-`   _.-` ");
            System.out.println("                `------`.                                 _.-`   _.-` ");
            System.out.println("                 \\     |                             _.-`   _.-` ");
            System.out.println("                  \\    \\_                       _.-`   _.-` ");
            System.out.println("                   `-._    `-._              __.-`   _.-` ");
            System.out.println("                       `-._    `-.__.--===--`    _.-` ");
            System.out.println("                           `-._     / LGB  \\_.-` ");
            System.out.println("                               `-._.--=====-` ");
            System.out.println("Would you like to fight or run?");
        }
        else{
            System.out.println("There are enemies around the bend!");
            System.out.println("                                             |______| ");
            System.out.println("                            _                 |    | ");
            System.out.println("                           | `-._             |    | ");
            System.out.println("         __________________|_____`._______    /    /____________________________.-.____________ ");
            System.out.println("     __.`-------------------____----------`--/`._.`-----|                        o|            | ");
            System.out.println("    ||                     (____)            |          | ======================  |____________| ");
            System.out.println("    ||_______________________________________|__________| ======================  | ");
            System.out.println("    '-._o                          o____(_)_____________| ============= ____..o---' ");
            System.out.println("        `.           __0-------''-`          `---..--._(|_o______.-----`      `.O.` ");
            System.out.println("          )     o  .' //       ||                                            __//__ ");
            System.out.println("         /        (   \\       ||                                           `------` ");
            System.out.println("        /         \\___________//                                            |     | ");
            System.out.println("       /         __/-----------`                                             |     | ");
            System.out.println("   _./          (                                                            /     / ");
            System.out.println(" _.-`             )                                                         /     / ");
            System.out.println(" \\              (                                                          /     / ");
            System.out.println("  \\     _ o      )                                                       _/     / ");
            System.out.println("   \\_.-`        ( _                                                  _.-`   _.-` ");
            System.out.println("    (_____________)O)                                             _.-`   _.-` ");
            System.out.println("                 __\\__                                       _.-`   _.-` ");
            System.out.println("                `------`.                                 _.-`   _.-` ");
            System.out.println("                 \\     |                             _.-`   _.-` ");
            System.out.println("                  \\    \\_                       _.-`   _.-` ");
            System.out.println("                   `-._    `-._              __.-`   _.-` ");
            System.out.println("                       `-._    `-.__.--===--`    _.-` ");
            System.out.println("                           `-._     / LGB  \\_.-` ");
            System.out.println("                               `-._.--=====-` ");
            System.out.println("Would you like to fight or run?");
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("p4")) {
                finished = false;
                System.out.println("You are already in place 4, silly!");
            }
            else if(input.contains("fight")){
                finished=true;
                System.out.println("\u000C");
                chooseWeapon();
                if(enemyPlacement==2){
                    enemyHealth=150;
                    fight2();
                }
                else{
                    enemyHealth=75;
                    fight2();
                }
            }
            else if(input.contains("run")){
                int index=rand.nextInt(3);
                if(index==0){
                    finished=true;
                    System.out.println("Running was a bad idea. You tripped on your own shoe \nlaces and your enemies lay you to your death.");
                    System.out.println("GAME OVER");
                    System.out.println("You were in Place 4");
                    if(captin==1){
                        System.out.println("You made it 40%");
                    }
                    else if(captin==2){
                        System.out.println("You made it 50%");
                    }
                    else if(captin==3){
                        System.out.println("You made it 40%");
                    }
                    else if(captin==4){
                        System.out.println("You made it 30%");
                    }
                    else if(captin==5){
                        System.out.println("You made it 40%");
                    }
                    printGoodbye();
                }
                else{
                    System.out.println("You escaped from your enemies!");
                    System.out.println("Go back to place 2 or place 1 to move out of their territory.");
                }
            }
            else if(input.contains("p2")){
                finished = true;
                System.out.println("\u000C");
                place2();
            }
            else if(input.contains("p1")){
                finished=true;
                System.out.println("\u000C");
                place1();
            } 
            else if(input.contains("p5")){
                finished=true;
                System.out.println("\u000C");
                place5();
            } 
            else if(input.contains("p6")){
                finished=true;
                System.out.println("\u000C");
                place6();
            } 
            else if(input.contains("p8")){
                finished=true;
                System.out.println("\u000C");
                place8();
            }
            else if(input.contains("map")){
                map();
            }           
            else if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else if(input.contains("captin")){
                captinInstructions();
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    private void place4b()
    {
        boolean finished = false;
        System.out.println("You are now in Place 4");
        if(captin==2){
            System.out.println("Congratulations! You have reached Captin Jones!");
            System.out.println("Now that you have Captin Jones, you need to return back to our base safely.");
            System.out.println("To do that, you will need to travel back to place 1, and when you get \nthere, you need to type in 'base' to reach your destination.");
            System.out.println("Good luck!");
            System.out.println("If you forget, you can always type 'captin' and you will recieve the directions to finish the game.");
        }
        else{
            System.out.println("Continue your journey to find Captin Jones!");
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }

            else if(input.contains("p4")) {
                finished = false;
                System.out.println("You are already in Place 4, silly!");
            }
            else if(input.contains("p1")){
                finished = true;
                System.out.println("\u000C");
                place1();
            }
            else if(input.contains("p2")){
                finished=true;
                System.out.println("\u000C");
                place2();
            }
            else if(input.contains("p5")){
                finished=true;
                System.out.println("\u000C");
                place5();
            }
            else if(input. contains("p6")){
                finished=true;
                System.out.println("\u000C");
                place6();
            }
            else if(input.contains("p8")){
                finished=true;
                System.out.println("\u000C");
                place8();
            }
            else if(input.contains("map")){
                map();
            }   
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else if(input.contains("captin")){
                captinInstructions();
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    private void place5()
    {
        boolean finished = false;
        System.out.println("You are now in Place 5");
        if(captin==3){
            System.out.println("Congratulations! You have reached Captin Jones!");
            System.out.println("Now that you have Captin Jones, you need to return back to our base safely.");
            System.out.println("To do that, you will need to travel back to place 1, and when you get \nthere, you need to type in 'base' to reach your destination.");
            System.out.println("Good luck!");
            System.out.println("If you forget, you can always type 'captin' and you will recieve the directions to finish the game.");
        }
        else{
            System.out.println("The captin is not here. Sorry!");
        }
        if(enemyPlacement==3){
            System.out.println("There are double the enemies surrounding!");
            System.out.println("                                             |______| ");
            System.out.println("                            _                 |    | ");
            System.out.println("                           | `-._             |    | ");
            System.out.println("         __________________|_____`._______    /    /____________________________.-.____________ ");
            System.out.println("     __.`-------------------____----------`--/`._.`-----|                        o|            | ");
            System.out.println("    ||                     (____)            |          | ======================  |____________| ");
            System.out.println("    ||_______________________________________|__________| ======================  | ");
            System.out.println("    '-._o                          o____(_)_____________| ============= ____..o---' ");
            System.out.println("        `.           __0-------''-`          `---..--._(|_o______.-----`      `.O.` ");
            System.out.println("          )     o  .' //       ||                                            __//__ ");
            System.out.println("         /        (   \\       ||                                           `------` ");
            System.out.println("        /         \\___________//                                            |     | ");
            System.out.println("       /         __/-----------`                                             |     | ");
            System.out.println("   _./          (                                                            /     / ");
            System.out.println(" _.-`             )                                                         /     / ");
            System.out.println(" \\              (                                                          /     / ");
            System.out.println("  \\     _ o      )                                                       _/     / ");
            System.out.println("   \\_.-`        ( _                                                  _.-`   _.-` ");
            System.out.println("    (_____________)O)                                             _.-`   _.-` ");
            System.out.println("                 __\\__                                       _.-`   _.-` ");
            System.out.println("                `------`.                                 _.-`   _.-` ");
            System.out.println("                 \\     |                             _.-`   _.-` ");
            System.out.println("                  \\    \\_                       _.-`   _.-` ");
            System.out.println("                   `-._    `-._              __.-`   _.-` ");
            System.out.println("                       `-._    `-.__.--===--`    _.-` ");
            System.out.println("                           `-._     / LGB  \\_.-` ");
            System.out.println("                               `-._.--=====-` ");
            System.out.println("Would you like to fight or run?");
        }
        else{
            System.out.println("There are enemies surrounding you!");
            System.out.println("                                             |______| ");
            System.out.println("                            _                 |    | ");
            System.out.println("                           | `-._             |    | ");
            System.out.println("         __________________|_____`._______    /    /____________________________.-.____________ ");
            System.out.println("     __.`-------------------____----------`--/`._.`-----|                        o|            | ");
            System.out.println("    ||                     (____)            |          | ======================  |____________| ");
            System.out.println("    ||_______________________________________|__________| ======================  | ");
            System.out.println("    '-._o                          o____(_)_____________| ============= ____..o---' ");
            System.out.println("        `.           __0-------''-`          `---..--._(|_o______.-----`      `.O.` ");
            System.out.println("          )     o  .' //       ||                                            __//__ ");
            System.out.println("         /        (   \\       ||                                           `------` ");
            System.out.println("        /         \\___________//                                            |     | ");
            System.out.println("       /         __/-----------`                                             |     | ");
            System.out.println("   _./          (                                                            /     / ");
            System.out.println(" _.-`             )                                                         /     / ");
            System.out.println(" \\              (                                                          /     / ");
            System.out.println("  \\     _ o      )                                                       _/     / ");
            System.out.println("   \\_.-`        ( _                                                  _.-`   _.-` ");
            System.out.println("    (_____________)O)                                             _.-`   _.-` ");
            System.out.println("                 __\\__                                       _.-`   _.-` ");
            System.out.println("                `------`.                                 _.-`   _.-` ");
            System.out.println("                 \\     |                             _.-`   _.-` ");
            System.out.println("                  \\    \\_                       _.-`   _.-` ");
            System.out.println("                   `-._    `-._              __.-`   _.-` ");
            System.out.println("                       `-._    `-.__.--===--`    _.-` ");
            System.out.println("                           `-._     / LGB  \\_.-` ");
            System.out.println("                               `-._.--=====-` ");
            System.out.println("Would you like to fight or run?");
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("p5")) {
                finished = false;
                System.out.println("You are already in place 5, silly!");
            }
            else if(input.contains("fight")){
                finished=true;
                System.out.println("\u000C");
                chooseWeapon();
                if(enemyPlacement==3){
                    enemyHealth=150;
                    fight3();
                }
                else{
                    enemyHealth=75;
                    fight3();
                }
            }
            else if(input.contains("run")){
                int index=rand.nextInt(3);
                if(index==0){
                    finished=true;
                    System.out.println("Running was the worst idea EVER! \nYou started screaming at the top of your lungs, and a roc came and gobbled you up.");
                    System.out.println("(A roc is a gargantuan bird that is a carnivore.)");
                    System.out.println("GAME OVER");
                    System.out.println("You were in Place 5");
                    if(captin==1){
                        System.out.println("You made it 30%");
                    }
                    else if(captin==2){
                        System.out.println("You made it 40%");
                    }
                    else if(captin==3){
                        System.out.println("You made it 50%");
                    }
                    else if(captin==4){
                        System.out.println("You made it 40%");
                    }
                    else if(captin==5){
                        System.out.println("You made it 40%");
                    }
                    printGoodbye();
                }
                else{
                    System.out.println("You escaped from your enemies!");
                    System.out.println("Go back to place 3 or place 1 to move out of their territory.");
                }
            }
            else if(input.contains("p4")){
                finished = true;
                System.out.println("\u000C");
                place4();
            }
            else if(input.contains("p1")){
                finished=true;
                System.out.println("\u000C");
                place1();
            } 
            else if(input.contains("p3")){
                finished=true;
                System.out.println("\u000C");
                place3();
            } 
            else if(input.contains("p7")){
                finished=true;
                System.out.println("\u000C");
                place7();
            } 
            else if(input.contains("p8")){
                finished=true;
                System.out.println("\u000C");
                place8();
            }
            else if(input.contains("map")){
                map();
            }           
            else if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else if(input.contains("captin")){
                captinInstructions();
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    private void place5b()
    {
        boolean finished = false;
        System.out.println("You are now in Place 5");
        if(captin==3){
            System.out.println("Congratulations! You have reached Captin Jones!");
            System.out.println("Now that you have Captin Jones, you need to return back to our base safely.");
            System.out.println("To do that, you will need to travel back to place 1, and when you get \nthere, you need to type in 'base' to reach your destination.");
            System.out.println("Good luck!");
            System.out.println("If you forget, you can always type 'captin' and you will recieve the directions to finish the game.");
        }
        else{
            System.out.println("Continue your journey to find Captin Jones!");
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("p5")) {
                finished = false;
                System.out.println("You are already in place 5, silly!");
            }
            else if(input.contains("p4")){
                finished = true;
                System.out.println("\u000C");
                place4b();
            }
            else if(input.contains("p1")){
                finished=true;
                System.out.println("\u000C");
                place1();
            } 
            else if(input.contains("p3")){
                finished=true;
                System.out.println("\u000C");
                place3();
            } 
            else if(input.contains("p7")){
                finished=true;
                System.out.println("\u000C");
                place7();
            } 
            else if(input.contains("p8")){
                finished=true;
                System.out.println("\u000C");
                place8();
            }
            else if(input.contains("map")){
                map();
            }           
            else if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else if(input.contains("captin")){
                captinInstructions();
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    private void place6()
    {
        boolean finished = false;
        System.out.println("You are now in Place 6");
        if(recover==3){
            System.out.println("Would you like to restore your health?");
            System.out.println("If you do, then type 'restore'.");
            System.out.println("If you do not, then type 'stay'.");
        }
        else{
            System.out.println("You missed a chance to restore your health. Next time!");
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("p6")) {
                finished = false;
                System.out.println("You are already in place 6, silly!");
            }
            else if(input.contains("restore")){
                finished=false;
                playerHealth=100;
                System.out.println("Now type in a different command to go.");
            }
            else if(input.contains("stay")){
                finished=false;
                System.out.println("Ok. That was your choice.");
                System.out.println("Now type in a different command to go.");
            }
            else if(input.contains("p4")){
                finished = true;
                System.out.println("\u000C");
                place4();
            }
            else if(input.contains("p8")){
                finished=true;
                System.out.println("\u000C");
                place8();
            } 
            else if(input.contains("map")){
                map();
            }            
            else if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else if(input.contains("captin")){
                captinInstructions();
            }
            else if(input.contains("barney")){
                System.out.println("\u000C");
                System.out.println("I love you");
                System.out.println("You love me");
                System.out.println("We're a happy family");
                System.out.println("With a great big hug and a kiss from me to you");
                System.out.println("Won't you say you love me too");
                System.out.println("                                       _o=<&&&&>=vo__   ");
                System.out.println("                                     ?/$='''  '''^=<&&R$~\\   ");
                System.out.println("                                   .&?/'              `''$$,   ");
                System.out.println("                                 ,/?/'       /-'^\\.   .-=~\\T,   ");
                System.out.println("                               ,/?/'        /\\|6?`|  |<<q- ,??   ");
                System.out.println("                             ./?/'          `\\??dp'  `$??,/|,i\\.   ");
                System.out.println("                            ,*??              `'       ''' `b'\\$$&&\\.   ");
                System.out.println("                           ,Td'                             `&:`H' '&7, .__   ");
                System.out.println("               ._.         H||            .                  `*\\H,  `&$$S:7|   ");
                System.out.println("              |????        M|,         ,--&|\\                  `&?b   ''://'   ");
                System.out.println("     .,o--vo\\,PJ'H|,       H|L         ``''H?b                 ,-`?\\   ,&&'   ");
                System.out.println("    ,P?-''^==:=' ||b       `L9,            `H`&,               |?:!|| ,P&   ");
                System.out.println("    `b?\\          9/?       ??H,            |L *b.,''\\          :$:&  H]'   ");
                System.out.println("     `b$\\o.        */\\.      ??*b.           9.  `\\:(|     .,/$6d'  |\\T   ");
                System.out.println("       ``\\Z\\       `\\7b.    ,To?&b.          \\(\\:-.-S:-~=-''',P     MJ'   ");
                System.out.println("          `\\?*b       ?&&\\.  d\\|<_ `\\o_       `&&M\\:?-+#:>\\.|,&'    |LT   ");
                System.out.println("            `\\?\\      ``\\?\\d|/`4RM|:~:$=v\\.    `$k<MR&MF$$?&J'     HJ'   ");
                System.out.println("              `\\?\\.       `\\b/$$$&v!-?&<?::P\\    `'^-^-?b=Sd'     |\\T   ");
                System.out.println("  _o~=~$&$>==v\\.??\\,         `\\d `\\$$'9P':-?>:'=\\ooo/=/$$~?$\\     ,R/   ");
                System.out.println("./$?~^''''''`'\\&&< ?b               '`~$P:c: /v==v,#::?<<&:'T|   d$/'   ");
                System.out.println(":.             ''=o/&.                ,P    o&Z'`'.##| |MH\\|| ,$$'   ");
                System.out.println("=:$H&=\\.           `'b?b.             .&'    96*.-v.:?/`\\==$&?$&*'   ");
                System.out.println("    `^$?\\.           `*&*\\          ,P       ?~-~'      |$$S>'   ");
                System.out.println("       `\7b           ,T/\\&&\\.      d?                    |T'   ");
                System.out.println("         \\/b         .&J'  `\\>     d'                      T,   ");
                System.out.println("          &`L        /||          ?|                        ?,   ");
                System.out.println("          ||9       J\\T           H                          ?,   ");
                System.out.println("           H||     ||/           ||                           9,   ");
                System.out.println("           ||M     PJ'           ||                           `H   ");
                System.out.println("            bT,   ||T            ||                            ||   ");
            } 
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    private void place7()
    {
        boolean finished = false;
        System.out.println("You are now in Place 7");
        if(captin==4){
            System.out.println("Congratulations! You have reached Captin Jones!");
            System.out.println("Now that you have Captin Jones, you need to return back to our base safely.");
            System.out.println("To do that, you will need to travel back to place 1, and when you get \nthere, you need to type in 'base' to reach your destination.");
            System.out.println("Good luck!");
            System.out.println("If you forget, you can always type 'captin' and you will recieve the directions to finish the game.");
        }
        else{
            System.out.println("The captin is not here. Sorry!");
        }
        if(enemyPlacement==4){
            System.out.println("There are double the hoarde of agents \nfrom the Society of the Evening Star coming to \nattack you!");
            System.out.println("                                             |______| ");
            System.out.println("                            _                 |    | ");
            System.out.println("                           | `-._             |    | ");
            System.out.println("         __________________|_____`._______    /    /____________________________.-.____________ ");
            System.out.println("     __.`-------------------____----------`--/`._.`-----|                        o|            | ");
            System.out.println("    ||                     (____)            |          | ======================  |____________| ");
            System.out.println("    ||_______________________________________|__________| ======================  | ");
            System.out.println("    '-._o                          o____(_)_____________| ============= ____..o---' ");
            System.out.println("        `.           __0-------''-`          `---..--._(|_o______.-----`      `.O.` ");
            System.out.println("          )     o  .' //       ||                                            __//__ ");
            System.out.println("         /        (   \\       ||                                           `------` ");
            System.out.println("        /         \\___________//                                            |     | ");
            System.out.println("       /         __/-----------`                                             |     | ");
            System.out.println("   _./          (                                                            /     / ");
            System.out.println(" _.-`             )                                                         /     / ");
            System.out.println(" \\              (                                                          /     / ");
            System.out.println("  \\     _ o      )                                                       _/     / ");
            System.out.println("   \\_.-`        ( _                                                  _.-`   _.-` ");
            System.out.println("    (_____________)O)                                             _.-`   _.-` ");
            System.out.println("                 __\\__                                       _.-`   _.-` ");
            System.out.println("                `------`.                                 _.-`   _.-` ");
            System.out.println("                 \\     |                             _.-`   _.-` ");
            System.out.println("                  \\    \\_                       _.-`   _.-` ");
            System.out.println("                   `-._    `-._              __.-`   _.-` ");
            System.out.println("                       `-._    `-.__.--===--`    _.-` ");
            System.out.println("                           `-._     / LGB  \\_.-` ");
            System.out.println("                               `-._.--=====-` ");
            System.out.println("Would you like to fight or run?");
        }
        else{
            System.out.println("There is a hoarde of agents from the Society of the Evening Star \ncoming to attack you!");
            System.out.println("                                             |______| ");
            System.out.println("                            _                 |    | ");
            System.out.println("                           | `-._             |    | ");
            System.out.println("         __________________|_____`._______    /    /____________________________.-.____________ ");
            System.out.println("     __.`-------------------____----------`--/`._.`-----|                        o|            | ");
            System.out.println("    ||                     (____)            |          | ======================  |____________| ");
            System.out.println("    ||_______________________________________|__________| ======================  | ");
            System.out.println("    '-._o                          o____(_)_____________| ============= ____..o---' ");
            System.out.println("        `.           __0-------''-`          `---..--._(|_o______.-----`      `.O.` ");
            System.out.println("          )     o  .' //       ||                                            __//__ ");
            System.out.println("         /        (   \\       ||                                           `------` ");
            System.out.println("        /         \\___________//                                            |     | ");
            System.out.println("       /         __/-----------`                                             |     | ");
            System.out.println("   _./          (                                                            /     / ");
            System.out.println(" _.-`             )                                                         /     / ");
            System.out.println(" \\              (                                                          /     / ");
            System.out.println("  \\     _ o      )                                                       _/     / ");
            System.out.println("   \\_.-`        ( _                                                  _.-`   _.-` ");
            System.out.println("    (_____________)O)                                             _.-`   _.-` ");
            System.out.println("                 __\\__                                       _.-`   _.-` ");
            System.out.println("                `------`.                                 _.-`   _.-` ");
            System.out.println("                 \\     |                             _.-`   _.-` ");
            System.out.println("                  \\    \\_                       _.-`   _.-` ");
            System.out.println("                   `-._    `-._              __.-`   _.-` ");
            System.out.println("                       `-._    `-.__.--===--`    _.-` ");
            System.out.println("                           `-._     / LGB  \\_.-` ");
            System.out.println("                               `-._.--=====-` ");
            System.out.println("Would you like to fight or run?");
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("p7")) {
                finished = false;
                System.out.println("You are already in place 7, silly!");
            }
            else if(input.contains("fight")){
                finished=true;
                System.out.println("\u000C");
                chooseWeapon();
                if(enemyPlacement==4){
                    enemyHealth=150;
                    fight4();
                }
                else{
                    enemyHealth=75;
                    fight4();
                }
            }
            else if(input.contains("run")){
                int index=rand.nextInt(3);
                if(index==0){
                    finished=true;
                    System.out.println("Running was a bad idea. You got trapped in a VERY obvious hunting trap \nand you fall over. Your enemies then trap you and hang you.");
                    System.out.println("GAME OVER");
                    System.out.println("You were in Place 7");
                    if(captin==1){
                        System.out.println("You made it 20%");
                    }
                    else if(captin==2){
                        System.out.println("You made it 30%");
                    }
                    else if(captin==3){
                        System.out.println("You made it 40%");
                    }
                    else if(captin==4){
                        System.out.println("You made it 50%");
                    }
                    else if(captin==5){
                        System.out.println("You made it 40%");
                    }
                    printGoodbye();
                }
                else{
                    System.out.println("You escaped from the agents from the Society of the Evening Star!");
                    System.out.println("Go to place 5 to recover.");
                }
            }
            else if(input.contains("p5")){
                finished = true;
                System.out.println("\u000C");
                place5();
            }
            else if(input.contains("p8")){
                finished=true;
                System.out.println("\u000C");
                place8();
            } 
            else if(input.contains("map")){
                map();
            }           
            else if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else if(input.contains("captin")){
                captinInstructions();
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    private void place7b()
    {
        boolean finished = false;
        System.out.println("You are now in Place 7");
        if(captin==4){
            System.out.println("Congratulations! You have reached Captin Jones!");
            System.out.println("Now that you have Captin Jones, you need to return back to our base safely.");
            System.out.println("To do that, you will need to travel back to place 1, and when you get \nthere, you need to type in 'base' to reach your destination.");
            System.out.println("Good luck!");
            System.out.println("If you forget, you can always type 'captin' and you will recieve the directions to finish the game.");
        }
        else{
            System.out.println("Continue your journey to find Captin Jones!");            
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }

            else if(input.contains("p7")) {
                finished = false;
                System.out.println("You are already in Place 7, silly!");
            }
            else if(input.contains("p8")){
                finished = true;
                System.out.println("\u000C");
                place8();
            }
            else if(input.contains("p5")){
                finished=true;
                System.out.println("\u000C");
                place5();
            }
            else if(input.contains("map")){
                map();
            }   
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else if(input.contains("captin")){
                captinInstructions();
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    private void place8()
    {
        boolean finished = false;
        System.out.println("You are now in Place 8");
        if(captin==5){
            System.out.println("Congratulations! You have reached Captin Jones!");
            System.out.println("Now that you have Captin Jones, you need to return back to our base safely.");
            System.out.println("To do that, you will need to travel back to place 1, and when you get \nthere, you need to type in 'base' to reach your destination.");
            System.out.println("Good luck!");
            System.out.println("If you forget, you can always type 'captin' and you will recieve the directions to finish the game.");
        }
        else{
            System.out.println("The captin is not here. Sorry!");
        }
        if(enemyPlacement==5){
            System.out.println("One of your agents was a spy for the Society of the Evening Star, \nand turned on you! Double the enemies are coming!");
            System.out.println("                                             |______| ");
            System.out.println("                            _                 |    | ");
            System.out.println("                           | `-._             |    | ");
            System.out.println("         __________________|_____`._______    /    /____________________________.-.____________ ");
            System.out.println("     __.`-------------------____----------`--/`._.`-----|                        o|            | ");
            System.out.println("    ||                     (____)            |          | ======================  |____________| ");
            System.out.println("    ||_______________________________________|__________| ======================  | ");
            System.out.println("    '-._o                          o____(_)_____________| ============= ____..o---' ");
            System.out.println("        `.           __0-------''-`          `---..--._(|_o______.-----`      `.O.` ");
            System.out.println("          )     o  .' //       ||                                            __//__ ");
            System.out.println("         /        (   \\       ||                                           `------` ");
            System.out.println("        /         \\___________//                                            |     | ");
            System.out.println("       /         __/-----------`                                             |     | ");
            System.out.println("   _./          (                                                            /     / ");
            System.out.println(" _.-`             )                                                         /     / ");
            System.out.println(" \\              (                                                          /     / ");
            System.out.println("  \\     _ o      )                                                       _/     / ");
            System.out.println("   \\_.-`        ( _                                                  _.-`   _.-` ");
            System.out.println("    (_____________)O)                                             _.-`   _.-` ");
            System.out.println("                 __\\__                                       _.-`   _.-` ");
            System.out.println("                `------`.                                 _.-`   _.-` ");
            System.out.println("                 \\     |                             _.-`   _.-` ");
            System.out.println("                  \\    \\_                       _.-`   _.-` ");
            System.out.println("                   `-._    `-._              __.-`   _.-` ");
            System.out.println("                       `-._    `-.__.--===--`    _.-` ");
            System.out.println("                           `-._     / LGB  \\_.-` ");
            System.out.println("                               `-._.--=====-` ");
            System.out.println("Would you like to fight or run?");
        }
        else{
            System.out.println("One of your agents was a spy for the Society of the Evening Star, \nand turned on you! Enemies are coming!");
            System.out.println("                                             |______| ");
            System.out.println("                            _                 |    | ");
            System.out.println("                           | `-._             |    | ");
            System.out.println("         __________________|_____`._______    /    /____________________________.-.____________ ");
            System.out.println("     __.`-------------------____----------`--/`._.`-----|                        o|            | ");
            System.out.println("    ||                     (____)            |          | ======================  |____________| ");
            System.out.println("    ||_______________________________________|__________| ======================  | ");
            System.out.println("    '-._o                          o____(_)_____________| ============= ____..o---' ");
            System.out.println("        `.           __0-------''-`          `---..--._(|_o______.-----`      `.O.` ");
            System.out.println("          )     o  .' //       ||                                            __//__ ");
            System.out.println("         /        (   \\       ||                                           `------` ");
            System.out.println("        /         \\___________//                                            |     | ");
            System.out.println("       /         __/-----------`                                             |     | ");
            System.out.println("   _./          (                                                            /     / ");
            System.out.println(" _.-`             )                                                         /     / ");
            System.out.println(" \\              (                                                          /     / ");
            System.out.println("  \\     _ o      )                                                       _/     / ");
            System.out.println("   \\_.-`        ( _                                                  _.-`   _.-` ");
            System.out.println("    (_____________)O)                                             _.-`   _.-` ");
            System.out.println("                 __\\__                                       _.-`   _.-` ");
            System.out.println("                `------`.                                 _.-`   _.-` ");
            System.out.println("                 \\     |                             _.-`   _.-` ");
            System.out.println("                  \\    \\_                       _.-`   _.-` ");
            System.out.println("                   `-._    `-._              __.-`   _.-` ");
            System.out.println("                       `-._    `-.__.--===--`    _.-` ");
            System.out.println("                           `-._     / LGB  \\_.-` ");
            System.out.println("                               `-._.--=====-` ");
            System.out.println("Would you like to fight or run?");
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("p8")) {
                finished = false;
                System.out.println("You are already in place 8, silly!");
            }
            else if(input.contains("fight")){
                finished=true;
                System.out.println("\u000C");
                chooseWeapon();
                if(enemyPlacement==5){
                    enemyHealth=150;
                    fight5();
                }
                else{
                    enemyHealth=75;
                    fight5();
                }
            }
            else if(input.contains("run")){
                int index=rand.nextInt(3);
                if(index==0){
                    finished=true;
                    System.out.println("Running was a bad idea. You get cornered and trapped. The Society of the Evening Star then tests you on their new torture device. \nYou die screaming.");
                    System.out.println("GAME OVER");
                    System.out.println("You were in Place 8");
                    if(captin==1){
                        System.out.println("You made it 30%");
                    }
                    else if(captin==2){
                        System.out.println("You made it 40%");
                    }
                    else if(captin==3){
                        System.out.println("You made it 40%");
                    }
                    else if(captin==4){
                        System.out.println("You made it 40%");
                    }
                    else if(captin==5){
                        System.out.println("You made it 50%");
                    }
                    printGoodbye();
                }
                else{
                    System.out.println("You escaped from your enemies!");
                    System.out.println("Go back to place 6 or place 5 to move out of their territory.");
                }
            }
            else if(input.contains("p7")){
                finished = true;
                System.out.println("\u000C");
                place7();
            }
            else if(input.contains("p6")){
                finished=true;
                System.out.println("\u000C");
                place6();
            } 
            else if(input.contains("p5")){
                finished=true;
                System.out.println("\u000C");
                place5();
            } 
            else if(input.contains("p4")){
                finished=true;
                System.out.println("\u000C");
                place4();
            } 
            else if(input.contains("map")){
                map();
            }

            else if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else if(input.contains("captin")){
                captinInstructions();
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    /**
     * Start the technical support system. This will print a welcome
     * message and enter into a dialog with the user, until the user
     * ends the dialog.
     */
    private void place8b()
    {
        boolean finished = false;
        System.out.println("You are now in Place 8");
        if(captin==5){
            System.out.println("Congratulations! You have reached Captin Jones!");
            System.out.println("Now that you have Captin Jones, you need to return back to our base safely.");
            System.out.println("To do that, you will need to travel back to place 1, and when you get \nthere, you need to type in 'base' to reach your destination.");
            System.out.println("Good luck!");
            System.out.println("If you forget, you can always type 'captin' and you will recieve the directions to finish the game.");
        }
        else{
            System.out.println("Continue your journey to find Captin Jones!");
        }

        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("bye")){
                finished=true;
                printGoodbye();
            }

            else if(input.contains("p8")) {
                finished = false;
                System.out.println("You are already in Place 8, silly!");
            }
            else if(input.contains("p7")){
                finished = true;
                System.out.println("\u000C");
                place7();
            }
            else if(input.contains("p6")){
                finished=true;
                System.out.println("\u000C");
                place6();
            }
            else if(input.contains("p5")){
                finished=true;
                System.out.println("\u000C");
                place5();
            }
            else if(input.contains("p4")){
                finished=true;
                System.out.println("\u000C");
                place4();
            }
            else if(input.contains("map")){
                map();
            }   
            else if(input.contains("health")){
                System.out.println("Your health is "+playerHealth);
            }
            else if(input.contains("instructions")){
                instructions();
            }
            else if(input.contains("coins")){
                System.out.println("You have "+coins+" coins");
                System.out.println("You had "+coins+" coins");
                System.out.println("                 ______________ ");
                System.out.println("    __,.,---'''''              '''''---..._ ");
                System.out.println(" ,-'             .....:::''::.:            '`-. ");
                System.out.println(" '           ...:::.....       ' ");
                System.out.println("             ''':::'''''       .               , ");
                System.out.println(" |'-.._           ''''':::..::':          __,,- ");
                System.out.println(" '-.._''`---.....______________.....---''__,,- ");
                System.out.println("       ''`---.....______________.....---'' ");
            }
            else if(input.contains("captin")){
                captinInstructions();
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    private void captinInstructions()
    {
        System.out.println("Now that you have Captin Jones, you need to return back to our base safely.");
        System.out.println("To do that, you will need to travel back to place 1, and when you get \nthere, you need to type in 'base' to reach your destination.");
        System.out.println("Good luck!");
        System.out.println("If you forget, you can always type 'captin' and you will recieve the directions to finish the game.");
    }

    private void map()
    {
        System.out.println();
        System.out.println("       (2)-------(1)--------(3)       ");
        System.out.println("        |         /\\         |        ");
        System.out.println("        |        /  \\        |        ");
        System.out.println("        |       /    \\       |        ");
        System.out.println("        |      /      \\      |        ");
        System.out.println("        |     /        \\     |        ");
        System.out.println("        |    /          \\    |        ");
        System.out.println("        |   /            \\   |        ");
        System.out.println("        |  /              \\  |        ");
        System.out.println("        (4)-----------------(5)       ");
        System.out.println("        | \\                / |       ");
        System.out.println("        |  \\              /  |       ");
        System.out.println("        |   \\            /   |       ");
        System.out.println("        |    \\          /    |       ");
        System.out.println("        |     \\        /     |       ");
        System.out.println("        |      \\      /      |       ");
        System.out.println("        |       \\    /       |       ");
        System.out.println("        |        \\  /        |       ");
        System.out.println("        |         \\/         |       ");
        System.out.println("       (6)--------(8)-------(7)       ");
        System.out.println();
    }

    /**
     * Print a welcome message to the screen.
     */
    private void printWelcome()
    {
        System.out.println("URGENT: Message from the FBI");

        System.out.println("'||''''| '||'''|,  |''||''|       '||\\   /||`                                          |''||''|                                            '||     '||`        ");
        System.out.println(" ||  .    ||   ||     ||    ||     || \\./ ||   ''               ''                        ||                                           ''   ||      ||         ");
        System.out.println(" ||''|    ||;;;;      ||           ||     ||   ||  ('''' (''''  ||  .|''|, `||''|,        ||    '||),,(|,  '||''|, .|''|, ('''' (''''  ||   ||''|,  ||  .|''|, ");
        System.out.println(" ||       ||   ||     ||    ||     ||     ||   ||   `'')  `'')  ||  ||  ||  ||  ||        ||     || || ||   ||  || ||  ||  `'')  `'')  ||   ||  ||  ||  ||..|| ");
        System.out.println(".||.     .||...|'  |..||..|       .||     ||. .||. `...' `...' .||. `|..|' .||  ||.    |..||..| .||    ||.  ||..|' `|..|' `...' `...' .||. .||..|' .||. `|...  ");
        System.out.println("                                                                                                            ||                                                 ");
        System.out.println("                                                                                                           .|| ");       
        System.out.println("Coded by: Sophie Steven");
        System.out.println("Made possible by Mr. Cole");
        System.out.println("Welcome to FBI: Mission Impossible! In this game, your objective is to save \nthe day by saving our commander, \nCaptain Franz Jones. He has been captured by our enemy, \nthe Society of the Evening Star. To save him, you will \nneed to reach the location of where he is kept prisoner and back safely. \nWe do not know where Captin Jones is. \nYou will get standard military armor, but you will get to \nselect what weapon you hold. You will be able to \nchoose one of our top grade weapons that are fail safe. You have \naccess to a map of where you are. You can also travel from place to place by \ntyping the name of the location that is on the map."); 
        System.out.println("We’ll get you suited up, and good luck!");
        System.out.println("Some basic commands to move around the game:");
        System.out.println("p1 - Place 1");
        System.out.println("p2 - Place 2");
        System.out.println("p3 - Place 3");
        System.out.println("p4 - Place 4");
        System.out.println("p5 - Place 5");
        System.out.println("p6 - Place 6");
        System.out.println("p7 - Place 7");
        System.out.println("p8 - Place 8");
        System.out.println("health - your health");
        System.out.println("bye - leave the game");
        System.out.println("map - map of where the places are located");
        System.out.println("instructions - how to operate the game");
    }

    private void instructions()
    {
        System.out.println("p1 - Place 1");
        System.out.println("p2 - Place 2");
        System.out.println("p3 - Place 3");
        System.out.println("p4 - Place 4");
        System.out.println("p5 - Place 5");
        System.out.println("p6 - Place 6");
        System.out.println("p7 - Place 7");
        System.out.println("p8 - Place 8");
        System.out.println("health - your health");
        System.out.println("bye - leave the game");
        System.out.println("map - map of where the places are located");
        System.out.println("instructions - how to operate the game");
    }

    /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye()
    {
        boolean finished=false;
        if(captin==1){
            System.out.println("Captin Jones was in Place 2");
        }
        else if(captin==2){
            System.out.println("Captin Jones was in Place 4");
        }
        else if(captin==3){
            System.out.println("Captin Jones was in Place 5");
        }
        else if(captin==4){
            System.out.println("Captin Jones was in Place 7");
        }
        else if(captin==5){
            System.out.println("Captin Jones was in Place 8");
        }
        System.out.println("You had "+coins+" coins");
        System.out.println("                 ______________ ");
        System.out.println("    __,.,---'''''              '''''---..._ ");
        System.out.println(" ,-'             .....:::''::.:            '`-. ");
        System.out.println(" '           ...:::.....       ' ");
        System.out.println("             ''':::'''''       .               , ");
        System.out.println(" |'-.._           ''''':::..::':          __,,- ");
        System.out.println(" '-.._''`---.....______________.....---''__,,- ");
        System.out.println("       ''`---.....______________.....---'' ");
        System.out.println("Thanks for helping us, anyway...");
        System.out.println("Would you like to play again?");
        while(!finished) {
            HashSet input = reader.getInput();

            if(input.contains("yes")){
                finished=true;
                start();
            }

            else if(input.contains("no")) {
                finished = true;
                System.out.println("Ok. Bye.");
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
    }

    private void chooseWeapon()
    {
        boolean finished=false;
        System.out.println("-Choose Your Weapon-");
        System.out.println("Bow and Arrow");
        System.out.println("Rifle");
        System.out.println("Pistol");
        System.out.println("Sword");
        System.out.println("Knife");
        System.out.println("Crossbow");
        System.out.println("Spear");
        System.out.println("My fists");

        while(!finished){
            HashSet input = reader.getInput();

            if(input.contains("bow")&&input.contains("and")&&input.contains("arrow")){
                finished=true;
                System.out.println("You have chosen to attack with a bow and arrow");
                damage=10;
            }
            else if(input.contains("rifle")){
                finished=true;
                System.out.println("You have chosen to attack with a rifle");
                damage=30;
            }
            else if(input.contains("pistol")){
                finished=true;
                System.out.println("You have chosen to attack with a pistol");
                damage=20;
            }
            else if(input.contains("sword")){
                finished=true;
                System.out.println("You have chosen to attack with a sword");
                damage=15;
            }
            else if(input.contains("knife")){
                finished=true;
                System.out.println("You have chosen to attack with a knife");
                damage=10;
            }
            else if(input.contains("crossbow")){
                finished=true;
                System.out.println("You have chosen to attack with a crossbow");
                damage=25;
            }
            else if(input.contains("spear")){
                finished=true;
                System.out.println("You have chosen to attack with a spear");
                damage=5;
            }
            else if(input.contains("my")&&input.contains("fists")||input.contains("fists")){
                finished=true;
                System.out.println("You have chosen to attack with your fists");
                damage=0;
            }
            else {
                System.out.println("Please choose on of the weapons above.");
            }
        }
    }

    private void fight1()
    {
        while(playerHealth>0 && enemyHealth>0){
            int enemyAttack=rand.nextInt(7);
            playerHealth-=enemyAttack;
            System.out.println("Player Health "+playerHealth);

            int playerAttack=rand.nextInt(10);
            enemyHealth-=playerAttack;
            System.out.println("Enemy Health "+enemyHealth);
        }
        if(playerHealth<1&&enemyHealth<1){
            System.out.println("You won the battle...barely.");
            playerHealth=2;
            System.out.println("Your health is "+playerHealth);
            System.out.println("You won 25 gold coins!");
            System.out.println("                 ______________ ");
            System.out.println("    __,.,---'''''              '''''---..._ ");
            System.out.println(" ,-'             .....:::''::.:            '`-. ");
            System.out.println(" '           ...:::.....       ' ");
            System.out.println("             ''':::'''''       .               , ");
            System.out.println(" |'-.._           ''''':::..::':          __,,- ");
            System.out.println(" '-.._''`---.....______________.....---''__,,- ");
            System.out.println("       ''`---.....______________.....---'' ");
            coins+=25;
            System.out.println();
            place2b();
        }
        else if(enemyHealth<1){
            System.out.println("You defeated your enemies!");
            System.out.println("Your health is "+playerHealth);
            System.out.println("You won 50 gold coins!");
            System.out.println("                 ______________ ");
            System.out.println("    __,.,---'''''              '''''---..._ ");
            System.out.println(" ,-'             .....:::''::.:            '`-. ");
            System.out.println(" '           ...:::.....       ' ");
            System.out.println("             ''':::'''''       .               , ");
            System.out.println(" |'-.._           ''''':::..::':          __,,- ");
            System.out.println(" '-.._''`---.....______________.....---''__,,- ");
            System.out.println("       ''`---.....______________.....---'' ");
            coins+=50;
            System.out.println();
            place2b();
        }
        else{
            System.out.println("You have lost the battle.");
            System.out.println("You are dead...GAME OVER");
            System.out.println("Your enemies had "+enemyHealth+" health remaining.");
            System.out.println("You were in Place 2");
            if(captin==1){
                System.out.println("You made it 50%");
            }
            else if(captin==2){
                System.out.println("You made it 40%");
            }
            else if(captin==3){
                System.out.println("You made it 30%");
            }
            else if(captin==4){
                System.out.println("You made it 20%");
            }
            else if(captin==5){
                System.out.println("You made it 30%");
            }
            System.out.println();
            printGoodbye();
        }
    }

    private void fight2()
    {
        while(playerHealth>0 && enemyHealth>0){
            int enemyAttack=rand.nextInt(7);
            playerHealth-=enemyAttack;
            System.out.println("Player Health "+playerHealth);

            int playerAttack=rand.nextInt(10);
            enemyHealth-=playerAttack;
            System.out.println("Enemy Health "+enemyHealth);
        }
        if(playerHealth<1&&enemyHealth<1){
            System.out.println("You won the battle...barely.");
            playerHealth=2;
            System.out.println("Your health is "+playerHealth);
            System.out.println("You won 25 gold coins!");
            System.out.println("                 ______________ ");
            System.out.println("    __,.,---'''''              '''''---..._ ");
            System.out.println(" ,-'             .....:::''::.:            '`-. ");
            System.out.println(" '           ...:::.....       ' ");
            System.out.println("             ''':::'''''       .               , ");
            System.out.println(" |'-.._           ''''':::..::':          __,,- ");
            System.out.println(" '-.._''`---.....______________.....---''__,,- ");
            System.out.println("       ''`---.....______________.....---'' ");
            coins+=25;
            System.out.println();
            place4b();
        }
        else if(enemyHealth<1){
            System.out.println("You defeated your enemies!");
            System.out.println("Your health is "+playerHealth);
            System.out.println("You won 50 gold coins!"); 
            System.out.println("                 ______________ ");
            System.out.println("    __,.,---'''''              '''''---..._ ");
            System.out.println(" ,-'             .....:::''::.:            '`-. ");
            System.out.println(" '           ...:::.....       ' ");
            System.out.println("             ''':::'''''       .               , ");
            System.out.println(" |'-.._           ''''':::..::':          __,,- ");
            System.out.println(" '-.._''`---.....______________.....---''__,,- ");
            System.out.println("       ''`---.....______________.....---'' ");
            coins+=50;
            System.out.println();
            place4b();
        }
        else{
            System.out.println("You have lost the battle.");
            System.out.println("You are dead...GAME OVER");
            System.out.println("Your enemies had "+enemyHealth+" health remaining.");
            System.out.println("You were in Place 4");
            if(captin==1){
                System.out.println("You made it 40%");
            }
            else if(captin==2){
                System.out.println("You made it 50%");
            }
            else if(captin==3){
                System.out.println("You made it 40%");
            }
            else if(captin==4){
                System.out.println("You made it 30%");
            }
            else if(captin==5){
                System.out.println("You made it 40%");
            }
            System.out.println();
            printGoodbye();
        }
    }

    private void fight3()
    {
        while(playerHealth>0 && enemyHealth>0){
            int enemyAttack=rand.nextInt(7);
            playerHealth-=enemyAttack;
            System.out.println("Player Health "+playerHealth);

            int playerAttack=rand.nextInt(10);
            enemyHealth-=playerAttack;
            System.out.println("Enemy Health "+enemyHealth);
        }
        if(playerHealth<1&&enemyHealth<1){
            System.out.println("You won the battle...barely.");
            playerHealth=2;
            System.out.println("Your health is "+playerHealth);
            System.out.println("You won 25 gold coins!");
            System.out.println("                 ______________ ");
            System.out.println("    __,.,---'''''              '''''---..._ ");
            System.out.println(" ,-'             .....:::''::.:            '`-. ");
            System.out.println(" '           ...:::.....       ' ");
            System.out.println("             ''':::'''''       .               , ");
            System.out.println(" |'-.._           ''''':::..::':          __,,- ");
            System.out.println(" '-.._''`---.....______________.....---''__,,- ");
            System.out.println("       ''`---.....______________.....---'' ");
            coins+=25;
            System.out.println();
            place5b();
        }
        else if(enemyHealth<1){
            System.out.println("You defeated your enemies!");
            System.out.println("Your health is "+playerHealth);
            System.out.println("You won 50 gold coins!");
            System.out.println("                 ______________ ");
            System.out.println("    __,.,---'''''              '''''---..._ ");
            System.out.println(" ,-'             .....:::''::.:            '`-. ");
            System.out.println(" '           ...:::.....       ' ");
            System.out.println("             ''':::'''''       .               , ");
            System.out.println(" |'-.._           ''''':::..::':          __,,- ");
            System.out.println(" '-.._''`---.....______________.....---''__,,- ");
            System.out.println("       ''`---.....______________.....---'' ");
            System.out.println();
            place5b();
        }
        else{
            System.out.println("You have lost the battle.");
            System.out.println("You are dead...GAME OVER");
            System.out.println("Your enemies had "+enemyHealth+" health remaining.");
            System.out.println("You were in Place 5");
            if(captin==1){
                System.out.println("You made it 30%");
            }
            else if(captin==2){
                System.out.println("You made it 40%");
            }
            else if(captin==3){
                System.out.println("You made it 50%");
            }
            else if(captin==4){
                System.out.println("You made it 240%");
            }
            else if(captin==5){
                System.out.println("You made it 40%");
            }
            System.out.println();
            printGoodbye();
        }
    }

    private void fight4()
    {
        while(playerHealth>0 && enemyHealth>0){
            int enemyAttack=rand.nextInt(7);
            playerHealth-=enemyAttack;
            System.out.println("Player Health "+playerHealth);

            int playerAttack=rand.nextInt(10);
            enemyHealth-=playerAttack;
            System.out.println("Enemy Health "+enemyHealth);
        }
        if(playerHealth<1&&enemyHealth<1){
            System.out.println("You won the battle...barely.");
            playerHealth=2;
            System.out.println("Your health is "+playerHealth);
            System.out.println("You won 25 gold coins!");
            System.out.println("                 ______________ ");
            System.out.println("    __,.,---'''''              '''''---..._ ");
            System.out.println(" ,-'             .....:::''::.:            '`-. ");
            System.out.println(" '           ...:::.....       ' ");
            System.out.println("             ''':::'''''       .               , ");
            System.out.println(" |'-.._           ''''':::..::':          __,,- ");
            System.out.println(" '-.._''`---.....______________.....---''__,,- ");
            System.out.println("       ''`---.....______________.....---'' ");
            coins+=25;
            System.out.println();
            place7b();
        }
        else if(enemyHealth<1){
            System.out.println("You defeated your enemies!");
            System.out.println("Your health is "+playerHealth);
            System.out.println("You won 50 gold coins!");
            System.out.println("                 ______________ ");
            System.out.println("    __,.,---'''''              '''''---..._ ");
            System.out.println(" ,-'             .....:::''::.:            '`-. ");
            System.out.println(" '           ...:::.....       ' ");
            System.out.println("             ''':::'''''       .               , ");
            System.out.println(" |'-.._           ''''':::..::':          __,,- ");
            System.out.println(" '-.._''`---.....______________.....---''__,,- ");
            System.out.println("       ''`---.....______________.....---'' ");
            coins+=50;
            System.out.println();
            place7b();
        }
        else{
            System.out.println("You have lost the battle.");
            System.out.println("You are dead...GAME OVER");
            System.out.println("Your enemies had "+enemyHealth+" health remaining.");
            System.out.println("You were in Place 7");
            if(captin==1){
                System.out.println("You made it 20%");
            }
            else if(captin==2){
                System.out.println("You made it 30%");
            }
            else if(captin==3){
                System.out.println("You made it 40%");
            }
            else if(captin==4){
                System.out.println("You made it 50%");
            }
            else if(captin==5){
                System.out.println("You made it 40%");
            }
            System.out.println();
            printGoodbye();
        }
    }

    private void fight5()
    {
        while(playerHealth>0 && enemyHealth>0){
            int enemyAttack=rand.nextInt(7);
            playerHealth-=enemyAttack;
            System.out.println("Player Health "+playerHealth);

            int playerAttack=rand.nextInt(10);
            enemyHealth-=playerAttack;
            System.out.println("Enemy Health "+enemyHealth);
        }
        if(playerHealth<1&&enemyHealth<1){
            System.out.println("You won the battle...barely.");
            playerHealth=2;
            System.out.println("Your health is "+playerHealth);
            System.out.println("You won 25 gold coins!");
            System.out.println("                 ______________ ");
            System.out.println("    __,.,---'''''              '''''---..._ ");
            System.out.println(" ,-'             .....:::''::.:            '`-. ");
            System.out.println(" '           ...:::.....       ' ");
            System.out.println("             ''':::'''''       .               , ");
            System.out.println(" |'-.._           ''''':::..::':          __,,- ");
            System.out.println(" '-.._''`---.....______________.....---''__,,- ");
            System.out.println("       ''`---.....______________.....---'' ");
            System.out.println();
            place8b();
        }
        else if(enemyHealth<1){
            System.out.println("You defeated your enemies!");
            System.out.println("Your health is "+playerHealth);
            System.out.println("You won 50 gold coins!");
            System.out.println("                 ______________ ");
            System.out.println("    __,.,---'''''              '''''---..._ ");
            System.out.println(" ,-'             .....:::''::.:            '`-. ");
            System.out.println(" '           ...:::.....       ' ");
            System.out.println("             ''':::'''''       .               , ");
            System.out.println(" |'-.._           ''''':::..::':          __,,- ");
            System.out.println(" '-.._''`---.....______________.....---''__,,- ");
            System.out.println("       ''`---.....______________.....---'' ");
            coins+=50;
            System.out.println();
            place8b();
        }
        else{
            System.out.println("You have lost the battle.");
            System.out.println("You are dead...GAME OVER");
            System.out.println("Your enemies had "+enemyHealth+" health remaining.");
            System.out.println("You were in Place 8");
            if(captin==1){
                System.out.println("You made it 30%");
            }
            else if(captin==2){
                System.out.println("You made it 40%");
            }
            else if(captin==3){
                System.out.println("You made it 40%");
            }
            else if(captin==4){
                System.out.println("You made it 40%");
            }
            else if(captin==5){
                System.out.println("You made it 50%");
            }
            System.out.println();
            printGoodbye();
        }
    }
}
