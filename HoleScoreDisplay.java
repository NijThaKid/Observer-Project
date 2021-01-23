/**
 * Current Hole Display
 * @author extre
 *
 */
public class HoleScoreDisplay implements Observer {

	Subject golfer;
	private int strokes;
	private int par;
	
	/**
	 * This creates the display for the golf strokes and sees if he makes par
	 * @param golfer
	 */
	public HoleScoreDisplay(Subject golfer) {
		this.golfer = golfer;
		golfer.registerObserver(this);
	}
	
	@Override
	public void update(int strokes, int par)
	{
		this.strokes = strokes;
		this.par = par;
		displayCurrentScore();
		
	}
	
	public void displayCurrentScore() {
		int temp = 0;
		System.out.println("Current Hole Stats");
		System.out.println("Par: " + par);
		System.out.println("Strokes: " + strokes);
		
		temp = Math.abs(strokes - par);
		
		if(par == strokes ) {
			System.out.println("Made Par");
			
		} else if(par > strokes) {
			System.out.println(temp + " Under Par ");
		} else if(par < strokes) {
			System.out.println(temp + " Over Par ");
		}
	
}
}
