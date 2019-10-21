import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java. util.Iterator;
/**
 * The responder class represents a response generator object. It is
 * used to generate an automatic response.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    0.1  (1.Feb.2002)
 */
public class Responder
{
    private Random randomGenerator;
    private ArrayList responses;
    private HashMap responseMap;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        randomGenerator=new Random();
        responses=new ArrayList();
        fillResponses();
        responseMap=new HashMap();
        fillResponseMap();
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String pickDefaultResponse()
    {
        int index = randomGenerator.nextInt (responses.size ( ));
        return (String) responses.get (index);
    }

    private void fillResponseMap()
    {
        responseMap.put ("1", "If you want to go to place 1, then type in the word p1");
        responseMap.put ("2", "If you want to go to place 2, then type in the word p2");
        responseMap.put ("3", "If you want to go to place 3, then type in the word p3");
        responseMap.put ("4", "If you want to go to place 4, then type in the word p4");
        responseMap.put ("5", "If you want to go to place 5, then type in the word p5");
        responseMap.put ("6", "If you want to go to place 6, then type in the word p6");
        responseMap.put ("7", "If you want to go to place 7, then type in the word p7");
        responseMap.put ("8", "If you want to go to place 8, then type in the word p8");
        responseMap.put ("place 1", "If you want to go to place 1, then type in the word p1");
        responseMap.put ("place 2", "If you want to go to place 2, then type in the word p2");
        responseMap.put ("place 3", "If you want to go to place 3, then type in the word p3");
        responseMap.put ("place 4", "If you want to go to place 4, then type in the word p4");
        responseMap.put ("place 5", "If you want to go to place 5, then type in the word p5");
        responseMap.put ("place 6", "If you want to go to place 6, then type in the word p6");
        responseMap.put ("place 7", "If you want to go to place 7, then type in the word p7");
        responseMap.put ("place 8", "If you want to go to place 8, then type in the word p8");
    }

    private void fillResponses()
    {
        responses.add ("Command not recognized");
        responses.add ("Please try a different command");
        responses.add ("Illegal command");
        responses.add ("Not a valid command");
        responses.add ("Unrecognized command");
        responses.add ("Try a different command in this portion of FBI: Mission Impossible!");
        responses.add ("I don't think that your previous command is part of the game!");
    }

    public String generateResponse (HashSet words)
    {
        Iterator it = words.iterator( );
        while (it.hasNext( )){
            String word = (String) it.next ( );
            String response = (String) responseMap.get(word);
            if (response != null) {
                return response;
            }
        }
        return pickDefaultResponse();
    }
}