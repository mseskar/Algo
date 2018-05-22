/******************************************************************************
 *@mseskar
 @5/5/18
 *
 *  Description:  Plays two guitar strings (concert A and concert C)
 *                when the user types the lowercase letters 'a' and 'c',
 *                respectively in the standard drawing window.
 *
 ******************************************************************************/

public class GuitarHeroLite_MiS {

    public static void main(String[] args) {

        // Create two guitar strings, for concert A and C
        double CONCERT_A = 440.0;
        double CONCERT_C = CONCERT_A * Math.pow(2, 3.0/12.0);
        GuitarString stringA = new GuitarString_MiS(CONCERT_A);
        GuitarString stringC = new GuitarString_MiS(CONCERT_C);


        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {

                // the user types the note
                char key = StdDraw.nextKeyTyped();
                // pluck the corresponding string
                if (key == 'a') { stringA.pluck(); }
                if (key == 'c') { stringC.pluck(); }
            }

            // compute the superposition of the samples
            double sample = stringA.sample() + stringC.sample();

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            stringA.tic();
            stringC.tic();
        }
    }

}
