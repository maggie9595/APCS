//Maggie Yu

public class CharFreq implements Comparable<CharFreq>
{
    private char character;
    //Keep track of how many times this character appears in the input.
    private int frequency;
    
    public CharFreq(int freq)
    {
        frequency = freq;
    }
    
    public CharFreq(char c, int freq)
    {
        this(freq);
        character = c;
    }
    
    public char getChar()
    {
        return character;
    }
    
    public int getFreq()
    {
        return frequency;
    }
    
	//Compare two CharFreqs by comparing their frequencies. 
    public int compareTo(CharFreq other)
    {
        return this.getFreq() - other.getFreq();
    }
}