import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main( String[] args )
    {

        Main m = new Main();
        List<String> list = new ArrayList<>();

        try(BufferedReader br = new BufferedReader( new InputStreamReader(Main.class.getResourceAsStream("eff_large_wordlist.txt")) ))
        {

            Scanner input = new Scanner( System.in );
            String st;

            while( ( st = br.readLine() ) != null )
            {
                list.add( st );
            }

            System.out.println( "How many words should your password contain (6 or more is recommended)" );

            int wordCount = input.nextInt();

            ArrayList<String> numList = m.randomiser( wordCount );

            System.out.println();

            for ( String i : numList )
            {
                m.regexer( list, i );
                //System.out.println("hey" + i);
            }

            System.out.println();
            System.out.println();

        }
        catch ( FileNotFoundException ex ) {ex.printStackTrace();}
        catch ( IOException ex ) {ex.printStackTrace();}

    }


    public void regexer ( List<String> al, String number )
    {
        String pat = number+"\\s+(\\w+)";

        Pattern p = Pattern.compile( pat );
        Matcher m;

        for ( String i : al )
        {
            //System.out.println(i);
            m = p.matcher( i );

            if ( m.find() )
            {
                System.out.print( m.group(1) + " " );
            }
        }
    }

    public ArrayList<String> randomiser( int x )
    {

       String single = "";
       ArrayList<String> list = new ArrayList<>();

       Random rand = new Random();
       int a;

       for ( int i = 0; i < x; i++ )
       {
           for ( int j = 0; j < 5; j++ )
           {
               a = rand.nextInt(6) + 1;
               single = single.concat(Integer.toString(a));
           }
           list.add(single);
           //System.out.println(single);
           single = "";
       }
       return list;
    }
}
